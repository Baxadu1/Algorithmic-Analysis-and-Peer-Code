public class SelectionSort {
    public static void sort(int[] arr) {
        int n = arr.length;
        boolean swapped;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            swapped = false;
            for (int j = i + 1; j < n; j++) {
                Metrics.incComparisons();
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                    swapped = true;
                }
            }
            if (!swapped) break; // early termination
            swap(arr, i, minIndex);
        }
    }

    private static void swap(int[] arr, int i, int j) {
        Metrics.incSwaps();
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
