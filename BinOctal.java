import java.util.ArrayList;

public class BinOctal {
	
	private final byte BASE = 8;
	public int[] binarySequence;
	
	/**
	 * Creates an empty BinOctal constructor
	 */
	
	public BinOctal ( ) {
	}
	
	/**
	 * Creates a new BinOctal constructor with the parameter being a sequence of bits
	 *
	 * @param bits
	 * 		the binary sequence of 0's and 1's to convert to octal (base 8)
	 */
	
	public BinOctal ( String bits ) {
		
		this.inputBinarySequence ( bits );
		
	}
	
	/**
	 * 1. Transfers a binary sequence by fattening the new binary sequence with as many 0's as required to turn it
	 * into a proper 3-bit binary sequence <br />
	 * 2. Adds the binary sequence onto the 0's at the beginning of the initial sequence according to the length of the
	 * initial sequence required to maintain the standard length of the proper 3-bit binary sequence <br />
	 * 3. Stores the binary sequence into an array to be used later
	 *
	 * @param bits
	 * 		the binary sequence of 0's and 1's to convert to octal (base 8)
	 */
	
	public void inputBinarySequence ( String bits ) {
		
		String newBits = bits;
		String tempBits = "";
		int g = newBits.length ( ), h = 0, i = 0;
		
		while ( g < newBits.length ( ) + ( 3 - ( newBits.length ( ) % 3 ) ) ) {
			
			tempBits += "0";
			g++;
			
		}
		
		tempBits += newBits;
		
		binarySequence = new int[ tempBits.length ( ) ];
		
		while ( h < binarySequence.length ) {
			
			binarySequence[ h ] = Integer.parseInt ( tempBits.substring ( h , h++ + 1 ) );
			
		}
		
	}
	
	/**
	 * 1. Creates an expandable ArrayList of type Integer to store 3-bit sequences of the given binary sequence in
	 * sequential order from left-to-right <br />
	 * 2. Creates a dual-dimensional array with the lengths of the finished ArrayList database to store the finalized
	 * 3-bit binary sequences
	 *
	 * @return a recognizable dual-dimensional array with the properly-formatted 3-bit binary sequences to be used to
	 * 		get the octal value
	 */
	
	public int[][] octBits ( ) {
		
		ArrayList < ArrayList < Integer > > octBitsTemp = new ArrayList < ArrayList < Integer > > ( );
		
		int g = 0, tick = 3, h = 0, i = 0, j = 0;
		
		while ( g < binarySequence.length ) {
			
			ArrayList < Integer > oct3 = new ArrayList < Integer > ( );
			
			while ( h < tick ) {
				
				oct3.add ( binarySequence[ g++ ] );
				h++;
				
			}
			
			h = 0;
			octBitsTemp.add ( oct3 );
			
		}
		
		int[][] octBits = new int[ octBitsTemp.size ( ) ][ 3 ];
		
		while ( i < octBits.length ) {
			
			ArrayList < Integer > list = octBitsTemp.get ( i );
			
			while ( j < list.size ( ) ) {
				
				octBits[ i ][ j ] = list.get ( j++ );
				
			}
			
			i++;
			j = 0;
			
		}
		
		return octBits;
		
	}
	
	/**
	 * 1. Creates a two-power reference array to match a 3-bit binary sequence against when converting a binary
	 * sequence into a single octal number <br />
	 * 2. Creates an octal character reference array with all of the numbers already listed in octal format in direct
	 * accordance with their respective index in the reference array <br />
	 * 3. Uses a while-loop to produce a sum by multiplying the number's two-power value respective to the specific
	 * 3-bit binary sequence by the number's binary value (0 or 1). This sum is less than or equal to 7 & denotes the
	 * index of the octal number from the reference array
	 *
	 * @param octBits
	 * 		the 3-bit binary sequence to turn into an octal number
	 *
	 * @return the respective octal value of the specific 3-bit binary sequence
	 */
	
	public int octCharacter ( int[] octBits ) {
		
		int[] tempOctBits = new int[] { 4 , 2 , 1 };
		int sum = 0, g = 0, finalIndex = 0;
		int[] characterList = new int[] { 0 , 1 , 2 , 3 , 4 , 5 , 6 , 7 };
		
		while ( g < octBits.length ) {
			
			sum += tempOctBits[ g ] * octBits[ g++ ];
			
		}
		
		finalIndex = sum;
		
		return characterList[ finalIndex ];
		
	}
	
	/**
	 * 1. Extracts the dual-dimensional 3-bit binary sequential database <br />
	 * 2. Uses a loop to run through the 3-bit sequential database, forming a sequential sequence of octal
	 * numbers in descending sequential order
	 *
	 * @return a neatly-formatted octal number for a sequence of binary characters
	 */
	
	public int finOct ( ) {
		
		int[][] octBits = this.octBits ( );
		String finOct = "";
		
		int g = 0;
		
		while ( g < octBits.length ) {
			
			finOct += this.octCharacter ( octBits[ g++ ] );
			
		}
		
		return Integer.parseInt ( finOct );
		
	}
	
}