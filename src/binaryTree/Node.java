package binaryTree;

public class Node<T extends Comparable<T>> implements Comparable<Node<T>>{

    private T data;
    private Node<T> left, right;

    public Node(T data) {
        this.data = data;
        left = right = null;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Node<T> getLeft() {
        return left;
    }

    public void setLeft(Node<T> left) {
        this.left = left;
    }

    public Node<T> getRight() {
        return right;
    }

    public void setRight(Node<T> right) {
        this.right = right;
    }

    @Override
    public int compareTo(Node<T> o) {
        return this.data.compareTo(o.data);
    }
}
