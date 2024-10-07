public class Test {
    public static void main(String[] args) {
        System.out.println("Test NumLinkedList ");
        NumLinkedList list = new NumLinkedList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        NumLinkedList.printList(list);
        System.out.println("Size: " + list.size());
        System.out.println("Is sorted: " + list.isSorted());
        NumLinkedList list2 = new NumLinkedList();
        list2.add(2);
        list2.add(3);
        list2.add(5);
        list2.add(6);
        NumLinkedList mergedList = NumLinkedList.merge(list, list2);
        System.out.println("Merged list:");
        NumLinkedList.printList(mergedList);
        System.out.println("Is sorted: " + mergedList.isSorted());
        list.reverse();
        System.out.println("Reversed list:");
        NumLinkedList.printList(list);
        NumLinkedList duplicatedList = NumLinkedList.duplicate(list);
        System.out.println("Duplicated list:");
        NumLinkedList.printList(duplicatedList);
        System.out.println("--------------------------- \n\n");

        System.out.println("Test QueuedStack ");
        QueuedStack<Integer> stack = new QueuedStack<Integer>();
        System.out.println("Is empty: " + stack.empty());
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        System.out.println("Peek: " + stack.peek());
        System.out.println("Pop: " + stack.pop());
        System.out.println("Peek: " + stack.peek());
        System.out.println("Pop: " + stack.pop());
        System.out.println(stack);
        System.out.println("--------------------------- \n\n");

        System.out.println("Test StackedQueue");
        StackedQueue<Integer> queue = new StackedQueue<Integer>();
        System.out.println("Is empty: " + queue.isEmpty());
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        System.out.println("Peek: " + queue.peek());
        System.out.println("Poll: " + queue.poll());
        System.out.println("Peek: " + queue.peek());
        System.out.println("Poll: " + queue.poll());
        System.out.println(queue);
        System.out.println("--------------------------- \n\n");
    }
}
