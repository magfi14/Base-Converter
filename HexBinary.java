import java.util.ArrayList;

public class HexBinary {
	
	public final int[] BASES = { 8 , 4 , 2 , 1 };
	public ArrayList < Integer > binarySequence;
	public String hexNumber;
	
	/**
	 * Creates a new HexBinary object with a flexible binary sequence of ArrayList type Integer
	 */
	
	public HexBinary ( ) {
		
		binarySequence = new ArrayList < Integer > ( );
		
	}
	
	/**
	 * Creates a new HexBinary object with a hexadecimal sequence
	 *
	 * @param hexNumber
	 * 		the hexadecimal sequence that will be turned into a binary sequence
	 */
	
	public HexBinary ( String hexNumber ) {
		
		this ( );
		this.inputHexNumber ( hexNumber );
		
	}
	
	/**
	 * Retrieves the hexadecimal sequence
	 *
	 * @return the hexadecimal sequence
	 */
	
	public String getHexNumber ( ) {
		
		return this.hexNumber;
		
	}
	
	/**
	 * Inputs a hexadecimal sequence
	 *
	 * @param hexNumber
	 * 		the hexadecimal sequence
	 */
	
	public void inputHexNumber ( String hexNumber ) {
		
		this.hexNumber = hexNumber;
		
	}
	
	/**
	 * Converts a string hexadecimal sequence into an array of integer values, each of which whose range lies from 0
	 * to 15. A = 10, B = 11, C = 12, D = 13, E = 14, F = 15
	 *
	 * @return an integer array consisting of all the numeric hexadecimal values from the hexadecimal sequence
	 */
	
	public int[] createHexSequence ( ) {
		
		String tepHexSequence = this.hexNumber;
		int h = 0;
		
		int[] arrayHexSequence = new int[ tepHexSequence.length ( ) ];
		
		while ( h < arrayHexSequence.length ) {
			
			arrayHexSequence[ h ] = this.getIntegerValue ( tepHexSequence.substring ( h , h++ + 1 ) );
			
		}
		
		return arrayHexSequence;
		
	}
	
	/**
	 * Gets the Integer value of a single hexadecimal character. If the character's value is between 0 and 9, the
	 * result will fall in the range of 0-9. If the character's value is A, B, C, D, E, F, the following scheme is
	 * used: A = 10, B = 11, C = 12, D = 13, E = 14, F = 15
	 *
	 * @param g
	 * 		the string value, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, A, B, C, D, E, or F
	 *
	 * @return the Integer value from 0 to 15
	 */
	
	public int getIntegerValue ( String g ) {
		
		int value = 0;
		
		switch ( g ) {
			
			case "0":
			case "1":
			case "2":
			case "3":
			case "4":
			case "5":
			case "6":
			case "7":
			case "8":
			case "9":
				value = Integer.parseInt ( g );
				break;
			case "A":
				value = 10;
				break;
			case "B":
				value = 11;
				break;
			case "C":
				value = 12;
				break;
			case "D":
				value = 13;
				break;
			case "E":
				value = 14;
				break;
			case "F":
				value = 15;
				break;
			
		}
		
		return value;
		
	}
	
	/**
	 * 1. Creates a resizeable ArrayList database to store all of the 4-bit binary sequences of each
	 * hexadecimal character
	 * <br />2. Extracts the
	 * Integer array from the String
	 * hexadecimal sequence via a loop
	 * <br />3. Loops through the hexadecimal sequence and creates a temporary storage space to store the 4-bit
	 * binary sequence, which is then added to the database in chronological descending order at the very end of the
	 * loop iteration. Two reference arrays are used to facilitate the conversion of hexadecimal characters into
	 * 4-bit binary sequences: <br /><ol><ol>
	 * <li>A hexadecimal character reference array, with values 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, A, B, C, D, E,
	 * and F; A = 10, B = 11, C = 12, D = 13, E = 14, F = 15</li>
	 * <li>A dual-dimensional predetermined 4-bit binary sequence reference array, with values 0 to 15 listed
	 * in 4-bit binary sequences which directly correspond via shared indices with the hexadecimal characters</li>
	 * </ol></ol>
	 * 4. Once the resizeable database is finalized at the end of the last iteration, an initial fixed-size
	 * dual-dimensional array is used to store the finalized 4-bit sequences of binary numbers in their respective
	 * order. A loop neatly transfers the data from the resizeable database to the fixed-size database. Interior loop
	 * controls control facilitation of exchange of data
	 *
	 * @return a chronological list of 4-bit binary sequences from the sequence of hexadecimal characters
	 */
	
	public int[] createBinarySequence ( ) {
		
		ArrayList < ArrayList < Integer > > tempBinarySequence = new ArrayList < ArrayList < Integer > > ( );
		
		int[] interiorHexSequence = new int[ this.createHexSequence ( ).length ];
		
		int f = 0;
		
		while ( f < interiorHexSequence.length ) {
			
			interiorHexSequence[ f ] = this.createHexSequence ( )[ f++ ];
			
		}
		
		int g = 0, h = 0, i = 0, j = 0, k = 0, l = 0, m = 0;
		
		while ( g < interiorHexSequence.length ) {
			
			h = 0;
			int chosenNumber = interiorHexSequence[ g++ ];
			ArrayList < Integer > tempInteriorBinarySequence = new ArrayList < Integer > ( );
			String[] hexRoster = new String[] { "0" , "1" , "2" , "3" , "4" , "5" , "6" , "7" , "8" , "9" , "A" , "B"
					, "C" , "D" , "E" , "F" };
			int[][] binaryRoster = new int[][]
					                       {
							                       { 0 , 0 , 0 , 0 } ,
							                       { 0 , 0 , 0 , 1 } ,
							                       { 0 , 0 , 1 , 0 } ,
							                       { 0 , 0 , 1 , 1 } ,
							                       { 0 , 1 , 0 , 0 } ,
							                       { 0 , 1 , 0 , 1 } ,
							                       { 0 , 1 , 1 , 0 } ,
							                       { 0 , 1 , 1 , 0 } ,
							                       { 1 , 0 , 0 , 0 } ,
							                       { 1 , 0 , 0 , 1 } ,
							                       { 1 , 0 , 1 , 0 } ,
							                       { 1 , 0 , 1 , 1 } ,
							                       { 1 , 1 , 0 , 0 } ,
							                       { 1 , 1 , 0 , 1 } ,
							                       { 1 , 1 , 1 , 0 } ,
							                       { 1 , 1 , 1 , 1 }
					                       };
			
			while ( h < binaryRoster[ chosenNumber ].length ) {
				
				tempInteriorBinarySequence.add ( binaryRoster[ chosenNumber ][ h++ ] );
				
			}
			
			tempBinarySequence.add ( tempInteriorBinarySequence );
			
		}
		
		int[][] tempHardBinarySequence = new int[ tempBinarySequence.size ( ) ][ 4 ];
		int[] binarySequence = new int[ tempBinarySequence.size ( ) * 4 ];
		
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
	 * 1. Extracts the sequential, fixed binary sequence derived from the sequence of hexadecimal characters <br />
	 * 2. Converts the fixed binary sequence into a readable binary sequence to be converted into other bases; base
	 * 8, 10 & 16
	 *
	 * @return the readable binary sequence that can be recognized by the binary converters to convert base 2
	 * 		(binary) into base 8 (octal), base 10 (decimal) & base 16 (hexadecimal)
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