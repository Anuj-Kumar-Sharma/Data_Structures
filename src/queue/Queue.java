package queue;

import linkedList.LinkedList;

public class Queue<T extends Comparable<T>> {

    LinkedList<T> linkedList;

    public Queue() {
        linkedList = new LinkedList<>();
    }

    public void push(T data){
        linkedList.addToLast(data);
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
