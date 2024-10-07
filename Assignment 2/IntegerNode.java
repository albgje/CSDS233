/*
 * IntegerNode.java
 * This class represents a node in a singly linked list of integers.
 */
public class IntegerNode {
    // Instance variables
    private int element;
    private IntegerNode next;

    // Constructor
    public IntegerNode(int element) {
        this.element = element;
        this.next = null;
    }

    // Getters and Setters
    public int getElement() {
        return element;
    }

    public IntegerNode getNext() {
        return next;
    }

    public void setElement(int element) {
        this.element = element;
    }

    public void setNext(IntegerNode next) {
        this.next = next;
    }
}
