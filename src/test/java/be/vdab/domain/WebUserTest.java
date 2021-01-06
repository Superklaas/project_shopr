package be.vdab.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class WebUserTest {

    private WebUser webUser;
    private Validator validator;

    @BeforeEach
    public void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
        webUser = new WebUser("Klaas",27);
    }

    @Test
    void setName_CorrectName() {
        webUser.setName("Test test");
        assertEquals("Test test", webUser.getName());
        Set<ConstraintViolation<WebUser>> violations = validator.validate(webUser);
        assertTrue(violations.isEmpty());
    }

    @Test
    void setName_WrongName() {
        webUser.setName("Test8466 test");
        Set<ConstraintViolation<WebUser>> violations = validator.validate(webUser);
        Assertions.assertAll(() -> {
            assertFalse(violations.isEmpty());
            assertEquals("your first name cannot contain a number or a special character",
                    violations.iterator().next().getMessage());
        });
    }

    @Test
    void setName_BlankName() {
        webUser.setName(" ");
        Set<ConstraintViolation<WebUser>> violations = validator.validate(webUser);
        Assertions.assertAll(() -> {
            assertFalse(violations.isEmpty());
            assertEquals("must not be blank",
                    violations.iterator().next().getMessage());
        });
    }

    @Test
    void setAge_CorrectAge() {
        webUser.setAge(35);
        assertEquals(35, webUser.getAge());
        Set<ConstraintViolation<WebUser>> violations = validator.validate(webUser);
        assertTrue(violations.isEmpty());
    }

    @Test
    void setAge_AgeUnder18() {
        webUser.setAge(16);
        Set<ConstraintViolation<WebUser>> violations = validator.validate(webUser);
        Assertions.assertAll(() -> {
            assertFalse(violations.isEmpty());
            assertEquals("age must be between 18 and 90",
                    violations.iterator().next().getMessage());
        });
    }

    @Test
    void setAge_AgeOver90() {
        webUser.setAge(96);
        Set<ConstraintViolation<WebUser>> violations = validator.validate(webUser);
        Assertions.assertAll(() -> {
            assertFalse(violations.isEmpty());
            assertEquals("age must be between 18 and 90",
                    violations.iterator().next().getMessage());
        });
    }

    @Test
    void setAge_EmptyAge() {
        webUser = new WebUser();
        webUser.setName("Klaas");
        Set<ConstraintViolation<WebUser>> violations = validator.validate(webUser);
        Assertions.assertAll(() -> {
            assertFalse(violations.isEmpty());
            assertEquals("age must be between 18 and 90",
                    violations.iterator().next().getMessage());
        });
    }


}
