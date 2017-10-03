package binaryTree;

public class BinaryTree<T extends Comparable<T>> {

    Node<T> root;

    public BinaryTree(Node<T> root){
        this.root = root;
    }

    public Node<T> constructTreeFromLevelOrderArray(T[] a) {
        root = new Node<>(a[0]);

        for (int i = 0; i < a.length/2-1; i++) {
            Node<T> leftNode = new Node<>(a[2*i+1]);
            Node<T> rightNode = new Node<>(a[2*i+2]);

            root.setLeft(leftNode);
            root.setRight(rightNode);
        }

        return root;
    }



}
