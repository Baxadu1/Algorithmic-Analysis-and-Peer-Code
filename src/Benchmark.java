import java.util.Random;

public class Benchmark {


    private static final int[] SIZES = {100, 1000, 10000, 100000};


    public static void run(String name, Runnable algorithm) {
        Metrics.reset();
        long start = System.nanoTime();
        algorithm.run();
        long end = System.nanoTime();
        double ms = (end - start) / 1_000_000.0;

        System.out.printf("%-25s time=%.3f ms, comps=%d, swaps=%d, allocs=%d, arrAccess=%d, recDepth=%d%n",
                name, ms,
                Metrics.getComparisons(),
                Metrics.getSwaps(),
                Metrics.getAllocations(),
                Metrics.getArrayAccesses(),
                Metrics.getRecursionDepth()
        );
    }


    public static void runBenchmarks() {
        System.out.println("=== Benchmark: Student B Algorithms ===");

        for (int n : SIZES) {
            int[] base = generateRandomArray(n);
            System.out.println("\nArray size: " + n);


            run("Selection Sort", () -> {
                int[] arr = base.clone();
                SelectionSort.sort(arr);
            });


            run("Heap Sort", () -> {
                int[] arr = base.clone();
                HeapSort.sort(arr);
            });


            run("Kadane’s Algorithm", () -> {
                Kadane.Result res = Kadane.maxSubarray(base.clone());
                // выводим только сумму
                System.out.println("Kadane result sum=" + res.maxSum);
            });


            run("MaxHeap insert+extract", () -> {
                MaxHeap heap = new MaxHeap(base.length);
                for (int val : base) heap.insert(val);
                while (true) {
                    try {
                        heap.extractMax();
                    } catch (RuntimeException e) {
                        break;
                    }
                }
            });
        }
    }

    private static int[] generateRandomArray(int n) {
        Random rand = new Random();
        return rand.ints(n, -10000, 10000).toArray();
    }
}
