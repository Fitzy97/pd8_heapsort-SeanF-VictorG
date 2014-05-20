public class HeapSort {
    private ALHeap heap;
    
    public HeapSort(){
	heap=new ALHeap();
    }
    public static Integer[] sort(Integer[] list){
	for (Integer i: list){
	    heap.add(i);
	}
	
	Integer[] retArr= new Integer[list.length];
	int k=0;
	while (!heap.isEmpty()){
	    retArr[k]=heap.removeMin();
	    k++;
	}
    }
    public static void main(String[] args){
	Integer[] arr= {9,7,8,6,3,4,2,5,1,10};
	arr=sort(arr);
	System.out.println(arr.toString());
    }
	
	
}