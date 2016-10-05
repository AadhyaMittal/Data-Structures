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
public class topView 
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
    
    private class CNode
    {
        Node n;
        int d;
        public CNode(Node n, int d)
        {
            this.n = n;
            this.d = d;
        }
    }
    
    public void topView()
    {
        topView(root);
    }
    
    private void topView(Node root)
    {
        Set<Integer> s = new HashSet<>();
        Queue<CNode> q = new LinkedList<>();
        q.add(new CNode(root, 0));
        while(q.isEmpty() == false)
        {
            CNode t = q.remove();
            if(!s.contains(t.d))
            {    
                System.out.print(t.n.key + " ");
                s.add(t.d);
            }
            if(t.n.left != null)
                q.add(new CNode(t.n.left, t.d - 1));
            if(t.n.right != null)
                q.add(new CNode(t.n.right, t.d + 1));
            
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
    
    /*TOP VIEW FOR A TREE -----> DOES NOT WORK FOR A BST
    
    public void topView()
    {
        topView(root);
    }
    
    private void goLeft(Node root)
    {
        if(root.left != null)
            goLeft(root.left);
        System.out.print(root.key + " ");
    }
    
    private void goRight(Node root)
    {
        System.out.print(root.key + " ");
        if(root.right != null)
            goRight(root.right);
        
    }
    
    private void topView(Node root)
    {
        if(root.left != null)
            goLeft(root.left);
        System.out.print(root.key + " ");
        if(root.right != null)
            goLeft(root.right);
    }*/
    
    
    
    
    public static void main(String[] args)
    {
        topView t = new topView();
        t.insert(10);
        t.insert(9);
        t.insert(12);
        t.insert(2);
        t.insert(13);
        t.insert(11);
        t.insert(1);
        t.insert(3);
        t.insert(4);
        t.insert(5);
        t.insert(6);
        t.insert(7);
        t.insert(8);
        t.topView();
    }
}
