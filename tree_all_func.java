//To implement all the functions used in a BST

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
public class bst1 
{
    private Node root = null;

    private class Node
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
        root = insert(root,key);        //need reference of updated root
    }
    
    private Node insert(Node root, int key)
    {
        if(root == null)
            return new Node(key);       //calls the constructor 
        else if(key < root.key)
            root.left = insert(root.left, key);     /*node is created and value added in that node
                                                     after that the node is returned and is returned to root.left*/
        else if(key > root.key)
            root.right = insert(root.right, key);
        
        root.N = 1 + size(root.left) + size(root.right);
        return root;
    }
    
    public int size()
    {
        return size(root);
    }
    
    private int size(Node root)
    {
        return root == null ? 0 : root.N;
    }
    
    public int height()
    {
        return height(root);
    }
    
    private int height(Node root)
    {
        if(root == null)
            return -1;
        else
            return 1 + max(height(root.left), height(root.right));
    }
    
    private int max(int a, int b)
    {
        return a > b ? a : b;
    }
    
    public boolean isEmpty()
    {
        return isEmpty(root);
    }
    
    private boolean isEmpty(Node root)
    {
        return size() == 0;
    }
    public void preOrder()
    {
        preOrder(root);
    }
    
    private void preOrder(Node root)
    {
        if(root == null)
            return;
        System.out.print( root.key + " ");
        preOrder(root.left);
        preOrder(root.right);
    }
    
    public void postOrder()
    {
        postOrder(root);
    }
    
    private void postOrder(Node root)
    {
        if(root == null)
            return;
        postOrder(root.left);
        postOrder(root.right);
        System.out.print( root.key + " ");
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
        System.out.print( root.key + " ");
        inOrder(root.right);
    }
    
    public void levelOrder()
    {
        levelOrder(root);
    }
    
    Queue<Node> q = new LinkedList<Node>();
    private void levelOrder(Node root)
    {
        if(root != null)
            q.add(root);
        while(q.isEmpty() == false)
        {
            Node x = q.remove();
            System.out.print(x.key + " ");
            if(x.left != null)
                q.add(x.left);
            if(x.right != null)
                q.add(x.right);
        }
        
    }
    
    public int lowestCommonAncestor(int n1, int n2)
    {
        return lowestCommonAncestor(root,n1,n2).key;
    }
    
    private Node lowestCommonAncestor(Node root, int n1, int n2)
    {
        if(root == null)
            return null;
        if(n1 < root.key && n2 < root.key)
            return lowestCommonAncestor(root.left, n1, n2);
        else if(n1 > root.key && n2 > root.key)
            return lowestCommonAncestor(root.right, n1, n2);
        return root;
    }
   /* public boolean search(int key)
    {
        if(search(root,key) == null)
            return false;
        else 
            return true;
    }
    
    private Node search(Node root, int key)
    {
        if(root == null || root.key == key)
            return root;
        if(key < root.key)
            return search(root.left, key);
        else
            return search(root.right, key);
    }*/
    
    public boolean search(int key)
    {
        return search(root,key);
    }
    
    private boolean search(Node root, int key)
    {
        if(root == null)
            return false;
        if(root.key == key)
            return true;
        if(key < root.key)
            return search(root.left, key);
        else
            return search(root.right, key);
    }
    
    public int rank(int key)
    {
        if(search(key))
            return rank(root, key);
        return -1;
    }
    
    private int rank(Node root, int key)
    {
        if(key == root.key)
            return size(root.left);
        else if(key < root.key)
            return rank(root.left, key);
        else 
            return 1 + size(root.left) + rank(root.right, key);
    }
    
    public int getMin()
    {
        return getMin(root).key;
    }
    
    private Node getMin(Node root)
    {
        if(root.left == null)
            return root;
        return getMin(root.left);
    }
    
    public int getMax()
    {
        return getMax(root).key;
    }
    
    private Node getMax(Node root)
    {
        if(root.right == null)
            return root;
        return getMax(root.right);
    }
    
    public void delMin()
    {
        if (root == null)
            return;
        root = delMin(root);
    }
    
    private Node delMin(Node root)
    {
        if(root.left == null)
            return root.right;
        root.left = delMin(root.left);
        return root;
    }
    
    public void delMax()
    {
        if(root == null)
            return;
        root = delMax(root);
    }
    
    private Node delMax(Node root)
    {
        if(root.right == null)
            return root.left;
        root.right = delMax(root.right);
        return root;
    }
    
    public static void main(String[] args)
    {
        bst1 b = new bst1();
        b.insert(5);
        b.insert(3);
        b.insert(4);
        b.insert(2);
        b.insert(7);
        b.insert(6);
        b.insert(8);
        System.out.print("preOrder : ");
        b.preOrder();
        System.out.println();
        System.out.print("postOrder : ");
        b.postOrder();
        System.out.println();
        System.out.print("inOrder : ");
        b.inOrder();
        System.out.println();
        System.out.print("levelOrder : ");
        b.levelOrder();
        System.out.println();
        System.out.println("Size of the tree is : " + b.size());
        System.out.println("Height of the tree is : " + b.height());
        System.out.println("Minumun element : " + b.getMin());
        System.out.println("Maximum element : " + b.getMax());
        System.out.println("Is 11 present in the tree? : " + b.search(11));
        System.out.println("Is 2 present in the tree? : " + b.search(2));
        System.out.println("The RANK of 2 in the tree is : " + b.rank(2));
        System.out.println("The RANK of 8 in the tree is : " + b.rank(8));
        System.out.println("Lowest common ancestor of 2, 4 is : " + b.lowestCommonAncestor(2,4));
        b.delMin();
        System.out.print("inOrder after delMin: ");
        b.inOrder();
        System.out.println();
        b.delMax();
        System.out.print("inOrder after delMax: ");
        b.inOrder();
        System.out.println();
        System.out.println("Is the tree empty?? : " + b.isEmpty());
    }
    
}
