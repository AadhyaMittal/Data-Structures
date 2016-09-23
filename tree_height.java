//Your function should return a single integer denoting the height of the binary tree.

   /*
    
    class Node 
       int data;
       Node left;
       Node right;
   */
   private int isGreater(int a, int b)
   {
       return (a > b ? a : b);
   }
   int height(Node root)
    {
         if(root == null)
         {
             return -1;
         }
         else
         {
              return 1 + isGreater(height(root.left),height(root.right));    
         }
       
    }
