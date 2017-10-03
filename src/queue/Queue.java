package queue;

import linkedList.LinkedList;
import linkedList.Node;

public class Queue<T extends Comparable<T>> {

    LinkedList<T> linkedList;

    public Queue() {
        linkedList = new LinkedList<>();
    }

    public void push(T data){
        linkedList.addToLast(data);
    }

    public Node<T> peek() {
        return linkedList.getHead();
    }

    public Node<T> pop() {
        return linkedList.deleteFromFront();
    }

    public boolean isEmpty(){
        return linkedList.isEmpty();
    }
}
