package com.kunal.quantMeasure;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class QuantMeasureApplication {

	public static void main(String[] args) {
		//SpringApplication.run(QuantMeasureApplication.class, args);
		//demonstrateLengthEquality_CMToInch();
		//demonstrateLengthEquality_YardToInch();
		demonstrateConversionFromYardToFeet();
	}

	/**
	 * This method has 2 length object that accepts 2 inputs.
	 * First inout is the value.
	 * And the second is the type of value which has been defined using an Enum.
	 * After that both object are compared for equality.
	 */
	public static void demonstrateLengthEquality_YardToInch() {
		Length length1 = new Length(1, Length.LengthUnit.YARDS);
		Length length2 = new Length(36, Length.LengthUnit.INCHES);
		if (length1.equals(length2))
			System.out.println("Length1: " + length1.toString() + " and Length2: " + length2.toString() + " are equal.");
		else
			System.out.println("Length1: " + length1.toString() + " and Length2: " + length2.toString() + " are not equal.");
	}

	public static void demonstrateLengthEquality_CMToInch() {
		Length length1 = new Length(100, Length.LengthUnit.CENTIMETERS);
		Length length2 = new Length(39.3701, Length.LengthUnit.INCHES);
		if (length1.equals(length2))
			System.out.println("Length1: " + length1.toString() + " and Length2: " + length2.toString() + " are equal.");
		else
			System.out.println("Length1: " + length1.toString() + " and Length2: " + length2.toString() + " are not equal.");
	}

	public static void demonstrateConversionFromYardToFeet() {
		Length length = new Length(7, Length.LengthUnit.FEET);
		System.out.println("7 Feet in Centimeters is: " + length.convertTo(length, Length.LengthUnit.CENTIMETERS));
	}

}
