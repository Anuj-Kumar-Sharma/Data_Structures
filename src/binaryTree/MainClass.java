package binaryTree;

public class MainClass {

    public static void main(String[] args) {

        BinaryTree<Integer> tree = new BinaryTree<>();
        Integer[] a = {1, 2, 3, 4, 5, 6, 7, 11, -1, 8, -1, -1, 9, -1, -1};

        /**
         *                                      TREE
         *                                       1
         *                                     /   \
         *                                    2     3
         *                                   / \   / \
         *                                  4   5 6   7
         *                                 /   /   \
         *                                11  8     9
         */

        tree.constructTreeFromLevelOrderArray(a, 0);

        tree.printLevelOrderNewLine();
        System.out.println();


        System.out.println(tree.maximumSumPathBetweenTwoLeaves(tree.getRoot()));


    }
}
