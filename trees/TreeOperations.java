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

    public static boolean areStructurallySame(BinaryTree.Node root1, BinaryTree.Node root2) {
        if (root1 == null && root2 == null) {
            return true;
        }
        if (root1 == null || root2 == null) {
            return false;
        }
        return (root1.data == root2.data) && areStructurallySame(root1.leftChild, root2.leftChild)
            && areStructurallySame(root1.rightChild, root2.rightChild);
	}

    public static int heightOfNode(BinaryTree.Node node) {
        if (node == null) {
            return 0;
        }

        int left = heightOfNode(node.leftChild);
        int right = heightOfNode(node.rightChild);

        return Math.max(left, right) + 1;
    }

    public static int diameter(BinaryTree.Node root) {
        if (root == null) {
            return 0;
        }

        return Math.max(heightOfNode(root.leftChild) + heightOfNode(root.rightChild) + 1,
            Math.max(diameter(root.leftChild), diameter(root.rightChild)));
    }
}