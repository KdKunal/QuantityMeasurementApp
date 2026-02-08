package com.kunal.quantMeasure;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class QuantMeasureApplicationTests {

    @Test
    public void testEquality_FeetToFeet_SameValue() {
        Length length1 = new Length(7.0, Length.LengthUnit.FEET);
        Length length2 = new Length(7.0, Length.LengthUnit.FEET);
        assertTrue(length1.equals(length2));
    }

    @Test
    public void testEquality_InchToInch_SameValue() {
        Length length1 = new Length(7.0, Length.LengthUnit.INCHES);
        Length length2 = new Length(7.0, Length.LengthUnit.INCHES);
        assertTrue(length1.equals(length2));
    }

    @Test
    public void testEquality_NullComparison() {
        Length length = new Length(7.0, Length.LengthUnit.INCHES);
        assertFalse(length.equals(null));
    }

    @Test
    public void testEquality_InchToFeet_EquivalentValue() {
        Length length1 = new Length(30.0, Length.LengthUnit.INCHES);
        Length length2 = new Length(2.5, Length.LengthUnit.FEET);
        assertTrue(length1.equals(length2));
    }

    @Test
    public void testEquality_CrossUnit_DifferentValue() {
        Length length1 = new Length(32.0, Length.LengthUnit.INCHES);
        Length length2 = new Length(2.5, Length.LengthUnit.FEET);
        assertFalse(length1.equals(length2));
    }

    @Test
    public void testEquality_FeetToInch_EquivalentValue() {
        Length length1 = new Length(2.5, Length.LengthUnit.FEET);
        Length length2 = new Length(30.0, Length.LengthUnit.INCHES);
        assertTrue(length1.equals(length2));
    }

    @Test
    public void testEquality_FeetToFeet_DifferentValue() {
        Length length1 = new Length(2.5, Length.LengthUnit.FEET);
        Length length2 = new Length(3.0, Length.LengthUnit.FEET);
        assertFalse(length1.equals(length2));
    }

    @Test
    public void testEquality_InchToInch_DifferentValue() {
        Length length1 = new Length(2.0, Length.LengthUnit.INCHES);
        Length length2 = new Length(3.0, Length.LengthUnit.INCHES);
        assertFalse(length1.equals(length2));
    }

    @Test
    public void testEquality_Unit_SameReference() {
        Length length = new Length(7.0, Length.LengthUnit.FEET);
        assertTrue(length.equals(length));
    }
}
