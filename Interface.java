package uca_datastructures;
import java.util.*;
/**
 *
 * @author AADHYA
 */

class Process
    {
        private String pName;
        private int pid;
        Process(String pName, int pid)
        {
            this.pName = pName;
            this.pid = pid;
        }
        public String toString()
        {
            return this.pName;
        }
    }
    
    class Priority implements Comparable
    {
        private int avgTime;
        private int totalTime;
        Priority(int avgTime, int totalTime)
        {
            this.avgTime = avgTime;
            this.totalTime = totalTime;
        }
        public int compareTo(Object o)
        {
            Priority p = (Priority)o;          //TYPECASTING      
                                             
            if(this.avgTime < p.avgTime)
                return -1;
            if(this.avgTime > p.avgTime)
                return 1;
            return 0;
         
        }
    }
   
public class InterfaceSJF 
{
    private Node root = null;
    
    class Node
    {
        Priority key;
        Process value;
        Node left;
        Node right;
        Node(Priority key, Process value)
        {
            this.key = key;
            this.value = value;
        }
    }
    
    public void insert(Priority key, Process value)
    {
        root = insert(root, key, value);
    }
    
    private Node insert(Node x, Priority key, Process value)
    {
        if(x == null)
            return new Node(key, value);
        if(key.compareTo(x.key) < 0)
            x.left = insert(x.left, key, value);
        else if(key.compareTo(x.key) > 0)
            x.right = insert(x.right, key, value);
        else
            x.value = value;
        return x;
    }
    
    public void inOrder()
    {
        inOrder(root);
    }
    
    private void inOrder(Node x)
    {
        if(x == null)
            return;
        inOrder(x.left);
        System.out.println(x.value);
        inOrder(x.right);
    }
    
    public static void main(String[] args)
    {
        Process p1 = new Process("Process1" , 1);
        Process p2 = new Process("Process2" , 2);
        Process p3 = new Process("Process3" , 3);
        
        Priority pt1 = new Priority(5,1);
        Priority pt2 = new Priority(7,2);
        Priority pt3 = new Priority(3,3);
        
        InterfaceSJF tree = new InterfaceSJF();
        tree.insert(pt1, p1);
        tree.insert(pt2, p2);
        tree.insert(pt3, p3);
        tree.inOrder();
    }
}
