package com.kunal.quantMeasure;

public class Inches {

    private final double value;

    public Inches(double value) {
        this.value = value;
    }

    public double getValue() {
        return value;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Inches other = (Inches) obj;
        return Double.compare(this.value, other.value) == 0;
    }

    @Override
    public String toString() {
        return "Inches { value=" + value + "}";
    }
}
