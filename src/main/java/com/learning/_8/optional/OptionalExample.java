package com.learning._8.optional;

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
        String string = "NON-NULL";
        Optional<String> optionalS = Optional.of(string);

        //3.Returns an Optional with specific value or an empty Optional if parameter is null
        Optional<String> optional = Optional.ofNullable(getString());


        //Usage:
        User user1 = new User();
        User user2 = new User(1000, "Password1234#");
        user2.setAddress(new Address("addressLine", "Noida", new Country("India", "+91")));

        Optional<User> optional1 = Optional.ofNullable(user1);
        System.out.println(optional1.map(User::getAddress).map(Address::getAddressLine).orElse("None"));

        System.out.println(addressLine(user2));
        System.out.println(addressLineOptional(user2));

//      Checking if a value is present
        Optional<String> optionalValue = "".describeConstable();// Some operation that may or may not produce a value
        if (optionalValue.isPresent()) {
            String value = optionalValue.get();
            System.out.println("value: " + value);
        } else {
            // Handle the absence of a value
        }

//      providing a default value
        String value = optionalValue.orElse("Default Value");

//      Executing an action if a value is present:
        optionalValue.ifPresent(val -> System.out.println("Value is present: " + val));

//      Chaining operations:
        Optional<Integer> length = optionalValue.map(String::length);


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

    public Optional<User> findUserById(List<User> users, int id) {
        for (User user: users) {
            if (user.getId() == id) return Optional.of(user);
        }
        return Optional.empty();
    }

}
