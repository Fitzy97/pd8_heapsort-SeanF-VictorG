//David Bang
//APCS pd 8
//HW# 41
//2014-05-19 

/*****************************************************
 *Heapsort.java
The best case scenario for heapsort is when the data set to be sorted is already sorted. If the data set is already sorted, the adding of the Integer objects to heap will only require a single operation which is adding the object to the end of the _heap in the ALHeap. Then removing the objects from the ALHeap will only remove the root and the immediate left child or right child  will be made the new root and then everything below it swapped up which is about log n operations. These removed objects will be put into a new array and the array will be returned. The execution time for this is O (n log n) because removeMin is called n times and removeMin has an O (log n) runtime. Memory consumption is require to make add to the ALHeap which makes a new pointer to each object added. Then memory is also used to add to the arrayList, the pointers to each of the Integer objects from the ALHeap. It makes a ton of new pointers to already made Integer objects.

The worst case scenerio is if the data set is sorted in the opposite way meaning it is the reverse of the sorted list we will return meaning it is sorted in descending order. If the data set is reverse sorted, the adding of the Integer objects to heap will require at worst case, n log n operations as  adding the object to the end of the _heap in the ALHeap and then swaping it to the top of the _heap or to the root takes about log n operations. Then removing the objects from the ALHeap will only remove the root and the immediate left child or right child  will be made the new root and then everything below it swapped up which is about log n operations. These removed objects will be put into a new array and the array will be returned. The execution time for this is O (n log n) because removeMin is called n times and removeMin has an O (log n) runtime and adding the data to the ALHeap is also n log n calls so the O (n log n) is the general runtime.Memory consumption is require to make add to the ALHeap which makes a new pointer to each object added. Then memory is also used to add to the arrayList, the pointers to each of the Integer objects from the ALHeap. Basically it just makes a ton of new pointers to already made Integer objects.



 *****************************************************/

public class Heapsort {
    private ALHeap heap;
    
    public Heapsort () {
	heap = new ALHeap ();
    }
    
    public Integer[] sort( Integer[] data ) {
	for (Integer i: data) {
	    heap.add (i);
	}
	
	Integer [] retArray = new Integer [data.length];
	int counter = 0;
	
	while ( !heap.isEmpty()) {
	    retArray [counter] = heap.removeMin ();
	    counter ++;
	}
	return retArray;
    }

    public static void main( String[] args ) {
	Heapsort sorty = new Heapsort();
	Integer [] n = {3,4,5,2,214,12,51,7,32,51,323,21};
	Integer [] m = sorty.sort (n);
	for (int i=0;i<m.length;i++){
	    System.out.print(m[i]+" ");
	}

    }
}
