package trees;

public class TestTreeOperations {

    public static void main(String[] args) {
        BinaryTree<Integer> tree = new BinaryTree<Integer>(5);
        Helper.createFullBinaryTree(tree);
        BinaryTree<Integer> tree2 = new BinaryTree<Integer>(5);
        Helper.createFullBinaryTree(tree2);
        TreeOperations.convertToMirror(tree2.root);

        System.out.print("Is Mirror??  ");
        System.out.print(TreeOperations.IsMirror(tree.root, tree.root));
        System.out.println();
        System.out.println();
        System.out.print("Is Mirror??  ");
        System.out.print(TreeOperations.IsMirror(tree.root, tree2.root));
        System.out.println();
        System.out.println();
        System.out.print("Are Structurally Same??  ");
        System.out.print(TreeOperations.areStructurallySame(tree.root, tree.root));
        System.out.println();
        System.out.println();
        System.out.print("Are Structurally Same??  ");
        System.out.print(TreeOperations.areStructurallySame(tree.root, tree2.root));
        System.out.println();
        System.out.println();

        System.out.print("Diameter of Tree : ");
        System.out.print(TreeOperations.diameter(tree.root));
        System.out.println();
        System.out.println();

        System.out.print("Vertical Sum of Binary Tree : ");
        TreeOperations.verticalSum(tree.root);
        System.out.println();
        System.out.println();

        System.out.print("Zig-Zag traversal of Binary Tree : ");
        TreeOperations.zigzagTraversal(tree.root);
        System.out.println();
        System.out.println();

        System.out.print("Leaf to Root Paths of a Binary Tree : ");
        System.out.println();
        TreeOperations.leafToRootPaths(tree.root);
        System.out.println();
    }
}
