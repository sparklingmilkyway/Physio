package ch.ti.bfh.physio_app.concept;


/**
 * model for API -> a therapeut with a token
 */
public class UserDTO {

    public long id;
    public String firstname;
    public String surname;
    public String email;
    public String passwordhash;
    public String token;

    public UserDTO(Therapeut therapeut, String token){
        this.id = therapeut.getId();
        this.firstname = therapeut.getFirstname();
        this.surname = therapeut.getSurname();
        this.email = therapeut.getEmail();
        this.passwordhash = therapeut.getPasswordHash();
        this.token = token;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPasswordhash() {
        return passwordhash;
    }

    public void setPasswordhash(String passwordhash) {
        this.passwordhash = passwordhash;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
