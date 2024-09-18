package com.learning._8.optional.model;

import java.util.Optional;

public class User {
    private int id;
    private String password;
    private Optional<Address> address;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User(int id1, String password1) {
        super();
        id = id1;
        password = password1;
    }

    public User() {

    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Optional<Address> getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = Optional.ofNullable(address);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", password='" + password + '\'' +
                ", address=" + address +
                '}';
    }
}
