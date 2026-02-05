package com.kunal.quantMeasure;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class QuantMeasureApplication {

	public static void main(String[] args) {
		//SpringApplication.run(QuantMeasureApplication.class, args);

		demonstrateFeetEquality();
		demonstrateInchEquality();
	}

	/**
	 * This method is used for demonstrating the equality between two objects of Feet class.
	 * The values for the instances of Feet are hardcoded.
	 */
	public static void demonstrateFeetEquality() {
		Feet feet1 = new Feet(10.0);
		Feet feet2 = new Feet(11.0);
		if (feet1.equals(feet2))
			System.out.println("Feet1: " + feet1.toString() + " and Feet2: " + feet2.toString() + " are equal.");
		else
			System.out.println("Feet1: " + feet1.toString() + " and Feet2: " + feet2.toString() + " are not equal.");
	}

	/**
	 * This method is used for demonstrating the equality between two objects of Inches class.
	 * The values for the instances of Inches are hardcoded.
	 */
	public static void demonstrateInchEquality() {
		Inches inch1 = new Inches(10.0);
		Inches inch2 = new Inches(10.0);
		if (inch1.equals(inch2))
			System.out.println("Inch1: " + inch1.toString() + " and Inch2: " + inch2.toString() + " are equal.");
		else
			System.out.println("Inch1: " + inch1.toString() + " and Inch2: " + inch2.toString() + " are not equal.");
	}

}
