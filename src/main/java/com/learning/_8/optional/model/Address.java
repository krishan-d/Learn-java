package com.learning._8.optional.model;

import java.util.Optional;

public class Address {
    private String addressLine;
    private String city;
    private Optional<Country> country;

    public Address(String addressLine, String city, Country country) {
        super();
        this.addressLine = addressLine;
        this.city = city;
        this.country = Optional.ofNullable(country);
    }

    public String getAddressLine() {
        return addressLine;
    }

    public void setAddressLine(String addressLine) {
        this.addressLine = addressLine;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Optional<Country> getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = Optional.ofNullable(country);
    }

    @Override
    public String toString() {
        return "Address{" +
                "addressLine='" + addressLine + '\'' +
                ", city='" + city + '\'' +
                ", country=" + country +
                '}';
    }
}
