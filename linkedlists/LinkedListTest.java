package linkedlists;

public class LinkedListTest {

    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<Integer>();
        list.insert(1);
        list.insert(2);
        list.insert(3);
        list.insert(4);
        list.printList();
        list.insert(0, 1);
        list.insert(6, 5);
        list.insert(5, 5);
        list.printList();
        list.delete(1);
        list.delete(2);
        list.delete(5);
        list.printList();
    }
}