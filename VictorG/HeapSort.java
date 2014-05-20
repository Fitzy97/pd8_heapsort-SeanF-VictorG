//Victor Gaitour
//APCS2-8
//HW41
//2014-05-19
public class HeapSort {
    private static ALHeap heap= new ALHeap();
    
    public HeapSort(){
//heap=new ALHeap();
    }
    public static Integer[] sort(Integer[] list){
for (Integer i: list){
heap.add(i);
}

Integer[] retArr= new Integer[list.length];
for (int i=0; i<list.length;i++){
retArr[i]=heap.removeMin();
}
return retArr;
    }
    public static void main(String[] args){
Integer[] arr= {9,7,8,6,3,4,2,5,1,10};
arr=sort(arr);
//System.out.println(arr.toString());
for (int i=0;i<arr.length;i++){
System.out.print(arr[i]+" ");
}
    }


}