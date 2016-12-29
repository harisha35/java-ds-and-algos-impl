package linkedlists;

public class LinkedListOperations {

    public static <Item extends Comparable<Item>> Comparable 
        getNthNodeFromEnd(LinkedList.Node head, int n) {

        if (head == null) {
            return null;
        }

        LinkedList.Node hare = head;
        LinkedList.Node tortoise = head;
        while (n > 0 && hare != null) {
            hare = hare.getNext();
            n--;
        }
        if (n > 0) {
            System.out.println("Please select a proper value for 'n'");
            return null;
        } else {
            while(hare != null) {
                hare = hare.getNext();
                tortoise = tortoise.getNext();
            }
            return tortoise.getData();
        }
    }

    public static <Item extends Comparable<Item>> Comparable 
        getMiddleElement(LinkedList.Node head) {

        if (head == null) {
            return null;
        }

        return getMiddleNode(head).getData();
    }

    private static LinkedList.Node getMiddleNode(LinkedList.Node head) {
        LinkedList.Node hare = head;
        LinkedList.Node tortoise = head;
        while(hare.getNext() != null && hare.getNext().getNext() != null) {
            hare = hare.getNext().getNext();
            tortoise = tortoise.getNext();
        }
        return tortoise;
    }

	public static LinkedList.Node splitIntoHalf(LinkedList.Node head) {
        if (head == null) {
            return null;
        }

        LinkedList.Node firstTail = getMiddleNode(head);
        LinkedList.Node secondHead = firstTail.getNext();
        firstTail.setNext(null);
        return secondHead;
    }

    public static LinkedList.Node IterativeReverseList(LinkedList.Node head) {
        if (head == null) {
            return null;
        }

        LinkedList.Node prev = null;
        LinkedList.Node curr = head;
        LinkedList.Node next = head.getNext();

        while (next != null) {
            curr.setNext(prev);
            prev = curr;
            curr = next;
            next = next.getNext();
        }
        curr.setNext(prev);
        return curr;
    }

    public static boolean isPalindrome(LinkedList.Node head) {
        LinkedList.Node head2 = splitIntoHalf(head);
        head2 = IterativeReverseList(head2);
        while(head2.getNext() != null) {
            if(!head.getData().equals(head2.getData())) {
                return false;
            }
            head = head.getNext();
            head2 = head2.getNext();
        }
        return true;
    }

    public static boolean hasCycle(LinkedList.Node head) {
        return getStartNodeOfCycle(head) != null;
    }

    public static int lengthOfCycle(LinkedList.Node head) {
        LinkedList.Node startNodeOfCycle = getStartNodeOfCycle(head);
        if (startNodeOfCycle != null) {
            int count = 1;
            LinkedList.Node temp = startNodeOfCycle.getNext();
            while (temp != startNodeOfCycle) {
                temp = temp.getNext();
                count++;
            }
            return count;
        } else {
            return 0;
        }
    }

    public static LinkedList.Node getStartNodeOfCycle(LinkedList.Node head) {
        LinkedList.Node hare = head;
        LinkedList.Node tortoise = head;
        boolean hasCycle = false;
        while(hare != null && hare.getNext() != null) {
            hare = hare.getNext().getNext();
            tortoise = tortoise.getNext();
            if (hare == tortoise) {
                hasCycle = true;
                break;
            }
        }
        if (hasCycle) {
            tortoise = head;
            while(tortoise != hare) {
                tortoise = tortoise.getNext();
                hare = hare.getNext();
            }
            return tortoise;
        } else {
            return null;
        }
    }
}