//To find the number that occurs only once in an array in O(n) -- > time  && O(n) --> time + O(1) --> space

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uca_datastructures;

import java.util.*;
import java.lang.Math.*;

/**
 *
 * @author AADHYA
 */
public class LonelyNumber 
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter the number of elements ");
        int n = scan.nextInt();
        int[] input = new int[n];
        int[] a = new int[32];
        int i, j;
        int lonNum = 0;
        System.out.print("Enter the elements ");
        for(i = 0; i < n; i++)
        {
            input[i] = scan.nextInt(); 
        }
        
        for(i = 0; i < n; i++)
        {
            for(j = 0; j < 32; j++)
            {
                a[j] = a[j] + ((input[i]>>j) & 1); 
            }
        }
        
        for(i = 0; i < 32; i++)
        {
            if (a[i] % 3 != 0)
            lonNum = lonNum + (int)Math.pow(2, i);
        }
        
        System.out.print("The lonely number is : " + lonNum);
    }
    
}

