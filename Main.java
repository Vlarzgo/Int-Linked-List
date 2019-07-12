package Task4;

public class Main {
    public static void main(String[] args) {

        IntList myList = new IntLinkedList();

        myList.add(0);
        myList.add(1);
        myList.add(2);
        myList.add(3);
        myList.add(4);
        System.out.println("Add \n" + myList);

        myList.add(3, 55);
        System.out.println("Add 55 at index 3 \n" + myList);

        myList.clear();
        System.out.println("Clear \n" + myList);

        System.out.println("Is Empty\n" + myList.isEmpty());

        myList.add(7);
        myList.add(7);
        myList.add(7);
        myList.add(7);
        myList.add(7);
        myList.add(6);
        myList.add(5);
        myList.add(8);
        myList.add(7);
        myList.add(7);
        myList.add(5);
        myList.add(1);
        myList.add(7);
        myList.add(9);

        System.out.println("New Arr\n" + myList);

        System.out.println("Sub List from 4 to 12\n" + myList.subList(4, 12));

        myList.set(4, 55);
        System.out.println("Set 55 at index 4\n" + myList);

        myList.removeByValue(13);
        System.out.println("Remove by value 5\n" + myList);

        myList.remove(4);
        System.out.println("Remove 4\n" + myList);

        System.out.println("Get 4\n" + myList.get(4));

        System.out.println("Size\n" + myList.size());

        IntStack myStack = new IntLinkedList();
        myStack.push(1);
        myStack.push(2);
        myStack.push(3);
        myStack.push(4);

        System.out.println("MyStack \n" + myStack);

        System.out.println("Peek of myStack \n" + myStack.peek());

        System.out.println("Pop of myStack \n" + myStack.pop() + "\nAnd Stack \n" + myStack);

        IntQueue myQueue = new IntLinkedList();
        myQueue.add(1);
        myQueue.add(2);
        myQueue.add(3);
        myQueue.add(4);

        System.out.println("MyQueue \n" + myQueue);

        System.out.println("Remove in Queue\n" + myQueue.remove() + "\nAnd Queue \n" + myQueue);

        System.out.println("Element in Queue\n" + myQueue.element());
    }
}
