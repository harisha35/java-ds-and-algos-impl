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

    public static void RecursiveReverseList(LinkedList list) {
        LinkedList.Node temp = ReverseListRecursively(list, list.head);
        if (temp != null) {
            temp.setNext(null);
        }
    }

    private static LinkedList.Node ReverseListRecursively(LinkedList list, LinkedList.Node start) {
        if (start.getNext() == null) {
            list.head = start;
            return start;
        } else {
            LinkedList.Node temp = ReverseListRecursively(list, start.getNext());
            temp.setNext(start);
            return start;
        }
    }

    public static LinkedList.Node pairwiseSwapIterative(LinkedList.Node head) {
        if (head == null) {
            return null;
        }

        if (head.getNext() == null) {
            return head;
        }

        LinkedList.Node prev = head;
        LinkedList.Node curr = head.getNext();
        head = curr;

        while (true) {
            LinkedList.Node next = curr.getNext();
            curr.setNext(prev);

            if (next == null || next.getNext() == null) {
                prev.setNext(next);
                break;
            }

            prev.setNext(next.getNext());
            prev = next;
            curr = next.getNext();
        }

        return head;
    }

    public static LinkedList.Node pairwiseSwapRecursive(LinkedList.Node head) {
        if (head == null) {
            return null;
        }

        if (head.getNext() == null) {
            return head;
        }

        LinkedList.Node next = head.getNext();
        LinkedList.Node temp = next.getNext();
        next.setNext(head);
        head.setNext(pairwiseSwapRecursive(temp));
        return next;
    }

    /* Merging two linked lists using three pointers and a boolean variable, with runtime O(n+m) */
    public static LinkedList mergeTwoLists(LinkedList.Node head1, LinkedList.Node head2) {
        LinkedList.Node first = head1.getData().compareTo(head2.getData()) < 0 ? head1 : head2;
        LinkedList.Node second = first == head1 ? head2 : head1;
        boolean isFirstHead = first == head1 ? true : false;
        LinkedList.Node mergedList = first;
        first = first.getNext();
        while ( first != null && second != null) {
            if(first.getData().compareTo(second.getData()) < 0) {
                mergedList.setNext(first);
                mergedList = first;
                first = first.getNext();
            } else {
                mergedList.setNext(second);
                mergedList = second;
                second = second.getNext();
            }
        }
        while(first != null) {
            mergedList.setNext(first);
            mergedList = first;
            first = first.getNext();
        }

        while(second != null) {
            mergedList.setNext(second);
            mergedList = second;
            second = second.getNext();
        }

        LinkedList list = new LinkedList();
        if (isFirstHead) {
            list.head = head1;
        } else {
            list.head = head2;
        }
        return list;
    }

    public static LinkedList mergeKSortedLists(LinkedList[] lists) {
        int last = lists.length - 1;
        int i, j;
        while (last != 0) {
            i = 0;
            j = last;
            while (i < j) {
                lists[i] = mergeTwoLists(lists[i].head, lists[j].head);
                i++;
                j--;
                if (i >= j) {
                    last = j;
                }
            }
        }
        return lists[0];
    }

    public static LinkedList.Node IntersectionOfTwoLists(LinkedList list1, LinkedList list2) {
        int length1 = list1.getLength();
        int length2 = list2.getLength();
        int diff = length1 - length2 > 0 ? length1 - length2 : length2 - length1;
        LinkedList.Node first = list1.head;
        LinkedList.Node second = list2.head;

        if(length1 < length2) {
            while(diff > 0) {
                second = second.getNext();
                diff--;
            }
        } else {
            while(diff > 0) {
                first = first.getNext();
                diff--;
            }
        }
        while(first != null) {
            if(second != first) {
                second = second.getNext();
                first = first.getNext();
            } else {
                return first;
            }
        }
        return null;
    }

	public static LinkedList.Node reverseListInPairsIterative(LinkedList.Node head) {
		if (head == null) {
			return null;
		}
		if (head.getNext() == null) {
			return head;
		}
		LinkedList.Node newHead = head.getNext();
		LinkedList.Node temp = null;
		while (head != null && head.getNext() != null) {
			temp = head.getNext();
			head.setNext(head.getNext().getNext());
			temp.setNext(head);
			head = head.getNext();
		}
		return newHead;
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
