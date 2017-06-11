package ch.ti.bfh.physio_app.manager;

import ch.ti.bfh.physio_app.concept.*;
import org.mindrot.jbcrypt.BCrypt;

import javax.enterprise.context.ApplicationScoped;


@ApplicationScoped
public class LoginManager {

    public boolean auth(Therapeut therapeut, String password){
        if(BCrypt.checkpw(password, therapeut.getPasswordHash()))
                 return true;
        else  return false;
    }


    public static String doHash(String pwToHash){
        // Hash a password for the first time
        String hashed = BCrypt.hashpw(pwToHash, BCrypt.gensalt());
        /*
        // gensalt's log_rounds parameter determines the complexity
        // the work factor is 2**log_rounds, and the default is 10
        String hashed = BCrypt.hashpw(password, BCrypt.gensalt(12));
        */
        return hashed;
    }

}
