public class Driver{
    public static void main(String args[]){
	Barcode b = new Barcode("08451");
	Barcode c = new Barcode("99999");
	Barcode d = new Barcode("01111");
	System.out.println(b); //084518 |||:::|::|::|::|:|:|::::|||::|:|
	System.out.println(b.toString().compareTo("084518 |||:::|::|::|::|:|:|::::|||::|:|")); //0
	System.out.println(b.compareTo(b)); //0
	System.out.println(c.compareTo(b));
	System.out.println(d.compareTo(b));
	/*length 
	  Barcode e = new Barcode("123456");
	  System.out.println(e);
	*/
	/*length
	  Barcode e = new Barcode("1234");
	  System.out.println(e);
	*/
	/*type
	  Barcode e= new Barcode("12.45");
	  System.out.println(e);
	*/

	String[] testcodes = {
	    "|||:::|::|::|::|:|:|::::|||::|:|",
	    "|||:::|::|::|::|:|:|::::|||::|:|",
	    "|||:::|::|::|::|:|:|::::|||::|:|",
	    "|||:::|::|::|::|:|:|::::|||::|:|",
	};

	for (String test : testcodes) {
	    System.out.println("\n# ok -");
	    System.out.println(Barcode.toZip(test));
	}	

	String[] errors = {
	    "|||:::|::|::|::|:|:|::::|||:|::|", //checksum
	    "|||:::|::|::|::|:|:|::::|:|::|:|", //encoded ints or checksum
	    "|||:::|::|::?::|:|:|::::|||::|:|", //invalid char
	    "|||:::|::|::|::|:|:|:::|||::|:|", //length
	    ":||:::|::|::|::|:|:|::::|||::|:|", // rightmost
	    "|:||:::|::|::|::|:|:|::::|||::|:", // leftmost
	};

	for (String error : errors) {
	    System.out.println("\n# error -");
	    try { System.out.println(Barcode.toZip(error)); }
	    catch (IllegalArgumentException e) {
		e.printStackTrace();
	    }
	}
	    
    }

}
