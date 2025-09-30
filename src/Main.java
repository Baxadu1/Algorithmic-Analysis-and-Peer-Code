import java.util.Arrays;

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


        System.out.println("=== Small demo (Student B algorithms) ===");

        int[] arr = {5, 2, 9, 1, 10, 6};


        Benchmark.run("Selection Sort", () -> {
            int[] copy = arr.clone();
            SelectionSort.sort(copy);
            System.out.println("Sorted: " + Arrays.toString(copy));
        });


        Benchmark.run("Heap Sort", () -> {
            int[] copy = arr.clone();
            HeapSort.sort(copy);
            System.out.println("Sorted: " + Arrays.toString(copy));
        });


        Benchmark.run("Kadane", () -> {
            Kadane.Result res = Kadane.maxSubarray(arr.clone());
            System.out.println("Kadane result: " + res);
        });


        Benchmark.run("MaxHeap", () -> {
            MaxHeap heap = new MaxHeap(arr.length);
            for (int val : arr) heap.insert(val);
            while (true) {
                try {
                    System.out.print(heap.extractMax() + " ");
                } catch (RuntimeException e) {
                    break;
                }
            }
            System.out.println();
        });


        Benchmark.runBenchmarks();
    }
}
