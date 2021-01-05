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

    private WebUser webUser = new WebUser();
    private Validator validator;

    @BeforeEach
    public void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
        webUser.setAge(18);
    }

    @Test
    void setName() {
        webUser.setName("Test test");
        assertEquals("Test test", webUser.getName());
        Set<ConstraintViolation<WebUser>> violations = validator.validate(webUser);
        assertTrue(violations.isEmpty());
    }

    @Test
    void setWrongName() {
        webUser.setName("Test8466 test");
        Set<ConstraintViolation<WebUser>> violations = validator.validate(webUser);
        Assertions.assertAll(() -> {
            assertFalse(violations.isEmpty());
            assertEquals("your first name cannot contain a number or a special character", violations.iterator().next().getMessage());
        });
    }
}
