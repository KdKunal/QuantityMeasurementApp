package com.kunal.quantMeasure;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Length {
    private double value;
    private LengthUnit unit;

    private static final double EPSILON = 1e-9;

    public enum LengthUnit {

        FEET(12.0),
        INCHES(1.0),
        YARDS(36),
        CENTIMETERS(0.393701);

        private double conversionFactor;

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

    private BigDecimal convertToBaseUnit() {
        return BigDecimal.valueOf(value)
                .multiply(BigDecimal.valueOf(unit.getConversionFactor()));
    }

    public boolean compare(Length otherLengthObject) {
        BigDecimal thisLength = this.convertToBaseUnit().setScale(2, RoundingMode.DOWN);
        BigDecimal thatLength = otherLengthObject.convertToBaseUnit().setScale(2, RoundingMode.DOWN);
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

    @Override
    public String toString() {
        return "Length { value=" + value + "}";
    }
}
