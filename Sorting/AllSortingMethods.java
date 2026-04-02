package DSA.Sorting;

public class AllSortingMethods {

    public int[] BubbleSort(int[] A) {
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


    public int[] Selection(int[] A) {
        int i, j, min, temp;
        for (i = 0; i < A.length - 1; i++) {
            min = i;
            for (j = i + 1; j < A.length; j++) {
                if (A[j] < A[min]) {
                    min = j;
                }
            }
            temp = A[min];
            A[min] = A[i];
            A[i] = temp;
        }
        return A;
    }


    public int[] InsertionSort(int[] A) {
        int i, j, v;
        for (i = 1; i < A.length; i++) {
            v = A[i];
            j = i;

            while (j > 0 && A[j - 1] > v) {
                A[j] = A[j - 1];
                j--;
            }
            A[j] = v;
        }
        return A;
    }


    public int[] ShellSort(int[] A) {
        int i, j, h, v;

        for (h = 1; h < A.length / 3; h = 3 * h + 1);

        for (; h > 0; h = h / 3) {
            for (i = h; i < A.length; i++) {
                v = A[i];
                j = i;

                while (j >= h && A[j - h] > v) {
                    A[j] = A[j - h];
                    j -= h;
                }

                A[j] = v;
            }
        }
        return A;
    }

 
    public void Mergesort(int[] A, int[] temp, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;

            Mergesort(A, temp, left, mid);
            Mergesort(A, temp, mid + 1, right);

            Merge(A, temp, left, mid + 1, right);
        }
    }


    public void Merge(int[] A, int[] temp, int left, int mid, int right) {
        int i = left;
        int j = mid;
        int k = left;

        int left_end = mid - 1;

        while (i <= left_end && j <= right) {
            if (A[i] <= A[j]) {
                temp[k++] = A[i++];
            } else {
                temp[k++] = A[j++];
            }
        }

        while (i <= left_end) {
            temp[k++] = A[i++];
        }

        while (j <= right) {
            temp[k++] = A[j++];
        }

        // Copy back to original array
        for (i = left; i <= right; i++) {
            A[i] = temp[i];
        }
    }


    public static void main(String[] args) {
        AllSortingMethods obj = new AllSortingMethods();

        int[] A = {4, 5, 8, 2, 1, 6};

    
        // int[] result = obj.BubbleSort(A);
        // int[] result = obj.Selection(A);
        // int[] result = obj.InsertionSort(A);
        // int[] result = obj.ShellSort(A);

        int[] temp = new int[A.length];
        obj.Mergesort(A, temp, 0, A.length - 1);

        for (int val : A) {
            System.out.print(val + " ");
        }
    }
}
