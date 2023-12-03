package org.example.structure;

import java.time.LocalDate;

public abstract class Artist {

    private String name, firstname, lastname;
    private LocalDate birthdate;

    public Artist(String name, String firstname, String lastname, LocalDate birthdate) {
        this.name = name;
        this.firstname = firstname;
        this.lastname = lastname;
        this.birthdate = birthdate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    public int getAge() {
        return LocalDate.now().getYear() - birthdate.getYear();
    }

    @Override
    public String toString() {
        return this.firstname + " " + this.lastname + " -> " + this.getAge();
    }

    public abstract void perform();
}
