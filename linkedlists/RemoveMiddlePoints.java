package linkedlists;

public class RemoveMiddlePoints {

    private class Node {
        int x;
        int y;
        Node next;

        Node(int x, int y) {
            this.x = x;
            this.y = y;
            this.next = null;
        }
    }

    public Node insert(int x, int y, Node head) {
        if (head == null) {
            return new Node(x, y);
        }

        while(head.next != null) {
            head = head.next;
        }

        head.next = new Node(x, y);
        return head.next;
    }

    public void printList(Node head) {
        while(head != null) {
            System.out.print("(" + head.x + " , " + head.y + ") -> ");
            head = head.next;
        }
        System.out.print("null");
        System.out.println();
    }

    public void removeDuplicates(Node head) {
        if (head == null || head.next == null || head.next.next == null) {
            return;
        }

        Node start = head;
        Node temp1 = head.next;
        Node temp2 = temp1.next;

        if (start.x == temp1.x) {
            while (temp2 != null && temp1.x == temp2.x) {
                start.next = temp2;
                temp1.next = null;
                temp1 = temp2;
                temp2 = temp2.next;
            }
        }

        if (start.y == temp1.y) {
            while (temp2 != null && temp1.y == temp2.y) {
                start.next = temp2;
                temp1.next = null;
                temp1 = temp2;
                temp2 = temp2.next;
            }
        }

        removeDuplicates(temp1);
    }

    public static void main(String[] args) {

        RemoveMiddlePoints list = new RemoveMiddlePoints();
        Node head = list.insert(0, 10, null);
        list.insert(1, 10, head);
        list.insert(5, 10, head);
        list.insert(7, 10, head);
        list.insert(7, 5, head);
        list.insert(20, 5, head);
        list.insert(40, 5, head);

        list.printList(head);

        list.removeDuplicates(head);

        list.printList(head);

        RemoveMiddlePoints list2 = new RemoveMiddlePoints();
        Node head2 = list2.insert(2, 3, null);
        list2.insert(4, 3, head2);
        list2.insert(6, 3, head2);
        list2.insert(10, 3, head2);
        list2.insert(12, 3, head2);

        list2.printList(head2);

        list2.removeDuplicates(head2);

        list2.printList(head2);
    }
}
