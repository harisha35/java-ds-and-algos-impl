public class PreOrderTraversalRecursive {

    public static void traverse(BinaryTree.Node root) {
        if (root != null) {
            System.out.print(root.data + "  ");
            traverse(root.leftChild);
            traverse(root.rightChild);
        }
    }
}
