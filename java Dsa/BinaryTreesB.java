// // Building a binary tree using preorder sequence 

// import java.util.*; //***** O(n)

// public class BinaryTreesB {
//     public static class Node {
//         int data;
//         Node left;
//         Node right; 

//         Node(int data){
//             this.data = data;
//             this.left = null;
//             this.right = null;
//         }
//     }

//     public static class BinaryTree {
//         static int idx = -1;
//         public static Node buildTree(int nodes[]){
//             idx++;
//             if (idx >= nodes.length || nodes[idx] == -1) {
//                 return null;
//             }
//             Node newNode = new Node(nodes[idx]);
//             newNode.left = buildTree(nodes);
//             newNode.right = buildTree(nodes);

//             return newNode;
//         }

//         // Preorder Traversal
//         public static void preOrder(Node root){ // ***** O(n)
//             if (root == null) {
//                 return;
//             }
//             preOrder(root.left);
//             System.out.print(root.data + " ");
//             preOrder(root.right);
//         }

//         // PostOrder Treaversal
//         public static void postOrder(Node root){
//             if (root == null) {
//                 return;
//             }
//             postOrder(root.left);
//             postOrder(root.right);
//             System.out.print(root.data + " ");
//         }

//         // Level Order Traversal
//         public static void levelOrder(Node root){
//             if(root == null){
//                 return;
//             }
//             Queue<Node> q = new LinkedList<>();
//             q.add(root);
//             q.add(null);

//             while (!q.isEmpty()) {
//                 Node currNode = q.remove();
//                 if (currNode == null) {
//                     System.out.println();
//                     if (q.isEmpty()) {
//                         break;
//                     } else {
//                         q.add(null); // for printing next
//                     }
//                 } else {
//                     System.out.print(currNode.data + " ");
//                     if (currNode.left != null) {
//                         q.add(currNode.left);
//                     }
//                     if (currNode.right != null) {
//                         q.add(currNode.right);
//                     }
//                 }
//             }
//         }
//     }

//     public static void main(String[] args) {
//         int nodes[] = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
//         BinaryTree tree = new BinaryTree();
//         Node root = BinaryTree.buildTree(nodes);
//         // if (root != null) {
//         //     System.out.println(root.data);
//         // } else {
//         //     System.out.println("Tree is empty");
//         // }

//         // tree.preOrder(root);
//         // tree.postOrder(root);
//         tree.levelOrder(root);
//     }
// }

// Height of a tree

import java.util.*;

public class BinaryTreesB {
    public static class Node {  // Make Node class static
        int data;
        Node left, right;

        public Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    // height of a tree
    public static int height(Node root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        return Math.max(leftHeight, rightHeight) + 1;
    }

    // Count nodes of a tree
    public static int count(Node root) {
        if (root == null) {
            return 0;
        }
        int leftCount = count(root.left);
        int rightCount = count(root.right);
        return leftCount + rightCount + 1;
    }

    // Diameter of a tree ***** O(n^2)
    public static int diameter(Node root) {
        if (root == null) {
            return 0;
        }
        int leftDiam = diameter(root.left);
        int leftHt = height(root.left); //left height
        int rightDiam = diameter(root.right);
        int rightHt = height(root.right); //right height

        int selfDiam = leftHt + rightHt + 1;

        return Math.max(selfDiam, Math.max(leftDiam, rightDiam));
    }

    // Kth level of a tree ***** O(n)
    public static void kthLevel(Node root, int level, int k) {
        if (root == null) {
            return;
        }
        if (level == k) {
            System.out.print(root.data + " ");
            return;
        }
        kthLevel(root.left, level + 1, k);
        kthLevel(root.right, level + 1, k);
    }

    // Lowest common ancestor ***** O(n)
  
        public static boolean getPath(Node root, int n, ArrayList<Node> path) {
            if (root == null) {
                return false;
            }
    
            path.add(root);
    
            if (root.data == n) {
                return true;
            }
    
            boolean foundLeft = getPath(root.left, n, path);
            boolean foundRight = getPath(root.right, n, path);
    
            if (foundLeft || foundRight) {
                return true;
            }
    
            path.remove(path.size() - 1);
            return false;
        }
    
        public static Node lca(Node root, int n1, int n2) {
            ArrayList<Node> path1 = new ArrayList<>();
            ArrayList<Node> path2 = new ArrayList<>();
    
            if (!getPath(root, n1, path1) || !getPath(root, n2, path2)) {
                return null;
            }
    
            int i;
            for (i = 0; i < path1.size() && i < path2.size(); i++) {
                if (!path1.get(i).equals(path2.get(i))) {
                    break;
                }
            }
    
            return path1.get(i - 1);
        }

        // lca approach 2
        public static Node lca2(Node root, int n1, int n2) {

            if (root == null || root.data == n1 || root.data == n2) {
                return root;
            }

            Node leftLca = lca2(root.left, n1, n2);
            Node rightLca = lca2(root.right, n1, n2);

            // leftLca = val , rightLca = null
            if(rightLca == null){
                return leftLca;
            }
            // leftLca = null , rightLca = val
            if(leftLca == null){
                return rightLca;
            }
            return root;
        }

        // Minimum distance between 2 Nodes ***** O(n)
    public static int lcaDist(Node root, int n) {
        if (root == null) {
            return -1;
        }
        if (root.data == n) {
            return 0;
        }

        int leftDist = lcaDist(root.left, n);
        int rightDist = lcaDist(root.right, n);

        if (leftDist == -1 && rightDist == -1) {
            return -1;
        } else if (leftDist == -1) {
            return rightDist + 1;
        } else {
            return leftDist + 1;
        }
    }

    public static int minDist(Node root, int n1, int n2) {
        Node lca = lca2(root, n1, n2);
        int dist1 = lcaDist(lca, n1);
        int dist2 = lcaDist(lca, n2);

        return dist1 + dist2;
    }

    // Kth ancestor of Node
    public static int kthAncestor(Node root, int n, int k) {
        if (root == null) {
            return -1;
        }

        if (root.data == n) {
            return 0;
        }
        int leftDist = kthAncestor(root.left, n, k);
        int rightDist = kthAncestor(root.right, n, k);

        if (leftDist == -1 && rightDist == -1) {
            return -1;
        }
        int max = Math.max(leftDist, rightDist);
        if (max + 1 == k ) {
            System.out.println(root.data);
        }
        return max + 1;
    }

    public static void main(String[] args) {
        //     1
        //    / \
        //   2   3
        //  / \ / \
        // 4  5 6  7 

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        // System.out.println(height(root));
        // System.out.println(count(root));
        // System.out.println(diameter(root));

        // int k = 2;
        // kthLevel(root, 1, k);

        // int n1 = 4;
        // int n2 = 6;
        // Node lcaNode = lca2(root, n1, n2);

        // if (lcaNode != null) {
        //     System.out.println("LCA of " + n1 + " and " + n2 + " is " + lcaNode.data);
        // } else {
        //     System.out.println("Keys are not present");
        // }

        // System.out.println(minDist(root, n1, n2));

        int n = 5, k = 2;
        kthAncestor(root, n, k);
    }
}

