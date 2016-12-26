package trees;

public class TestIterativeTraversals {

    public static void main(String[] args) {
        BinaryTree<Integer> tree = new BinaryTree<Integer>(5);
        Helper.createRandomTree(tree, 15);
        System.out.println("Level Order Traversal : ");
        LevelOrderTraversal.traverse(tree.root);
        System.out.println();
        System.out.println();
        System.out.println("Preorder Order Traversal : ");
        PreOrderTraversalIterative.traverse(tree.root);
        System.out.println();
        System.out.println();
    }
}