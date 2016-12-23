package trees;

public class PostOrderTraversalRecursive {

    public static void traverse(BinaryTree.Node root) {
        if (root != null) {
            traverse(root.leftChild);
            traverse(root.rightChild);
            System.out.print(root.data + "  ");
        }
    }
}
