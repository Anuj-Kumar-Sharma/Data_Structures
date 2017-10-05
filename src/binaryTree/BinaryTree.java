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

    public void printAllRootToLeafPaths() {
        ArrayList<T> list = new ArrayList<>();
        printAllRootToLeafPathsUtil(root, list, 0);
    }

    public void printArrayList(ArrayList<T> list, int s, int e) {
        for (int i = s; i<e; i++) {
            System.out.print(list.get(i)+" ");
        }
        System.out.println();
    }

    public void printAllRootToLeafPathsUtil(Node<T> node, ArrayList<T> list, int i) {
        if (node == null) return;

        if (i < list.size()) list.set(i, node.getData());
        else list.add(i, node.getData());

        if (isLeafNode(node)) {
            printArrayList(list, 0, i+1);
            return;
        }

        printAllRootToLeafPathsUtil(node.getLeft(), list, i+1);
        printAllRootToLeafPathsUtil(node.getRight(), list, i+1);
    }

    ////////////////////////////////////                   MISCELLANEOUS               ///////////////////////////////////////

    public boolean isLeafNode(Node<T> node) {
        return node.getLeft() == null && node.getRight() == null;
    }

    public int getMaximumDepth(Node<T> node) {
        if (node == null) return 0;
        return Math.max(getMaximumDepth(node.getLeft()), getMaximumDepth(node.getRight())) + 1;
    }

    public int getSize(Node<T> node) {
        if (node == null) return 0;
        return getSize(node.getLeft())+ getSize(node.getRight()) + 1;
    }

    public boolean getPathSum(Node<Integer> node, int sum) {
        if (node == null) return false;
        if (isLeafNode((Node<T>) node) && node.getData() == sum) {
            System.out.print(node.getData()+" ");
            return true;
        }

        if(getPathSum(node.getLeft(), sum-node.getData()) || getPathSum(node.getRight(), sum-node.getData())) {
            System.out.print(node.getData() + " ");
            return true;
        }

        return false;
    }

    public boolean isHeightBalanced(Node<T> node) {
        if (node == null) return true;

        int leftHeight = getMaximumDepth(node.getLeft());
        int rightHeight = getMaximumDepth(node.getRight());

        if (Math.abs(leftHeight-rightHeight) <= 1) {
            return isHeightBalanced(node.getLeft()) && isHeightBalanced(node.getRight());
        }
        return false;
    }

    public int getDiameter(Node<T> node) {
        if (node == null) return 0;

        int leftHeight = getMaximumDepth(node.getLeft());
        int rightHeight = getMaximumDepth(node.getRight());

        int diameter = leftHeight+rightHeight+1;
        return Math.max(diameter, Math.max(getDiameter(node.getLeft()), getDiameter(node.getRight())));
    }

    public int getChildrenSumTree(Node<Integer> node) {
        if (node == null) return 0;
        if (isLeafNode((Node<T>) node)) return node.getData();

        int sumData = getChildrenSumTree(node.getLeft()) + getChildrenSumTree(node.getRight());
        node.setData(sumData);
        return sumData;
    }

    public int getLeafNodesCount(Node<T> node) {
        if (node == null) return 0;
        if (isLeafNode(node)) return 1;

        return getLeafNodesCount(node.getRight()) + getLeafNodesCount(node.getLeft());
    }

    public Node<T> getLowestCommonAncestor(Node<T> node, T d1, T d2) {
        if (node == null) return null;

        if (node.getData().equals(d1) || node.getData().equals(d2)) return node;

        Node<T> left = getLowestCommonAncestor(node.getLeft(), d1, d2);
        Node<T> right = getLowestCommonAncestor(node.getRight(), d1, d2);

        if (left == null && right == null) return null;

        if (left != null && right != null) return node;

        if (left != null) return left;

        return right;
    }

    public ArrayList<T> getAllAncestors(T d) {
        ArrayList<T> list = new ArrayList<>();
        getAllAncestorsUtil(root, d, list);
        return list;
    }

    public boolean getAllAncestorsUtil(Node<T> node, T d, ArrayList<T> list) {
        if (node == null) return false;

        if (node.getData().equals(d)) {
            list.add(node.getData());
            return true;
        }

        if (getAllAncestorsUtil(node.getLeft(), d, list) || getAllAncestorsUtil(node.getRight(), d, list)) {
            list.add(node.getData());
            return true;
        }
        return false;
    }

    public boolean areMirrorImageStructures(Node<T> n1, Node<T> n2) {
        if (n1 == null && n2 == null) return true;
        if (n1 == null || n2 == null) return false;

        return areMirrorImageStructures(n1.getLeft(), n2.getRight()) && areMirrorImageStructures(n1.getRight(), n2.getLeft());
    }

    public boolean isFoldable(Node<T> node) {
        return node == null || areMirrorImageStructures(node.getLeft(), node.getRight());
    }

    public int getMaximumWidth() {
        Map<Integer, Integer> map = new HashMap<>();

        maximumWidthUtil(root, map, 0);

        int max = -1;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if(entry.getValue() > max) max = entry.getValue();
        }
        return max;
    }

    public void maximumWidthUtil(Node<T> node, Map<Integer, Integer> map, int level) {
        if (node == null) return;

        if(map.containsKey(level)) map.put(level, map.get(level)+1);
        else map.put(level, 1);

        maximumWidthUtil(node.getLeft(), map, level+1);
        maximumWidthUtil(node.getRight(), map, level+1);
    }

    public int getMaximumSumPathRootToLeaf(Node<Integer> node) {
        if (node == null) return 0;
        if (isLeafNode((Node<T>) node)) return node.getData();

        return Math.max(getMaximumSumPathRootToLeaf(node.getLeft()), getMaximumSumPathRootToLeaf(node.getRight())) + node.getData();
    }

    /**
     * removes the nodes from the tree that are not in the path(root to leaf) where the sum is greater than 'sum'
     */
    public Node<Integer> removeNodesNodeInPath(Node<Integer> node, int sum) {
        if (node == null) return null;
        if (isLeafNode((Node<T>) node)) {
            if (node.getData() < sum) return null;
            else return node;
        }

        Node<Integer> left = removeNodesNodeInPath(node.getLeft(), sum-node.getData());
        Node<Integer> right = removeNodesNodeInPath(node.getRight(), sum-node.getData());

        node.setLeft(left);
        node.setRight(right);

        if (left == null && right == null) return null;
        return node;
    }

    public int distanceFromRoot(Node<T> node, T d1) {
        if (node == null) return 0;
        if (node.getData().equals(d1)) return 1;

        int dis = -1;
        int leftDis = distanceFromRoot(node.getLeft(), d1);
        int rightDis = distanceFromRoot(node.getRight(), d1);

        if(leftDis > 0) dis =  leftDis+1;
        if (rightDis > 0) dis =  rightDis+1;

        return dis;
    }

    public int distanceBetweenTwoNodes(T d1, T d2) {
        int ld1 = distanceFromRoot(root, d1);
        int ld2 = distanceFromRoot(root, d2);

        Node<T> lca = getLowestCommonAncestor(root, d1, d2);
        int llca = distanceFromRoot(root, lca.getData());

        return ld1+ld2-2*llca;
    }

    public int maximumSumDistanceFromRootToLeaf(Node<Integer> node) {
        if (node == null) return 0;
        if (isLeafNode((Node<T>) node)) return node.getData();

        int leftSum = maximumSumDistanceFromRootToLeaf(node.getLeft());
        int rightSum = maximumSumDistanceFromRootToLeaf(node.getRight());

        return Math.max(leftSum, rightSum)+node.getData();
    }

    public int maximumSumPathBetweenTwoLeaves(Node<Integer> node) {
        if (node == null) return 0;

        int leftPathSum = maximumSumDistanceFromRootToLeaf(node.getLeft());
        int rightPathSum = maximumSumDistanceFromRootToLeaf(node.getRight());

        int totalSum = leftPathSum+rightPathSum+node.getData();

        return Math.max(totalSum, Math.max(maximumSumPathBetweenTwoLeaves(node.getLeft()), maximumSumPathBetweenTwoLeaves(node.getRight())));
    }
}
