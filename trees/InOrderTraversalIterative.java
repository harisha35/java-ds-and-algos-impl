package trees;

import stacks.Stack;

public class InOrderTraversalIterative {

    public static void traverse(BinaryTree.Node root) {
        Stack<BinaryTree.Node> stack = new Stack<BinaryTree.Node>();
        while(true) {
            while(root != null) {
                stack.push(root);
                root = root.leftChild;
            }
            if(stack.size() <= 0) {
                break;
            }
            root = stack.pop();
            System.out.print(root.data + "  ");
            root = root.rightChild;
        }
    }
}