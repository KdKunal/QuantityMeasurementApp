package com.kunal.quantMeasure;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class QuantMeasureUnitConversionTest {

    @Test
    public void testConversion_FeetToFeetConversion() {
        Length length = new Length(7, Length.LengthUnit.FEET);
        Length convertedLength = length.convertTo(length, Length.LengthUnit.FEET);
        assertEquals(length.getValue(), convertedLength.getValue());
    }

    @Test
    public void testEquality_FeetToInchConversion() {
        Length length = new Length(7, Length.LengthUnit.FEET);
        Length convertedLength = length.convertTo(length, Length.LengthUnit.INCHES);
        assertEquals(84.0, convertedLength.getValue());
    }

    @Test
    public void testConversion_FeetToYardConversion() {
        Length length = new Length(7, Length.LengthUnit.FEET);
        Length convertedLength = length.convertTo(length, Length.LengthUnit.YARDS);
        assertEquals(2.33, convertedLength.getValue());
    }

    @Test
    public void testConversion_FeetToCentimetersConversion() {
        Length length = new Length(10, Length.LengthUnit.FEET);
        Length convertedLength = length.convertTo(length, Length.LengthUnit.CENTIMETERS);
        assertEquals(304.80, convertedLength.getValue());
    }

    @Test
    public void testConversion_InchToFeetConversion() {
        Length length = new Length(12, Length.LengthUnit.INCHES);
        Length convertedLength = length.convertTo(length, Length.LengthUnit.FEET);
        assertEquals(1, convertedLength.getValue());
    }

    @Test
    public void testConversion_InchToInchConversion() {
        Length length = new Length(12, Length.LengthUnit.INCHES);
        Length convertedLength = length.convertTo(length, Length.LengthUnit.INCHES);
        assertEquals(12, convertedLength.getValue());
    }

    @Test
    public void testConversion_InchToYardConversion() {
        Length length = new Length(36, Length.LengthUnit.INCHES);
        Length convertedLength = length.convertTo(length, Length.LengthUnit.YARDS);
        assertEquals(1, convertedLength.getValue());
    }

    @Test
    public void testConversion_InchToCentimeterConversion() {
        Length length = new Length(12, Length.LengthUnit.INCHES);
        Length convertedLength = length.convertTo(length, Length.LengthUnit.CENTIMETERS);
        assertEquals(30.48, convertedLength.getValue());
    }

    @Test
    public void testConversion_YardToFeetConversion() {
        Length length = new Length(1, Length.LengthUnit.YARDS);
        Length convertedLength = length.convertTo(length, Length.LengthUnit.FEET);
        assertEquals(3, convertedLength.getValue());
    }

    @Test
    public void testConversion_YardToInchConversion() {
        Length length = new Length(1, Length.LengthUnit.YARDS);
        Length convertedLength = length.convertTo(length, Length.LengthUnit.INCHES);
        assertEquals(36, convertedLength.getValue());
    }

    @Test
    public void testConversion_YardToYardConversion() {
        Length length = new Length(1, Length.LengthUnit.YARDS);
        Length convertedLength = length.convertTo(length, Length.LengthUnit.YARDS);
        assertEquals(1, convertedLength.getValue());
    }

    @Test
    public void testConversion_YardToCentimeterConversion() {
        Length length = new Length(1, Length.LengthUnit.YARDS);
        Length convertedLength = length.convertTo(length, Length.LengthUnit.CENTIMETERS);
        assertEquals(91.44, convertedLength.getValue());
    }

    @Test
    public void testConversion_CentimeterToFeetConversion() {
        Length length = new Length(100, Length.LengthUnit.CENTIMETERS);
        Length convertedLength = length.convertTo(length, Length.LengthUnit.FEET);
        assertEquals(3.28, convertedLength.getValue());
    }

    @Test
    public void testConversion_CentimeterToInchConversion() {
        Length length = new Length(100, Length.LengthUnit.CENTIMETERS);
        Length convertedLength = length.convertTo(length, Length.LengthUnit.INCHES);
        assertEquals(39.37, convertedLength.getValue());
    }

    @Test
    public void testConversion_CentimeterToYardConversion() {
        Length length = new Length(100, Length.LengthUnit.CENTIMETERS);
        Length convertedLength = length.convertTo(length, Length.LengthUnit.YARDS);
        assertEquals(1.09, convertedLength.getValue());
    }

    @Test
    public void testConversion_CentimeterToCentimeterConversion() {
        Length length = new Length(100, Length.LengthUnit.CENTIMETERS);
        Length convertedLength = length.convertTo(length, Length.LengthUnit.CENTIMETERS);
        assertEquals(100.0, convertedLength.getValue());
    }

    @Test
    public void testConversion_IllegalArgument_NAN() {
        Length length = new Length(Double.NaN, Length.LengthUnit.INCHES);
        IllegalArgumentException ex = assertThrows(
                IllegalArgumentException.class,
                () -> length.convertTo(length, Length.LengthUnit.INCHES)
        );
        assertEquals("The value passed for conversion is not finite.", ex.getMessage());
    }

    @Test
    public void testConversion_IllegalArgument_Infinite() {
        Length length = new Length(Double.POSITIVE_INFINITY, Length.LengthUnit.FEET);
        IllegalArgumentException ex = assertThrows(
                IllegalArgumentException.class,
                () -> length.convertTo(length, Length.LengthUnit.FEET)
        );
        assertEquals("The value passed for conversion is not finite.", ex.getMessage());
    }

    @Test
    public void testConversion_IllegalArgument_SourceUnit() {
        Length length = new Length(36.0, null);
        IllegalArgumentException ex = assertThrows(
                IllegalArgumentException.class,
                () -> length.convertTo(length, Length.LengthUnit.INCHES)
        );
        assertEquals("Source or Target unit Missing.", ex.getMessage());
    }

    @Test
    public void testConversion_IllegalArgument_TargetUnit() {
        Length length = new Length(2.0, Length.LengthUnit.YARDS);
        IllegalArgumentException ex = assertThrows(
                IllegalArgumentException.class,
                () -> length.convertTo(length, null)
        );
        assertEquals("Source or Target unit Missing.", ex.getMessage());
    }

    @Test
    public void testConversion_ZeroValue() {
        Length length = new Length(0.0, Length.LengthUnit.CENTIMETERS);
        Length convertedLength = length.convertTo(length, Length.LengthUnit.CENTIMETERS);
        assertEquals(0.0, convertedLength.getValue());
    }

    @Test
    public void testConversion_RoundTrip_PreservesValue() {
        Length length = new Length(3.0, Length.LengthUnit.YARDS);
        Length convertedLength = length.convertTo(length, Length.LengthUnit.FEET);
        Length originalLength = convertedLength.convertTo(convertedLength, Length.LengthUnit.YARDS);
        assertEquals(3.0, originalLength.getValue());
    }

    @Test
    public void testConversion_NegativeValue() {
        Length length = new Length(-1.0, Length.LengthUnit.YARDS);
        Length convertedLength = length.convertTo(length, Length.LengthUnit.FEET);
        assertEquals(-3.0, convertedLength.getValue());
    }

}
