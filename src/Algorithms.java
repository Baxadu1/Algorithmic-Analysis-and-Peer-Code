import java.util.Arrays;

public class Algorithms {


    public static void selectionSort(int[] arr) {
        int n = arr.length;
        boolean swapped;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            swapped = false;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                    swapped = true;
                }
            }

            if (swapped) {
                int tmp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = tmp;
            } else {

                break;
            }
        }
    }


    public static void heapSort(int[] arr) {
        int n = arr.length;


        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }


        for (int i = n - 1; i > 0; i--) {

            int tmp = arr[0];
            arr[0] = arr[i];
            arr[i] = tmp;


            heapify(arr, i, 0);
        }
    }

    private static void heapify(int[] arr, int heapSize, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < heapSize && arr[left] > arr[largest]) {
            largest = left;
        }
        if (right < heapSize && arr[right] > arr[largest]) {
            largest = right;
        }
        if (largest != i) {
            int tmp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = tmp;
            heapify(arr, heapSize, largest);
        }
    }


    public static int[] kadane(int[] arr) {
        int maxSoFar = arr[0];
        int maxEndingHere = arr[0];
        int start = 0, end = 0, s = 0;

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > maxEndingHere + arr[i]) {
                maxEndingHere = arr[i];
                s = i;
            } else {
                maxEndingHere += arr[i];
            }

            if (maxEndingHere > maxSoFar) {
                maxSoFar = maxEndingHere;
                start = s;
                end = i;
            }
        }
        return new int[]{maxSoFar, start, end}; // [maxSum, startIndex, endIndex]
    }


    static class MaxHeap {
        private int[] heap;
        private int size;
        private int capacity;

        public MaxHeap(int capacity) {
            this.capacity = capacity;
            this.size = 0;
            this.heap = new int[capacity];
        }

        private int parent(int i) { return (i - 1) / 2; }
        private int left(int i) { return 2 * i + 1; }
        private int right(int i) { return 2 * i + 2; }

        public void insert(int key) {
            if (size == capacity) throw new IllegalStateException("Heap full");

            heap[size] = key;
            int i = size;
            size++;


            while (i != 0 && heap[parent(i)] < heap[i]) {
                swap(i, parent(i));
                i = parent(i);
            }
        }

        public int extractMax() {
            if (size <= 0) throw new IllegalStateException("Heap empty");
            if (size == 1) return heap[--size];

            int root = heap[0];
            heap[0] = heap[--size];
            maxHeapify(0);
            return root;
        }

        public void increaseKey(int i, int newKey) {
            if (i < 0 || i >= size) throw new IllegalArgumentException("Invalid index");
            if (newKey < heap[i]) throw new IllegalArgumentException("New key smaller");

            heap[i] = newKey;
            // Bubble up
            while (i != 0 && heap[parent(i)] < heap[i]) {
                swap(i, parent(i));
                i = parent(i);
            }
        }

        private void maxHeapify(int i) {
            int l = left(i);
            int r = right(i);
            int largest = i;

            if (l < size && heap[l] > heap[largest]) largest = l;
            if (r < size && heap[r] > heap[largest]) largest = r;

            if (largest != i) {
                swap(i, largest);
                maxHeapify(largest);
            }
        }

        private void swap(int i, int j) {
            int tmp = heap[i];
            heap[i] = heap[j];
            heap[j] = tmp;
        }

        public void printHeap() {
            System.out.println(Arrays.toString(Arrays.copyOf(heap, size)));
        }
    }


    public static void main(String[] args) {
        int[] arr1 = {5, 2, 8, 1, 3};
        selectionSort(arr1);
        System.out.println("Selection Sort: " + Arrays.toString(arr1));

        int[] arr2 = {12, 11, 13, 5, 6, 7};
        heapSort(arr2);
        System.out.println("Heap Sort: " + Arrays.toString(arr2));

        int[] arr3 = {-2, -3, 4, -1, -2, 1, 5, -3};
        int[] result = kadane(arr3);
        System.out.printf("Kadane’s: maxSum=%d, start=%d, end=%d%n", result[0], result[1], result[2]);

        MaxHeap heap = new MaxHeap(10);
        heap.insert(3);
        heap.insert(2);
        heap.insert(15);
        heap.insert(5);
        heap.printHeap();
        System.out.println("Extract max: " + heap.extractMax());
        heap.printHeap();
        heap.increaseKey(1, 20);
        heap.printHeap();
    }
}
