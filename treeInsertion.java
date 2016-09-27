/*you are given a pointer to the root of a binary search tree and a value to be inserted into the tree.
Insert this value into its appropriate position in the binary search tree and return the root of the updated binary tree.*/

 /* Node is defined as :
 class Node 
    int data;
    Node left;
    Node right;
    
    */

    static Node Insert(Node root,int value)
    {
        if(root == null) {
            Node newNode = new Node();
            newNode.data = value;
            newNode.left = newNode.right = null;
            return newNode;
        }
        else if(value < root.data)
            root.left = Insert(root.left, value);
        else if(value > root.data)
            root.right = Insert(root.right, value);
        return root;
    }

