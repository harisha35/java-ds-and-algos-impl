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

        LinkedList<Integer> list3 = new LinkedList<Integer>();
        list3.insert(5);
        list3.insert(10);
        list3.insert(15);

        LinkedList<Integer> list4 = new LinkedList<Integer>();
        list4.insert(2);
        list4.insert(3);
        list4.insert(20);

        LinkedList mergedList = LinkedListOperations.mergeTwoLists(list3.head, list4.head);
        mergedList.printList();

        LinkedList.Node n1 = new LinkedList.Node(1);
        LinkedList.Node n2 = new LinkedList.Node(2);
        LinkedList.Node n3 = new LinkedList.Node(3);
        LinkedList.Node n4 = new LinkedList.Node(4);
        LinkedList.Node n5 = new LinkedList.Node(5);
        LinkedList.Node n6 = new LinkedList.Node(6);
        LinkedList.Node n7 = new LinkedList.Node(7);
        LinkedList.Node n8 = new LinkedList.Node(33);
        LinkedList.Node n9 = new LinkedList.Node(34);
        LinkedList.Node n10 = new LinkedList.Node(35);

        n1.setNext(n2);
        n2.setNext(n3);
        n3.setNext(n4);
        n4.setNext(n5);
        n5.setNext(n6);
        n6.setNext(n7);
        n8.setNext(n9);
        n9.setNext(n10);
        n10.setNext(n4);

        LinkedList firstList = new LinkedList();
        LinkedList secondList = new LinkedList();
        firstList.head = n1;
        secondList.head = n8;

        LinkedList.Node intersection =
            LinkedListOperations.IntersectionOfTwoLists(firstList, secondList);

        if (intersection != null) {
            System.out.println("Intersection of two lists is at : " + intersection.getData());
        } else {
            System.out.println("The tw lists won't intersect with each other");
        }

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

        LinkedList<Integer> list5 = new LinkedList<Integer>();
        LinkedList<Integer> list6 = new LinkedList<Integer>();
        LinkedList<Integer> list7 = new LinkedList<Integer>();

        list5.insert(1);
        list5.insert(3);
        list5.insert(5);
        list5.insert(7);

        list6.insert(2);
        list6.insert(4);
        list6.insert(6);
        list6.insert(8);

        list7.insert(0);
        list7.insert(9);
        list7.insert(10);
        list7.insert(11);

        LinkedList[] lists = new LinkedList[3];
        lists[0] = list5;
        lists[1] = list6;
        lists[2] = list7;

        mergedList = LinkedListOperations.mergeKSortedLists(lists);
        mergedList.printList();
    }
}