package linkedlists;

public class LinkedList<Item extends Comparable<Item>>{

    // TODO: head should be private
    public Node head;

    public LinkedList() {
        head = null;
    }

    public class Node<Item extends Comparable<Item>> {
        private Item data;
        private Node next;

        public Node(Item data) {
            this.data = data;
            this.next = null;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public Item getData() {
            return data;
        }

        public void setData(Item data) {
            this.data = data;
        }
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void insert(Item data, int position) {
        if (position == 1) {
            Node temp = new Node<Item>(data);
            temp.setNext(head);
            head = temp;
        }
        else {
            Node temp = head;
            while (position-- > 1 && temp.getNext() != null) {
                temp = temp.getNext();
            }
            if (position <= 1 && temp.getNext() == null) {
                temp.setNext(new Node<Item>(data));
            }
            else if (position <= 1){
                Node newNode = new Node<Item>(data);
                newNode.setNext(temp.getNext());
                temp.setNext(newNode);
            } else {
                System.out.println("Please select a proper value for position parameter");
            }
        }
    }

    public void insert(Item data) {
        if (isEmpty()) {
            head = new Node(data);
        } else {
            Node temp = head;
            while (temp.getNext() != null) {
                temp = temp.getNext();
            }
            temp.setNext(new Node<Item>(data));
        }
    }

    public void delete(int position) {
        // First Node
        if (position == 1) {
            if (!isEmpty()) {
                Node temp = head;
                head = head.getNext();
                temp.setNext(null);
            }
        } else {
            Node temp = head;
            while (position-- > 2 && temp.getNext() != null
                && temp.getNext().getNext() != null) {
                temp = temp.getNext();
            }
            // Nodes other than first node
            if (position <= 1) {
                Node delNode = temp.getNext();
                temp.setNext(delNode.getNext());
                delNode.setNext(null);
            }
            // Error Case: when postion vvalue is too big
            else {
                System.out.println("Please select a proper value for position parameter");
            }
        }
    }

    public void printList() {
        Node temp = head;
        System.out.println();
        System.out.println("--------- Contents of Linked List ---------");
        while (temp != null) {
            System.out.print(temp.getData() + " -> ");
            temp = temp.getNext();
        }
        System.out.print("null");
        System.out.println();
        System.out.println();
    }
}