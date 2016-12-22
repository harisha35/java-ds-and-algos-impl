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

    public static boolean getRandomBooleanValue() {
        return Math.random() < 0.5;
    }

    public static int getRandomNumber(int max, int min) {
        return min + (int)(Math.random() * ((max - min) + 1));
    }
}
