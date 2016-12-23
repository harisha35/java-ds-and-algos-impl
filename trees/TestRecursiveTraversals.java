package trees;

public class TestRecursiveTraversals {

    public static void main(String[] args) {
        BinaryTree<Integer> tree = new BinaryTree<Integer>(5);
        Helper.createRandomTree(tree, 15);
        System.out.println("PreOrder Traversal : ");
        PreOrderTraversalRecursive.traverse(tree.root);
        System.out.println();
        System.out.println();
        System.out.println("InOrder Traversal : ");
        InOrderTraversalRecursive.traverse(tree.root);
        System.out.println();
        System.out.println();
        System.out.println("PostOrder Traversal : ");
        PostOrderTraversalRecursive.traverse(tree.root);
        System.out.println();
        System.out.println();
    }
}
