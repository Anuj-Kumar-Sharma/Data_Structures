package linkedList;

public class Node<T extends Comparable<T>> implements Comparable<Node<T>> {
    private Node next;
    private T data;


    public Node() {
    }

    public Node(T data) {
        this.data = data;
        next = null;
    }

    public Node<T> getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public int compareTo(Node<T> o) {
        return this.data.compareTo(o.data);
    }
}