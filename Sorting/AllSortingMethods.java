package DSA.Sorting;

public class AllSortingMethods {

  
    public int[] bubbleSort(int[] A) {
        for (int pass = A.length - 1; pass > 0; pass--) {
            for (int i = 0; i < pass; i++) {
                if (A[i] > A[i + 1]) {
                    int temp = A[i];
                    A[i] = A[i + 1];
                    A[i + 1] = temp;
                }
            }
        }
        return A;
    }

    public int[] selectionSort(int[] A) {
        for (int i = 0; i < A.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < A.length; j++) {
                if (A[j] < A[min]) {
                    min = j;
                }
            }
            int temp = A[min];
            A[min] = A[i];
            A[i] = temp;
        }
        return A;
    }

 
    public int[] insertionSort(int[] A) {
        for (int i = 1; i < A.length; i++) {
            int v = A[i];
            int j = i;

            while (j > 0 && A[j - 1] > v) {
                A[j] = A[j - 1];
                j--;
            }
            A[j] = v;
        }
        return A;
    }

    public int[] shellSort(int[] A) {
        int h = 1;

        while (h < A.length / 3) {
            h = 3 * h + 1;
        }

        while (h > 0) {
            for (int i = h; i < A.length; i++) {
                int v = A[i];
                int j = i;

                while (j >= h && A[j - h] > v) {
                    A[j] = A[j - h];
                    j -= h;
                }
                A[j] = v;
            }
            h = h / 3;
        }
        return A;
    }

    public void mergeSort(int[] A, int[] temp, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;

            mergeSort(A, temp, left, mid);
            mergeSort(A, temp, mid + 1, right);

            merge(A, temp, left, mid + 1, right);
        }
    }

    private void merge(int[] A, int[] temp, int left, int mid, int right) {
        int i = left;
        int j = mid;
        int k = left;
        int leftEnd = mid - 1;

        while (i <= leftEnd && j <= right) {
            if (A[i] <= A[j]) {
                temp[k++] = A[i++];
            } else {
                temp[k++] = A[j++];
            }
        }

        while (i <= leftEnd) temp[k++] = A[i++];
        while (j <= right) temp[k++] = A[j++];

        for (i = left; i <= right; i++) {
            A[i] = temp[i];
        }
    }

    public void quickSort(int[] A, int low, int high) {
        if (low < high) {
            int pi = partition(A, low, high);
            quickSort(A, low, pi - 1);
            quickSort(A, pi + 1, high);
        }
    }

    private int partition(int[] A, int low, int high) {
        int pivot = A[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (A[j] < pivot) {
                i++;
                swap(A, i, j);
            }
        }

        swap(A, i + 1, high);
        return i + 1;
    }


    private void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }

    public void display(int[] A) {
        for (int val : A) {
            System.out.print(val + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        AllSortingMethods obj = new AllSortingMethods();

        int[] A = {4, 5, 8, 2, 1, 6};

        // obj.bubbleSort(A);
        // obj.selectionSort(A);
        // obj.insertionSort(A);
        // obj.shellSort(A);

      
        // int[] temp = new int[A.length];
        // obj.mergeSort(A, temp, 0, A.length - 1);

        obj.quickSort(A, 0, A.length - 1);

        obj.display(A);
    }
}
