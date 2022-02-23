public class HexDecimal {
	
	private String hexNumber;
	private HexOctal hexOctal;
	private OctDecimal octDecimal;
	
	/**
	 * Creates a new HexDecimal object
	 */
	
	public HexDecimal ( ) {
	}
	
	/**
	 * Creates a new HexDecimal object with a hexadecimal sequence
	 *
	 * @param hexNumber
	 * 		the hexadecimal sequence that will be turned into a decimal number
	 */
	
	public HexDecimal ( String hexNumber ) {
		
		this ( );
		this.inputHexNumber ( hexNumber );
		
	}
	
	/**
	 * Defines the instructions for the HexDecimal constructor, where a hexadecimal sequence is transferred to the
	 * constructor and HexOctal and OctDecimal objects are initialized in this fashion:
	 * <ol><li>The HexOctal object instance retrieves the hexadecimal sequence
	 * </li>
	 * <li>The hexadecimal sequence, once passed to the HexOctal object instance, gets converted into an
	 * octal number, which is then passed onto the OctDecimal object instance</li></ol>
	 *
	 * @param hexNumber
	 * 		the hexadecimal sequence that will be turned into a decimal number
	 */
	
	public void inputHexNumber ( String hexNumber ) {
		
		this.hexNumber = hexNumber;
		this.hexOctal = new HexOctal ( this.hexNumber );
		this.octDecimal = new OctDecimal ( this.hexOctal.getOctalNumber ( ) );
		
	}
	
	/**
	 * Retrieves the decimal number from the OctDecimal object instance
	 *
	 * @return the decimal number
	 */
	
	public int getDecimalNumber ( ) {
		
		return this.octDecimal.getDecimalNumber ( );
		
	}
	
	/**
	 * @return the decimal number
	 */
	
	public int finDec ( ) {
		
		return this.getDecimalNumber ( );
		
	}
	
}
