public class MyBinaryTree {
    TreeNode root;

    public void traverseBinaryTree(TreeNode node){
        if(node != null) {
            traverseBinaryTree(node.left);
            System.out.println(node.data + " ");
            traverseBinaryTree(node.right);
        }
    }
}
class TreeNode {
    int data;
    TreeNode left;
    TreeNode right;

    public TreeNode(int data){
        this.data = data;
        this.right = null;
        this.left = null;
    }
}
