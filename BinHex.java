import java.util.ArrayList;

public class BinHex {
	
	private final byte BASE = 16;
	public int[] binarySequence;
	
	/**
	 * Creates an empty BinHex constructor
	 */
	
	public BinHex ( ) {
	}
	
	/**
	 * Creates a new BinHex constructor with the parameter being a sequence of bits
	 *
	 * @param bits
	 * 		the binary sequence of 0's and 1's to convert to hexadecimal (base 16)
	 */
	
	public BinHex ( String bits ) {
		
		this.inputBinarySequence ( bits );
		
	}
	
	/**
	 * 1. Transfers a binary sequence by fattening the new binary sequence with as many 0's as required to turn it into
	 * a whole byte <br />
	 * 2. Adds the binary sequence onto the 0's at the beginning of the initial sequence according to the length of
	 * the initial sequence required to maintain the standard byte length <br />
	 * 3. Stores the binary sequence into an array to be used later
	 *
	 * @param bits
	 * 		the binary sequence of 0's and 1's to convert to hexadecimal (base 16)
	 */
	
	public void inputBinarySequence ( String bits ) {
		
		String newBits = bits;
		String tempBits = "";
		int g = newBits.length ( ), h = 0, i = 0;
		
		while ( g < newBits.length ( ) + ( 4 - ( newBits.length ( ) % 4 ) ) ) {
			
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
	 * 1. Creates an expandable ArrayList of type Integer to store 4-bit sequences of the given binary sequence in
	 * sequential order from left-to-right <br />
	 * 2. Creates a dual-dimensional array with the lengths of the finished ArrayList database to store the finalized
	 * four-bit binary sequences <br />
	 *
	 * @return a recognizable dual-dimensional array with the properly-formatted 4-bit binary sequences to be used to
	 * 		get the hexadecimal value
	 */
	
	public int[][] hexBits ( ) {
		
		ArrayList < ArrayList < Integer > > hexBitsTemp = new ArrayList < ArrayList < Integer > > ( );
		
		int g = 0, tick = 4, h = 0, i = 0, j = 0;
		
		while ( g < this.binarySequence.length ) {
			
			ArrayList < Integer > hex4 = new ArrayList < Integer > ( );
			
			while ( h < tick ) {
				
				hex4.add ( this.binarySequence[ g++ ] );
				h++;
				
			}
			
			h = 0;
			hexBitsTemp.add ( hex4 );
			
		}
		
		int[][] hexBits = new int[ hexBitsTemp.size ( ) ][ 4 ];
		
		while ( i < hexBits.length ) {
			
			ArrayList < Integer > list = hexBitsTemp.get ( i );
			
			while ( j < list.size ( ) ) {
				
				hexBits[ i ][ j ] = list.get ( j++ );
				
			}
			
			i++;
			j = 0;
			
		}
		
		return hexBits;
		
	}
	
	/**
	 * 1. Creates a two-power reference array to match a 4-bit binary sequence against when converting a binary
	 * sequence into a single hexadecimal character <br />
	 * 2. Creates a hexadecimal character reference array with all of the characters already listed in hexadecimal
	 * format
	 * in direct accordance with their respective index in the array as follows: 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, A, B,
	 * C, D, E, F; A = 10, B = 11, C = 12, D = 13, E = 14, F = 15 <br />
	 * 3. Uses a while-loop to produce a sum by multiplying the character's two-power value respective to the
	 * specific 4-bit binary sequence by the character's binary value (0 or 1). This sum is less than or equal to 15
	 * & denotes the index of the hexadecimal character from the reference array
	 *
	 * @param hexBits
	 * 		the 4-bit binary sequence to turn into a hexadecimal character
	 *
	 * @return the respective hexadecimal value of the specific 4-bit binary sequence
	 */
	
	public String hexCharacter ( int[] hexBits ) {
		
		int[] tempHexBits = new int[] { 8 , 4 , 2 , 1 };
		int sum = 0, g = 0, finalIndex = 0;
		String[] characterList = new String[] { "0" , "1" , "2" , "3" , "4" , "5" , "6" , "7" , "8" , "9" , "A" , "B"
				, "C" , "D" , "E" , "F" };
		
		while ( g < hexBits.length ) {
			
			sum += tempHexBits[ g ] * hexBits[ g++ ];
			
		}
		
		finalIndex = sum;
		
		return characterList[ finalIndex ];
		
	}
	
	/**
	 * 1. Extracts the dual-dimensional 4-bit binary sequential database <br />
	 * 2. Uses a loop to run through the 4-bit sequential database, forming a sequential string of hexadecimal
	 * characters in descending sequential order
	 *
	 * @return a neatly-formatted hexadecimal value for a sequence of binary characters
	 */
	
	public String finHex ( ) {
		
		int[][] hexBits = this.hexBits ( );
		String finHex = "";
		
		int g = 0;
		
		while ( g < hexBits.length ) {
			
			finHex += this.hexCharacter ( hexBits[ g++ ] );
			
		}
		
		return finHex;
		
	}
	
}