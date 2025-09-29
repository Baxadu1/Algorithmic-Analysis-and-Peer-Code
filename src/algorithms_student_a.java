public class algorithms_student_a {
    public static void insertionSort(int[] arr){
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            int j = i-1;

            while (j>=0 && arr[j]>temp){
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = temp;
        }
    }




    public static void shellSort(int[] arr){
        int n = arr.length;
        for (int gap = n/2; gap > 0; gap /= 2){
            for (int i = gap; i < n; i++){
                int temp = arr[i];
                int j = i;
                while (j >= gap && arr[j-gap] > temp){
                    arr[j] = arr[j-gap];
                    j -= gap;
                }
                arr[j] = temp;
            }
        }
    }


    public static int boyerMooreMajorityVote(int[] arr){
        int candidate = 0;
        int count = 0;
        for (int num : arr){
            if (count == 0){
                candidate = num;
                count = 1;
            } else if (num == candidate){
                count++;
            } else {
                count--;
            }
        }
        return candidate;
    }





    public static class minHeap {
        private int[] heap;
        private int size;
        private int capacity;

        public minHeap(int capacity){
            this.capacity = capacity;
            this.size = 0;
            this.heap = new int[capacity];
        }

        private int parent(int i){ return (i-1)/2; }
        private int left(int i){ return 2*i+1; }
        private int right(int i){ return 2*i+2; }

        private void swap(int i, int j){
            int temp = heap[i];
            heap[i] = heap[j];
            heap[j] = temp;
        }

        public void insert(int val){
            if (size == capacity) return;
            heap[size] = val;
            int current = size;
            size++;
            while (current > 0 && heap[current] < heap[parent(current)]){
                swap(current, parent(current));
                current = parent(current);
            }
        }

        public int extractMin(){
            if (size <= 0) return Integer.MAX_VALUE;
            if (size == 1){
                size--;
                return heap[0];
            }
            int root = heap[0];
            heap[0] = heap[size-1];
            size--;
            minHeapify(0);
            return root;
        }

        private void minHeapify(int i){
            int l = left(i);
            int r = right(i);
            int smallest = i;
            if (l < size && heap[l] < heap[smallest]) smallest = l;
            if (r < size && heap[r] < heap[smallest]) smallest = r;
            if (smallest != i){
                swap(i, smallest);
                minHeapify(smallest);
            }
        }
    }


}
