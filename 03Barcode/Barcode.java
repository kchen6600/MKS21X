public class Barcode implements Comparable<Barcode>{
// instance variables
   private String _zip;
   private int _checkDigit;

// constructors
//precondition: _zip.length() = 5 and zip contains only digits.
//postcondition: throws a runtime exception zip is not the correct length
//               or zip contains a non digit
//               _zip and _checkDigit are initialized.
  public Barcode(String zip) {
      if (zip.length != 5){
	  throw new IllegalArgumentException("Zip is not the right length.");
      }
      for (int i = 0; i < 5; i++){
	  if(!isDigit(zip.charAt(i))){
	      throw new IllegalArgumentException("Zip can only be a 5 digit number.");
	  }
      }
      _zip = zip;
      _checkDigit = checkSum() % 10;
  }

// postcondition: Creates a copy of a bar code.
  public Barcode clone(){
      Barcode bc = new Barcode(_zip);
      return bc;
  }


// postcondition: computes and returns the check sum for _zip
  private int checkSum(){
      int sum = 0;
      for (int i = 0; i < _zip.length; i++){
	  sum += Integer.parseInt(_zip.charAt(i));
      }
      return sum;
  }

//postcondition: format zip + check digit + Barcode 
//ex. "084518  |||:::|::|::|::|:|:|::::|||::|:|"      
  public String toString(){
      String str = _zip + _checkDigit + " |";
      for (int i = 0; i < _zip.length(); i++){
	  char ch = _zip.charAt(i);
	  if (ch == '1'){
	      str += ":::||";
	  }
	  else if (ch == '2'){
	      str += "::|:|";
	  }
	  else if (ch == '3'){
	      str += "::||:";
	  }
	  else if (ch == '4'){
	      str += ":|::|";
	  }
	  else if (ch == '5'){
	      str += ":|:|:";
	  }
	  else if (ch == '6'){
	      str += ":||::";
	  }
	  else if (ch == '7'){
	      str += "|:::|";
	  }
	  else if (ch == '8'){
	      str += "|::|:";
	  }
	  else if (ch == '9'){
	      str += "|:|::";
	  }
	  else{
	      str += "||:::";
	  }
      }
	      
  }


// postcondition: compares the zip + checkdigit, in numerical order. 
  public int compareTo(Barcode other){
      return (Integer.valueOf(_zip + _checkDigit)).compareTo(Integer.valueOf(Other._zip + other._checkDigit));
  }
    
}


