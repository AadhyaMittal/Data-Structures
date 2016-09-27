/*You are given pointer to the root of the binary search tree and two values n1 and n2.
You need to return the lowest common ancestor (LCA) of n1 and n2 in the binary search tree. You only need to complete the function.*/



 /* Node is defined as :
 class Node 
    int data;
    Node left;
    Node right;
    
    */

static Node lca(Node root,int n1,int n2)
    {
        if(root == null)
            return null;
        if(n1 < root.data && n2 < root.data)
            return lca(root.left, n1, n2);
        else if(n1 > root.data && n2 > root.data)
            return lca(root.right, n1, n2);
       return root;
    }




