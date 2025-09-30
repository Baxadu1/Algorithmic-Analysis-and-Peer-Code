
public class Metrics {

    public static long comparisons = 0;
    public static long swaps = 0;
    public static long allocations = 0;
    public static long arrayAccesses = 0;
    public static long recursionDepth = 0;


    private static long currentDepth = 0;


    public static void incComparisons() { comparisons++; }
    public static void incSwaps() { swaps++; }
    public static void incAllocations() { allocations++; }
    public static void incArrayAccesses() { arrayAccesses++; }
    public static void incArrayAccesses(long n) { arrayAccesses += n; }


    public static void enterRecursion() {
        currentDepth++;
        if (currentDepth > recursionDepth) recursionDepth = currentDepth;
    }

    public static void leaveRecursion() {
        if (currentDepth > 0) currentDepth--;
    }


    public static void reset() {
        comparisons = 0;
        swaps = 0;
        allocations = 0;
        arrayAccesses = 0;
        recursionDepth = 0;
        currentDepth = 0;
    }

    public static long getComparisons() { return comparisons; }
    public static long getSwaps() { return swaps; }
    public static long getAllocations() { return allocations; }
    public static long getArrayAccesses() { return arrayAccesses; }
    public static long getRecursionDepth() { return recursionDepth; }


    public static void print() {
        print("Metrics");
    }


    public static void print(String algorithmName) {
        System.out.println("=== Metrics for " + algorithmName + " ===");
        System.out.println("Comparisons:       " + comparisons);
        System.out.println("Swaps:             " + swaps);
        System.out.println("Allocations:       " + allocations);
        System.out.println("Array accesses:    " + arrayAccesses);
        System.out.println("Max recursion depth:" + recursionDepth);
        System.out.println();
    }

    @Override
    public String toString() {
        return String.format("time= -, comps=%d, swaps=%d, allocs=%d, arrAccess=%d, recDepth=%d",
                comparisons, swaps, allocations, arrayAccesses, recursionDepth);
    }
}
