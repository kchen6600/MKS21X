public class CirculatingBook extends LibraryBook{
    private String currentHolder, dueDate;
    
    public CirculatingBook(String author, String title, String ISBN, String callNumber){
	super(author, title, ISBN, callNumber);
	currentHolder = null;
	dueDate = null;
	
    }

    public String getCurrentHolder(){
	return currentHolder;
    }

    public void setCurrentHolder(String currentHolder){
	this.currentHolder = currentHolder;
    }

    public String getDueDate(){
	return dueDate;
    }

    public void setDueDate(String dueDate){
	this.dueDate = dueDate;
    }

    public void checkout(String patron, String due){
	currentHolder = patron;
	dueDate = due;
    }

    public void returned(){
        currentHolder = null;
	dueDate = null;
    }

    public String circulationStatus(){
	if (currentHolder != null){
	    return "Current holder: "+currentHolder+"\nDue date: "+dueDate;
	}
	else{
	    return "Book available on shelves.";
	}
    }

    public String toString(){
	return super.toString();
    }


}
