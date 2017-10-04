package linkedList;

import java.util.HashSet;

import java.util.Set;

public class LinkedList<T extends Comparable<T>> {

    private Node<T> head, tail;
    private int length;

    public LinkedList() {
        head = null;
        length = 0;
    }

    public LinkedList(LinkedList linkedList) {
        head = linkedList.head;
        tail = linkedList.tail;
        length = linkedList.getLength();
    }

    public int getLength() {
        return length;
    }

    public Node<T> getHead() {
        return head;
    }

    public void print() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.getData());
            if (temp.getNext() != null) System.out.print(" -> ");
            temp = temp.getNext();
        }
        System.out.println();
    }

    public Node<T> addToLast(T data) {
        Node<T> newNode = new Node<>(data);
        if (head == null) {
            head = tail = newNode;
        } else {
            tail.setNext(newNode);
            tail = tail.getNext();
        }
        return newNode;
    }

    public Node<T> addToFront(T data) {
        Node<T> newNode = new Node<>(data);
        newNode.setNext(head);
        head = newNode;
        length++;
        return newNode;
    }

    public Node<T> deleteFromFront() {
        if(head == null) return null;
        Node<T> temp = head;
        head = head.getNext();
        return temp;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void bubbleSort() {
        int tempLen = length;

        while (tempLen-- != 0) {

            Node<T> cur = head, pre = null, nex = cur.getNext();

            while (nex != null) {
                if (pre == null) {
                    if (cur.getData().compareTo(nex.getData()) > 0) {
                        cur.setNext(nex.getNext());
                        nex.setNext(cur);
                        head = nex;

                        pre = nex;
                        nex = cur.getNext();
                    } else {
                        pre = cur;
                        cur = nex;
                        nex = nex.getNext();
                    }
                } else {
                    if (cur.getData().compareTo(nex.getData()) > 0) {

                        cur.setNext(nex.getNext());
                        nex.setNext(cur);
                        pre.setNext(nex);

                        pre = nex;
                        nex = cur.getNext();
                    } else {
                        pre = cur;
                        cur = nex;
                        nex = nex.getNext();
                    }
                }
            }
        }
    }

    public Node<T> reverse(Node node) {
        Node<T> next = node.getNext();
        if (next == null) return node;

        Node tempNode = reverse(next);
        node.getNext().setNext(node);
        node.setNext(null);

        return head = tempNode;
    }

    /**
     * Floyd cycle Detection
     *
     * @return Node at intersection
     */
    public Node<T> findIntersectionFCD() {
        Node<T> slow = head, fast = head;

        do {
            slow = slow.getNext();
            fast = fast.getNext().getNext();
        } while ((slow != null && fast != null && fast.getNext() != null) && slow != fast);

        if (slow == null || fast == null || fast.getNext() == null) {
            return head;
        }

        slow = head;
        while (slow != fast) {
            slow = slow.getNext();
            fast = fast.getNext();
        }

        return slow;
    }

    public Node<T> findIntersectionHash() {

        Node<T> cur = head;
        Set<Node<T>> set = new HashSet<>();
        while (cur != null) {
            if(set.contains(cur)) return cur;
            set.add(cur);
            cur = cur.getNext();
        }
        return null;
    }



}

