package uca_datastructures;

/**
 *
 * @author AADHYA
 */
public class RBtree1
{
        private static final boolean RED = true;
        private static final boolean BLACK = false;
        private Node root = null;
        private class Node 
        {
            int key;
            int value;
            Node right;
            Node  left;
            boolean color;
            
            Node(int key,int value, boolean  color) 
            {
                this.key =  key;
                this.value = value;
                this.color = color;
            }
        }
        private boolean isRed(Node x)
        {
            if(x == null) 
                return false;
            return x.color == RED;
        }        
        public void insert(int key, int value) 
        {
             root = insert(root, key, value);
        }
        private Node insert(Node n, int key, int value)
        {
            if( n == null) 
                return new Node(key,value,RED);// every new link added is red in color
             if(n.key == key)
             {
                n.value = n.value;
            }
            else if (n.key > key) 
            {
                n.left = insert(n.left, key, value);
            }    
            else
            {
                n.right = insert(n.right, key, value);
            }
            // if one black and one red and red is in RHS 
            if( isRed(n.right)  &&  !isRed(n.left) ) 
            {
                n = rotateLeft(n);
            }
            //if two consecutive link in LHS, rotate it right
            if( isRed(n.left) && isRed(n.left.left) )
                n = rotateRight(n);
            if( isRed(n.left) && isRed(n.right))
                flipColors(n);
            return n;
        }      
        private void  flipColors(Node x)
        {
            x.left.color = BLACK;
            x.right.color = BLACK;
            x.color  = RED;   
        }          
        private Node rotateLeft(Node x)
        {
            Node h = x.right;
            x.right = h.left;
            h.left = x;
            h.color = x.color;
            x.color = RED;
            return h;
        }        
        private Node rotateRight(Node x)
        {
            Node h = x.left;
            x.left = h.right;
            h.right  = x;
            h.color = x.color;
            x.color = RED;
            return h;
        
        }
        public int height()
        {
            return height(root);
        }
        private int height(Node x)
        {
            if(x == null) 
                return -1;
            return 1 + Math.max( height(x.left), height(x.right));
        
        }
    public static void main(String[] args) 
    {

        RBtree1 rbTree = new RBtree1();
        rbTree.insert(1,12);
        rbTree.insert(2,13);
        rbTree.insert(3,14);
        rbTree.insert(4,15);
        rbTree.insert(5,16);
        rbTree.insert(6,17);
        rbTree.insert(7,17);
        rbTree.insert(8,18);
        rbTree.insert(9,19);
        rbTree.insert(10,20);
        int height = rbTree.height();
        System.out.println("Height = "+height);
    }
}
