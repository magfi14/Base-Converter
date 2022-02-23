import org.jetbrains.annotations.NotNull;

public class DecHex {
	
	private int decimal;
	
	/**
	 * Creates a new DecHex object
	 */
	
	public DecHex ( ) {
	}
	
	/**
	 * Creates a new DecHex object with a decimal number
	 *
	 * @param decimal
	 * 		the decimal number that will be turned into a hexadecimal sequence
	 */
	
	public DecHex ( int decimal ) {
		
		this ( );
		this.setDecimal ( decimal );
		
	}
	
	/**
	 * Inputs a decimal (base-10) number to pass to the DecHex constructor
	 *
	 * @param decimal
	 * 		the decimal (base-10) number to pass onto the constructor
	 */
	
	public void setDecimal ( int decimal ) {
		
		this.decimal = decimal;
		
	}
	
	/**
	 * 1. Creates a new <strong>private</strong> BinHex sequence to be used to retrieve the hexadecimal sequence<br />
	 * 2. Creates DecBinary converter to convert the decimal (base-10) number into a binary (base-2) sequence<br />
	 * 3. Extracts the binary (base-2) sequence from the BinHex object instance to pass onto the BinHex object
	 * instance which is then retrieved in its entirety
	 *
	 * @return a BinHex sequence, which holds the data for the hexadecimal (base-16) sequence to be extracted and
	 * 		converted into other bases, base-2 (binary), base-8 (octal) and base-10 (decimal) later
	 */
	
	private @NotNull
	BinHex hexSequence ( ) {
		
		DecBinary binarySequence = new DecBinary ( this.decimal );
		BinHex hexSequence = new BinHex ( binarySequence.toString ( ) );
		
		return hexSequence;
		
	}
	
	/**
	 * Extracts the hexadecimal sequence from the BinHex object instance
	 *
	 * @return the hexadecimal sequence
	 */
	
	public String finHex ( ) {
		
		return this.hexSequence ( ).finHex ( );
		
	}
	
}