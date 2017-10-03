package linkedList;

public class MainClass {

    public static void main(String[] args) {

        LinkedList<Integer> linkedList = new LinkedList<>();

        linkedList.addToFront(2);
        linkedList.addToLast(5);
        linkedList.addToLast(7);
        linkedList.addToLast(5);
        Node temp = linkedList.addToLast(7);
        linkedList.addToFront(10);
        linkedList.addToLast(3);
        linkedList.addToFront(3);
        linkedList.addToLast(7);
        /*Node last = linkedList.addToLast(1);
        last.setNext(temp);*/

 /*       System.out.println(last.getNext()==(temp));

        Node intersection = linkedList.findIntersectionHash();
        System.out.println(intersection.getData());
*/
        linkedList.print();

        LinkedList<Integer> sum = getSum(linkedList, linkedList);
        sum.print();

    }

    public static LinkedList<Integer> getSum(LinkedList<Integer> a, LinkedList<Integer> b) {

        int la = a.getLength();
        int lb = b.getLength();
        LinkedList<Integer> c = new LinkedList<>(a);
        if(la == lb) {

            getSum(a.getHead(), b.getHead(), c.getHead());

        } else {

        }
        return c;
    }

    static int carry = 0;
    public static void getSum(Node<Integer> a, Node<Integer> b, Node<Integer> c) {
        if(a == null) {
            return;
        }

        getSum(a.getNext(), b.getNext(), c.getNext());

        int sum = a.getData() + b.getData() + carry;
        sum = sum%10;
        carry = sum/10;
        c.setData(sum);
    }
}
