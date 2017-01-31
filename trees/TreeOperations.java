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

    public static BinaryTree.Node lca(BinaryTree.Node root,
        BinaryTree.Node node1, BinaryTree.Node node2) {
            if (root == null) {
                return null;
            }

            if (node1 == root || node2 == root) {
                return root;
            }

            BinaryTree.Node left = lca(root.leftChild, node1, node2);
            BinaryTree.Node right = lca(root.rightChild, node1, node2);

            if (left == null && right == null) {
                return root;
            }

            return left != null ? left : right;
    }
}