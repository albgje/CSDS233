public class BinarySearchTreeMain {
    public static void main(String[] args) {
        // test inserting nodes and traversals
        System.out.println("Test Inserting nodes and traversals: \n");
        System.out.println("tree1: ");
        BinarySearchTree tree = new BinarySearchTree();
        tree.insert(4);
        tree.insert(2);
        tree.insert(5);
        tree.insert(6);
        tree.insert(1);
        tree.insert(3);
        System.out.println("Inorder: ");
        tree.inorderTrav();
        System.out.println();
        System.out.println("Preorder: ");
        tree.preorderTrav();
        System.out.println();
        System.out.println("Postorder: ");
        tree.postorderTrav();
        System.out.println();

        // test create tree 
        System.out.println("\nTest create tree: ");
        System.out.println("tree2: ");
        BinarySearchTree tree2 = new BinarySearchTree();
        tree2.createTree(new int[] {5,4,6,3,7,2,8,1,9});
        tree2.inorderTrav();
        System.out.println();
        tree2.preorderTrav();
        System.out.println();
        tree2.postorderTrav();
        System.out.println();

        // test search
        System.out.println("\nTest search: ");
        System.out.println("5 in tree2: " + tree2.search(5));
        System.out.println("9 in tree2: " + tree2.search(9));
        System.out.println("10 in tree2: " + tree2.search(10));
        System.out.println("20 in tree2: " + tree2.search(10));
        System.out.println();

        // test delete
        System.out.println("Test delete: ");
        System.out.println("Before deleting 5: ");
        tree2.inorderTrav();
        System.out.println();
        tree2.delete(5);
        System.out.println("After deleting 5: ");
        tree2.inorderTrav();
        System.out.println();
        System.out.println("Before deleting 6: ");
        tree2.inorderTrav();
        System.out.println();
        tree2.delete(6);
        System.out.println("After deleting 6: ");
        tree2.inorderTrav();
        System.out.println();

        // test find min/max
        System.out.println("\nTest find min/max: ");
        System.out.println("Min: " + tree2.findMin());
        System.out.println("Max: " + tree2.findMax());
        System.out.println();

        // test height
        System.out.println("\nTest height: ");
        System.out.println("Height: " + tree2.height());
    }
}
