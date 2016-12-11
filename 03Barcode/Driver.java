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
} 
}
