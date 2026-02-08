package com.kunal.quantMeasure;

public class Length {
    private double value;
    private LengthUnit unit;

    private static final double EPSILON = 1e-9;

    public enum LengthUnit {

        FEET(12.0),
        INCHES(1.0);

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

    private double convertToBaseUnit() {
        return value * unit.getConversionFactor();
    }

    public boolean compare(Length otherLengthObject) {
        double thisLength = this.convertToBaseUnit();
        double thatLength = otherLengthObject.convertToBaseUnit();
        return Math.abs(thisLength-thatLength) < EPSILON;
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
