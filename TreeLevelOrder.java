//We need to print the nodes level by level. We process each level from left to right. 
Level Order Traversal: 3 -> 5 -> 2 -> 1 -> 4 -> 6

   /* 
    
    class Node 
       int data;
       Node left;
       Node right;
   */
    Queue<Node> q = new LinkedList<Node>();
    void LevelOrder(Node root)
    {
        if(root != null) 
            q.add(root);
        while(q.isEmpty() == false) 
        {
            Node x = q.remove();
            System.out.print(x.data + " ");
            if(x.left != null) 
                q.add(x.left);
            if(x.right != null) 
                q.add(x.right);
        }
    }
