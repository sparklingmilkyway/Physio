package ch.ti.bfh.physio_app.manager;

import ch.ti.bfh.physio_app.concept.Therapeut;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.RandomUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import java.security.MessageDigest;
import java.util.Date;
import java.util.function.Function;

import static com.auth0.jwt.algorithms.Algorithm.HMAC512;


@ApplicationScoped
public class JWTService {

    private static final String HEADER_PREFIX = "Bearer ";
    private static final String SECRET_KEY_SALT = "YD3094sdjAnlsJJ326kl0kLMK09";
    private static final String TOKEN_ISSUER = "Physioadmin";
    private static final Logger LOGGER = LoggerFactory.getLogger(JWTService.class);


    private byte[] configuredKeyinBytes =  RandomUtils.nextBytes(64);
    private Algorithm signingAlgorithm;
    private JWTVerifier tokenVerifier;



    @PostConstruct
    private void initializeSigningAlgorithm() {
        final MessageDigest digest = DigestUtils.getSha512Digest();
        digest.update(configuredKeyinBytes);
        digest.update(SECRET_KEY_SALT.getBytes());
        signingAlgorithm = HMAC512(digest.digest());

        tokenVerifier = JWT.require(signingAlgorithm)
                .withIssuer(TOKEN_ISSUER)
                .build();
    }

    public String getSignature(Therapeut therapeut) {
        return HEADER_PREFIX + JWT.create()
                .withIssuedAt(new Date())
                .withIssuer(TOKEN_ISSUER)
                .withSubject(therapeut.toString())
                .sign(signingAlgorithm);
    }

    public boolean verifySignature(final String signature) {
        final DecodedJWT jwt;
        try {
            jwt = tokenVerifier.verify(signature);
        }
        catch (JWTVerificationException e){
            LOGGER.debug("Invalid JWT: {}", e.getMessage());
            LOGGER.trace("JWT: {}", signature);
            return false;
        }

        final String subject = jwt.getSubject();

        if (subject.isEmpty()) {
            LOGGER.debug("JWT Subject is not set.", subject);
            return false;
        }
        return true;
    }


    /*

    //Sample method to construct a JWT
    private String createJWT(String id, String issuer, String subject, long ttlMillis) {

        //The JWT signature algorithm we will be using to sign the token
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;

        long nowMillis = System.currentTimeMillis();
        Date now = new Date(nowMillis);

        //We will sign our JWT with our ApiKey secret
        byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary(apiKey.getSecret());
        Key signingKey = new SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.getJcaName());

        //Let's set the JWT Claims
        JwtBuilder builder = Jwts.builder().setId(id)
                .setIssuedAt(now)
                .setSubject(subject)
                .setIssuer(issuer)
                .signWith(signatureAlgorithm, signingKey);

        //if it has been specified, let's add the expiration
        if (ttlMillis >= 0) {
            long expMillis = nowMillis + ttlMillis;
            Date exp = new Date(expMillis);
            builder.setExpiration(exp);
        }

        //Builds the JWT and serializes it to a compact, URL-safe string
        return builder.compact();
    }

    //Sample method to validate and read the JWT
    private void parseJWT(String jwt) {

        //This line will throw an exception if it is not a signed JWS (as expected)
        Claims claims = Jwts.parser()
                .setSigningKey(DatatypeConverter.parseBase64Binary(apiKey.getSecret()))
                .parseClaimsJws(jwt).getBody();
        System.out.println("ID: " + claims.getId());
        System.out.println("Subject: " + claims.getSubject());
        System.out.println("Issuer: " + claims.getIssuer());
        System.out.println("Expiration: " + claims.getExpiration());
    }

    */

}
