package conversion;

import java.lang.Math;

class Conversion {
	// instance fields
	private double fromValue;
	private double toValue;
	private String fromUnit;
	private String toUnit;

	public Conversion(double fromValue, String fromUnit, String toUnit) {
		this.fromValue = fromValue;
		this.fromUnit = fromUnit;
		this.toUnit = toUnit;
		this.toValue = calculateToValue(fromValue, fromUnit, toUnit);
	}

	public double getFromValue() {
		return this.fromValue;
	}
	public double getToValue() {
		return this.toValue;
	}
	public String getFromUnit() {
		return this.fromUnit;
	}
	public String getToUnit() {
		return this.toUnit;
	}

	private double calculateToValue(double fromValue, String fromUnit, String toUnit) {
		double temp;
		switch(fromUnit) {

			// 1-DIMENSIONAL CONVERSIONS

			case "in":
				switch(toUnit) {
					case "cm":
						return inToCm(fromValue);
					case "ft":
						return inToFt(fromValue);
				}
				break;
			case "cm":
				switch(toUnit) {
					case "in":
						return cmToIn(fromValue);
					case "ft":
						temp = cmToIn(fromValue);
						return inToFt(temp);
				}
			case "ft":
				switch(toUnit) {
					case "in":
						return ftToIn(fromValue);
					case "cm":
						temp = ftToIn(fromValue);
						return inToCm(temp);
					case "m":
						temp = ftToIn(fromValue);
						temp = inToCm(temp);
						return cmToM(temp);
				}
			case "m":
				switch(toUnit) {
					case "cm":
						return mToCm(fromValue);
					case "in":
						temp = mToCm(fromValue);
						return cmToIn(temp);
					case "ft":
						temp = mToCm(fromValue);
						temp = cmToIn(temp);
						return inToFt(temp);
					case "mi":
						temp = mToCm(fromValue);
						temp = cmToIn(temp);
						temp = inToFt(temp);
						return ftToMi(temp);
					case "km":
						return mToKm(fromValue);
				}
			case "mi":
				switch(toUnit) {
					case "km":
						temp = miToFt(fromValue);
						temp = ftToIn(temp);
						temp = inToCm(temp);
						temp = cmToM(temp);
						return mToKm(temp);
					case "m":
						temp = miToFt(fromValue);
						temp = ftToIn(temp);
						temp = inToCm(temp);
						return cmToM(temp);
				}

			// 2-DIMENSIONAL CONVERSIONS
			case "in2":
				switch(toUnit) {
					case "cm2":
						return in2ToCm2(fromValue);
					case "ft2":
						return in2ToFt2(fromValue);
					case "m2":
						temp = in2ToCm2(fromValue);
						return cm2ToM2(temp);
				}
		}
		return -1;
	}

	// 1-DIMENSIONAL METHODS
	private double inToCm(double num) {
		return num * 2.54;
	}
	private double cmToIn(double num) {
		return num / 2.54;
	}
	private double inToFt(double num) {
		return num / 12;
	}
	private double ftToIn(double num) {
		return num * 12;
	}
	private double ftToMi(double num) {
		return num / 5280;
	}
	private double miToFt(double num) {
		return num * 5280;
	}
	private double mToCm(double num) {
		return num * 100;
	}
	private double cmToM(double num) {
		return num / 100;
	}
	private double mToKm(double num) {
		return num / 1000;
	}
	private double kmToM(double num) {
		return num * 1000;
	}

	// 2-DIMENSIONAL METHODS
	private double in2ToCm2(double num) {
		return num * Math.pow(2.54, 2);
	}
	private double cm2ToIn2(double num) {
		return num / Math.pow(2.54, 2);
	}
	private double in2ToFt2(double num) {
		return num / Math.pow(12, 2);
	}
	private double ft2ToIn2(double num) {
		return num * Math.pow(12, 2);
	}
	private double cm2ToM2(double num) {
		return num / Math.pow(100, 2);
	}
	private double m2ToCm2(double num) {
		return num * Math.pow(100, 2);
	}

}