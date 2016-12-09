public class Driver{
    public static void main(String[] args){
	System.out.println(new Barcode("08451"));
	System.out.println(Barcode.toCode("08451"));
	System.out.println(Barcode.toZip("|||:::|::|::|::|:|:|::::|||::|:|"));
	System.out.println((new Barcode("08451")).compareTo((new Barcode("08451"))));
    }
}
