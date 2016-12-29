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
    }
}