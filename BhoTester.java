public class BhoTester {
	
	public static void printListinString ( int[] list ) {
		
		for ( int g : list ) {
			
			System.out.print ( g + "\t" );
			
		}
		
		System.out.println ( );
		
	}
	
	public static void printDListinString ( int[][] list ) {
		
		for ( int[] g : list ) {
			
			printListinString ( g );
			
		}
		
	}
	
	public static void main ( String[] args ) {
		
		BinDecimal binDecimal = new BinDecimal ( "11101" );
		
		System.out.println ( binDecimal.finDec ( ) );
		
	}
	
	public static int convertBinaryToDecimal ( String bits )
	{
		
		BinDecimal binDecimal = new BinDecimal ( bits );
		return binDecimal.finDec ( );
		
	}
	
	public static String convertBinaryToHexadecimal ( String bits )
	{
		
		BinHex binHex = new BinHex ( bits );
		return binHex.finHex ( );
		
	}
	
	public static int convertBinaryToOctal ( String bits )
	{
		
		BinOctal binOct = new BinOctal ( bits );
		return binOct.finOct ( );
		
	}
	
	public static String convertDecimalToBinary ( int decimal )
	{
		
		DecBinary decBinary = new DecBinary ( decimal );
		return decBinary.finBin ( );
		
	}
	
	public static String convertDecimalToHexadecimal(int decimal)
	{
		
		DecHex decHex = new DecHex(decimal);
		return decHex.finHex();
		
	}
	
	public static int convertDecimalToOctal(int decimal)
	{
		
		DecOctal decOct = new DecOctal(decimal);
		return decOct.finOct();
		
	}
	
}