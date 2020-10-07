package primitives;

public class PowerOfFour {
	/**
	 * q. validate if input is power of 4.
	 * 
	 * sol.
	 * power of fours (base 2) =>  1, 100(=4), 10000(=16), 1000000(4^3=2^6=64)
	 * 
	 * 1) nonZero
	 * 2) should have single leading one bit 
	 *    => e.g. input = 100, then (input-1) = 011
	 * 3) should odd positioned bits 
	 *    => 1 or 3 or 5 or 7 or ... 
	 *    => (base2) 1010101...1 // (base16)0x55555555
	 *    
	 *    => 7 6 5 4 | 3 2 1 0
	 *    => 0 1 0 1 | 0 1 0 1
	 *    
	 *    =>  16 * 5 | 16^0  * 5
	 */
	public static boolean isPowerOfFour(int input) {
		int mask = 0x55555555;
		
		boolean isNonZero = input != 0;
		boolean hasSingleLeadingOneBit = (input & (input - 1)) == 0;
		boolean hasOddPositionedBits = (input & mask) == input;
		
		return isNonZero && hasSingleLeadingOneBit && hasOddPositionedBits;
	}
	
	public static void main(String[] args) {
		System.out.println(isPowerOfFour(16)); // true
		System.out.println(isPowerOfFour(8)); // false
	}

}
