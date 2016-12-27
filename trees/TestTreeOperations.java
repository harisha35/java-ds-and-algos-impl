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
	}
}