package binaryTree;

import queue.Queue;
import stack.Stack;

import java.util.*;

public class BinaryTree<T extends Comparable<T>> {

    private Node<T> root;

    public Node<T> getRoot() {
        return root;
    }

    /**
     * Method to construct the Binary tree
     *
     * @param a array of elements in level order
     * @param i index for array a
     * @return root node of the tree
     */
    public Node<T> constructTreeFromLevelOrderArray(T[] a, int i) {

        if (i >= a.length || a[i].equals(-1)) {
            return null;
        }

        Node<T> root = new Node<>(a[i]);
        root.setLeft(constructTreeFromLevelOrderArray(a, 2 * i + 1));
        root.setRight(constructTreeFromLevelOrderArray(a, 2 * i + 2));
        return this.root = root;
    }

    ////////////////////////////////////                   TRAVERSALS                 ///////////////////////////////////////

    public void printInorder(Node<T> root) {
        if (root != null) {
            printInorder(root.getLeft());
            System.out.print(root.getData() + " ");
            printInorder(root.getRight());
        }
    }

    public void printPostOrder(Node<T> root) {
        if (root != null) {
            printPostOrder(root.getLeft());
            printPostOrder(root.getRight());
            System.out.print(root.getData() + " ");
        }
    }

    public void printPreOrder(Node<T> root) {
        if (root != null) {
            System.out.print(root.getData() + " ");
            printPreOrder(root.getLeft());
            printPreOrder(root.getRight());
        }
    }

    public void printLevelOrder() {
        if (root == null) return;
        Queue<Node<T>> queue = new Queue<>();
        queue.push(root);
        while (!queue.isEmpty()) {
            Node<T> node = queue.pop();
            System.out.print(node.getData() + " ");
            if (node.getLeft() != null) queue.push(node.getLeft());
            if (node.getRight() != null) queue.push(node.getRight());
        }
    }

    public void printLevelOrderNewLine() {
        Queue<Node<T>> queue = new Queue<>();
        queue.push(root);
        queue.push(null);
        while (!queue.isEmpty()) {
            Node<T> node = queue.peek();
            queue.pop();
            if (node == null) {
                System.out.println();
                if (!queue.isEmpty()) queue.push(null);
            } else {
                System.out.print(node.getData() + " ");
                if (node.getLeft() != null) queue.push(node.getLeft());
                if (node.getRight() != null) queue.push(node.getRight());
            }
        }
    }

    public void printLevelOrderZigzag() {
        Stack<Node<T>> s1 = new Stack<>();
        Stack<Node<T>> s2 = new Stack<>();

        s1.push(root);
        while (!s1.isEmpty() || !s2.isEmpty()) {
            while (!s1.isEmpty()) {
                Node<T> node = s1.pop();
                System.out.print(node.getData() + " ");
                if (node.getRight() != null) s2.push(node.getRight());
                if (node.getLeft() != null) s2.push(node.getLeft());
            }

            while (!s2.isEmpty()) {
                Node<T> node = s2.pop();
                System.out.print(node.getData() + " ");
                if (node.getLeft() != null) s1.push(node.getLeft());
                if (node.getRight() != null) s1.push(node.getRight());
            }
        }
    }

    public void printGivenLevel(Node<T> node, int level) {
        if (node == null) return;
        if (level == 1) {
            System.out.print(node.getData() + " ");
        }

        printGivenLevel(node.getLeft(), level - 1);
        printGivenLevel(node.getRight(), level - 1);
    }

    public void printVerticalOrder() {
        Map<Integer, ArrayList<T>> map = new TreeMap<>();
        verticalOrderUtil(root, 0, map);

        for (Map.Entry<Integer, ArrayList<T>> entry : map.entrySet()) {
            ArrayList<T> a = entry.getValue();
            for (T t: a) {
                System.out.print(t+" ");
            }
            System.out.println();
        }
    }

    private void verticalOrderUtil(Node<T> node, int level, Map<Integer, ArrayList<T>> map) {
        if (node == null) return;
        ArrayList<T> arrayList = map.get(level);
        if (arrayList == null) arrayList = new ArrayList<>();
        arrayList.add(node.getData());
        map.put(level, arrayList);

        verticalOrderUtil(node.getLeft(), level-1, map);
        verticalOrderUtil(node.getRight(), level+1, map);
    }

    private class MaxLevel{
        int ml;
        public MaxLevel(int ml) {
            this.ml = ml;
        }
    }

    public void printRightView() {
        printRightViewUtil(root, 0, new MaxLevel(-1));
    }

    public void printRightViewUtil(Node<T> node, int cl, MaxLevel maxLevel) {
        if (node == null) return;
        if (cl > maxLevel.ml) {
            System.out.print(node.getData()+" ");
            maxLevel.ml = cl;
        }
        printRightViewUtil(node.getRight(), cl+1, maxLevel);
        printRightViewUtil(node.getLeft(), cl+1, maxLevel);
    }

    public void printTopView() {
        Map<Integer, T> map = new TreeMap<>();
        printTopViewUtil(root, 0, map);
        for (Map.Entry<Integer, T> entry: map.entrySet()) {
            System.out.print(entry.getValue()+" ");
        }
    }

    public void printTopViewUtil(Node<T> node, int level, Map<Integer, T> map) {
        if (node == null) return;
        if (!map.containsKey(level)) {
            map.put(level, node.getData());
        }

        printTopViewUtil(node.getLeft(), level-1, map);
        printTopViewUtil(node.getRight(), level+1, map);
    }

    public void printDiagonalView() {
        Map<Integer, ArrayList<T>> map = new TreeMap<>();
        printDiagonalUtil(root, 0, 0, map);

        for (Map.Entry<Integer, ArrayList<T>> entry : map.entrySet()) {
            ArrayList<T> a = entry.getValue();
            for (T t: a) {
                System.out.print(t+" ");
            }
            System.out.println();
        }
    }

    public void printDiagonalUtil(Node<T> node, int x, int y, Map<Integer, ArrayList<T>> map) {
        if (node == null) return;
        int key = x-y;
        ArrayList<T> arrayList = map.get(key);
        if (arrayList == null) arrayList = new ArrayList<>();
        arrayList.add(node.getData());
        map.put(key, arrayList);

        printDiagonalUtil(node.getLeft(), x-1, y+1, map);
        printDiagonalUtil(node.getRight(), x+1, y+1, map);
    }

    ////////////////////////////////////                   MISCELLANEOUS               ///////////////////////////////////////


}
