package ch.ti.bfh.physio_app.concept;

/**
 * Created by Jonas on 28.03.2017.
 */
public class User extends pEntityWithID {

    private String surname;
    private String lastname;
    private String passwordHash;

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }
}