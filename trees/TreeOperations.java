package trees;

public class TreeOperations {

    public static boolean IsMirror(BinaryTree.Node root1, BinaryTree.Node root2) {
        if (root1 == null && root2 == null) {
            return true;
        }
        if (root1 == null || root2 == null) {
            return false;
        }
        return (root1.data == root2.data) && IsMirror(root1.leftChild, root2.rightChild)
            && IsMirror(root1.rightChild, root2.leftChild);
    }

    public static void convertToMirror(BinaryTree.Node root) {
        if (root != null) {
            convertToMirror(root.leftChild);
            convertToMirror(root.rightChild);
            BinaryTree.Node temp = root.leftChild;
            root.leftChild = root.rightChild;
            root.rightChild = temp;
        }
    }
}