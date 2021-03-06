package algorithm.level2twoWayRecursion;

public class SortIntegersII {
    /**
     * @param A: an integer array
     * @return: nothing
     */
     // using quicksort
    public void sortIntegers2(int[] A) {
        quickSort(A, 0, A.length - 1);
    }

    private void quickSort(int[] A, int start, int end) {
        if (start > end) {
            return;
        }
        int left = start, right = end;
        int pivot = A[start + (end - start) / 2];
        while (left <= right) {
            while(left <= right && A[left] < pivot) {
                left++;
            }
            while (left <= right && A[right] > pivot) {
                right--;
            }
            if (left <= right) {
                int temp = A[left];
                A[left] = A[right];
                A[right] = temp;
                left++;
                right--;
            }
        }
        quickSort(A, start, right);
        quickSort(A, left, end);
    }
}
