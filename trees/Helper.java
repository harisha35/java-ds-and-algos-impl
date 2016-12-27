package trees;

public class Helper {

    public static void createRandomTree(BinaryTree tree, int numberOfNodes) {
        BinaryTree.Node currentNode = tree.root;

        for( int i = 1; i < numberOfNodes; i++) {
             BinaryTree.Node child = new BinaryTree.Node();
             child.data = getRandomNumber(0, 100);
             if (getRandomBooleanValue()) {
                 currentNode.leftChild = child;
             } else {
                 currentNode.rightChild = child;
             }

             currentNode = child;
        }
    }

    // TODO : Make this function reusable by taking height as an argument
    public static void createFullBinaryTree(BinaryTree tree) {
        BinaryTree.Node currentNode = tree.root;
        currentNode.data = 1;
        currentNode.leftChild = new BinaryTree.Node();
        currentNode.leftChild.data = 2;
        currentNode.rightChild = new BinaryTree.Node();
        currentNode.rightChild.data = 3;
    }

    public static boolean getRandomBooleanValue() {
        return Math.random() < 0.5;
    }

    public static int getRandomNumber(int max, int min) {
        return min + (int)(Math.random() * ((max - min) + 1));
    }
}
