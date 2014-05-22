//David Bang
//APCS pd 8
//HW# 42
//2014-05-21 

/*****************************************************
 *Heapsort.java

My approach was to first make helper funcions that would due the components that I wanted done. I made swap which would swap the values in 2 positions for an array, then I made maxChildPos, then Heapify then MaxHeapify, then sort and then max which was required for me to heapify it completely later.

Basically what I did for the sort is a looked at the max value of the data set and heapified it till it became the root, thereby making a kind of max heap ( I can't get it to completely become a max heap without using other more memory). Then I would swap the root with the right most leaf of the heap and then I would partially heapify the array again to make it more like a heap as nodes would get sifted down until the heap property was regained. Then I would partially heapify the array again and but it will be ignoring the last index in the array and heapify without touching it, this part is the sorted array. Then I would keep decrementing the size of the unsorted heap and moving the last index of the heap and then make that index a part of the sorted region and then heapify the rest of the array that is not sorted. I would continue this until I reach the root and then I will stop sorting as the sorting will be done.

O (1) memory constraint
 *****************************************************/



public class Heapsort {

   
    public int[] sort( int[] data ) {
	int i = data.length - 1;
	int max = max (data);
	while ( data [0] != max)
	    MaxHeapify (data, i); //only partially heapifies each call, always excludes the i th index
	MaxHeapify (data, i);
	while (i >= 0){
	    swap (data,0, i);
	    MaxHeapify (data, i );
	    i--;
	}
	return data;
    }

    public int max (int [] data) {
	int tmp = data [0];
	for (int i = 0; i < data.length; i ++) {
	    if (tmp < data [i])
		tmp = data [i];
	}
	return tmp;
    }
		 
		 

    public void swap ( int[] data, int pos1, int pos2 ) {
	int tmp = data [pos1];
	data[pos1] = data [pos2];
	data[pos2] = tmp;
    }

    
    public void MaxHeapify (int [] data, int limit) {
	for (int i = 0; i < limit; i ++) {
	    Heapify (data, i, limit);
	}
    }
	

    public void Heapify (int[] data, int pos, int limit) {
	int foo = data [pos];
	int maxChildPos;

	//choose child w/ max value, or check for child
	while (pos <= limit) {

	    maxChildPos = maxChildPos(data, pos, limit);

	    //if no children, then i've walked far enough
	    if ( maxChildPos == -1 ) 
	        break;
	    //if i am greater than my greatest child, then i've walked far enough
	    else if ( foo > data [maxChildPos]) 
		break;
	    //if i am < greatest child, swap with that child
	    else {
		swap( data, pos, maxChildPos );
		pos = maxChildPos;
	    } 
	}

    }
	
	

    private int maxChildPos(int [] data, int pos, int limit ) {
	int retVal;
	int lc = 2*pos + 1; //index of left child
	int rc = 2*pos + 2; //index of right child

	//pos is not in the heap or pos is a leaf position
	if ( pos < 0 || pos >= limit || lc >= limit )
	    retVal = -1;
	//if no right child, then left child is only option for max
	else if ( rc >= limit )
	    retVal = lc;
	//have 2 children, so compare to find max 
	else if ( data[lc] > data[rc] )
	    retVal = lc;
	else
	    retVal = rc;
	return retVal;
    }//O(1)

    
    

    public static void main( String[] args ) {

	Heapsort pile = new Heapsort();
	int [] data = {10, 15, 14, 11,1,2,4,5,6,13,213,41,12,8,9,7, 17};
	for (int i = 0; i < data.length; i ++ ) {
	    System.out.print (" " + data [i]);
	}

	System.out.print ("\n\n Partially heap, (becomes heaper as it goes on and loops in sort) \n");

	pile.MaxHeapify (data, data.length - 1);
	for (int i = 0; i < data.length; i ++ ) {
	    System.out.print (" " + data [i]);
	}

	System.out.print ("\n\n Sorted Stuff \n");

	pile.sort (data);
	for (int i = 0; i < data.length; i ++ ) {
	    System.out.print (" " + data [i]);
	}
	System.out.print ("\n");
    }
}
