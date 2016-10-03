//To show the TOP VIEW of a BST

/*
   class Node 
       int data;
       Node left;
       Node right;
*/
void goLeft(Node root)
{
    if(root.left != null)
        goLeft(root.left);
    System.out.print(root.data + " ");
}

void goRight(Node root)
{
    System.out.print(root.data + " ");
    if(root.right != null)    
        goRight(root.right);
}

void top_view(Node root)
{
    if(root.left != null)
        goLeft(root.left);
    System.out.print(root.data + " ");
    if(root.right != null)
        goRight(root.right);
}
