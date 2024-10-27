public class BinarySearchTree {
    // Inner class for Node
    class Node {
        // Instance Variables
        private int data;
        private Node left;
        private Node right;
    
        // Constructor
        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    // Instance Variables
    private Node root;

    // Inserts a key into the tree
    void insert(int key) {
        // If the tree is empty, create a new node
        if (root == null) {
            root = new Node(key);
        } else {
            // Traverse the tree to find the correct position
            Node current = root;
            while (true) {
                // If the key is less than the current node's data, go left
                if (key < current.data) {
                    if (current.left == null) {
                        current.left = new Node(key);
                        break;
                    } else {
                        current = current.left;
                    }
                } else {
                    // If the key is greater than or equal to the current node's data, go right
                    if (current.right == null) {
                        current.right = new Node(key);
                        break;
                    } else {
                        current = current.right;
                    }
                }
            
            }
        }
    }

    // Creates a tree from an array of keys
    void createTree(int[] keys) {
        for (int key : keys) {
            insert(key);
        }
    }

    // Searches for a key in the tree
    boolean search(int key) {
        Node current = root;
        while (true) {
            // If the current node is null, the key is not in the tree
            if (current == null) {
                return false;
            } // If the current node's data is equal to the key, the key might be in the tree
            else if (current.data == key) {
                return true;
            } // If the key is less than the current node's data, go left
            else if (key < current.data) {
                current = current.left;
            } // If the key is greater than the current node's data, go right
            else {
                current = current.right;
            }
        }
    }

    // Deletes a key from the tree
    Node delete(int key) {
        Node parent = null;
        Node current = root;
        while (true) {
            // If the current node is null, the key is not in the tree
            if (current == null) {
                return null;
            } // If the current node's data is equal to the key, the key is found
            else if (current.data == key) {
                // leaf node
                if (current.left == null && current.right == null) {
                    // tree has one node
                    if (parent == null) {
                        root = null;
                    } // its a left child
                    else if (parent.left == current) {
                        parent.left = null;
                    } // its a right child
                    else {
                        parent.right = null;
                    }
                    // return the deleted node
                    return current;
                }
                // one child node
                if ((current.left != null && current.right == null) || (current.left == null && current.right != null)) {
                    // make into root
                    if (parent == null) {
                        root = current.left;
                    } // its a left child
                    else if (parent.left == current) {
                        parent.left = current.left;
                    } // its a right child
                    else {
                        parent.right = current.left;
                    }
                    // return the deleted node
                    return current;
                }
                // two children
                if (current.left != null && current.right != null) {
                    Node successor = current.right;
                    Node successorParent = current;
                    // find the inorder successor
                    while (successor.left != null) {
                        successorParent = successor;
                        successor = successor.left;
                    }
                    // place the right subtree of the successor in the left of the successor's parent
                    if (successorParent.left == successor) {
                        successorParent.left = successor.right;
                    } else {
                        successorParent.right = successor.right;
                    }
                    // replace the current node with the successor
                    current.data = successor.data;
                }
            // If the key is less than the current node's data, go left, if greater, go right
            } else if (key < current.data) {
                parent = current;
                current = current.left;
            } else {
                parent = current;
                current = current.right;
            }
        }
    }
    
    // go all the way to the left
    int findMin() {
        Node current = root;
        while (current.left != null) {
            current = current.left;
        }
        return current.data;
    }

    // go all the way to the right
    int findMax() {
        Node current = root;
        while (current.right != null) {
            current = current.right;
        }
        return current.data;
    }

    // Height
    int height() {
        return height(root) - 1;
    }

    // Helper method for height
    int height(Node node) {
        if (node == null) {
            return 0;
        } else {
            // find the height of the left and right subtrees
            int leftHeight = height(node.left);
            int rightHeight = height(node.right);
            // return the maximum height (+ 1 for the current node)
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }

    // InOrder Traversal
    void inorderTrav() {
        inorderTrav(root);
    }

    // Helper method for InOrder Traversal
    void inorderTrav(Node node) {
        if (node != null) {
            inorderTrav(node.left);
            System.out.print(node.data + " ");
            inorderTrav(node.right);
        }
    }

    // PreOrder Traversal
    void preorderTrav() {
        preorderTrav(root);
    }

    // Helper method for PreOrder Traversal
    void preorderTrav(Node node) {
        if (node != null) {
            System.out.print(node.data + " ");
            preorderTrav(node.left);
            preorderTrav(node.right);
        }
    }

    // PostOrder Traversal
    void postorderTrav() {
        postorderTrav(root);
    }

    // Helper method for PostOrder Traversal
    void postorderTrav(Node node) {
        if (node != null) {
            postorderTrav(node.left);
            postorderTrav(node.right);
            System.out.print(node.data + " ");
        }
    }


}