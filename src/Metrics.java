public class Metrics {
    private static long comparisons = 0;
    private static long swaps = 0;
    private static long allocations = 0;
    private static long arrayAccesses = 0;
    private static long recursionDepth = 0;
    private static long currentRecursion = 0;

    public static void reset() {
        comparisons = swaps = allocations = arrayAccesses = recursionDepth = currentRecursion = 0;
    }

    public static void incComparisons() { comparisons++; }
    public static void incSwaps() { swaps++; }
    public static void incAllocations() { allocations++; }
    public static void incArrayAccesses() { arrayAccesses++; }

    public static void enterRecursion() {
        currentRecursion++;
        recursionDepth = Math.max(recursionDepth, currentRecursion);
    }

    public static void leaveRecursion() { currentRecursion--; }

    public static void print() {
        System.out.println("Comparisons: " + comparisons);
        System.out.println("Swaps: " + swaps);
        System.out.println("Array Accesses: " + arrayAccesses);
        System.out.println("Allocations: " + allocations);
        System.out.println("Max Recursion Depth: " + recursionDepth);
    }
}
