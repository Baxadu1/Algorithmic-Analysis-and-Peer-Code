public class MaxHeap {
    private int[] heap;
    private int size;

    public MaxHeap(int capacity) {
        heap = new int[capacity];
        size = 0;
        Metrics.incAllocations();
    }

    public void insert(int key) {
        if (size == heap.length) throw new IllegalStateException("Heap full");
        heap[size] = key;
        size++;
        heapifyUp(size - 1);
    }

    public int extractMax() {
        if (size == 0) throw new IllegalStateException("Heap empty");
        int max = heap[0];
        heap[0] = heap[size - 1];
        size--;
        heapifyDown(0);
        return max;
    }

    public void increaseKey(int index, int newValue) {
        if (index >= size || heap[index] >= newValue) throw new IllegalArgumentException();
        heap[index] = newValue;
        heapifyUp(index);
    }

    private void heapifyUp(int i) {
        while (i > 0 && heap[parent(i)] < heap[i]) {
            swap(i, parent(i));
            i = parent(i);
        }
    }

    private void heapifyDown(int i) {
        int largest = i;
        int left = left(i);
        int right = right(i);

        if (left < size && heap[left] > heap[largest]) largest = left;
        if (right < size && heap[right] > heap[largest]) largest = right;

        if (largest != i) {
            swap(i, largest);
            heapifyDown(largest);
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
