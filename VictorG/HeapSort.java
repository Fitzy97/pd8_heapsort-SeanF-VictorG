public class HeapSort {
    
    
    public HeapSort(){
	//heap=new ALHeap();
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
	int partition=list.length-1;
	while (partition>0){
	    swap(list,0,partition);//swap values
	    heapify(list,partition);//reheapify the unsorted section
	    partition--;//change the marker to the unsorted section
	}
	return list;
    }
    private static void heapify(int[] list, int partition){
    	for (int i = partition-1; i>=0;i--){
    		int k=i;
    		while (list[k]>list[getParent(k)]){
    			swap(list,k,getParent(k));
    			k=getParent(k);
    		}
    	}
    }
    private static void swap( int[] list, int pos1, int pos2){
	int a =list[pos1];
	list[pos1]=list[pos2];
	list[pos2]=a;
	}
	private static void print(int[] list){
		for(int i=0; i<list.length;i++){
			System.out.println(list[i]+" ");
			}
		System.out.println("\n");
		}
    
    private static int MaxChildPos( int[] heap ,int pos ) {
	int retVal;
	int lc = 2*pos + 1; //index of left child
	int rc = 2*pos + 2; //index of right child
	
	//pos is not in the heap or pos is a leaf position
	if ( pos < 0 || pos >= heap.length || lc >= heap.length )
	    retVal = -1;
	//if no right child, then left child is only option for min
	else if ( rc >= heap.length )
	    retVal = lc;
	//have 2 children, so compare to find least
	else if ( heap[lc] > heap[rc] )
	    retVal = lc;
	else
	    retVal = rc;
	return retVal;
    }//O(1)
    
    private static int getParent(int i){
	return (i-1)/2;
    }
	
    public static void main(String[] args){
	int[] arr= {9,7,8,6,3,4,2,5,1,10};
	arr=sort(arr);
	for (int i=0;i<arr.length;i++){
	     System.out.println(arr[i]);
	}
    }
	
	
}