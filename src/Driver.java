package conversion;

class Driver {
	public static void main(String[] args) {
		if (args.length == 0) {
			System.out.println("** No args provided. Use [VALUE] [FROM_UNIT] [TO_UNIT] to process data. **");
		} else {
			Conversion newConv = new Conversion(Double.parseDouble(args[0]), args[1], args[2]);
			// print error message if getToUnit() returns -1
			if (newConv.getToValue() == -1) {
				System.out.printf("ERROR: Can't convert from %s to %s", newConv.getFromUnit(), newConv.getToUnit());
			} else {
				System.out.printf("%,.2f %s is %,.2f %s", newConv.getFromValue(), newConv.getFromUnit(),
						newConv.getToValue(), newConv.getToUnit());
			}
		}
	}
}