//To print the nodes of a BST in ZIG ZAG ORDER

//OUTPUT Zig Zag Order : 7 9 4 2 6 8 10 5 3 1 

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uca_datastructures;

import java.util.*;

/**
 *
 * @author AADHYA
 */
public class ZigzagOrder 
{
    public Node root = null;
    public class Node
    {
        int key;
        Node left;
        Node right;
        int N;
        
        public Node(int key)
        {
            this.key = key;
            this.left = null;
            this.right = null;
            this.N = 1;
        }
    }
    
    public void insert(int key)
    {
        root = insert(root, key);
    }
    
    private Node insert(Node root, int key)
    {
        if (root == null)
            return new Node(key);
        else if(key < root.key)
            root.left = insert(root.left, key);
        else if(key > root.key)
            root.right = insert(root.right, key);
        //root.N = 1 + size(root.left) + size(root.right);
        return root;
    }
    
    public void zigZagOrder()
    {
        zigZagOrder(root);
    }
    
    private void zigZagOrder(Node root)
    {
        if(root == null)
            return;
        Stack<Node> s = new Stack<Node>();
        boolean rev = true;
        s.push(root);
        while(!s.isEmpty())
        {
            Stack<Node> t = new Stack<Node>();
            while(!s.isEmpty())
            {
                Node x = s.pop();
                System.out.print(x.key + " ");
                if(rev)
                {
                    if(x.left != null)
                        t.push(x.left);
                    if(x.right != null)
                        t.push(x.right);
                }
                else
                {
                    if(x.right != null)
                        t.push(x.right);
                    if(x.left != null)
                        t.push(x.left);
                }
            }
            rev = !rev;
            s = t;
        }
    }
    
    public static void main(String[] args)
    {
        ZigzagOrder z = new ZigzagOrder();
        z.insert(7);
        z.insert(9);
        z.insert(4);
        z.insert(2);
        z.insert(1);
        z.insert(3);
        z.insert(8);
        z.insert(10);
        z.insert(6);
        z.insert(5);
        System.out.print("Zig Zag Order : ");
        z.zigZagOrder();
        System.out.println();
}
