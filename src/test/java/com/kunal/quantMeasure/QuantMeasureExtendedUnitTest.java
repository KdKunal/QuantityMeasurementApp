package com.kunal.quantMeasure;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class QuantMeasureExtendedUnitTest {

    @Test
    public void testEquality_YardsToYards_SameValue() {
        Length length1 = new Length(7.0, Length.LengthUnit.YARDS);
        Length length2 = new Length(7.0, Length.LengthUnit.YARDS);
        assertTrue(length1.equals(length2));
    }

    @Test
    public void testEquality_CentimeterToCentimeter_SameValue() {
        Length length1 = new Length(11.0, Length.LengthUnit.CENTIMETERS);
        Length length2 = new Length(11.0, Length.LengthUnit.CENTIMETERS);
        assertTrue(length1.equals(length2));
    }

    @Test
    public void testEquality_YardsToYards_DifferentValue() {
        Length length1 = new Length(10.0, Length.LengthUnit.YARDS);
        Length length2 = new Length(7.0, Length.LengthUnit.YARDS);
        assertFalse(length1.equals(length2));
    }

    @Test
    public void testEquality_CentimeterToCentimeter_DifferentValue() {
        Length length1 = new Length(11.0, Length.LengthUnit.CENTIMETERS);
        Length length2 = new Length(12.0, Length.LengthUnit.CENTIMETERS);
        assertFalse(length1.equals(length2));
    }

    @Test
    public void testEquality_NullComparison() {
        Length length = new Length(7.0, Length.LengthUnit.CENTIMETERS);
        assertFalse(length.equals(null));
    }

    @Test
    public void testEquality_YardToFeet_EquivalentValue() {
        Length length1 = new Length(1.0, Length.LengthUnit.YARDS);
        Length length2 = new Length(3.0, Length.LengthUnit.FEET);
        assertTrue(length1.equals(length2));
    }

    @Test
    public void testEquality_YardToInch_EquivalentValue() {
        Length length1 = new Length(1.0, Length.LengthUnit.YARDS);
        Length length2 = new Length(36.0, Length.LengthUnit.INCHES);
        assertTrue(length1.equals(length2));
    }

    @Test
    public void testEquality_YardToCentimeter_EquivalentValue() {
        Length length1 = new Length(1.0, Length.LengthUnit.YARDS);
        Length length2 = new Length(91.44, Length.LengthUnit.CENTIMETERS);
        assertTrue(length1.equals(length2));
    }

    @Test
    public void testEquality_YardToFeet_DifferentValue() {
        Length length1 = new Length(2.0, Length.LengthUnit.YARDS);
        Length length2 = new Length(3.0, Length.LengthUnit.FEET);
        assertFalse(length1.equals(length2));
    }

    @Test
    public void testEquality_YardToInch_DifferentValue() {
        Length length1 = new Length(1.5, Length.LengthUnit.YARDS);
        Length length2 = new Length(36.0, Length.LengthUnit.INCHES);
        assertFalse(length1.equals(length2));
    }

    @Test
    public void testEquality_YardToCentimeter_DifferentValue() {
        Length length1 = new Length(1.0, Length.LengthUnit.YARDS);
        Length length2 = new Length(91.95, Length.LengthUnit.CENTIMETERS);
        assertFalse(length1.equals(length2));
    }

    @Test
    public void testEquality_Yard_SameReference() {
        Length length = new Length(2.0, Length.LengthUnit.YARDS);
        assertTrue(length.equals(length));
    }

    @Test
    public void testEquality_Centimeter_SameReference() {
        Length length = new Length(100.0, Length.LengthUnit.CENTIMETERS);
        assertTrue(length.equals(length));
    }
}
