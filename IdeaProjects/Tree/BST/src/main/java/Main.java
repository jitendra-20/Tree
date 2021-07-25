public class Main {
    public static void main(String[] args) {
           BST bst= new BST();
           Node root=null;
           root=bst.createBST(root,30);
           root=bst.createBST(root,40);
           root=bst.createBST(root,20);
           root=bst.createBST(root,10);
           root=bst.createBST(root,25);
           root=bst.createBST(root,7);
           root=bst.createBST(root,9);

           System.out.println(root);
           bst.inorder(root);
           int found=bst.search1(root, 25);

           System.out.println("");

           if(found==-1){
               System.out.println("Item not present in BST");
           }else{
               System.out.println("Found the item");
           }
           bst.deleteNode(root,10);
           System.out.println("================");

           bst.inorder(root);


    }
}


class BST{

    public Node createBST(Node root, int key){
        Node temp=null;
        if(root==null){
            temp= new Node(null,key,null);
            return temp;
        }
        if(key==root.data){
            return root;
        }
        if(key>root.data){
             root.right=createBST(root.right,key);
        }else{
            root.left=createBST(root.left,key);
        }

        return root;
    }

    public void inorder(Node root){
        if(root==null){
            return ;
        }
        inorder(root.left);
        System.out.print(root.data + "->");
        inorder(root.right);
    }

    public int search(Node root, int key) {
        if(root==null){
            return -1;
        }
        if(root.data==key){
            return root.data;
        }
        search(root.left,key);
        search(root.right,key);
        return -1;

    }

    public int search1(Node root, int key) {
        int found=-1;
        if(root==null){
            return -1;
        }
        if(root.data==key){
            return root.data;
        }
        if(key<root.data){
        //  found=  search1(root.left,key);
            return search1(root.left,key);
        }else{
          // found= search1(root.right,key);
            return search1(root.right,key);
        }
       // return found;

    }

    /*
         1st leaft node
         2nd having one child
         3 having 2 child
         We find the inorder successor or predecessor so that we do not have to do lots of modification
         There code be situation.

         We were taking inorder successor or predecessor because we wanted to avoid mulitple
         modification in the tree.
         If  inorder successor or predecessor is not a leaf node, then we have to make multiple modification

        Time complexity Search log(n) + modification log(n)
     */
    public Node deleteNode(Node p, int key){
        if(p==null) {
            return null;
        }
        if(p.left==null && p.right==null){
            return null;
        }
        Node q=null;
        if(key<p.data)
          p.left=deleteNode(p.left,key);
        else if(key>p.data)
           p.right=deleteNode(p.right,key);
        else{
            //key is found , now delete it
            int leftTreeHeight=height(p.left);
            int righTreeHeight=height(p.right);
            System.out.println(p.data);
            System.out.println(leftTreeHeight);
            System.out.println(righTreeHeight);
            if(leftTreeHeight>righTreeHeight){
                System.out.println();
                q=inorderPredecessor(p.left);
                p.data=q.data;
                p.left=deleteNode(p.left,q.data);

            }else{
                q=inordeSucessor(p.right);
                p.data=q.data;
                p.right=deleteNode(p.right,q.data);

            }




        }
        return p;

    }

    private int height(Node root) {
        if(root==null){
            return 0;
        }
        int x=height(root.left);
        int y=height(root.right);
        return Math.max(x,y)+1;


    }

    private Node inorderPredecessor(Node leftNode) {
        while(leftNode!=null && leftNode.right!=null){
            leftNode=leftNode.right;
        }
        return leftNode;

    }
    private Node inordeSucessor(Node rightNode) {
        while(rightNode!=null && rightNode.left!=null){
            rightNode=rightNode.left;
        }
        return rightNode;

    }


}
class Node {
    Node left;
    int data;
    Node right;


    public Node(Node left, int data, Node right) {
        this.left = left;
        this.data = data;
        this.right = right;
    }

    public Node(int data) {
        this.data = data;
    }


    @Override
    public String toString() {
        return "Node{" +
                "left=" + left +
                ", data=" + data +
                ", right=" + right +
                '}';
    }
}