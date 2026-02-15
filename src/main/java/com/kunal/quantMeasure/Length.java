package com.kunal.quantMeasure;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Length {
    private double value;
    private LengthUnit unit;

    public enum LengthUnit {

        FEET(12.0),
        INCHES(1.0),
        YARDS(36),
        CENTIMETERS(1.0/2.54);

        private final double conversionFactor;

        LengthUnit(double conversionFactor){
            this.conversionFactor = conversionFactor;
        }

        public double getConversionFactor() {
            return conversionFactor;
        }
    }

    public Length(double value, LengthUnit unit) {
        this.value = value;
        this.unit = unit;
    }

    public double getValue() {
        return value;
    }

    public boolean compare(Length otherLengthObject) {
        BigDecimal thisLength = this.convertToBaseUnit().setScale(2, RoundingMode.UP);
        BigDecimal thatLength = otherLengthObject.convertToBaseUnit().setScale(2, RoundingMode.UP);
        return thisLength.subtract(thatLength).abs()
                .compareTo(BigDecimal.valueOf(0.000001)) <= 0;
    }

    /**
     * This method converts value from source to the type of target unit.
     * @param source
     * @param targetUnit
     * @return Length object.
     */
    public Length convertTo(Length source, LengthUnit targetUnit) {
        performValidationForConversion(source, targetUnit);
        if ((!(targetUnit.equals(source.unit)))) {
            BigDecimal convertedValue = source.convertToBaseUnit();
            convertedValue = convertedValue.divide(
                    BigDecimal.valueOf(targetUnit.conversionFactor),
                    2,
                    RoundingMode.HALF_UP
            );
            return new Length(convertedValue.doubleValue(), targetUnit);
        }
        return new Length(source.value, source.unit);
    }

    /**
     * Adds up two values.
     * The 2nd value is converted to 1st object's unit type.
     * and addition is performed and returned back.
     * @param source
     * @param target
     * @return length object.
     */
    public Length sumUp(Length source, Length target) {
        BigDecimal finalValue;
        validate(source, target);
        if (!(source.unit.equals(target.unit))) {
            target = source.convertTo(target, source.unit);
        }
        finalValue = BigDecimal.valueOf(source.getValue() + target.getValue())
                .setScale(2, RoundingMode.HALF_UP);
        return new Length(finalValue.doubleValue(), source.unit);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Length length = (Length) obj;
        return this.compare(length);

    }

    @Override
    public String toString() {
        return "Length { value=" + value + "}";
    }

    private BigDecimal convertToBaseUnit() {
        return BigDecimal.valueOf(value)
                .multiply(BigDecimal.valueOf(unit.getConversionFactor()));
    }

    private void performValidationForConversion(Length source, LengthUnit targetUnit) {
        validate(source, new Length(0.0, targetUnit));
    }

    private void validate(Length source, Length target) {
        if (!(Double.isFinite(source.value)) || !(Double.isFinite(target.value))) {
            throw new IllegalArgumentException("The value passed for conversion is not finite.");
        } else if (source.unit == null || target.unit == null) {
            throw new IllegalArgumentException("Source or Target unit Missing.");
        }
    }
}
