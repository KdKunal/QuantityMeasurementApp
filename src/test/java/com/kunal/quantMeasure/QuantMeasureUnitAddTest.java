package com.kunal.quantMeasure;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class QuantMeasureUnitAddTest {

    //Test addition with Positive Values
    @Test
    public void testAddition_FeetToFeetAddition() {
        Length source = new Length(5.0, Length.LengthUnit.FEET);
        Length target = new Length(4.0, Length.LengthUnit.FEET);
        assertEquals(9.0, source.sumUp(source, target).getValue());
    }

    @Test
    public void testAddition_FeetToInchAddition() {
        Length source = new Length(7.0, Length.LengthUnit.FEET);
        Length target = new Length(12.0, Length.LengthUnit.INCHES);
        assertEquals(8.0, source.sumUp(source, target).getValue());
    }

    @Test
    public void testAddition_FeetToYardAddition() {
        Length source = new Length(7.0, Length.LengthUnit.FEET);
        Length target = new Length(1.0, Length.LengthUnit.YARDS);
        assertEquals(10.0, source.sumUp(source, target).getValue());
    }

    @Test
    public void testAddition_FeetToCentimetersAddition() {
        Length source = new Length(7.0, Length.LengthUnit.FEET);
        Length target = new Length(130.0, Length.LengthUnit.CENTIMETERS);
        assertEquals(11.27, source.sumUp(source, target).getValue());
    }

    //Test addition with Negative Values
    @Test
    public void testAddition_FeetToFeetAddition_NegativeValue() {
        Length source = new Length(-5.0, Length.LengthUnit.FEET);
        Length target = new Length(-4.0, Length.LengthUnit.FEET);
        assertEquals(-9.0, source.sumUp(source, target).getValue());
    }

    @Test
    public void testAddition_FeetToInchAddition_NegativeValue() {
        Length source = new Length(7.0, Length.LengthUnit.FEET);
        Length target = new Length(-12.0, Length.LengthUnit.INCHES);
        assertEquals(6.0, source.sumUp(source, target).getValue());
    }

    @Test
    public void testAddition_FeetToYardAddition_NegativeValue() {
        Length source = new Length(-7.0, Length.LengthUnit.FEET);
        Length target = new Length(1.0, Length.LengthUnit.YARDS);
        assertEquals(-4.0, source.sumUp(source, target).getValue());
    }

    @Test
    public void testAddition_FeetToCentimetersAddition_NegativeValue() {
        Length source = new Length(7.0, Length.LengthUnit.FEET);
        Length target = new Length(-130.0, Length.LengthUnit.CENTIMETERS);
        assertEquals(2.73, source.sumUp(source, target).getValue());
    }

    @Test
    public void testAddition_InchToFeetAddition() {
        Length source = new Length(36.0, Length.LengthUnit.INCHES);
        Length target = new Length(2.0, Length.LengthUnit.FEET);
        assertEquals(60.0, source.sumUp(source, target).getValue());
    }

    @Test
    public void testAddition_InchToInchAddition() {
        Length source = new Length(36.0, Length.LengthUnit.INCHES);
        Length target = new Length(12.0, Length.LengthUnit.INCHES);
        assertEquals(48.0, source.sumUp(source, target).getValue());
    }

    @Test
    public void testAddition_InchToYardAddition() {
        Length source = new Length(36.0, Length.LengthUnit.INCHES);
        Length target = new Length(1.0, Length.LengthUnit.YARDS);
        assertEquals(72.0, source.sumUp(source, target).getValue());
    }

    @Test
    public void testAddition_InchToCentimeterAddition() {
        Length source = new Length(36.0, Length.LengthUnit.INCHES);
        Length target = new Length(120.0, Length.LengthUnit.CENTIMETERS);
        assertEquals(83.24, source.sumUp(source, target).getValue());
    }

    // YARD Addition
    @Test
    public void testAddition_YardToFeetAddition() {
        Length source = new Length(1.0, Length.LengthUnit.YARDS);
        Length target = new Length(2.0, Length.LengthUnit.FEET);
        assertEquals(1.67, source.sumUp(source, target).getValue());
    }

    @Test
    public void testAddition_YardToInchAddition() {
        Length source = new Length(1.0, Length.LengthUnit.YARDS);
        Length target = new Length(24.0, Length.LengthUnit.INCHES);
        assertEquals(1.67, source.sumUp(source, target).getValue());
    }

    @Test
    public void testAddition_YardToYardAddition() {
        Length source = new Length(1.0, Length.LengthUnit.YARDS);
        Length target = new Length(2.0, Length.LengthUnit.YARDS);
        assertEquals(3.0, source.sumUp(source, target).getValue());
    }

    @Test
    public void testAddition_YardToCentimeterAddition() {
        Length source = new Length(1.0, Length.LengthUnit.YARDS);
        Length target = new Length(30.0, Length.LengthUnit.CENTIMETERS);
        assertEquals(1.33, source.sumUp(source, target).getValue());
    }

    //Centimeter Addition
    @Test
    public void testAddition_CentimeterToFeetAddition() {
        Length source = new Length(32.0, Length.LengthUnit.CENTIMETERS);
        Length target = new Length(2.0, Length.LengthUnit.FEET);
        assertEquals(92.96, source.sumUp(source, target).getValue());
    }

    @Test
    public void testAddition_CentimeterToInchAddition() {
        Length source = new Length(1.0, Length.LengthUnit.CENTIMETERS);
        Length target = new Length(2.0, Length.LengthUnit.INCHES);
        assertEquals(6.08, source.sumUp(source, target).getValue());
    }

    @Test
    public void testAddition_CentimeterToYardAddition() {
        Length source = new Length(300.0, Length.LengthUnit.CENTIMETERS);
        Length target = new Length(2.0, Length.LengthUnit.YARDS);
        assertEquals(482.88, source.sumUp(source, target).getValue());
    }

    @Test
    public void testAddition_CentimeterToCentimeterAddition() {
        Length source = new Length(300.0, Length.LengthUnit.CENTIMETERS);
        Length target = new Length(210.0, Length.LengthUnit.CENTIMETERS);
        assertEquals(510.0, source.sumUp(source, target).getValue());
    }

    //Illegal Argument to test exceptions
    @Test
    public void testAddition_IllegalArgument_NAN() {
        Length source = new Length(Double.NaN, Length.LengthUnit.INCHES);
        Length target = new Length(Double.NaN, Length.LengthUnit.INCHES);
        IllegalArgumentException ex = assertThrows(
                IllegalArgumentException.class,
                () -> source.sumUp(source, target)
        );
        assertEquals("The value passed for conversion is not finite.", ex.getMessage());
    }

    @Test
    public void testAddition_IllegalArgument_Infinite() {
        Length source = new Length(Double.POSITIVE_INFINITY, Length.LengthUnit.FEET);
        Length target = new Length(Double.POSITIVE_INFINITY, Length.LengthUnit.INCHES);
        IllegalArgumentException ex = assertThrows(
                IllegalArgumentException.class,
                () -> source.sumUp(source, target)
        );
        assertEquals("The value passed for conversion is not finite.", ex.getMessage());
    }

    @Test
    public void testAddition_IllegalArgument_SourceUnit() {
        Length source = new Length(36.0, null);
        Length target = new Length(36.0, Length.LengthUnit.INCHES);
        IllegalArgumentException ex = assertThrows(
                IllegalArgumentException.class,
                () -> source.sumUp(source, target)
        );
        assertEquals("Source or Target unit Missing.", ex.getMessage());
    }

    @Test
    public void testAddition_IllegalArgument_TargetUnit() {
        Length source = new Length(36.0, Length.LengthUnit.INCHES);
        Length target = new Length(36.0, null);
        IllegalArgumentException ex = assertThrows(
                IllegalArgumentException.class,
                () -> source.sumUp(source, target)
        );
        assertEquals("Source or Target unit Missing.", ex.getMessage());
    }

    @Test
    public void testAddition_SourceZeroValue() {
        Length source = new Length(0.0, Length.LengthUnit.INCHES);
        Length target = new Length(2.0, Length.LengthUnit.FEET);
        assertEquals(24.0, source.sumUp(source, target).getValue());
    }

    @Test
    public void testAddition_Commutativity() {
        Length source1 = new Length(12.0, Length.LengthUnit.INCHES);
        Length target1 = new Length(2.0, Length.LengthUnit.FEET);

        Length source2 = new Length(2.0, Length.LengthUnit.FEET);
        Length target2 = new Length(12.0, Length.LengthUnit.INCHES);

        double summedUpValue = source2.sumUp(source2, target2).getValue();
        assertEquals(source1.sumUp(source1, target1).getValue(), summedUpValue * 12);
    }
}
