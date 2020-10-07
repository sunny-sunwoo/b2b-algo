package primitives;

public class ChangingBase {
	/**
	 * q. given an integer(represented as a string) under base b1, convert it to base b2.
	 * 
	 * sol.
	 * convert b1 -> 10, and then 10 -> b2
	 */
	public static String changeBase(String input, int b1, int b2) {
		return convertTenToN(convertNToTen(input, b1), b2);
	}
	
	/**
	 * accum properly with calculating the weight
	 */
	private static String convertNToTen(String input, int base) {
		int total = 0;
		
		for (int i = input.length() - 1; i >= 0; i--) {
			int weight = input.length() - 1 - i;
			char curChar = input.charAt(i);
			int curVal = 0;
			if (Character.isDigit(curChar)) {
				curVal = Character.getNumericValue(curChar);
			} else {
				curVal = curChar - 'A' + 10;
			}
			total += curVal * (int) Math.pow(base, weight);
		}
		return String.valueOf(total);
	}
	
	/**
	 * loop while the remaining num is greater than 0
	 * append remainder and reverse at the end
	 * 
	 * e.g. 
	 * 10 / 2 = 5 ... 0
	 * 5 / 2 = 2 ... 1
	 * 2 / 2 = 1 ... 0
	 * 1 / 2 = 0 ... 1
	 */
	private static String convertTenToN(String input, int base) {
		StringBuilder sb = new StringBuilder();
		int curVal = Integer.parseInt(input);

		while (curVal > 0) {
			int remainder = curVal % base;
			if (remainder < 10) {
				sb.append(remainder);
			} else {
				sb.append((char)(remainder - 10 + 'A'));
			}
			
			curVal = curVal / base;
		}
		return sb.reverse().toString();
	}

	public static void main(String[] args) {
		System.out.println(changeBase("12", 10, 2));
		System.out.println(changeBase("123", 4, 16));
		System.out.println(changeBase("123", 10, 10));
	}
}
