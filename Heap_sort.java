package uca_datastructures;

import java.util.*;

/**
 *
 * @author AADHYA
 */
public class Heap 
{
    private int[] arr;
    private int size;
    private int pos;
    
    private Heap(int size)
    {
        this.size = size + 1;   //to accomodate the array elem missed at pos 0
        this.arr = new int[this.size];
        this. pos = 0;
    }
    
    public void insert(int x)
    {
        if(pos >= size)
            return;
        pos = pos + 1;
        arr[pos] = x;
        swimUp(pos);
    }
    
    private void swimUp(int i)
    {
        if(i <= 1)
            return;
        if(arr[i] > arr[i/2])
        {
            swap(i, i/2);
            swimUp(i/2);
        }
    }
    
    private void swap(int i, int j)
    {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    
    public void display()
    {
        for(int i = 1; i <= pos; i++)
        {
            System.out.print(arr[i] + " ");
        }
    }
    
    public int getMax()
    {
        return arr[1];
    }
    
    public int delMax()
    {
        if(pos < 1)
            return Integer.MIN_VALUE;
        int temp = arr[1];       //max elem is at the root
        swap(1, pos);      //pos represents the pos of the last inserted elem
        pos--;
        sinkDown(1);
        //size--;
        //System.out.println(size);
        return temp;
    }
    
    private void sinkDown(int i)
    {
        int max = i, left = 2*i, right = 2*i + 1;
        if(left <= pos && arr[left] > arr[max])
            max = left;
        if(right <= pos && arr[right] > arr[max])
            max = right;
        if(max != i)
        {
            swap(i, max);
            sinkDown(max);
        }
    }
    
    public void heapSort()
    {
        int n = arr.length;
 
        // Build heap (rearrange array)
            for (int i = n / 2 - 1; i >= 0; i--)
                heapify(arr, n, i);
 
        // One by one extract an element from heap
            for (int i=n-1; i>=0; i--)
            {
            // Move current root to end
                int temp = arr[0];
                arr[0] = arr[i];
                arr[i] = temp;
 
            // call max heapify on the reduced heap
                heapify(arr, i, 0);
            }
    }
        // To heapify a subtree rooted with node i which is
    // an index in arr[]. n is size of heap
    void heapify(int arr[], int n, int i)
    {
            int largest = i;  // Initialize largest as root
            int l = 2*i + 1;  // left = 2*i + 1
            int r = 2*i + 2;  // right = 2*i + 2
 
        // If left child is larger than root
            if (l < n && arr[l] > arr[largest])
                largest = l;
 
        // If right child is larger than largest so far
            if (r < n && arr[r] > arr[largest])
                largest = r;
 
        // If largest is not root
            if (largest != i)
            {
                int swap = arr[i];
                arr[i] = arr[largest];
                arr[largest] = swap;
 
            // Recursively heapify the affected sub-tree
                heapify(arr, n, largest);
            }
        
    }
    
    public static void main(String[] args)
    {
        Heap h = new Heap(5);
        h.insert(40);
        h.insert(20);
        h.insert(10);
        h.insert(30);
        h.insert(50);
        System.out.print("The elements of the heap are : " ); 
        //h.heapSort();
        h.display();
        System.out.println();
        System.out.print("The sorted heap is : ");
        h.heapSort();
        h.display();
        System.out.println();
        System.out.println("The max element of the heap is : " + h.getMax());
        h.delMax();
        System.out.print("The elements of the heap after deleting max elem are : " ); 
        h.display();
        System.out.println();
        System.out.print("The sorted heap after deleting max element is : ");
        h.heapSort();
        h.display();
        System.out.println();
    }
}
