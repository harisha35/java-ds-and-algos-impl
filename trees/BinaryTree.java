public class BinaryTree<T> {

    // TODO: root node should be private
    public Node<T> root;

    public static class Node<T> {
        public T data;
        public Node<T> leftChild;
        public Node<T> rightChild;
    }

    public BinaryTree(T data) {
        root = new Node<T>();
        root.data = data;
        root.leftChild = null;
        root.rightChild = null;
    }
}
