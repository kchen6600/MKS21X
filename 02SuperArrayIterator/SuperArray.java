import java.util.*;
public class SuperArray implements Iterable<String>{
  private String[] data;
  private int size;
  private int last;
  
  //0
  //constructor make an empty superArray should make size 0, 
  //but the data capacity 10.

  public SuperArray(){
      size = 0;
      data = new String[10];
      last = 0;
  }

  public SuperArray(int initialCapacity){
      if (initialCapacity < 0){
	  throw new IllegalArgumentException();
      }
      data = new String[initialCapacity];
      size = 0;
      last = 0;
  }

  public SuperArray(String[]ary){
	for (int i = 0; i < ary.length; i++){
	    data[i] = ary[i];
	}
    }

  public String get(int index){
      if (index < 0 || index >= size()){
	  throw new IndexOutOfBoundsException();
      }
      return data[index];
      
  }
  
  public int size(){
    return size;
  }

  //1
/**add the value n to the next available slot in the superArray.
 *this will change the size. This function should always work
 *And will resize the SuperArray if needed.*/
  public boolean add(String n){
      //constant
      if (data.length == size()){
	  grow();
      }
      data[size()] = n;
      size += 1;
      return true;
  }

  //2
/**Resize the data, by making a new array, then copying over elements, use this as your data.
*/

  private void grow(){
      //linear
      String[] newdata = new String[data.length *2];
      for (int i = 0; i < data.length; i++){
	  newdata[i] = data[i];
      }
      data = newdata;
  }

  //3
   /**format the super array like this :   [ 1, 3, 6, 8, 23, 99, -4, 5] 
    *commas between... square bracket start/end and no comma at end.*/
  public String toString(){
      if (isEmpty()){
	  return "[ ]";
      }
      String str = "[ ";
      for (int i = 0; i < size(); i++){
	  str += String.valueOf(data[i]) + ", ";
      }
      return str.substring(0,str.length()-2) +"]";
  }

  //4
    /**format the super array like this :   [ 1, 8, 23, 99, -4, 5, _, _, _, _]   
 *(capacity is 10, but only 6 are used)
    *commas between... square bracket start/end and no comma at end.
    *unused slots should be printed as _ (underscores) */
  public String toStringDebug(){
      if (isEmpty()){
	  return "[ ]";
      }
      String str = "";
      for (int i = 0; i < data.length; i++){
	  if (i < size()){
	      str += String.valueOf(data[i]) + ", ";
	  }
	  else{
	      str += "_, ";
	  }
      }
      return str.substring(0, str.length() - 2) + "]";
  }


  public void clear(){
    size = 0;
  }

  public boolean isEmpty(){
      return size() == 0;
  }

  public String set(int index, String element){
	// Replaces the element at the specified position in this list with the specified element. Returns the value of the element replaced.
      //constant
      // System.out.println(String.valueOf(index));
      if (index < 0 || index >= size()){
	  throw new IndexOutOfBoundsException();
      }
      String old = data[index];
      data[index] = element;

      if (index >= size()){
	  size = index + 1;
      }
      return old;
  }
  public void add(int index, String element){
	//Inserts the specified element at the specified position in this list. Shifts the element currently at that position (if any) and any subsequent elements to the right (adds one to their indices).
      //linear

      if (index < 0 || index > size()){
	  throw new IndexOutOfBoundsException();
      }
     
      if (size() == data.length){
	      grow();
	  }
      for (int i = size(); i > index; i--){
	  data[i] = data[i-1];
      }
      data[index] = element;
      size +=1;

  }

  public String remove(int index){
//  Removes the element at the specified position in this list. Shifts any subsequent elements to the left (subtracts one from their indices). The value returned is the value of the element removed.
      //linear
      if (index < 0 || index >= size()){
	  throw new IndexOutOfBoundsException();
      }
      String old = data[index];
      for (int i = index; i < size(); i++){
	  data[i] = data[i + 1];
      }
      size -= 1;
      return old;
  }

  public String[] toArray(){
//  Returns an array containing all of the elements in this list in proper sequence (from first to last element). Copy the old array; you don't want the address to poit to the internal array.
      String[] newArray = new String[size()];
      for (int i = 0; i < size(); i ++){
	  newArray[i] = data[i];
      }
      return newArray;
  }

  public void trimToSize(){
      //linear
      String[] newArray = new String[size];
      for ( int i = 0; i < size; i++){
	  newArray[i] = data[i];
      }
      data = newArray;
  }
  public int indexOf(String n){
//Returns the index of the first occurrence of the specified element in this list, or -1 if this list does not contain the element.
      for (int i = 0; i < size(); i++){
	  if (data[i].equals(n)){
	      return i;
	  }
      }
      return -1;
  }
  public int lastIndexOf(String n){
//Returns the index of the last occurrence of the specified element in this list, or -1 if this list does not contain the element.
      for (int i = size() -1; i >= 0; i--){
	  if (data[i].equals(n)){
	     return i;
	  }
      }
      return -1;
						
  }

  public Iterator<Integer> iterator(){
    return new SuperArrayIterator(this);
  }
    
}
