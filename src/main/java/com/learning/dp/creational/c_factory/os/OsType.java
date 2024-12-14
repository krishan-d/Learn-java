package com.learning.dp.creational.c_factory.os;

public enum OsType {

    ANDROID("android"), IOS("ios"), WINDOWS("windows");

    private final String value;
    OsType(String value) {
        this.value = value;
    }
    public String getValue() {
        return this.value;
    }
}
