package DSA.Stack;

public class Main {
    public static void main(String[] args) throws Exception {
        DynamicArrayStack ds=new DynamicArrayStack();
//        System.out.println(ds.pop());
        System.out.println(ds.size());
        ds.push(100);
        ds.push(200);
        ds.push(300);
      System.out.println(ds.pop());
        System.out.println(ds);
//        System.out.println(ds.top());

    }
}
