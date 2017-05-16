package ch.ti.bfh.physio_app.concept;

/**
 * Created by Jonas on 28.03.2017.
 */

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

/**
 * This superclass is inherited by the Patient and the Therapeut classes. Right now, we could take the PasswordHash
 * only to the Therapeut class since the Patient class does not have a password at the moment. But if we make good progress,
 * we will add a login for patients too.
 */
@MappedSuperclass
public class User extends pEntityWithID {

    @Column
    private String surname;
    @Column
    private String firstname;
    @Column
    private String email;
    @Column
    private String passwordHash;

    public User() {

    }

    public User(String surname, String firstname, String email, String passwordHash){
        this.surname = surname;
        this.firstname = firstname;
        this.email = email;
        this.passwordHash = passwordHash;
    }

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }
}
