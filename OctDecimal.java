import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public class OctDecimal {
	
	private int octNumber;
	
	/**
	 * Creates a new OctDecimal object
	 */
	
	public OctDecimal ( ) {
	}
	
	/**
	 * Creates a new OctDecimal object with an octal number
	 *
	 * @param octNumber
	 * 		the octal number that will be turned into a decimal number
	 */
	
	public OctDecimal ( int octNumber ) {
		
		this ( );
		this.setOctNumber ( octNumber );
		
	}
	
	/**
	 * Defines the instructions for the OctDecimal constructor, where an octal number is transferred to the constructor
	 *
	 * @param octNumber
	 * 		the octal number that will be turned into a decimal number
	 */
	
	public void setOctNumber ( int octNumber ) {
		
		this.octNumber = octNumber;
		
	}
	
	/**
	 * @return an OctBinary object
	 */
	
	@Contract ( " -> new" )
	private @NotNull OctBinary octBinary ( ) {
		
		return new OctBinary ( this.octNumber );
		
	}
	
	/**
	 * 1. Initializes a new empty BinDecimal object instance
	 * <br>2. Using the OctBinary object instance, the octal (base-8) number is converted into a binary sequence,
	 * then extracted into a database
	 * <br>3. A loop is used to string each base-2 (binary) number together into a recognizable string base-2
	 * sequence which the
	 * BinDecimal object can decipher to convert into a decimal (base-10) number
	 * <br>4. Since the base-2 (binary) sequence is now in a properly-formatted, possible-to-decipher string format,
	 * the BinDecimal
	 *
	 * @return a BinDecimal object, which will be used to extract the decimal (base-10) number
	 */
	
	private BinDecimal binDecimal ( ) {
		
		BinDecimal binDecimal = null;
		
		String binarySequence = "";
		int[] arrayBinarySequence = this.octBinary ( ).createBinarySequence ( );
		
		int g = 0;
		
		while ( g < arrayBinarySequence.length ) {
			
			binarySequence += ( Integer.toString ( arrayBinarySequence[ g++ ] ) );
			
		}
		
		binDecimal = new BinDecimal ( binarySequence );
		
		return binDecimal;
		
	}
	
	/**
	 * Extracts and retrieves the base-10 (decimal) number from the binary sequence by using the BinDecimal object
	 * instance
	 *
	 * @return the base-10 (decimal) number
	 */
	
	public int getDecimalNumber ( ) {
		
		return this.binDecimal ( ).finDec ( );
		
	}
	
	/**
	 * @return the decimal number
	 */
	
	public int finDec ( ) {
		
		return this.getDecimalNumber ( );
		
	}
	
}
