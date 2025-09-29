public class Kadane {
    static class Result {
        int maxSum, start, end;
        Result(int sum, int s, int e) {
            this.maxSum = sum;
            this.start = s;
            this.end = e;
        }
        @Override
        public String toString() {
            return "MaxSum = " + maxSum + " from index " + start + " to " + end;
        }
    }

    public static Result maxSubarray(int[] arr) {
        Metrics.reset();

        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("Array must not be empty");
        }

        int maxSoFar = arr[0];
        int maxEndingHere = arr[0];
        int start = 0, tempStart = 0, end = 0;

        for (int i = 1; i < arr.length; i++) {
            Metrics.incComparisons();
            if (arr[i] > maxEndingHere + arr[i]) {
                maxEndingHere = arr[i];
                tempStart = i;
            } else {
                maxEndingHere += arr[i];
            }

            Metrics.incComparisons();
            if (maxEndingHere > maxSoFar) {
                maxSoFar = maxEndingHere;
                start = tempStart;
                end = i;
            }
        }
        return new Result(maxSoFar, start, end);
    }
}
