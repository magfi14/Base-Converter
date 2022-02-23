public class HexOctal {
	
	private String hexNumber;
	private HexBinary hexBinary;
	private BinDecimal binDecimal;
	private DecOctal decOctal;
	
	/**
	 * Creates a new HexOctal object
	 */
	
	public HexOctal ( ) {
	}
	
	/**
	 * Creates a new HexOctal object with a hexadecimal sequence
	 *
	 * @param hexNumber
	 * 		the hexadecimal sequence that will be turned into an octal number
	 */
	
	public HexOctal ( String hexNumber ) {
		
		this ( );
		this.inputHexNumber ( hexNumber );
		
	}
	
	/**
	 * Defines the instructions for the HexOctal constructor, where a hexadecimal sequence is transferred to the
	 * constructor and HexBinary and BinDecimal objects are initialized in this fashion: <br /><ol>
	 * <li>The HexBinary object instance retrieves the hexadecimal sequence</li>
	 * <li>The hexadecimal sequence, once passed to the HexBinary object instance, gets converted into a
	 * properly-formatted binary sequence, which is then passed onto the BinDecimal object instance
	 * </li>
	 * <li>The binary sequence, once passed to the BinDecimal object instance, gets converted into a decimal value,
	 * which is then passed onto the DecOctal object instance
	 * </li>
	 * </ol>
	 *
	 * @param hexNumber
	 * 		the hexadecimal sequence that will be turned into an octal number
	 */
	
	public void inputHexNumber ( String hexNumber ) {
		
		this.hexNumber = hexNumber;
		this.hexBinary = new HexBinary ( this.hexNumber );
		this.binDecimal = new BinDecimal ( this.hexBinary.getBits ( ) );
		this.decOctal = new DecOctal ( this.binDecimal.finDec ( ) );
		
	}
	
	/**
	 * Retrieves the octal number from the DecOctal object instance
	 *
	 * @return the octal number
	 */
	
	public int getOctalNumber ( ) {
		
		return this.decOctal.finOct ( );
		
	}
	
	/**
	 * @return the octal number
	 */
	
	public int finOct ( ) {
		
		return this.getOctalNumber ( );
		
	}
	
}