package com.learning.core_examples.comparing;

import org.jetbrains.annotations.NotNull;

import java.time.LocalDate;
import java.util.Objects;

public class PersonWithEquals {

    private String firstname, lastname;
    private LocalDate birthdate;

    public PersonWithEquals(@NotNull String firstname, @NotNull String lastname) {
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public PersonWithEquals(String firstname, String lastname, LocalDate birthdate) {
        this(firstname, lastname);
        this.birthdate = birthdate;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PersonWithEquals that = (PersonWithEquals) o;
        return firstname.equals(that.firstname) && lastname.equals(that.lastname) && birthdate.equals(that.birthdate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstname, lastname, birthdate);
    }
}
