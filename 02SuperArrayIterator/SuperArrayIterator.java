import java.util.*;

public class SuperArrayIterator implements Iterator<String>{
    private int current;
    private SuperArray superarr;
    public SuperArrayIterator(SuperArray sa){
	current = 0;
	superarr = sa;
    }
       
    public String next(){
	if (hasNext()){
	    return superarr[current];
	    current++;
	}
	else{
	    throw new NoSuchElementException();
	}
    }

    public boolean hasNext(){
	return current+1 < superarr.size();
    }

    public void remove(){
	throw new UnsupportedOperationException();
    }
}
