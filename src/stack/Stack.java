package stack;

import linkedList.LinkedList;

public class Stack<T extends Comparable<T>> {

    LinkedList<T> linkedList;

    public Stack() {
        linkedList = new LinkedList<>();
    }

    public void push(T data){
        linkedList.addToFront(data);
    }

    public T peek() {
        return linkedList.getHead().getData();
    }

    public T pop() {
        return linkedList.deleteFromFront().getData();
    }

    public boolean isEmpty(){
        return linkedList.isEmpty();
    }
}
