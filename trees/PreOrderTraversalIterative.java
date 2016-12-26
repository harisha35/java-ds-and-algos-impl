package trees;

import stacks.Stack;

public class PreOrderTraversalIterative {

    public static void traverse(BinaryTree.Node root) {
        Stack<BinaryTree.Node> stack = new Stack<BinaryTree.Node>();

        if(root == null) {
            return;
        }

        stack.push(root);
        while(stack.size() > 0) {
            BinaryTree.Node temp = stack.pop();
            if (temp != null) {
                System.out.print(temp.data + "  ");
            }
            if (temp.rightChild != null) {
                stack.push(temp.rightChild);
            }
            if (temp.leftChild != null) {
                stack.push(temp.leftChild);
            }
        }
    }
}