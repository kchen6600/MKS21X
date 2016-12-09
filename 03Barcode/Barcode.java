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
      for (int i = 0; i < _zip.length; i++){
	  sum += Integer.parseInt(_zip.charAt(i));
      }
      return sum;
  }

//postcondition: format zip + check digit + Barcode 
//ex. "084518  |||:::|::|::|::|:|:|::::|||::|:|"      
  public String toCode(String zip){
      
      String str = _zip + _checkDigit + " |";
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
	  else if (ch == '0'{
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
	return _zip +" "+ toCode();
    }

    public String toZip(String code){
	String str = "";
	int currentlength = str.length();
	if (code.length() == 32){
	    for (int i = 1; i < code.length() - 5; i+=5){
		for (int j = 0; j < bars.length; j++){
		    if(code.substring(i, i+5) == bars[j]){
			str += j;
			currentlength +=1;
		    }
		}
	    }
	}
	else{
	    throw new IllegalArgumentException("Barcode must be 32 characters.");
	}
	
    }

// postcondition: compares the zip + checkdigit, in numerical order. 
  public int compareTo(Barcode other){
      return (Integer.valueOf(_zip + _checkDigit)).compareTo(Integer.valueOf(Other._zip + other._checkDigit));
  }
    
}


