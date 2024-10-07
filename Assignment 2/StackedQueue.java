import java.util.Stack;

public class StackedQueue<T> {
    // Instance variables
    private Stack<T> stack;
    private Stack<T> tempStack;

    // Constructor
    public StackedQueue() {
        stack = new Stack<T>();
        tempStack = new Stack<T>();
    }

    // Adds an element to the queue
    public boolean add(T element) {
        if (stack.empty()) {
            stack.push(element);
        } else {
            while (!stack.empty()) {
                tempStack.push(stack.pop());
            }
            stack.push(element);
            while (!tempStack.empty()) {
                stack.push(tempStack.pop());
            }
        }
        return true;
    }

    // Removes an element from the queue
    public T poll() {
        return stack.pop();
    }

    // Peeks at the front element of the queue
    public T peek() {
        return stack.peek();
    }

    // Checks if the queue is empty
    public boolean isEmpty() {
        return stack.empty();
    }
}
