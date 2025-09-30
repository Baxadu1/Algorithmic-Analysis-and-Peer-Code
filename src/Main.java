import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
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
