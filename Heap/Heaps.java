package DSA.Heap;

public class  Heaps {
    public int[] array;
    public int count;            // Number of elements in Heap
    public int capacity;        // Size of the heap
    public int heap_type;       // Min Heap or Max Heap

    public Heaps(int capacity, int heap_type) {
        this.heap_type = heap_type;
        this.count = 0;
        this.capacity = capacity;
        this.array = new int[capacity];
    }

    public int Parent(int i) {
        if (i <= 0 || i >= this.count)
            return -1;
        return (i-1) / 2;
    }

    public int LeftChild(int i) {
        int left = 2 * i + 1;
        if(left >= this.count)
            return -1;
        return left;
    }
    public int RightChild(int i) {
        int right = 2 * i + 2;
        if(right >= this.count)
            return -1;
        return right;
    }

    public int GetMaximum() {
        if(this.count == 0)
            return -1;
        return this.array[0];
    }

    public void PercolateDown(int i) {
        int l, r, max, temp;
        l = LeftChild(i);
        r = RightChild(i);
        if(l != -1 && this.array[l] > this.array[i])
            max = l;
        else
            max = i;
        if(r != -1&& this.array[r] > this.array[max])
            max = r;
        if(max != i) {  //Swap this.array[i] and  this.array[max];
            temp = this.array[i];
            this.array[i] = this.array[max];
            this.array[max] = temp;
            PercolateDown(max);
        }
    }

    int DeleteMax() {
        if(this.count == 0)
            return -1;
        int data = this.array[0];
        this.array[0] = this.array[this.count-1];
        this.count--; //reducing the heap size
        PercolateDown(0);
        return data;
    }
    public void Heapsort(int[] A, int n) {
        Heaps h = new Heaps(n, 0);
        int old_size, i, temp;
        BuildHeap(h, A, n);
        old_size = h.count;
        for(i = n-1; i > 0; i--) { //h.array[0] is the largest element
            temp = h.array[0];
            h.array[0] = h.array[h.count-1];
            h.count--;
            h.PercolateDown(0);
        }
        h.count = old_size;
    }

    public int Insert(int data) {
        int i;
        if(this.count == this.capacity)
            ResizeHeap();
        this.count++;   //increasing the heap size to hold this new item
        i = this.count-1;
        while(i >0 && data > this.array[(i-1)/2]) {
            this.array[i] = this.array[(i-1)/2];
            i = (i-1)/2;
        }
    this.array[i] = data;
        return data;
    }

    public void BuildHeap(Heaps h, int[] A, int n) {
        if(h == null)
            return;
        while (n > h.capacity)
            h.ResizeHeap();
        for(int i = 0; i < n; i++)
            h.array[i] = A[i];
        h.count = n;
        for (int i = (n-1)/2; i >=0; i --)
            h.PercolateDown(i);
    }


    public void ResizeHeap() {
        int[] array_old = new int[this.capacity];
        System.arraycopy(this.array, 0, array_old,0, this.count);
        this.array = new int[this.capacity * 2];
        if(this.array == null) {
            System.out.println("Memory Error");
            return;
        }
        for (int i = 0; i < this.count; i ++)
            this.array[i] = array_old[i];
             this.capacity *= 2;
             array_old = null;
    }

    public void DestroyHeap() {
        this.count = 0;
        this.array = null;
    }

    public void display(){
        if(count<0){
            System.out.println("empty");
        }
        else {
            for (int a:array){
                System.out.print(a+" ");
            }
        }
    }

    public static void main(String[] args) {
        Heaps h=new Heaps(16,1);
        int[] arr={500,200,300};
        h.BuildHeap(h,arr,3);
        System.out.println( h.Insert(100));
        h.Heapsort(arr,3);
        h.display();

    }
}