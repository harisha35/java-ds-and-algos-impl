package trees;

import stacks.Stack;
import queues.Queue;

public class LevelOrderTraversalInReverse {

    public static void traverse(BinaryTree.Node root) {

        if (root == null) {
            return;
        }

        Stack<BinaryTree.Node> stack = new Stack<BinaryTree.Node>();
        Queue<BinaryTree.Node> queue = new Queue<BinaryTree.Node>();
        BinaryTree.Node temp = null;

        queue.enQueue(root);
        while (queue.size() > 0) {
            temp = queue.deQueue();
            if(temp.rightChild != null) {
                queue.enQueue(temp.rightChild);
            }
            if(temp.leftChild != null) {
                queue.enQueue(temp.leftChild);
            }
            stack.push(temp);
        }
        while(stack.size() > 0) {
            System.out.print(stack.pop().data + "  ");
        }
    }
}