package com.learning.optional;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class OptionalExample {

    private User user;
    /*
        Optional<T>:
        Optional<T> class helps to handle situations, where there is possibility of getting
        NPE [NullPointerException].
        Works as a container for object of type T.
        Returns a value of this object if this value is not null.
    */

    public User getUser() {
        return user;
    }

    public static void main(String[] args) {
        //Creation:
        //1.Return an Empty Optional
        Optional<String> optionalE = Optional.empty();

        //2.Returns an Optional that contains a non-null value
        String string = "Value";
        Optional<String> optionalS = Optional.of(string);

        //3.Returns an Optional with specific value or an empty Optional if parameter is null
        Optional<String> optional = Optional.ofNullable(getString());


        //Usage:
        User user1 = new User();
        User user2 = new User("email@gmail.com", "1234");

        Optional<User> optional1 = Optional.ofNullable(user1);
        System.out.println(optional1.map(User::getAddress).map(Address::getAddressLine).orElse("None"));

        System.out.println(addressLine(user2));
        System.out.println(addressLineOptional(user2));

    }

    public static String getString() {
        return null;
    }

    public static String addressLine(User user) {
        if (user != null) {
            Address address = user.getAddress();
            if (address != null) {
                String addressLine = address.getAddressLine();
                if (addressLine != null) return addressLine;
            }
        }
        return "not specified";
    }

    public static String addressLineOptional(User user) {
        Optional<User> optional = Optional.ofNullable(user);
        return optional.map(User::getAddress)
                .map(Address::getAddressLine)
                .orElse("not specified");
    }
}
