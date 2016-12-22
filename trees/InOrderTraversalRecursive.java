public class InOrderTraversalRecursive {

    public static void traverse(BinaryTree.Node root) {
        if (root != null) {
            traverse(root.leftChild);
            System.out.print(root.data + "  ");
            traverse(root.rightChild);
        }
    }
}
