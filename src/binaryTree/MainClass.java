package binaryTree;

public class MainClass {

    public static void main(String[] args) {

        BinaryTree<Integer> tree = new BinaryTree<>();
        Integer[] a = {1, 2, 3, 4, 5, 6, -1, 11, -1, 8, -1, -1, 9, -1, -1};

        /**
         *                                      TREE
         *                                       1
         *                                     /   \
         *                                    2     3
         *                                   / \   /
         *                                  4   5 6
         *                                 /   /   \
         *                                11  8     9
         *
         */


        tree.constructTreeFromLevelOrderArray(a, 0);


        /*
        tree.printLevelOrder();
        System.out.println();*/

        tree.printLevelOrderNewLine();
        System.out.println();
//        tree.printLevelOrderZigzag();

//        System.out.println();

//        tree.printGivenLevel(tree.getRoot(), 4);
//        System.out.println();
//        tree.printVerticalOrder();
        System.out.println();
//        tree.printRightView();

        System.out.println();
//        tree.printTopView();

        tree.printDiagonalView();
    }
}
