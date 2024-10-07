// Imports
import java.util.Queue;
import java.util.LinkedList;

/*
 * QueuedStack.java
 */
public class QueuedStack<T> {
    // Instance variables
    private Queue<T> queue;

    // Constructor
    public QueuedStack() {
        queue = new LinkedList<T>();
    }

    // Pushes an element onto the stack
    public T push(T element) {
        Queue<T> queue2 = new LinkedList<T>();
        while (!queue.isEmpty()) {
            queue2.add(queue.remove());
        }
        queue.add(element);
        while (!queue2.isEmpty()) {
            queue.add(queue2.remove());
        }
        return element;
    }

    // Pops an element from the stack
    public T pop() {
        return queue.remove();
    }

    // Peeks at the top element of the stack
    public T peek() {
        return queue.peek();
    }

    // Checks if the stack is empty
    public boolean empty() {
        return queue.isEmpty();
    }
}
