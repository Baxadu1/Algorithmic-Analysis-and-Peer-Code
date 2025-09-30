public class algorithms_student_a {


    public static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;

            while (j >= 0) {
                Metrics.comparisons++;
                if (arr[j] > key) {
                    arr[j + 1] = arr[j];
                    Metrics.swaps++;
                    j--;
                } else {
                    break;
                }
            }
            arr[j + 1] = key;
        }
    }


    public static void shellSort(int[] arr) {
        int n = arr.length;
        for (int gap = n / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < n; i++) {
                int temp = arr[i];
                int j;
                for (j = i; j >= gap; j -= gap) {
                    Metrics.comparisons++;
                    if (arr[j - gap] > temp) {
                        arr[j] = arr[j - gap];
                        Metrics.swaps++;
                    } else {
                        break;
                    }
                }
                arr[j] = temp;
            }
        }
    }


    public static int boyerMooreMajorityVote(int[] nums) {
        int count = 0, candidate = -1;

        for (int num : nums) {
            if (count == 0) {
                candidate = num;
                Metrics.allocations++;
            }
            Metrics.comparisons++;
            count += (num == candidate) ? 1 : -1;
        }
        return candidate;
    }


    public static class minHeap {
        private int[] heap;
        private int size;
        private int capacity;

        public minHeap(int capacity) {
            this.capacity = capacity;
            this.size = 0;
            this.heap = new int[capacity];
            Metrics.allocations++;
        }

        private int parent(int i) { return (i - 1) / 2; }
        private int left(int i) { return 2 * i + 1; }
        private int right(int i) { return 2 * i + 2; }

        public void insert(int key) {
            if (size == capacity) throw new RuntimeException("Heap full");
            heap[size] = key;
            Metrics.allocations++;
            int i = size;
            size++;

            while (i != 0) {
                Metrics.comparisons++;
                if (heap[parent(i)] > heap[i]) {
                    swap(i, parent(i));
                    i = parent(i);
                } else break;
            }
        }

        public int extractMin() {
            if (size <= 0) throw new RuntimeException("Heap empty");
            if (size == 1) return heap[--size];

            int root = heap[0];
            heap[0] = heap[size - 1];
            size--;
            minHeapify(0);
            return root;
        }

        private void minHeapify(int i) {
            int l = left(i);
            int r = right(i);
            int smallest = i;

            if (l < size) {
                Metrics.comparisons++;
                if (heap[l] < heap[smallest]) smallest = l;
            }

            if (r < size) {
                Metrics.comparisons++;
                if (heap[r] < heap[smallest]) smallest = r;
            }

            if (smallest != i) {
                swap(i, smallest);
                minHeapify(smallest);
            }
        }

        private void swap(int i, int j) {
            int t = heap[i];
            heap[i] = heap[j];
            heap[j] = t;
            Metrics.swaps++;
        }
    }
}
