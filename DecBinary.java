class DecBinary {
	
	private final int selection;
	private int decimalNumber;
	private String unformattedBinaryNumber;
	
	/**
	 * Creates a new DecBinary object using a decimal (base-10) number
	 *
	 * @param decimalNumber
	 * 		the decimal (base-10) number
	 */
	
	DecBinary ( int decimalNumber ) {
		
		this.decimalNumber = decimalNumber;
		this.selection = 1;
		
	}
	
	/**
	 * Creates a new DecBinary object using a string sequence of binary (base-2) numbers directly formatted
	 *
	 * @param unformattedBinaryNumber
	 * 		the directly-formatted binary (base-2) sequence
	 */
	
	DecBinary ( String unformattedBinaryNumber ) {
		
		this.unformattedBinaryNumber = unformattedBinaryNumber;
		this.selection = 2;
		
	}
	
	/**
	 * @return the decimal (base-10) number
	 */
	
	int decimal ( ) {
		
		return this.decimalNumber;
		
	}
	
	/**
	 * @return the directly-formatted binary (base-2) sequence
	 */
	
	String unformattedBinary ( ) {
		
		return this.unformattedBinaryNumber;
		
	}
	
	/**
	 * Divides the decimal number (base-10) by 2 until it is reduced to 1 & increments the size of the potential
	 * readable binary sequence if a base-10 number is being passed on, or, sets the size of the binary sequence to
	 * the size of the directly-formatted binary (base-2) sequence if a base-2 sequence is being passed in lieu
	 *
	 * @return the size of the sequence
	 */
	
	int listSize ( ) {
		
		int size = 0;
		
		if ( this.selection == 1 ) {
			
			int number = this.decimal ( );
			
			while ( number >= 1 ) {
				
				number /= 2;
				size++;
				
			}
			
		}
		else if ( this.selection == 2 ) {
			
			size = this.unformattedBinary ( ).length ( );
			
		}
		
		return size;
		
	}
	
	/**
	 * Creates a readable formatted binary sequence in the form of array in the following fashion:
	 * <br /><ol>
	 * <li>Creates a new array & sets the array size to the predetermined size appropriate to evenly fit all the
	 * bits</li>
	 * <li>If a <strong>base-10</strong> number is being passed: <ol>
	 * <li>A new array with the same size is created alongside the first array, which is used to store the
	 * reverse order of the first array after the two loops conclude</li>
	 * <li>The first loop gets the base-2 value of the base-10 number before it is divided by 2 & repeats until the
	 * base-10 number
	 * is zero. This array stores the binary values from <strong>left-to-right</strong></li>
	 * <li>The second loop effectively reverses the order of the first array to make it possible to convert the
	 * binary sequence to base-8, base-10, or base-16. This array is returned from <strong>right-to-left</strong></li>
	 * </ol></li>
	 * <li>If a <strong>base-2</strong> sequence is being passed, a loop will be used to convert the
	 * directly-formatted base-2 sequence into a readable fixed array binary sequence</li>
	 * </ol>
	 *
	 * @return the readable fixed binary sequence, from right-to-left in descending order of two-power
	 */
	
	int[] binList ( ) {
		
		int[] binListFinal = new int[ this.listSize ( ) ];
		
		if ( this.selection == 1 ) {
			
			int[] binList = new int[ this.listSize ( ) ];
			int g = 0, h = binListFinal.length - 1, i = 0, number = this.decimal ( );
			
			while ( number > 0 ) {
				
				binList[ g++ ] = number % 2;
				number /= 2;
				
			}
			
			while ( h >= 0 ) {
				
				binListFinal[ h-- ] = binList[ i++ ];
				
			}
			
			return binListFinal;
			
		}
		else if ( this.selection == 2 ) {
			
			int g = 0;
			
			while ( g < binListFinal.length ) {
				
				binListFinal[ g++ ] = Integer.parseInt ( this.unformattedBinary ( ).substring ( g , g + 1 ) );
				
			}
			
		}
		
		return binListFinal;
		
	}
	
	/**
	 * Extracts the readable fixed binary sequence & converts it back into a string to be used to convert into
	 * base-8, base-10 & base-16
	 *
	 * @return the directly-formatted base-2 sequence
	 */
	
	public String toString ( ) {
		
		int[] list = this.binList ( );
		String stri = "";
		
		for ( int g : list ) {
			
			stri += Integer.toString ( g );
			
		}
		
		return stri;
		
	}
	
	/**
	 * @return the directly-formatted base-2 sequence
	 */
	
	public String finBin ( ) {
		
		return this.toString ( );
		
	}
	
}