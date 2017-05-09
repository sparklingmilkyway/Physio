package ch.ti.bfh.physio_app.concept;

/**
 * Created by Jonas on 28.03.2017.
 */

import javax.persistence.Entity;

/**
 * This superclass is inherited by the Patient and the Therapeut classes. Right now, we could take the PasswordHash
 * only to the Therapeut class since the Patient class does not have a password at the moment. But if we make good progress,
 * we will add a login for patients too.
 */
public class User extends pEntityWithID {


    private String surname;
    private String firstname;
    private String passwordHash;

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getFirstname() { return firstname; }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }
}
