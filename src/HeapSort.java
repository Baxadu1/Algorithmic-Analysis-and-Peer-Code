public class HeapSort {
    public static void sort(int[] arr) {
        Metrics.reset();
        int n = arr.length;

        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }

        for (int i = n - 1; i > 0; i--) {
            swap(arr, 0, i);
            heapify(arr, i, 0);
        }
    }

    private static void heapify(int[] arr, int n, int i) {
        Metrics.enterRecursion();
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n) {
            Metrics.incComparisons();
            if (arr[left] > arr[largest]) {
                largest = left;
            }
        }

        if (right < n) {
            Metrics.incComparisons();
            if (arr[right] > arr[largest]) {
                largest = right;
            }
        }

        if (largest != i) {
            swap(arr, i, largest);
            heapify(arr, n, largest);
        }
        Metrics.leaveRecursion();
    }

    private static void swap(int[] arr, int i, int j) {
        Metrics.incSwaps();
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
