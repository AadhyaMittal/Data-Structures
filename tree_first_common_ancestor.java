//To find the FIRST COMMON ANCESTOR of a node in a BST

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution 
{
    public Node root = null;
    
    public class Node
    {
        int key;
        Node left;
        Node right;
        
        public Node(int key)
        {
            this.key = key;
            this.left = null;
            this.right = null;
        }
    }
        
        public void insert(int key)
        {
            root = insert(root, key);    
        }
        
        private Node insert(Node root, int key)
        {
            if(root == null)
                return new Node(key);
            if(key < root.key)
                root.left = insert(root.left, key);
            else if(key > root.key)
                root.right = insert(root.right, key);
            return root;
        }
        
        public void inOrder()
        {
            inOrder(root);    
        }
        
        private void inOrder(Node root)
        {
            if(root == null)
                return;
            inOrder(root.left);
            System.out.print(root.key + " ");
            inOrder(root.right);
        }
    
    public int firstComAnc(int a, int b)
    {
        if(a == root.key || b == root.key)
            return -1;
        return firstComAnc(a, b, root).key;    
    }
    
    private Node firstComAnc(int a, int b, Node root)
    {
        if(root == null)
            return null;
        //if(a == root.key || b == root.key)
          //  return root;
        else if(a < root.key && b < root.key)
            return firstComAnc(a, b, root.left);
        else if(a > root.key && b > root.key)
            return firstComAnc(a, b, root.right);
        return root;
    }
    
    public static void main(String args[] ) throws Exception 
    {
        Solution s = new Solution();
        int i, x, y, n, a, b, c;
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();
        //System.out.println(n);
        for(i = 0; i < n; i++)
        {
            x = scan.nextInt();
            s.insert(x);
        }
        //s.inOrder();
        y = scan.nextInt();
        for(i = 0; i < y; i++)
        {
            a = scan.nextInt();
            b = scan.nextInt();
            System.out.println(s.firstComAnc(a, b));
        }
    }
}
