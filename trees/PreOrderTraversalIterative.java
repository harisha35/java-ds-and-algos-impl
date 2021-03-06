package trees;

import stacks.Stack;

public class PreOrderTraversalIterative {

    public static void traverse(BinaryTree.Node root) {
        Stack<BinaryTree.Node> stack = new Stack<BinaryTree.Node>();
        while(true) {
            while(root != null) {
            System.out.print(root.data + "  ");
                stack.push(root);
                root = root.leftChild;
            }
            if(stack.size() <= 0) {
                break;
            }
            root = stack.pop();
            root = root.rightChild;
        }
    }
}