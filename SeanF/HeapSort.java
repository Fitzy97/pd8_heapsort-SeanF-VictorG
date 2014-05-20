//Sean Fitzgerald
//APCS2 pd08
//HW40
//2014-05-19

/*******************************************
BEST CASE: Array contains 1 element -- O(n)
WORST CASE: Array contains infinite elements -- O(n)
My sort does not look at the data, therefore always runs at O(n)
*******************************************/

public class HeapSort {

    private ALHeap _heap;

    public HeapSort() {
	_heap = new ALHeap();
    }

    public Integer[] sort( Integer[] data ) {

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

    public static void main( String[] args ) {

	HeapSort sortedHeap = new HeapSort();
	Integer[] data = {12, 5, 9, 0, 11, 6, 4, 2, 10, 1, 3, 7, 8};

	System.out.println( "Unsorted data: " );
	for( Integer i: data )
	    System.out.print( "["+i+"]" );

	Integer[] sortedData = sortedHeap.sort( data );

	System.out.println( "\nSorted data: " );
	for( Integer i: sortedData )
	    System.out.print( "["+i+"]" );

    }
}
