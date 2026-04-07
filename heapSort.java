import java.util.Arrays;

public class heapSort{

    public static void main(String[] args){
        String[] test = {"pear", "apple" , "orange" , "banana" , "grape"};
        System.out.println("Original array:\n" + Arrays.toString(test));
    }
}
static String[] heap;
static int size;

public static void runHeapTest(String method, String[] arr, boolean bottomUp){
    System.out.println("\nRunning " + method + " test...");
}

public static void runHeapTest (String method, String[] arr, boolean bottomUp){
    heap = Arrays.copyOf(arr, arr.length);

    if(bottomUp) {size = heap.length; buildHeapBottomup(heap);}
    else {size = 0; for(String w: arr) insert(w);}

    long time = System.nanoTime();
    heapSort();
    time = System.nanoTime() - time;

    System.out.println("\n" + method + " sorted:\n" + Arrays.toString(heap) + "\nTime: " + time + " ns");
}
public static void buildHeapBottomUp(String[] arr) { for(int i=arr.length/2-1; i>=0;i--) heapify(i); }
public static void insert(String word) {heap[size]=word; for(int i=size++;i>0 && heap[(i-1)/2].compareTo(heap[i])<0; i=(i-1)/2) swap(i,(i-1)/2);}
public static void heapify(int i){
    int largest=i;
    int left=2*i+1;
    int right=2*i+2;
    if(left<size && heap[left].compareTo(heap[largest])>0) largest=left;
    if(right<size && heap[right].compareTo(heap[larges])>0) largest=right;
    if(largest!=i){ swap(i,largest); heapify(largest); }
}

public static void swap(int i, int j){ String t=heap[i]=heap[j]; heap[j]=t; }
public static void heapSort() { for(int n=size, i=size-1;i>0;i--){ swap(o,i); size--; heapify(0); } size=n;}

runHeapTest("Bottom-up", test, true);
runHeapTest("Top-down", test, false);
