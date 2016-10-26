package uca_datastructures;
import java.util.*;
/**
 *
 * @author AADHYA
 */

class TaskDetails
{
    private final String pName;
    private final int pid;
    TaskDetails(String pName, int pid)
    {
        this.pName = pName;
        this.pid = pid;
    }
    @Override
    public String toString()
    {
        return new StringBuilder (this.pName).append(", ").append(this.pid).toString();
    } 
}
   
class TaskPriority
{
    private int avgTime;
    private int totalTime;
    TaskPriority(int avgTime, int totalTime)
    {
        this.avgTime = avgTime;
        this.totalTime = totalTime;
    }
    public int getAvg() {
        return avgTime;
    }
    public int getTotal() {
        return totalTime;
    }
}
/*
abstract class JobDefinition implements Comparator {
    int start = 1;
    JobDefinition() {
        start = 1;
    }
}*/

class MyAvg implements Comparator {
    @Override
    public int compare(Object o1, Object o2) {
        TaskPriority t1 = (TaskPriority)o1;
        TaskPriority t2 = (TaskPriority)o2;
        if(t1.getAvg() < t2.getAvg()) { return -1; }
        else if(t1.getAvg() > t2.getAvg()) { return 1; }
        else { return 0; }
    }
}

class MyTotal implements Comparator{
    @Override
    public int compare(Object o1, Object o2) {
        TaskPriority t1 = (TaskPriority)o1;
        TaskPriority t2 = (TaskPriority)o2;
        if(t1.getTotal() < t2.getTotal()) { return -1; }
        else if(t1.getTotal() > t2.getTotal()) { return 1; }
        else { return 0; }
    }
}

class TaskList{
    class Node
    {
        TaskPriority key;
        TaskDetails value;
        Node left;
        Node right;
        Node(TaskPriority key, TaskDetails value)
        {
            this.key = key;
            this.value = value;
        }
    }
    
    private Node root = null;

    public void insert(TaskPriority key, TaskDetails value, Comparator C)
    {
        this.root = insert(root, key, value, C);
    }
    
    private Node insert(Node x, TaskPriority key, TaskDetails value, Comparator C)
    {
        if(x == null)
            return new Node(key, value);
        if(C.compare(x.key, key) < 0)
            x.left = insert(x.left, key, value, C);
        else if(C.compare(x.key, key) > 0)
            x.right = insert(x.right, key, value, C);
        else
            x.value = value;
        return x;
    }
    
    public void delete() {
        this.root = null;
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
}

public class comparator
{
    public static void main(String[] args)
    {
        TaskDetails p1 = new TaskDetails("Process1" , 1);
        TaskDetails p2 = new TaskDetails("Process2" , 2);
        TaskDetails p3 = new TaskDetails("Process3" , 3);
        
        TaskPriority pt1 = new TaskPriority(5,1);
        TaskPriority pt2 = new TaskPriority(7,2);
        TaskPriority pt3 = new TaskPriority(3,3);
        
        Comparator C1 = new MyAvg();
        // Comparator C = new MyTotal();
        
        TaskList TaskTree = new TaskList();
        TaskTree.insert(pt1, p1, C1);
        TaskTree.insert(pt2, p2, C1);
        TaskTree.insert(pt3, p3, C1);
        TaskTree.inOrder();
        
        TaskTree.delete();
        
        //C = (MyTotal) C;
        Comparator C2 = new MyTotal();
        TaskTree.insert(pt1, p1, C2);
        TaskTree.insert(pt2, p2, C2);
        TaskTree.insert(pt3, p3, C2);
        TaskTree.inOrder();
    }
}
