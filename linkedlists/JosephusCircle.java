package linkedlists;

public class JosephusCircle {

    private class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node push(int data, Node start) {
        if (start == null) {
            Node head = new Node(data);
            head.next = head;
            return head;
        } else {
            Node temp = start;
            while (temp.next != start) {
                temp = temp.next;
            }

            Node node = new Node(data);
            node.next = start;
            temp.next = node;
            return start;
        }
    }

    private int findJosephusNumber(Node start, int m) {
        Node temp = start;
        if (m == 1) {
		    while (temp.next != start) {
		        temp = temp.next;
		    }
            return temp.data;
        }

        while(temp.next != temp) {
            int count = 2;
            while(count < m) {
                temp = temp.next;
                count++;
            }
            Node nodeToDel = temp.next;
            temp.next = temp.next.next;
            temp = temp.next;
            nodeToDel.next = null;
        }
        return temp.data;
    }

    private Node addNodes(int n, JosephusCircle circle) {
        Node start = null;
        int count = 1;
        while(count <= n) {
            start = circle.push(count, start);
            count++;
        }
        return start;
    }

    private void printNodes(Node start) {
        Node temp = start.next;
        System.out.println(start.data);
        while (temp != start) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        JosephusCircle circle = new JosephusCircle();
        Node start = circle.addNodes(7, circle);
        System.out.println(circle.findJosephusNumber(start, 1));
    }
}
