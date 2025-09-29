import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random rand = new Random();
        int[] arr = rand.ints(10, -50, 50).toArray();

        System.out.println("Original: " + Arrays.toString(arr));

        // Selection Sort
        int[] s1 = arr.clone();
        SelectionSort.sort(s1);
        System.out.println("Selection Sort: " + Arrays.toString(s1));
        Metrics.print();

        // Heap Sort
        int[] s2 = arr.clone();
        HeapSort.sort(s2);
        System.out.println("Heap Sort: " + Arrays.toString(s2));
        Metrics.print();

        // Kadane’s Algorithm
        Kadane.Result res = Kadane.maxSubarray(arr.clone());
        System.out.println("Kadane: " + res);
        Metrics.print();

        // MaxHeap
        MaxHeap heap = new MaxHeap(20);
        for (int val : arr) heap.insert(val);
        System.out.print("Extracted from MaxHeap: ");
        while (true) {
            try {
                System.out.print(heap.extractMax() + " ");
            } catch (RuntimeException e) {
                break;
            }
        }
    }
}
