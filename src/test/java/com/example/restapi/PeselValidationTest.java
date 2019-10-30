package com.example.restapi;

import com.example.restapi.domain.User;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;


public class PeselValidationTest {

    @Autowired
    private Validator validator;

    @Before
    public void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    public void testSetWrongPesel() {
        User user = new User();
        user.setPesel("82113025ed1");
        user.setFirstname("Tomek");
        user.setLastname("Kudas");
        user.setId(1L);
        Set<ConstraintViolation<User>> violations = validator.validate(user);
        Assert.assertFalse(violations.isEmpty());
    }

    @Test
    public void testSetEmptyPesel() {
        User user = new User();
        user.setPesel("");
        user.setFirstname("Tomek");
        user.setLastname("Kudas");
        user.setId(1L);
        Set<ConstraintViolation<User>> violations = validator.validate(user);
        Assert.assertFalse(violations.isEmpty());
    }

    @Test
    public void testSetTooBigPesel() {
        User user = new User();
        user.setPesel("1234567890123");
        user.setFirstname("Tomek");
        user.setLastname("Kudas");
        user.setId(1L);
        Set<ConstraintViolation<User>> violations = validator.validate(user);
        Assert.assertFalse(violations.isEmpty());
    }

    @Test
    public void testSetTooShortPesel() {
        User user = new User();
        user.setPesel("1234");
        user.setFirstname("Tomek");
        user.setLastname("Kudas");
        user.setId(1L);
        Set<ConstraintViolation<User>> violations = validator.validate(user);
        Assert.assertFalse(violations.isEmpty());
    }

    @Test
    public void testSetRightPesel() {
        User user = new User();
        user.setPesel("821130001251");
        user.setFirstname("Tomek");
        user.setLastname("Kudas");
        user.setId(1L);
        Set<ConstraintViolation<User>> violations = validator.validate(user);
        Assert.assertTrue(violations.isEmpty());
    }


}
