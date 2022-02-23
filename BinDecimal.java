public class BinDecimal {
	
	private final byte BASE = 2;
	public int[] binarySequence, tempBinarySequence;
	
	/**
	 * Creates an empty BinDecimal constructor
	 */
	
	public BinDecimal ( ) {
	}
	
	/**
	 * Creates a new BinDecimal constructor with the parameter being a sequence of bits
	 *
	 * @param bits
	 * 		the binary sequence of 0's and 1's to convert to decimal (base 10)
	 */
	
	public BinDecimal ( String bits ) {
		
		this ( );
		this.inputBinarySequence ( bits );
		
	}
	
	/**
	 * Creates two arrays: array 1, to store the integer values of the single bits from the parameter value; array
	 * 2, to
	 * store a 2-power table of the integer values according to their indexed position in the sequence, ascending, from
	 * right to left
	 *
	 * @param bits
	 * 		the binary sequence of 0's and 1's to convert to decimal (base 10)
	 */
	
	public void inputBinarySequence ( String bits ) {
		
		int g = 0, h = 0;
		this.binarySequence = new int[ bits.length ( ) ];
		this.tempBinarySequence = new int[ bits.length ( ) ];
		
		while ( g < this.binarySequence.length ) {
			
			this.binarySequence[ g ] = Integer.parseInt ( bits.substring ( g , g++ + 1 ) );
			
		}
		
		while ( h < this.binarySequence.length || h < this.tempBinarySequence.length ) {
			
			this.tempBinarySequence[ h ] = ( int ) Math.pow ( 2 , this.tempBinarySequence.length - ( h++ + 1 ) );
			
		}
		
	}
	
	/**
	 * Adds up each bit in the sequence by mutliplying the bit's value (0 or 1) by the two-power of the base
	 * relative to
	 * the right-to-left position in the sequence, going left-to-right
	 *
	 * @return the decimal number
	 */
	
	public int getDecimalNumber ( ) {
		
		int g = 0, h = 0, sum = 0;
		
		while ( g < this.tempBinarySequence.length || h < this.binarySequence.length ) {
			
			sum += ( this.binarySequence[ g++ ] * this.tempBinarySequence[ h++ ] );
			
		}
		
		return sum;
		
	}
	
	/**
	 * Gets the string value of the new decimal number in base-10 after the conversion from binary (base-2) to decimal
	 * (base-10) is finished
	 *
	 * @return the converted number
	 */
	
	public String toString ( ) {
		return Integer.toString ( this.getDecimalNumber ( ) );
	}
	
	/**
	 * @return the converted decimal number
	 */
	
	public int finDec ( ) {
		return this.getDecimalNumber ( );
	}
	
}
