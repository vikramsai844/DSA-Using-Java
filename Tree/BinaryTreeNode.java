package DSA.Tree;

public class BinaryTreeNode {
    public int data;
    public BinaryTreeNode left, right;
    public BinaryTreeNode(int data){
        this.data = data;
        left = null;
        right = null;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public BinaryTreeNode getLeft() {
        return left;
    }

    public void setLeft(BinaryTreeNode left) {
        this.left = left;
    }

    public BinaryTreeNode getRight() {
        return right;
    }

    public void setRight(BinaryTreeNode right) {
        this.right = right;
    }

    public static void PreOrder(BinaryTreeNode root){
        if(root != null) {
            System.out.println(root.data);
            PreOrder(root.left);
            PreOrder(root.right);
        }
    }

    public static void InOrder(BinaryTreeNode root){
        if(root != null) {
            InOrder(root.left);
            System.out.println(root.data);
            InOrder(root.right);
        }
    }

    public static BinaryTreeNode Insert(BinaryTreeNode root, int data) {
        if( root == null) {
            root = new BinaryTreeNode(data);
            if( root == null) {
                System.out.println("Memory Error");
                return root;
            }
            else {
                root.data = data;
                root.left = null; root.right = null;
            }
        }
        else {
            if( data < root.data )
                root.left = Insert(root.left, data);
            else if( data > root.data )
                root.right = Insert(root.right, data);
        }
        return root;
    }

    public static void PostOrder(BinaryTreeNode root){
        if(root != null) {
            PostOrder(root.left);
            PostOrder(root.right);
            System.out.println(root.data);
        }
    }

    public static BinaryTreeNode FindMax(BinaryTreeNode root) {
        if(root == null)
            return null;
        else
        if( root.right == null)
            return root;
        else  return FindMax( root.right);
    }


    public static BinaryTreeNode Delete(BinaryTreeNode root, int data) {
        BinaryTreeNode temp;
        if( root == null)
            System.out.println("Element not there in tree");
        else if(data < root.data)
            root.left = Delete(root.left,data);
        else if(data > root.data)
        root.right = Delete(root.right, data);
        else {
            //Found element
            if( root.left != null && root.right !=null )  {
                /* Replace with largest in left subtree */
                temp = FindMax( root.left );
                root.data = temp.data;
                root.left = Delete(root.left, root.data);
            }
            else {
                /* One child */
                temp = root;
                if( root.left == null )
                    root = root.right;
                if( root.right == null)
                    root = root.left;


            }
        }
        return root;
    }






    public static void main(String[] args) {
        BinaryTreeNode b1=new BinaryTreeNode(100);

        BinaryTreeNode b3=new BinaryTreeNode(200);
        b1.setLeft(b3);

        BinaryTreeNode b4=new BinaryTreeNode(300);
        b3.setLeft(b4);

        BinaryTreeNode b5=new BinaryTreeNode(400);
        b1.setRight(b5);
//
//        BinaryTreeNode.PreOrder(b1);

//        BinaryTreeNode.InOrder(b1);

//        BinaryTreeNode.PostOrder(b1);

//        BinaryTreeNode.Insert(b1,500);
//        BinaryTreeNode.InOrder(b1);


        BinaryTreeNode.Delete(b1,100);
        BinaryTreeNode.InOrder(b1);

//      System.out.println(b1.getLeft().data);
//        System.out.println(b1.getData());
    }
}