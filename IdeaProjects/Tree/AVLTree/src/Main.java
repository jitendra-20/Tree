public class Main {

    public static void main(String[] args) {
        Node root=null;
        AVL avl= new AVL();
        //LL Rotation
    //    root=avl.insertInAVLTree(root, 30);
      // root=avl.insertInAVLTree(root, 20);
       //root=avl.insertInAVLTree(root, 10);
       //root=avl.insertInAVLTree(root, 25);
       //root=avl.insertInAVLTree(root, 40);

        //LR rotation

        root=avl.insertInAVLTree(root, 50);
        root=avl.insertInAVLTree(root, 10);
        root=avl.insertInAVLTree(root, 20);;

        System.out.println("final: "+ root.data);

       // avl.balaceFactor(root);
       // System.out.println("done");
        System.out.println(root);
    }
}

class AVL{

    public Node insertInAVLTree(Node root, int data){
        //step 1
        if(root==null){
            Node temp= new Node(data, 1);
            return root=temp;
        }
        //step 2

        if(data<root.data){
           // Node left=insertInAVLTree(root.left,data);
            //if(root.left==null){
              //  root.left=left;
            //}
            root.left=insertInAVLTree(root.left,data);

        }else{
            Node right=insertInAVLTree(root.right,data);
            if(root.right==null){
                root.right=right;
            }
        }
        //step 3

        //update the height of each node while returning
        root.height=calculateHeight(root);
        //calculate the BalfaceFactor and perform rotation
        //step 4
       // System.out.println("for node: "+ root.data +" BF: "+ balaceFactor(root));
        if(balaceFactor(root)==2 && balaceFactor(root.left)==1){
            System.out.println("calling LLRotation");
            return llRotation(root);
        }
        if(balaceFactor(root)==2 && balaceFactor(root.left)==-1){
            System.out.println("calling LRRotation");
            return llRRotation(root);
        }

        return root;
    }

    private Node llRotation(Node p) {
        Node pl=p.left;
        Node plr=pl.right;
        //now do the rotation, make the pl new root
        pl.right=p;
        p.left=plr;
        //by doing this height could have change so we need to adjust the height
        p.height=calculateHeight(p);
        pl.height=calculateHeight(pl);
        return pl;

    }

    private Node llRRotation(Node p){

        Node pl=p.left;
        Node plr=pl.right;
        //make the plr new root
        pl.right=plr.left;
        p.left=plr.right;

        plr.left=pl;
        plr.right=p;
        pl.height=calculateHeight(pl);
        p.height=calculateHeight(p);
        plr.height=calculateHeight(plr);
        return plr;
    }

    /*
    height of lefttree - height of righttree
     */
    int balaceFactor(Node p){
        if(p==null){
            System.out.println("test");
            return 0;
        }
        int leftHeight=p.left==null?0:p.left.height;
        int rightHeight=p.right==null?0:p.right.height;
        //System.out.println(leftHeight- rightHeight);
        return leftHeight- rightHeight;

    }
    private int calculateHeight(Node p) {
        if(p==null){
         //   System.out.println("test");
            return 0;
        }
        int leftHeight=p.left==null?0:p.left.height;
        int rightHeight=p.right==null?0:p.right.height;

        return Math.max(leftHeight,rightHeight)+1;
    }


}
class Node{
    Node left;
    int data;
    Node right;
    int height;


    public Node(int data, int height) {
        this.data = data;
        this.height=height;
    }

    @Override
    public String toString() {
        return "Node{" +
                "left=" + left +
                ", data=" + data +
                ", right=" + right +
                ", height=" + height +
                '}';
    }
}