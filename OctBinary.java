import java.util.ArrayList;

public class OctBinary {
	
	public final int[] BASES = { 4 , 2 , 1 };
	public ArrayList < Integer > binarySequence;
	public int octNumber;
	
	/**
	 * Creates a new OctBinary object with a flexible binary sequence of ArrayList type integer
	 */
	
	public OctBinary ( ) {
		
		binarySequence = new ArrayList < Integer > ( );
		
	}
	
	/**
	 * Creates a new OctBinary object with an octal number
	 *
	 * @param octNumber
	 * 		the octal number that will be turned into a binary sequence
	 */
	
	public OctBinary ( int octNumber ) {
		
		this ( );
		this.inputOctalNumber ( octNumber );
		
	}
	
	/**
	 * Retrieves the octal number
	 *
	 * @return the octal number
	 */
	
	public int getOctNumber ( ) {
		
		return this.octNumber;
		
	}
	
	/**
	 * Inputs an octal number
	 *
	 * @param octNumber
	 * 		the octal number
	 */
	
	public void inputOctalNumber ( int octNumber ) {
		
		this.octNumber = octNumber;
		
	}
	
	/**
	 * Converts an octal number into an array of integer values, each of which whose range lies from 0 to 7
	 *
	 * @return an integer array consisting of all the numeric octal values from the octal number
	 */
	
	public int[] createOctalSequence ( ) {
		
		String tempOctalSequence = Integer.toString ( this.octNumber );
		int h = 0;
		
		int[] arrayOctalSequence = new int[ tempOctalSequence.length ( ) ];
		
		while ( h < arrayOctalSequence.length ) {
			
			arrayOctalSequence[ h ] = Integer.parseInt ( tempOctalSequence.substring ( h , h++ + 1 ) );
			
		}
		
		return arrayOctalSequence;
		
	}
	
	/**
	 * 1. Creates a resizeable ArrayList database to store all of the 3-bit binary sequences of each octal digit<br>
	 * 2. Extracts the Integer array from the octal number via a loop<br>
	 * 3. Loops through the octal number and creates a temporary storage space to store the 3-bit binary
	 * sequence, which is then added to the databasae in chronological descending order at the very end of the
	 * loop iteration. Two reference arrays are used to facilitate the conversion of octal numbers into 3-bit
	 * binary sequences:
	 * <ol>
	 *     <li>An octal number reference array, with values 0, 1, 2, 3, 4, 5, 6, and 7</li>
	 *     <li>A dual-dimensional predetermined 3-bit binary sequence reference array, with values 0 to 7 listed in
	 *     3-bit binary sequences which directly correspond via shared indices with the octal numbers
	 *     </li>
	 * </ol>
	 * 4. Once the resizeable database is finalized at the end of the last iteration, an initial fixed-size dual
	 * dimensional array is used to store the finalized 3-bit sequences of binary numbers in their respective order.
	 * A loop neatly transfers the data from the resizeable database to the fixed-size database. Interior loop
	 * controls control facilitation of exchange of data
	 *
	 * @return a chronological list of 3-bit binary sequences from the octal number
	 */
	
	public int[] createBinarySequence ( ) {
		
		ArrayList < ArrayList < Integer > > tempBinarySequence = new ArrayList < ArrayList < Integer > > ( );
		
		int[] interiorOctalSequence = new int[ this.createOctalSequence ( ).length ];
		
		int f = 0;
		
		while ( f < interiorOctalSequence.length ) {
			
			interiorOctalSequence[ f ] = this.createOctalSequence ( )[ f++ ];
			
		}
		
		int g = 0, h = 0, i = 0, j = 0, k = 0, l = 0, m = 0;
		
		while ( g < interiorOctalSequence.length ) {
			
			h = 0;
			int chosenNumber = interiorOctalSequence[ g++ ];
			ArrayList < Integer > tempInteriorBinarySequence = new ArrayList < Integer > ( );
			int[] octalRoster = new int[] { 0 , 1 , 2 , 3 , 4 , 5 , 6 , 7 };
			int[][] binaryRoster = new int[][]
					                       {
							                       { 0 , 0 , 0 } ,
							                       { 0 , 0 , 1 } ,
							                       { 0 , 1 , 0 } ,
							                       { 0 , 1 , 1 } ,
							                       { 1 , 0 , 0 } ,
							                       { 1 , 0 , 1 } ,
							                       { 1 , 1 , 0 } ,
							                       { 1 , 1 , 1 }
					                       };
			
			while ( h < binaryRoster[ chosenNumber ].length ) {
				
				tempInteriorBinarySequence.add ( binaryRoster[ chosenNumber ][ h++ ] );
				
			}
			
			tempBinarySequence.add ( tempInteriorBinarySequence );
			
		}
		
		int[][] tempHardBinarySequence = new int[ tempBinarySequence.size ( ) ][ 3 ];
		int[] binarySequence = new int[ tempBinarySequence.size ( ) * 3 ];
		
		while ( i < tempBinarySequence.size ( ) ) {
			
			while ( j < tempBinarySequence.get ( i ).size ( ) ) {
				
				tempHardBinarySequence[ i ][ j ] = tempBinarySequence.get ( i ).get ( j++ );
				
				if ( j >= tempBinarySequence.get ( i ).size ( ) ) {
					
					break;
					
				}
				
			}
			
			i++;
			j = 0;
			
		}
		
		while ( k < tempHardBinarySequence.length ) {
			
			while ( l < tempHardBinarySequence[ k ].length ) {
				
				binarySequence[ m++ ] = tempHardBinarySequence[ k ][ l++ ];
				
				if ( l >= tempHardBinarySequence[ k ].length ) {
					
					break;
					
				}
				
			}
			
			k++;
			l = 0;
			
		}
		
		return binarySequence;
		
	}
	
	/**
	 * 1. Extracts the sequential, fixed binary sequence derived from the octal number
	 * <br>2. Converts the fixed binary sequence into a readable binary sequence to be converted into other bases;
	 * base 8, 10 & 16
	 *
	 * @return the readable binary sequence that can be recognized by the binary converters to convert base 2
	 * 		(binary) to base 8 (octal), base 10 (decimal) & base 16 (hexadecimal)
	 */
	
	public String getBits ( ) {
		
		int[] binarySequence = this.createBinarySequence ( );
		String bits = "";
		int g = 0;
		
		while ( g < binarySequence.length ) {
			
			bits += binarySequence[ g++ ];
			
		}
		
		return bits;
		
	}
	
	/**
	 * @return the readable sequence that can be recognized by the binary converters to convert base 2 (binary) into
	 * 		base 8 (octal), base 10 (decimal) & base 16 (hexadecimal)
	 */
	
	public String finBin ( ) {
		
		return this.getBits ( );
		
	}
	
}