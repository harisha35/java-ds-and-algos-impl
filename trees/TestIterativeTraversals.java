package trees;

public class TestIterativeTraversals {

    public static void main(String[] args) {
        BinaryTree<Integer> tree = new BinaryTree<Integer>(5);
        Helper.createFullBinaryTree(tree);
        System.out.println("Level Order Traversal : ");
        LevelOrderTraversal.traverse(tree.root);
        System.out.println();
        System.out.println();
        System.out.println("PreOrder Order Traversal : ");
        PreOrderTraversalIterative.traverse(tree.root);
        System.out.println();
        System.out.println();
        System.out.println("InOrder Order Traversal : ");
        InOrderTraversalIterative.traverse(tree.root);
        System.out.println();
        System.out.println();
        // TODO : Post Order Traversal
        System.out.println("Level Order Traversal In Reverse Order: ");
        LevelOrderTraversalInReverse.traverse(tree.root);
        System.out.println();
        System.out.println();
    }
}