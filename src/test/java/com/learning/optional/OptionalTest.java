package com.learning.optional;

import com.learning._8.optional.Address;
import com.learning._8.optional.Country;
import com.learning._8.optional.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

import java.util.Locale;
import java.util.NoSuchElementException;
import java.util.Optional;

public class OptionalTest {
    private User user;
    private Logger logger = LogManager.getLogger(OptionalTest.class);

    @Test(expected = NullPointerException.class)
    public void testNull() {
        String iso_code = user.getAddress().getCountry().getIso_code().toUpperCase(Locale.ROOT);
    }

    public void test() {
        if (user != null) {
            Address address = user.getAddress();
            if (address != null) {
                Country country = address.getCountry();
                if (country != null) {
                    String iso_code = country.getIso_code();
                    if (iso_code != null) {
                        iso_code = iso_code.toUpperCase(Locale.ROOT);
                    }
                }
            }
        }
    }

    @Test(expected = NoSuchElementException.class)
    public void whenCreateEmptyOptional_thenNull() {
        Optional<User> emptyObj = Optional.empty();
        emptyObj.get();
    }
    public User createNewUser() {
        logger.info("Creating New User");
        return new User("some@gmail.com", "1234");
    }

    @Test
    public void givenEmptyValue_whenCompare_thenOk() {
        logger.info("Using orElse");
        User result = Optional.ofNullable(user).orElse(createNewUser());
        logger.info("Using orElseGet");
        User result2 = Optional.ofNullable(user).orElseGet(this::createNewUser);
    }
}
