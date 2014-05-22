//Sean Fitzgerald
//APCS2 pd08
//HW42
//2014-05-22

/*******************************************
APPROACH:

1. Heapify array -- parse through array, every time a new element is touched, swap it backwards until it satisfies heapness.

2. Print heapified array. (Most important)

3. Starting from the back, parse through array.  Each time an element is touched, put the first array element in temp storage and the touched element in index 0.  Then, swap that element down the unsorted region of the array until it satisfies heapness.  The sorted region grows form the right.  

4. Uses a min heap and sorts in descending order.
*******************************************/

public class HeapSort {

    private ALHeap _heap;

    public HeapSort() {
	_heap = new ALHeap();
    }

    public void swap( Integer[] data, int index1, int index2 ) {
	Integer temp = data[index1];
	data[index1] = data[index2];;
        data[index2] = temp;
    }

    public int minOf( Integer[] data, int index1, int index2 ) {
	if ( data[index1] < data[index2] )
	    return index1;
	else
	    return index2;
    }

    public Integer[] sort1( Integer[] data ) {

	Integer[] sorted = new Integer[data.length];

	for( Integer i: data )
	    _heap.add( i );

	int i = 0;
	while( !_heap.isEmpty() ) {
	    sorted[i] = _heap.removeMin();
	    i++;
	}

	return sorted;
    }

    public Integer[] sort( Integer[] data ) {

	Integer temp = data[0];

	for (int i = 1; i < data.length; i++) {
	    for (int p = i; p > 0; p = (p-1)/2) {
		if ( data[p] < data[(p-1)/2] )
		    swap( data, p, (p-1)/2 );
	    }
	}

	System.out.println( "\nHeapified data: " );
	for( Integer i: data )
	    System.out.print( "["+i+"]" );

	for (int i = data.length-1; i > 0; i--) {
	    temp = data[0];
	    data[0] = data[i];
	    for (int p = 0; p*2+1 < i;){
		int q = p;
		p = minOf( data, p*2+1, p*2+2 );
		swap( data, q, p);
	    }
	    data[i] = temp;
	}

	return data;

    }


    public static void main( String[] args ) {

	HeapSort sortedHeap = new HeapSort();
	Integer[] data = {12, 5, 9, 0, 11, 4, 1, 2, 7, 3, 8, 6, 10, 107, -9, 50, 897, 25, 456, -8};

	System.out.println( "Unsorted data: " );
	for( Integer i: data )
	    System.out.print( "["+i+"]" );

	Integer[] sortedData = sortedHeap.sort( data );

	System.out.println( "\nSorted data: " );
	for( Integer i: sortedData )
	    System.out.print( "["+i+"]" );

    }
}
