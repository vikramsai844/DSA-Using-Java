package DSA.Sorting;

public class AllSortingMethods {

    public int[] BubbleSort(int[] A) {
        for (int pass = A.length - 1; pass >= 0; pass--)
        {
            for (int i = 0; i <= pass - 1 ; i++)
            {
                if(A[i] > A[i+1]) {
// swap elements
                    int temp = A[i];
                    A[i] = A[i+1];
                    A[i+1] = temp;
                }
            }
        }
        return A;
    }

    public int[] Selection(int[] A) {
        int i, j, min, temp;
        for (i = 0; i < A.length - 1; i++) {
            min = i;
            for (j = i+1; j < A.length; j++) {
                if(A [j] < A [min])
                    min = j;
            }
            // swap elements
            temp = A[min];
            A[min] = A[i];
            A[i] = temp;
        }
        return A;
    }


    public int[] InsertionSort(int[] A) {
        int i, j, v;
        for (i = 1; i <= A.length - 1; i++) {
            v = A[i];
            j = i;

            while (j >= 1 && A[j-1] > v ) {
                A[j] = A[j-1];
                j--;
            }
            A[j] = v;
        }
        return A;
    }

    public int[] ShellSort(int[] A) {
        int i, j, h, v;
        for (h = 1; h < A.length / 3; h = 3*h+1);

        for ( ; h > 0; h = h/3) {
            for (i = h+1; i < A.length-1; i+=1) {
                v = A[i];
                j = i;
                while (j > h && A[j-h] > v) {
                    A[j] = A[j-h];
                    j-=h;
                }
                A[j] = v;
            }
        }
        return A;
    }



    public void Mergesort(int[] A, int[] temp, int left, int right) {
        int mid;
        if(right > left) {
            mid = (right + left) / 2;
            Mergesort(A, temp, left, mid);
            Mergesort(A, temp, mid+1, right);
            Merge(A, temp, left, mid+1, right);
        }
    }
    public void Merge(int[] A, int[] temp, int left, int mid, int right) {
        int i, left_end, size, temp_pos;
        left_end = mid - 1;
        temp_pos = left;
        size = right - left + 1;
        while ((left <= left_end) && (mid <= right)) {
            if(A[left] <= A[mid]) {
                temp[temp_pos] = A[left];
                temp_pos = temp_pos + 1;
                left = left +1;
            }
            else {
                temp[temp_pos] = A[mid];
                temp_pos = temp_pos + 1;
                mid = mid + 1;
            }
        }
        while (left <= left_end) {
            temp[temp_pos] = A[left];
            left = left + 1;
            temp_pos = temp_pos + 1;
        }
        while (mid <= right) {
            temp[temp_pos] = A[mid];
            mid = mid + 1;
            temp_pos = temp_pos + 1;
        }
        for (i = 0; i < size-1; i++) {
            A[right] = temp[right];
            right = right-1;
        }
    }


    public static void main(String[] args) {
        AllSortingMethods bs=new AllSortingMethods();
        int[] A={4,5,8,2,1,6};
//        int[] temp=bs.BubbleSort(A);
//        int[] temp=bs.Selection(A);

//        int[] temp=bs.InsertionSort(A);

//        int[] temp=bs.ShellSort(A);
        int[] temparr = new int[A.length];

       bs.Mergesort(A,temparr,0,A.length-1);


//        for(int val:temp){
//            System.out.print(val+" ");
//        }
    }
}
