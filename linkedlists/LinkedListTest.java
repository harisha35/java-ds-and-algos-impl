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
        System.out.println("Data of last node : "
            + LinkedListOperations.getNthNodeFromEnd(list.head, 1));
        System.out.println("Data of middle node : "
            + LinkedListOperations.getMiddleElement(list.head));
        System.out.println("Is list palindrome? : "
            + LinkedListOperations.isPalindrome(list.head));

        LinkedList<Integer> list2 = new LinkedList<Integer>();
        list2.insert(1);
        list2.insert(2);
        list2.insert(3);
        list2.insert(2);
        list2.insert(1);
        System.out.println("Is list palindrome? : "
            + LinkedListOperations.isPalindrome(list2.head));

        LinkedList.Node node1 = new LinkedList.Node(1);
        LinkedList.Node node2 = new LinkedList.Node(2);
        LinkedList.Node node3 = new LinkedList.Node(3);
        LinkedList.Node node4 = new LinkedList.Node(4);
        LinkedList.Node node5 = new LinkedList.Node(5);
        LinkedList.Node node6 = new LinkedList.Node(6);
        LinkedList.Node node7 = new LinkedList.Node(7);

        node1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);
        node4.setNext(node5);
        node5.setNext(node6);
        node6.setNext(node7);
        node7.setNext(node3);

        System.out.println("Does list has cycle? : "
            + LinkedListOperations.hasCycle(node1));

        System.out.println("Length Of Cylce : "
            + LinkedListOperations.lengthOfCycle(node1));
    }
}