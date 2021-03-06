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
					case "m":
						temp = inToCm(fromValue);
						return cmToM(temp);
					case "mm":
						temp = inToCm(fromValue);
						return cmToMm(temp);
				}
			case "cm":
				switch(toUnit) {
					case "in":
						return cmToIn(fromValue);
					case "ft":
						temp = cmToIn(fromValue);
						return inToFt(temp);
				}
			case "mm":
				switch (toUnit) {
					case "cm":
						return mmToCm(fromValue);
					case "in":
						temp = mmToCm(fromValue);
						return cmToIn(temp);
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
			case "km":
				switch (toUnit) {
					case "mi":
						temp = kmToM(fromValue);
						temp = mToCm(temp);
						temp = cmToIn(temp);
						temp = inToFt(temp);
						return ftToMi(temp);
					case "m":
						return kmToM(fromValue);
					case "ft":
						temp = kmToM(fromValue);
						temp = mToCm(temp);
						temp = cmToIn(temp);
						return inToFt(temp);
					default:
						return -1;
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
					case "ft":
						return miToFt(fromValue);
					default:
						return -1;
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
					case "mm2":
						temp = in2ToCm2(fromValue);
						return cm2ToMm2(temp);
					default:
						return -1;
				}
			case "ft2":
				switch (toUnit) {
					case "in2":
						return ft2ToIn2(fromValue);
					case "cm2":
						temp = ft2ToIn2(fromValue);
						return in2ToCm2(temp);
					case "m2":
						temp = ft2ToIn2(fromValue);
						temp = in2ToCm2(temp);
						return cm2ToM2(temp);
					case "mi2":
						return ft2ToMi2(fromValue);
					case "ac":
						return ft2ToAc(fromValue);
				}
			case "m2":
				switch (toUnit) {
					case "cm2":
						return m2ToCm2(fromValue);
					case "ft2":
						temp = m2ToCm2(fromValue);
						temp = cm2ToIn2(temp);
						return in2ToFt2(temp);
					case "in2":
						temp = m2ToCm2(fromValue);
						return cm2ToIn2(temp);
					case "ac":
						temp = m2ToCm2(fromValue);
						temp = cm2ToIn2(temp);
						temp = in2ToFt2(temp);
						return ft2ToAc(temp);
				}
			case "ha":
				switch (toUnit) {
					case "m2":
						return haToM2(fromValue);
					case "mi2":
						temp = haToM2(fromValue);
						temp = m2ToCm2(temp);
						temp = cm2ToIn2(temp);
						temp = in2ToFt2(temp);
						return ft2ToMi2(temp);
					case "ft2":
						temp = haToM2(fromValue);
						temp = m2ToCm2(temp);
						temp = cm2ToIn2(temp);
						return in2ToFt2(temp);
					case "ac":
						temp = haToM2(fromValue);
						temp = m2ToCm2(temp);
						temp = cm2ToIn2(temp);
						temp = in2ToFt2(temp);
						return ft2ToAc(temp);
				}
			case "mi2":
				switch (toUnit) {
					case "ha":
						temp = mi2ToFt2(fromValue);
						temp = ft2ToIn2(temp);
						temp = in2ToCm2(temp);
						temp = cm2ToM2(temp);
						return m2ToHa(temp);
					case "ft2":
						return mi2ToFt2(fromValue);
				}
			case "ac":
				switch (toUnit) {
					case "ha":
						temp = acToFt2(fromValue);
						temp = ft2ToIn2(temp);
						temp = in2ToCm2(temp);
						temp = cm2ToM2(temp);
						return m2ToHa(temp);
				}

			// 3_DIMENSIONAL CONVERSIONS
			case "gal":
				switch(toUnit) {
					case "L":
						return galToL(fromValue);
					case "mL":
						temp = galToL(fromValue);
						return lToML(temp);
					case "qt":
						return galToQt(fromValue);
					case "pt":
						return galToPt(fromValue);
					case "cup":
						return galToCup(fromValue);
					case "floz":
						return galToFloz(fromValue);
					default:
						return -1;
				}
			case "L":
				switch(toUnit) {
					case "gal":
						return lToGal(fromValue);
					case "mL":
						return lToML(fromValue);
					case "qt":
						temp = lToGal(fromValue);
						return galToQt(temp);
				}
			case "C":
				switch (toUnit) {
					case "F":
						return cToF(fromValue);
					case "K":
						return cToK(fromValue);
					default:
						return -1;
				}
			case "F":
				switch (toUnit) {
					case "C":
						return fToC(fromValue);
					case "K":
						temp = fToC(fromValue);
						return cToK(temp);
					default:
						return -1;
				}
			case "K":
				switch (toUnit) {
					case "C":
						return kToC(fromValue);
					case "F":
						temp = kToC(fromValue);
						return cToF(temp);
					default:
						return -1;
				}
			case "oz":
				switch (toUnit) {
					case "g":
						temp = ozToLb(fromValue);
						return lbToG(temp);
					case "lb":
						return ozToLb(fromValue);
					case "kg":
						temp = ozToLb(fromValue);
						temp = lbToG(temp);
						return gToKg(temp);
				}
			case "lb":
				switch (toUnit) {
					case "g":
						return lbToG(fromValue);
					case "kg":
						temp = lbToG(fromValue);
						return gToKg(temp);
					case "oz":
						return lbToOz(fromValue);
				}
			case "g":
				switch (toUnit) {
					case "lb":
						return gToLb(fromValue);
					case "kg":
						return gToKg(fromValue);
					case "oz":
						temp = gToLb(fromValue);
						return lbToOz(temp);
				}
			case "kg":
				switch (toUnit) {
					case "g":
						return kgToG(fromValue);
					case "lb":
						temp = kgToG(fromValue);
						return gToLb(temp);
					case "oz":
						temp = kgToG(fromValue);
						temp = gToLb(temp);
						return lbToOz(temp);
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
	private double cmToMm(double num) {
		return num * 10;
	}
	private double mmToCm(double num) {
		return num / 10;
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
	private double ft2ToMi2(double num) {
		return num / Math.pow(5280, 2);
	}
	private double mi2ToFt2(double num) {
		return num * Math.pow(5280, 2);
	}
	private double cm2ToM2(double num) {
		return num / Math.pow(100, 2);
	}
	private double m2ToCm2(double num) {
		return num * Math.pow(100, 2);
	}
	private double m2ToKm2(double num) {
		return num / Math.pow(1000, 2);
	}
	private double km2ToM2(double num) {
		return num * Math.pow(1000, 2);
	}
	private double cm2ToMm2(double num) {
		return num * Math.pow(10, 2);
	}
	private double mm2ToCm2(double num) {
		return num / Math.pow(10, 2);
	}
	// ha (hectare) is a measure of area equal to 10,000 m2 (100m x 100m)
	private double m2ToHa(double num) {
		return num / Math.pow(100, 2);
	}
	private double haToM2(double num) {
		return num * Math.pow(100, 2);
	}
	private double ft2ToAc(double num) {
		return num / 43560;
	}
	private double acToFt2(double num) {
		return num * 43560;
	}

	// 3-DIMENSIONAL METHODS
	private double lToML(double num) {
		return num * 1000;
	}
	private double mLToL(double num) {
		return num / 1000;
	}
	private double galToL(double num) {
		return num * 3.785;
	}
	private double lToGal(double num) {
		return num / 3.785;
	}
	private double galToQt(double num) {
		return num * 4;
	}
	private double qtToGal(double num) {
		return num / 4;
	}
	private double galToPt(double num) {
		return num * 8;
	}
	private double ptToGal(double num) {
		return num / 8;
	}
	private double galToCup(double num) {
		return num * 16;
	}
	private double cupToGal(double num) {
		return num / 16;
	}
	private double galToFloz(double num) {
		return num * 128;
	}
	private double flozToGal(double num) {
		return num / 128;
	}

	// TIME METHODS
	private double yearToMonth(double num) {
		return num * 12;
	}
	private double monthToYear(double num) {
		return num / 12;
	}
	private double yearToDay(double num) {
		return num * 365;
	}
	private double dayToYear(double num) {
		return num / 365;
	}
	private double dayToHr(double num) {
		return num * 24;
	}
	private double hrToDay(double num) {
		return num / 24;
	}
	private double hrToMin(double num) {
		return num * 60;
	}
	private double minToHr(double num) {
		return num / 60;
	}
	private double minToS(double num) {
		return num * 60;
	}
	private double sToMin(double num) {
		return num / 60;
	}

	// TEMPERATURE METHODS

	private double fToC(double num) {
		return (num - 32) / 1.8;
	}
	private double cToF(double num) {
		return num * 1.8 + 32;
	}
	private double cToK(double num) {
		return num + 273.15;
	}
	private double kToC(double num) {
		return num - 273.15;
	}

	// WEIGHT METHODS

	private double gToLb(double num) {
		return num / 454;
	}
	private double lbToG(double num) {
		return num * 454;
	}
	private double gToKg(double num) {
		return num / 1000;
	}
	private double kgToG(double num) {
		return num * 1000;
	}
	private double ozToLb(double num) {
		return num / 16;
	}
	private double lbToOz(double num) {
		return num * 16;
	}
}