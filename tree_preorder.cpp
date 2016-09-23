//Print the tree's preorder traversal as a single line of space-separated values.

/* you only have to complete the function given below.  
Node is defined as  

class Node 
{
    int data;
    Node left;
    Node right;
}

*/

void preOrder(Node root) 
{
    if (root == null)
    {
        return;
    }
    System.out.print(root.data+" ");
    preOrder(root.left);
    preOrder(root.right);
}
