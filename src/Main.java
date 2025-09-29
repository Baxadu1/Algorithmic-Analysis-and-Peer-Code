import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        System.out.println("STUDENT A CODE:    ");

        int[] arr1 = {5, 2, 9, 1, 10, 6};
        algorithms_student_a.insertionSort(arr1);
        System.out.print("insertion sort: ");
        for (int x : arr1) System.out.print(x + " ");
        System.out.println();

        int[] arr2 = {12, 34, 54, 2, 3};
        algorithms_student_a.shellSort(arr2);
        System.out.print("shell sort: ");
        for (int x : arr2) System.out.print(x + " ");
        System.out.println();


        int[] arr3 = {2, 2, 1, 1, 2, 2, 3};
        int majority = algorithms_student_a.boyerMooreMajorityVote(arr3);
        System.out.println("boyer-moore majority vote: " + majority);

        algorithms_student_a.minHeap Heap = new algorithms_student_a.minHeap(10);
        Heap.insert(3);
        Heap.insert(2);
        Heap.insert(15);
        Heap.insert(5);
        Heap.insert(4);
        System.out.println("extract min: " + Heap.extractMin());
        System.out.println("extract min: " + Heap.extractMin());









        System.out.println("STUDENT B CODE:    ");


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
