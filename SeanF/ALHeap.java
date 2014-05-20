//Sean Fitzgerald
//APCS2 pd08
//HW40
//2014-05-19

/*****************************************************
 * class ALHeap  ---  skeleton
 * Implements a min heap using an ArrayList as underlying container
 * 
 * TASK:
 * Implement all methods
 * Add helpers as necessary
 * Classify runtime of each method
 *****************************************************/

import java.util.ArrayList;


public class ALHeap {

    //instance vars
    private ArrayList<Integer> _heap; //underlying container
    

    /*****************************************************
     * default constructor  ---  inits empty heap
     *****************************************************/
    public ALHeap() {
	_heap = new ArrayList<Integer>();
    } //O(1)



    /*****************************************************
     * boolean isEmpty()
     * Returns true if no meaningful elements in heap, false otherwise
     *****************************************************/
    public boolean isEmpty() {
	return _heap.size() == 0;
    }//O(?)



    /*****************************************************
     * add(Integer) 
     * Inserts an element in the heap
     * Postcondition: Tree maintains heap property.
     *****************************************************/
    public void add( Integer addVal ) {

	//Add value as last node, to maintain balance, completeness of tree
	_heap.add( addVal );

	int addValPos = _heap.size() - 1;
	int parentPos;

	while( addValPos > 0 ) { //potentially swap until reach root

	    //pinpoint parent
	    parentPos = (addValPos-1) / 2;

	    if ( addVal.compareTo(_heap.get(parentPos)) < 0 ) {//addVal < parent
		swap( addValPos, parentPos );
		addValPos = parentPos;
	    }
	    else
		break;
	}
    } //O(logn)


    /*****************************************************
      * Integer peekMin()
      * Returns min value in heap
      * Postcondition: Heap remains unchanged.
      *****************************************************/
    public Integer peekMin() {
	return _heap.get(0);
    }//O(1)



    /*****************************************************
     * removeMin()  ---  means of removing an element from heap
     * Removes and returns least element in heap.
     * Postcondition: Tree maintains heap property.
     *****************************************************/
    public Integer removeMin() {
	return remove( 0 );	
    }//O(n)

    public Integer remove( int index ) {
	Integer temp = _heap.get( index );
	if ( minChildPos( index ) == -1 )
	    _heap.remove( index );
	else {
	    swap( index, minChildPos( index ) );
	    remove( minChildPos( index ) );
	}
	return temp;
    }



    /*****************************************************
     * minChildPos(int)  ---  helper fxn for removeMin()
     * Returns index of least child, or 
     * -1 if no children, or if input pos is not in ArrayList
     * Postcondition: Tree unchanged
     *****************************************************/

    /*****************************************************
* minChildPos(int) --- helper fxn for removeMin()
* Returns index of least child, or
* -1 if no children, or if input pos is not in ArrayList
* Postcondition: Tree unchanged
*****************************************************/
    private int minChildPos( int pos ) {
	int retVal;
	int lc = 2*pos + 1; //index of left child
	int rc = 2*pos + 2; //index of right child

	//pos is not in the heap or pos is a leaf position
	if ( pos < 0 || pos >= _heap.size() || lc >= _heap.size() )
	    retVal = -1;
	//if no right child, then left child is only option for min
	else if ( rc >= _heap.size() )
	    retVal = lc;
	//have 2 children, so compare to find least
	else if ( _heap.get(lc).compareTo(_heap.get(rc)) < 0 )
	    retVal = lc;
	else
	    retVal = rc;
	return retVal;
    }//O(1)



    //~~~~~~~~~~~~~~~v~  MISC HELPERS ~v~~~~~~~~~~~~~~~

    public void swap( int index1, int index2 ) {
	Integer temp = _heap.get( index1 );
	_heap.set( index1, _heap.get( index2 ) );
	_heap.set( index2, temp );
    }

    public Integer minOf( Integer a, Integer b ) {
	if ( a < b )
	    return a;
	else
	    return b;
    }

    //~~~~~~~~~~~~~~~^~  MISC HELPERS ~^~~~~~~~~~~~~~~~



    /*****************************************************
     * toString()  ---  overrides inherited method
     * Returns either 
     * a) a level-order traversal of the tree (simple version)
     * b) ASCII representation of the tree (bit more complicated, much more fun)
     *****************************************************/
    public String toString() {
	String retStr = "";
	int level = 0;
	for (int i = 0; i < _heap.size(); i++) {
	    retStr += _heap.get(i) + ", ";
	    if ( i == 0 || i == level*2+2 ) {
		retStr += "\n";
		if ( i == level*2+2 ) 
		    level = level*2+2;
	    }
	}
	return retStr;
    }//O(n)






    //main method for testing
    public static void main( String[] args ) {

	ALHeap pile = new ALHeap();

	pile.add(2);
	System.out.println(pile);
	pile.add(4);
	System.out.println(pile);
	pile.add(6);
	System.out.println(pile);
	pile.add(8);
	System.out.println(pile);
	pile.add(10);
	System.out.println(pile);
	pile.add(1);
	System.out.println(pile);
	pile.add(3);
	System.out.println(pile);
	pile.add(5);
	System.out.println(pile);
	pile.add(7);
	System.out.println(pile);
	pile.add(9);
	System.out.println(pile);

	System.out.println("removing " + pile.removeMin() + "...");
	System.out.println(pile);
	System.out.println("removing " + pile.removeMin() + "...");
	System.out.println(pile);
	System.out.println("removing " + pile.removeMin() + "...");
	System.out.println(pile);
	System.out.println("removing " + pile.removeMin() + "...");
	System.out.println(pile);
	System.out.println("removing " + pile.removeMin() + "...");
	System.out.println(pile);
	System.out.println("removing " + pile.removeMin() + "...");
	System.out.println(pile);
	System.out.println("removing " + pile.removeMin() + "...");
	System.out.println(pile);
	System.out.println("removing " + pile.removeMin() + "...");
	System.out.println(pile);
	System.out.println("removing " + pile.removeMin() + "...");
	System.out.println(pile);
	System.out.println("removing " + pile.removeMin() + "...");
	System.out.println(pile);
	System.out.println("removing " + pile.removeMin() + "...");
	System.out.println(pile);
    }//end main()

}//end class ALHeap
