public class Main {
    public static void main(String[] args) {
        MyHashTable table = new MyHashTable(10);
        MyBinaryTree tree = new MyBinaryTree();

        tree.root = new TreeNode(10);
        tree.root.left = new TreeNode(23);
        tree.root.right = new TreeNode(31);
        tree.root.left.left = new TreeNode(48);
        tree.root.left.left.right = new TreeNode(89);

        tree.traverseBinaryTree(tree.root);

        table.put(105, "aboba");
        table.put(21, "amogus");
        table.put(31, "bebra");

        System.out.println(table.get(105));
        System.out.println(table.get(21));
        System.out.println(table.get(31));

        System.out.println("the table is empty: " + table.isEmpty());

        System.out.println("deleted element: " + table.remove(105));
        System.out.println("deleted element: " + table.remove(21));
        System.out.println("deleted element: " + table.remove(31));

        System.out.println("the size is: " +table.size());

        System.out.println("the table is empty: " + table.isEmpty());
    }
}
