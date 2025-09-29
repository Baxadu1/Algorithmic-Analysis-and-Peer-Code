public class MaxHeap {
    private int[] heap;
    private int size;

    public MaxHeap(int capacity) {
        if (capacity <= 0) throw new IllegalArgumentException("Capacity must be > 0");
        heap = new int[capacity];
        size = 0;
        Metrics.incAllocations();
    }

    public void insert(int val) {
        if (size == heap.length) throw new RuntimeException("Heap is full");
        heap[size] = val;
        size++;
        increaseKey(size - 1, val);
    }

    public void increaseKey(int index, int newValue) {
        if (newValue < heap[index]) throw new IllegalArgumentException("New value is smaller");
        heap[index] = newValue;

        while (index > 0 && heap[parent(index)] < heap[index]) {
            swap(index, parent(index));
            index = parent(index);
        }
    }

    public int extractMax() {
        if (size <= 0) throw new RuntimeException("Heap is empty");
        int max = heap[0];
        heap[0] = heap[size - 1];
        size--;
        maxHeapify(0);
        return max;
    }

    private void maxHeapify(int i) {
        int left = left(i);
        int right = right(i);
        int largest = i;

        if (left < size && heap[left] > heap[largest]) {
            largest = left;
        }
        if (right < size && heap[right] > heap[largest]) {
            largest = right;
        }
        if (largest != i) {
            swap(i, largest);
            maxHeapify(largest);
        }
    }

    private void swap(int i, int j) {
        Metrics.incSwaps();
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    private int parent(int i) { return (i - 1) / 2; }
    private int left(int i) { return 2 * i + 1; }
    private int right(int i) { return 2 * i + 2; }
}
