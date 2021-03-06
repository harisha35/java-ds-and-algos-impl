package trees;

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import queues.Queue;

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

    public static boolean printAncestors(BinaryTree.Node root, BinaryTree.Node node) {
        if (root == null) {
            return false;
        }

        if (root.leftChild == node || root.rightChild == node ||
            printAncestors(root.leftChild, node) || printAncestors(root.rightChild, node) ) {
                System.out.println(root.data);
                return true;
        }

        return false;
    }

    public static void verticalSum(BinaryTree.Node root) {
        Map<Integer,Integer> hashMap = new HashMap<>();

        verticalSumUtil(root, 0, hashMap);

        if (hashMap != null) {
            System.out.println(hashMap.entrySet());
        }
    }

    private static void verticalSumUtil(BinaryTree.Node node, int hd, Map<Integer,Integer> hashMap) {
        if (node == null) {
            return;
        }

        verticalSumUtil(node.leftChild, hd-1, hashMap);

        if (hashMap.containsKey(hd)) {
            int prevValue = hashMap.get(hd);
            hashMap.put(hd, prevValue + (int) node.data);
        } else {
            hashMap.put(hd, (int) node.data);
        }

        verticalSumUtil(node.rightChild, hd+1, hashMap);
    }

    public static void zigzagTraversal(BinaryTree.Node root) {

        boolean leftToRight = false;

        Queue<BinaryTree.Node> currentLevel = new Queue<>();
        Queue<BinaryTree.Node> nextLevel = new Queue<>();

        currentLevel.enQueue(root);

        while(!currentLevel.isEmpty()) {
            BinaryTree.Node temp = currentLevel.deQueue();

            if (temp == null) {
                continue;
            } else {
                System.out.print(temp.data + " ");
            }

            if (leftToRight) {
                nextLevel.enQueue(temp.leftChild);
                nextLevel.enQueue(temp.rightChild);
            } else {
                nextLevel.enQueue(temp.rightChild);
                nextLevel.enQueue(temp.leftChild);
            }

            if (currentLevel.isEmpty()) {
                leftToRight = !leftToRight;
                Queue<BinaryTree.Node> tempQueue = currentLevel;
                currentLevel = nextLevel;
                nextLevel = tempQueue;
            }
        }
    }

    public static void leafToRootPaths(BinaryTree.Node root) {
        List<Integer> paths = new ArrayList<>();
        leafToRoot(root, paths, 0);
    }

    private static void leafToRoot(BinaryTree.Node node, List<Integer> paths, int pathLen) {
        if (node == null) {
            return;
        }

        paths.add(pathLen, (int) node.data);
        pathLen++;

        if (node.leftChild == null && node.rightChild == null) {
            printPaths(paths, pathLen);
        } else {
            leafToRoot(node.leftChild, paths, pathLen);
            leafToRoot(node.rightChild, paths, pathLen);
        }
    }

    private static void printPaths(List<Integer> paths, int pathLen) {
        for (int i = 0; i < pathLen; i++) {
            System.out.print(paths.get(i) + " ");
        }
        System.out.println();
    }

    public static int pathWithMaxSum(BinaryTree.Node root) {
        if (root == null) {
            return 0;
        }

        int left = pathWithMaxSum(root.leftChild);
        int right = pathWithMaxSum(root.rightChild);

        int data = (int) root.data;

        return Math.max(data, Math.max( data + left + right,
            Math.max(data + left, data + right)));
    }
}