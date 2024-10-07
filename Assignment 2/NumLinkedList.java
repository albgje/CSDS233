/*
 * NumLinkedList.java
 * This class represents a singly linked list of integers.
 * It has methods to add an element to the list, check if the list is sorted,
 * reverse the list, merge two lists, and duplicate a list.
 * It also has a method to get the size of the list.
 * The list is represented by a head node.
 * Each node contains an integer element and a reference to the next node in the list. 
 */
public class NumLinkedList {
    // Instance variables
    private int size;
    private IntegerNode head;

    
    // Constructor
    public NumLinkedList() {
        this.size = 0;
        this.head = null;
    }
    
    // Returns the size of the linked list
    public int size() {
        return size;
    }

    // Adds an element to the linked list
    public void add(int element) {
        IntegerNode newNode = new IntegerNode(element);

        if (head == null) {
            head = newNode;
        } else {
            IntegerNode current = head;

            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(newNode);
        }
        size++;
    }

    // Checks if the linked list is sorted
    public boolean isSorted() {
        if (head == null || size == 1) {
            return true;
        }

        IntegerNode current = head;

        while (current.getNext() != null) {
            if (current.getElement() > current.getNext().getElement()) {
                return false;
            }
            current = current.getNext();
        }
        return true;
    }

    // Reverses the linked list
    public void reverse() {
        if (head == null || size == 1) {
            return;
        }

        IntegerNode prev = null;
        IntegerNode current = head;
        IntegerNode next = null;

        while (current != null) {
            next = current.getNext();
            current.setNext(prev);
            prev = current;
            current = next;
        }
        head = prev;
    }

    // Merges two linked lists and maintains the sorted order
    public static NumLinkedList merge(NumLinkedList list1, NumLinkedList list2) {
        NumLinkedList mergedList = new NumLinkedList();

        IntegerNode current1 = list1.head;
        IntegerNode current2 = list2.head;

        while (current1 != null && current2 != null) {
            if (current1.getElement() < current2.getElement()) {
                mergedList.add(current1.getElement());
                current1 = current1.getNext();
            } else {
                mergedList.add(current2.getElement());
                current2 = current2.getNext();
            }
        }

        while (current1 != null) {
            mergedList.add(current1.getElement());
            current1 = current1.getNext();
        }

        while (current2 != null) {
            mergedList.add(current2.getElement());
            current2 = current2.getNext();
        }

        return mergedList;
    }

    // Duplicates a linked list
    public static NumLinkedList duplicate(NumLinkedList list) {
        NumLinkedList duplicatedList = new NumLinkedList();
        
        IntegerNode current = list.head;

        while (current != null) {
            duplicatedList.add(current.getElement());
            current = current.getNext();
        }

        return duplicatedList;
    }
    
    // Print the linked list
    public static void printList(NumLinkedList list) {
        IntegerNode current = list.head;
        while (current != null) {
            System.out.print(current.getElement() + " ");
            current = current.getNext();
        }
        System.out.println();
    }
}
