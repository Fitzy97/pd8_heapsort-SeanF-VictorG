public class HeapSort {
    
    
    public HeapSort(){
	heap=new ALHeap();
    }
    public static int[] sort(int[] list){
	for (int i = list.length-1; i>=0;i--){
	    int k = i;
	    while (list[k]>list[getParent(k)]){
		swap(list,k,getParent(k));
		k=getParent(k);
	    }
	}//to make it into a bottom up heap
	//Now that its a heap, we have to remove the first and move it to the end until the list is sorted
	partition=list.length;
	while (partion>0){
	    swap(list,0,partition);
	    int k = 0;
	    while (true){
		if (list[k]<list[MaxChildPos(heap,list[k])]){
		    swap(list,k,MaxChildPos(heap,list[k]));
		    k=MaxChildPos(heap,list[k]);
		}
		else
		    break;
		partion--;
	    }
	}
	return list;
    }
    private static void swap( Integer[] list, int pos1, int pos2){
	int a =list[pos1];
	list[pos1]=list[pos2];
	list[pos2]=a;
    }
    private static int MaxChildPos( int[] heap ,int pos ) {
	int retVal;
	int lc = 2*pos + 1; //index of left child
	int rc = 2*pos + 2; //index of right child
	
	//pos is not in the heap or pos is a leaf position
	if ( pos < 0 || pos >= heap.size() || lc >= heap.size() )
	    retVal = -1;
	//if no right child, then left child is only option for min
	else if ( rc >= heap.size() )
	    retVal = lc;
	//have 2 children, so compare to find least
	else if ( heap.get(lc).compareTo(heap.get(rc)) > 0 )
	    retVal = lc;
	else
	    retVal = rc;
	return retVal;
    }//O(1)
    
    private static int getParent(int i){
	return (i-1)/2;
    }
	
    public static void main(String[] args){
	Integer[] arr= {9,7,8,6,3,4,2,5,1,10};
	arr=sort(arr);
	for (int i=0;i<arr.length;i++){
	     System.out.println(arr[i]);
	}
    }
	
	
}