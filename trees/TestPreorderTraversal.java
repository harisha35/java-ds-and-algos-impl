public class TestPreorderTraversal {

    public static void main(String[] args) {
        BinaryTree<Integer> tree = new BinaryTree<Integer>(5);
        Helper.createRandomTree(tree, 15);
        PreOrderTraversalRecursive.traverse(tree.root);
    }
}
