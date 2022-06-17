package conversion;

class Driver {
	public static void main(String[] args) {
		if (args.length == 0) {
			System.out.println("No args to process. Program terminated.");
		} else {
			Conversion newConv = new Conversion(Integer.parseInt(args[0]), args[1], args[2]);
			System.out.println(newConv.getFromValue() + " " + newConv.getFromUnit() + " is "
					+ newConv.getToValue() + " " + newConv.getToUnit());
		}
	}
}