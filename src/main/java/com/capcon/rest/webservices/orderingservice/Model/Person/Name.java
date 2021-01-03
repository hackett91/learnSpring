package com.capcon.rest.webservices.orderingservice.Model.Person;

public class Name {

    private String firstname;
    private String secondName;

    public Name(String firstname, String secondName) {
        this.firstname = firstname;
        this.secondName = secondName;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }
}
