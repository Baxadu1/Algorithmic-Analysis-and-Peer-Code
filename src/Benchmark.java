import java.util.Random;

public class Benchmark {
    private static final int[] SIZES = {100, 1000, 10000, 100000,100000};
    private static final int RUNS = 5; // average over multiple runs
    private static final Random rand = new Random();

    public static void main(String[] args) {
        System.out.printf("%-20s %-10s %-15s %-15s %-15s%n",
                "Algorithm", "n", "Time(ms)", "Comparisons", "Swaps/Updates");

        for (int n : SIZES) {
            int[] baseArray = generateArray(n);


            runBenchmark("Selection Sort", n, baseArray.clone(), (arr) -> SelectionSort.sort(arr));


            runBenchmark("Heap Sort", n, baseArray.clone(), (arr) -> HeapSort.sort(arr));


            runBenchmark("Kadane", n, baseArray.clone(), (arr) -> Kadane.maxSubarray(arr));


            runHeapBenchmark("MaxHeap", n, baseArray.clone());
        }
    }


    private static int[] generateArray(int n) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = rand.nextInt(1000000);
        return arr;
    }


    private static void runBenchmark(String name, int n, int[] arr, SortAlgorithm algo) {
        long totalTime = 0;
        long comparisons = 0;
        long swaps = 0;

        for (int r = 0; r < RUNS; r++) {
            int[] copy = arr.clone();
            Metrics.reset();

            long start = System.nanoTime();
            algo.run(copy);
            long end = System.nanoTime();

            totalTime += (end - start);
            comparisons += Metrics.getComparisons();
            swaps += Metrics.getSwaps();
        }

        System.out.printf("%-20s %-10d %-15.3f %-15d %-15d%n",
                name, n,
                totalTime / 1_000_000.0 / RUNS,
                comparisons / RUNS,
                swaps / RUNS);
    }


    private static void runHeapBenchmark(String name, int n, int[] arr) {
        long totalTime = 0;

        for (int r = 0; r < RUNS; r++) {
            Metrics.reset();

            long start = System.nanoTime();
            MaxHeap heap = new MaxHeap(arr.length);
            for (int x : arr) heap.insert(x); // Build heap
            for (int i = 0; i < arr.length / 2; i++) heap.extractMax(); // Extract half
            long end = System.nanoTime();

            totalTime += (end - start);
        }

        System.out.printf("%-20s %-10d %-15.3f %-15s %-15s%n",
                name, n,
                totalTime / 1_000_000.0 / RUNS,
                "-", "-");
    }


    @FunctionalInterface
    interface SortAlgorithm {
        void run(int[] arr);
    }
}
