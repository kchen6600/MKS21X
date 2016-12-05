import java.util.*;

public class SuperArrayIterator implements Iterator<String>{
    private int current;
    private SuperArray superarr;
    
    public SuperArrayIterator(SuperArray superarr){
	current = 0;
	this.superarr = superarr;
    }
       
    public String next(){
	if (hasNext()){
	    String currentstr = superarr.get(current);
	    current++;
	    return currentstr;
	}
	else{
	    throw new NoSuchElementException();
	}
    }

    public boolean hasNext(){
	return current < superarr.size();
    }

    public void remove(){
	throw new UnsupportedOperationException();
    }
}
