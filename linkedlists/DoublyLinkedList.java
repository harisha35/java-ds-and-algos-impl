package linkedlists;

public class DoublyLinkedList<Item extends Comparable<Item>>{

    // TODO: head should be private
    public Node head;

    public DoublyLinkedList() {
        head = null;
    }

    public static class Node<Item extends Comparable<Item>> {
        private Item data;
        private Node next;
        private Node previous;

        public Node(Item data) {
            this.data = data;
            this.next = null;
            this.previous = null;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public Node getPrevious() {
            return previous;
        }

        public void setPrevious(Node previous) {
            this.previous = previous;
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
            head.setPrevious(temp);
            head = temp;
        }
        else {
            Node temp = head;
            while (position-- > 1 && temp.getNext() != null) {
                temp = temp.getNext();
            }
            if (position <= 1 && temp.getNext() == null) {
                Node node = new Node<Item>(data);
                temp.setNext(node);
                node.setPrevious(temp);
            }
            else if (position <= 1){
                Node newNode = new Node<Item>(data);
                newNode.setNext(temp.getNext());
                newNode.setPrevious(temp);
                temp.getNext().setPrevious(newNode);
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
            Node node = new Node<Item>(data);
            temp.setNext(node);
            node.setPrevious(temp);
        }
    }

    public void delete(int position) {
        // First Node
        if (position == 1) {
            if (!isEmpty()) {
                Node temp = head;
                head = head.getNext();
                temp.setNext(null);
                head.setPrevious(null);
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
                if (delNode.getNext() != null) {
                    delNode.getNext().setPrevious(temp);
                }
                delNode.setNext(null);
                delNode.setPrevious(null);
            }
            // Error Case: when postion value is too big
            else {
                System.out.println("Please select a proper value for position parameter");
            }
        }
    }

    public int getLength() {
        Node temp = head;
        int length = 0;
        while(temp != null) {
            length++;
            temp = temp.getNext();
        }
        return length;
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