package trees;

import queues.Queue;

public class LevelOrderTraversal {

    public static void traverse(BinaryTree.Node root) {
        Queue<BinaryTree.Node> queue = new Queue<BinaryTree.Node>();
        queue.enQueue(root);
        while(queue.size() > 0) {
            BinaryTree.Node temp = queue.deQueue();
            System.out.print(temp.data + "  ");
            if (temp.leftChild != null) {
                queue.enQueue(temp.leftChild);
            }
            if (temp.rightChild != null) {
                queue.enQueue(temp.rightChild);
            }
        }
    }
}