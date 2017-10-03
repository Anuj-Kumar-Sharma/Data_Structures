package stack;

import linkedList.LinkedList;
import linkedList.Node;

public class Stack<T extends Comparable<T>> {

    LinkedList<T> linkedList;

    public Stack() {
        linkedList = new LinkedList<>();
    }

    public void push(T data){
        linkedList.addToFront(data);
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
