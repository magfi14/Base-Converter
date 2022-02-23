public class OctHex {
	
	private final OctBinary octBinary;
	private final BinHex binHex;
	private int octalNumber;
	
	/**
	 * 1. Creates a new OctHex object
	 * <br>2. Initializes the objects for OctBinary and BinHex, which will be used to aid in the conversion of said
	 * octal number to a hexadecimal sequence
	 */
	
	public OctHex ( ) {
		
		this.octBinary = new OctBinary ( );
		this.binHex = new BinHex ( );
		
	}
	
	/**
	 * Creates a new OctBinary object
	 *
	 * @param octalNumber
	 * 		the octal number that will be converted into a hexadecimal sequence
	 */
	
	public OctHex ( int octalNumber ) {
		
		this ( );
		this.inputOctalNumber ( octalNumber );
		
	}
	
	/**
	 * Defines the instructions for the OctHex constructor in this fashion:
	 * <ol>
	 *     <li>Passes the octal number down to the OctBinary object, which will be used to convert the octal number &
	 *     extract the base-2 (binary) sequence
	 *     </li>
	 *     <li>
	 *         Extracts the properly-formatted binary sequence from the OctBinary object & passes the binary sequence
	 *         to the BinHex object which will be used to convert the binary sequence into a hexadecimal (base-16)
	 *         sequence later
	 *     </li>
	 * </ol>
	 *
	 * @param octalNumber
	 * 		the octal number that will be converted into a hexadecimal sequence
	 */
	
	public void inputOctalNumber ( int octalNumber ) {
		
		this.octalNumber = octalNumber;
		this.octBinary.inputOctalNumber ( this.octalNumber );
		this.binHex.inputBinarySequence ( this.octBinary.getBits ( ) );
		
	}
	
	/**
	 * Extracts the hexadecimal sequence from the BinHex object
	 *
	 * @return the hexadecimal sequence
	 */
	
	public String getHexValue ( ) {
		
		return this.binHex.finHex ( );
		
	}
	
	/**
	 * @return the hexadecimal sequence
	 */
	
	public String finHex ( ) {
		
		return this.getHexValue ( );
		
	}
	
}