public class HeapSort {
    private ALHeap heap;
    
    public HeapSort(){
	heap=new ALHeap();
    }
    public static Integer[] sort(Integer[] list){
	for (int i = list.length-1; i>=0;i--){
	    int k = i;
	    while (list[k]>list[getParent(k)]){
		swap(list,k,getParent(k));
		k=getParent(k);
	    }
	}//to make it into a top-down heap
	//Now that its a heap, we have to 
    }
    private void swap( Integer[] list, int pos1, int pos2){
	int a =list[pos1];
	list[pos1]=list[pos2];
	list[pos2]=a;
    }
    private int getParent(int i){
	return (i-1)/2;
    }
	
    public static void main(String[] args){
	Integer[] arr= {9,7,8,6,3,4,2,5,1,10};
	arr=sort(arr);
	System.out.println(arr.toString());
    }
	
	
}