package com.kunal.quantMeasure;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class QuantMeasureInchesTest {

    @Test
    void testInchEquality_SameValue() {
        Inches inch1 = new Inches(10.0);
        Inches inch2 = new Inches(10.0);
        assertTrue(inch1.equals(inch2));
    }

    @Test
    void testInchEquality_DifferentValue() {
        Inches inch1 = new Inches(10.0);
        Inches inch2 = new Inches(11.0);
        assertFalse(inch1.equals(inch2));
    }

    @Test
    void testInchEquality_NullComparision() {
        Inches inch = new Inches(10.0);
        assertFalse(inch.equals(null));
    }

    @Test
    void testInchEquality_NonNumericInput() {
        Inches inch = new Inches(10.0);
        assertFalse(inch.equals("11.0"));
    }

    @Test
    void testInchEquality_SameReference() {
        Inches inch = new Inches(10.0);
        assertTrue(inch.equals(inch));
    }

    @Test
    void testInchEquality_DifferentTypes() {
        Inches inch1 = new Inches(10.0);
        Inches inch2 = new Inches(10.0);
        assertTrue(inch1.equals(inch2));
    }
}
