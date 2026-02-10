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

    private BigDecimal convertToBaseUnit() {
        return BigDecimal.valueOf(value)
                .multiply(BigDecimal.valueOf(unit.getConversionFactor()));
    }

    public boolean compare(Length otherLengthObject) {
        BigDecimal thisLength = this.convertToBaseUnit().setScale(2, RoundingMode.UP);
        BigDecimal thatLength = otherLengthObject.convertToBaseUnit().setScale(2, RoundingMode.UP);
        return thisLength.subtract(thatLength).abs()
                .compareTo(BigDecimal.valueOf(0.000001)) <= 0;
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

    public Length convertTo(Length source, LengthUnit targetUnit) {
        performValidation(source, targetUnit);
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

    private void performValidation(Length source, LengthUnit targetUnit) {
        if (!(Double.isFinite(source.value))) {
            throw new IllegalArgumentException("The value passed for conversion is not finite.");
        } else if (source.unit == null || targetUnit == null) {
            throw new IllegalArgumentException("Source or Target unit Missing.");
        }
    }

    @Override
    public String toString() {
        return "Length { value=" + value + "}";
    }
}
