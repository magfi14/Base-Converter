import org.jetbrains.annotations.NotNull;

public class DecOctal {
	
	private int decimal;
	
	/**
	 * Creates a new DecOctal object
	 */
	
	public DecOctal ( ) {
	}
	
	/**
	 * Creates a new DecOctal object with a new decimal number
	 *
	 * @param decimal
	 * 		the decimal number that will be turned into an octal number
	 */
	
	public DecOctal ( int decimal ) {
		
		this ( );
		this.setDecimal ( decimal );
		
	}
	
	/**
	 * Inputs a decimal (base-10) number to pass to the DecOctal constructor
	 *
	 * @param decimal
	 * 		the decimal (base-10) number to pass onto the constructor
	 */
	
	public void setDecimal ( int decimal ) {
		
		this.decimal = decimal;
		
	}
	
	/**
	 * 1. Creates a new <strong>private</strong> BinOctal sequence to be used to retrieve the octal number<br />
	 * 2. Creates DecBinary converter to convert the decimal (base-10) number into a binary (base-2) sequence<br />
	 * 3. Extracts the binary (base-2) sequence from the BinOctal object instance to pass onto the BinOctal object
	 * instance which is then retrieved in its entirety
	 *
	 * @return a BinOctal sequence, which holds the data for the octal (base-8) number to be extracted and converted
	 * 		into other bases, base-2 (binary), base-10 (decimal) and base-16 (hexadecimal) later
	 */
	
	private @NotNull
	BinOctal octalSequence ( ) {
		
		DecBinary binarySequence = new DecBinary ( this.decimal );
		BinOctal octalSequence = new BinOctal ( binarySequence.toString ( ) );
		
		return octalSequence;
		
	}
	
	/**
	 * Extracts the octal number from the BinOctal object instance
	 *
	 * @return the octal number
	 */
	
	public int finOct ( ) {
		
		return this.octalSequence ( ).finOct ( );
		
	}
	
}