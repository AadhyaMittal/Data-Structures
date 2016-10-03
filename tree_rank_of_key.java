//To find the RANK of a key in a BST

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class BST {
     private Node root;
        
        private class Node {
            
            private final Integer key;
            private Node right;
            private Node left;
            private int N;
            
            public Node(Integer key) {
                this.key = key;
                N = 1;
            }
        }
        public boolean isEmpty() {
            return size() == 0;
        }
        
        public int size() {
            return sizeOf(root);
        }
        
        private int sizeOf(Node x) {
            return x == null ? 0 : x.N;
        }
    
        public Integer get(int key) {
            Node x = get(root, key);
            return x == null ? null : x.key;
        }
        
        private Node get(Node x, Integer key) {
            if (x == null) {
                return null;
            }
            int cmp = key.compareTo(x.key);
            if (cmp == 0) {
                return x;
            }
            if (cmp < 0) {
                return get(x.left, key);
            }
            return get(x.right, key);
        }
    
    
    /*
 * Complete the function below.
 */

    public void insert(int key)
    {
        root = insert(root, key);
    }
    
    private Node insert(Node root, int key)
    {
        if(root == null)
            return new Node(key);
        else if(key < root.key)
            root.left = insert(root.left, key);
        else if(key > root.key)
            root.right = insert(root.right, key);
        root.N = 1 + sizeOf(root.left) + sizeOf(root.right);
        return root;
    }
    
    public Integer getRank(int key)
    {
        if(get(key) == null)
            return -1;
        return getRank(root, key);    
    } 
    
    private Integer getRank(Node root, int key)
    {
        if(root.key == key)
            return sizeOf(root.left);
        else if(key < root.key)
            return getRank(root.left, key);
        else //if(key > root.key)
            return 1 + sizeOf(root.left) + getRank(root.right, key);
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        BST bst = new BST();
        int n = in.nextInt();
        for(int i = 0 ; i < n ; i++){
            bst.insert(in.nextInt());
        }
        int m = in.nextInt();
        for(int i = 0 ; i < m ; i++){
            System.out.println(bst.getRank(in.nextInt()));
        }
    }
}
