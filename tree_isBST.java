// To check if a tree is a BINARY SEARCH TREE or not

/* Hidden stub code will pass a root argument to the function below. Complete the function to solve the challenge. Hint: you may want to write one or more helper functions.  

The Node class is defined as follows:
    class Node {
        int data;
        Node left;
        Node right;
     }
*/
    boolean checkBST(Node root) 
    {    
        boolean result = checkBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
        return result;
    }
    boolean checkBST(Node root, int low, int high)
    {
        if(root == null)
            return true;
        if(root.data < low || root.data > high)
            return false;
        return checkBST(root.left, low, root.data-1) && checkBST(root.right, root.data+1, high);
    }
    
