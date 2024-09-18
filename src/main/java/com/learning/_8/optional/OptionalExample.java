package com.learning._8.optional;

import com.learning._8.optional.model.Address;
import com.learning._8.optional.model.Country;
import com.learning._8.optional.model.User;

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

    public static void main(String[] args) throws Exception {
        //1.0 Creation:
        //1.1 Return an Empty Optional
        Optional<String> optionalE = Optional.empty();

        //1.2 Returns an Optional that contains a non-null value
        String string = "NON-NULL";
        Optional<String> optionalS = Optional.of(string);

        //1.3 Returns an Optional with specific value or an empty Optional if parameter is null
        Optional<String> optional = Optional.ofNullable(getString());


        User user1 = new User();
        Optional<User> optional1 = Optional.ofNullable(user1);
//      System.out.println(optional1.map(User::getAddress).map(Address::getAddressLine).orElse("None"));


        User user2 = new User(1000, "Password1234#");
        user2.setAddress(new Address("addressLine", "Noida", new Country("India", "+91")));
        Optional<User> optional2 = Optional.ofNullable(user2);

        // 2.0 Checking for Values
        // 2.1 isPresent()
        if (user2 != null) {
            System.out.println(user2.getAddress());
        } else {
            System.out.println("Null");
        }
        // or
        if (optional2.isPresent()) {
            System.out.println(user2.getAddress());
        } else {
            System.out.println("Null");
        }

        // 2.2 ifPresent()
        optional2.ifPresent(System.out::println);

        // 2.3 isEmpty() = !Optional.isPresent()


        // 3.0 Nested Null-checks
        // old approach
//      if (user2 != null) {
//          Address address = user2.getAddress();
//          if (address != null) {
//              String addressLine = address.getAddressLine();
//              if (addressLine != null) System.out.println(addressLine);
//          }
//      }

        // or
        // new approach [optional]
        String addressLine2 = optional2.flatMap(User::getAddress)
                .map(Address::getAddressLine)
                .orElse("not specified");
        // working:
        // flatMap : Optional<User> ---map---> Optional<Optional<Address>> ---flat---> Optional<Address>
        // map : Optional<Address> ---map---> Optional<String>
        System.out.println(addressLine2);


        // 4.0 Alternative results:
        // 4.1 .orElse()
//      User user3 = user2 != null ? user2: new User(2000, "");
        // or
        User user3 = optional2.orElse(new User(2000, ""));

        // 4.2 .orElseGet()
        User user4 = optional2.orElseGet(() -> new User(2000, ""));

        // .orElseThrow()
        User user5 = optional2.orElseThrow(Exception::new);


        // 5.0 Getting values from optional
        if (optional2.isPresent()){
            System.out.println(optional2.get());
        }


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

}
