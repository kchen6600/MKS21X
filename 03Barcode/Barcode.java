public class Barcode implements Comparable<Barcode>{
// instance variables
   private String _zip;
   private int _checkDigit;
   private static String[] bars = {"||:::",":::||","::|:|","::||:",":|::|",":|:|:",":||::","|:::|","|::|:","|:|::"};

// constructors
//precondition: _zip.length() = 5 and zip contains only digits.
//postcondition: throws a runtime exception zip is not the correct length
//               or zip contains a non digit
//               _zip and _checkDigit are initialized.
  public Barcode(String zip) {
      if (zip.length() != 5){
	  throw new IllegalArgumentException("Zip is not the right length.");
      }
      for (int i = 0; i < 5; i++){
	  if(!Character.isDigit(zip.charAt(i))){
	      throw new IllegalArgumentException("Zip can only be a 5 digit number.");
	  }
      }
      _zip = zip;
      _checkDigit = checkSum() % 10;
  }


// postcondition: computes and returns the check sum for _zip
  private int checkSum(){
      int sum = 0;
      for (int i = 0; i < _zip.length(); i++){
	  sum += _zip.charAt(i)- '0';
      }
      return sum;
  }

//postcondition: format zip + check digit + Barcode 
//ex. "084518  |||:::|::|::|::|:|:|::::|||::|:|"      
  public static String toCode(String zip){
      
      String str = "|";
      if (zip.length() == 5){
	  
      for (int i = 0; i < zip.length(); i++){
	  char ch = zip.charAt(i);
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
	  else if (ch == '0'){
	      str += "||:::";
	  }
	  else{
	      throw new IllegalArgumentException("Zip can only contain digits");
	  }
      }
      }
      else{
	  throw new IllegalArgumentException("Zip must contain 5 digits.");
      }

      str += "|";
      return str;
	      
  }

    public String toString() {
	String str = _zip + _checkDigit + " |";
	for (int i = 0; i <= _zip.length(); i++){
	    str += bars[(_zip + _checkDigit).charAt(i)-'0'];
	}
	return str + "|";
    }

    private static int verifySum(String code){
	int sum = 0;
	for (int i = 0; i < code.length() - 4; i +=5){
	    sum += scheme(code.substring(i, i+5));
	}
	return sum;
    }
    
    private static int scheme(String str){
	for (int i = 0; i < bars.length; i++){
	    if (bars[i].equals(str)){
		return i;
	    }
	}
	throw new IllegalArgumentException("Encoded ints are invalid and non-barcode characters can not be used.");
    }

    public static String toZip(String code){
	String str = "";
	if (code.length() != 32){
	    throw new IllegalArgumentException("Barcode must be 32 characters.");
	}
	else if (code.charAt(0) != '|' || code.charAt(code.length() - 1) != '|'){
	    throw new IllegalArgumentException("Barcode must begin and end with |.");
	}
	else if ((verifySum(code.substring(1, 26)) % 10) != (scheme(code.substring(26, 31)))){
	    throw new IllegalArgumentException("Checksum is invalid.");
	}
	for (int i = 1; i < code.length() - 6; i+=5){
	    str += scheme(code.substring(i, i +5));
	}
	return str;
	
    }

// postcondition: compares the zip + checkdigit, in numerical order. 
  public int compareTo(Barcode other){
      return (Integer.valueOf(_zip + _checkDigit)).compareTo(Integer.valueOf(other._zip + other._checkDigit));
  }
    
}


