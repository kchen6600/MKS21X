public class Sorts{
    public static String name(){
	return "06.Chen.Karen";
    }

    public static void selectionSort(int[] data){
	int min;
	int temp;
	int index;

	for (int i = 0; i < data.length-1; i++){
	    min = data[i];
	    index = i;
	    for (int j = i+1; j < data.length; j++){
		if (data[j] < min){
		    min = data[j];
		    index = j;
		}
	    }
	    temp = data[i];
	    data[i] = min;
	    data[index] = temp;
	}
	    
    }

    private static void insertionSort(int[] data){

	int temp;
	int saved;
	for (int index = 1; index < data.length; index++){
	    temp = data[index];
	    saved = index;
	    while (saved > 0 && temp < data[saved - 1]){
		data[saved] = data[saved - 1];
		saved -= 1;
	    }
	    data[saved] = temp;
	}			
    }

    public static void bubbleSort(int[] data){
	int temp;
	int saved;
	boolean swap = true;
	while (swap){
	    swap = false;
	    for (int index = 0; index < data.length-1; index++){
		if (data[index] > data[index+1]){
		    saved = data[index];
		    temp = data[index+1];
		    data[index] = temp;
		    data[index+1] = saved;
		    swap = true;
		}
	    }
	}
    }

    private static String arrayToString(int[]data){
	String str = "[";
	
	for (int i = 0; i < data.length; i++){
	    str += data[i] + ", ";
	}

	str += "]";
	return str;
    }

    public static void main(String[] args){
	int[] test = {62, 25, 12, 22, 11};
	selectionSort(test);
	System.out.println(arrayToString(test));
	int[] test2 = {0, 1, 9, 7, 2};
	insertionSort(test2);
	System.out.println(arrayToString(test2));
	int[] test3 = {1, 8, 3, 4, 0};
	bubbleSort(test3);
	System.out.println(arrayToString(test3));
	int[] emptytest = {};
	//selectionSort(emptytest);
	//insertionSort(emptytest);
	bubbleSort(emptytest);
	System.out.println(arrayToString(emptytest));
	int[] test4 = { 1,};
	//selectionSort(test4);
	//insertionSort(test4);
	bubbleSort(test4);
	System.out.println(arrayToString(test4));
         
	
    }
	

}
