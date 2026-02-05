package com.kunal.quantMeasure;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class QuantMeasureFeetTest {

    @Test
    void testFeetEquality_SameValue() {
        Feet feet1 = new Feet(1.0);
        Feet feet2 = new Feet(1.0);
        assertTrue(feet1.equals(feet2));
    }

    @Test
    void testFeetEquality_DifferentValue() {
        Feet feet1 = new Feet(1.0);
        Feet feet2 = new Feet(2.0);
        assertFalse(feet1.equals(feet2));
    }

    @Test
    void testFeetEquality_NullComparision() {
        Feet feet = new Feet(5.0);
        assertFalse(feet.equals(null));
    }

    @Test
    void testFeetEquality_NonNumericInput() {
        Feet feet = new Feet(11.0);
        assertFalse(feet.equals("11.0"));
    }

    @Test
    void testFeetEquality_SameReference() {
        Feet feet = new Feet(15.0);
        assertTrue(feet.equals(feet));
    }

    @Test
    void testFeetEquality_DifferentTypes() {
        Feet feet1 = new Feet(15.0);
        Feet feet2 = new Feet(15);
        assertTrue(feet1.equals(feet2));
    }
}
