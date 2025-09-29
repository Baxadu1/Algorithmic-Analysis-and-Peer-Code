public class Metrics {
    private static long comparisons = 0;
    private static long swaps = 0;
    private static long allocations = 0;
    private static long recursionDepth = 0;

    // --- Increment methods ---
    public static void incComparisons() { comparisons++; }
    public static void incSwaps() { swaps++; }
    public static void incAllocations() { allocations++; }

    public static void enterRecursion() { recursionDepth++; }
    public static void leaveRecursion() { recursionDepth--; }

    // --- Reset ---
    public static void reset() {
        comparisons = 0;
        swaps = 0;
        allocations = 0;
        recursionDepth = 0;
    }

    // --- Getters ---
    public static long getComparisons() { return comparisons; }
    public static long getSwaps() { return swaps; }
    public static long getAllocations() { return allocations; }
    public static long getRecursionDepth() { return recursionDepth; }
}
