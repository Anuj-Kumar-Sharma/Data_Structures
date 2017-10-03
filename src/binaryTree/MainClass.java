package binaryTree;

import linkedList.Node;
import queue.Queue;
import stack.Stack;

public class MainClass {

    public static void main(String[] args) {

        Stack<Node<Integer>> q = new Stack<>();
        /*q.push(null);
        q.push(null);*/
        q.push(new Node<>(45));
        q.push(new Node<>(5));
        q.push(new Node<>(15));
        q.push(new Node<>(25));

        System.out.println(q.peek().getData().getData());

        while (!q.isEmpty()) {
            System.out.println(q.pop().getData().getData());
        }


    }
}
