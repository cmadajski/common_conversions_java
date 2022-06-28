package conversion;

class Driver {
	public static void main(String[] args) {

		if (args.length == 0) {
			// print an error when no args are provided
			System.out.println("ERROR: NO_ARGS. Use [VALUE] [FROM_UNIT] [TO_UNIT] to process data.");
		} else if (args.length < 3) {
			// print an error when not enough args are provided
			System.out.println("ERROR: MISSING_ARGS. Must provide [VALUE] [FROM_UNIT] [TO_UNIT] to process data.");
		} else if (args.length > 3) {
			// print an error when too many args are provided
			System.out.println("ERROR: EXTRA_ARGS. Only provide [VALUE] [FROM_UNIT] [TO_UNIT] as args.");
		} else {
			Conversion newConv = new Conversion(Double.parseDouble(args[0]), args[1], args[2]);
			// print error message if getToUnit() returns -1
			if (newConv.getToValue() == -1) {
				System.out.printf("ERROR: INVALID_CONVERSION. Can't convert from %s to %s.\n", newConv.getFromUnit(), newConv.getToUnit());
			} else {
				System.out.printf("%,.2f %s is %,.2f %s\n", newConv.getFromValue(), newConv.getFromUnit(),
						newConv.getToValue(), newConv.getToUnit());
			}
		}
	}
}