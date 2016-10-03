//To implement all the functions used in a TRIE  

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
public class Trie 
{
    TrieNode root;
    public Trie()
    {
        root = new TrieNode();
    }
    
    public class TrieNode
    {
        Integer value;               //Integer is a wrapper class with default value null
        TrieNode[] nodes = new TrieNode[26];
    }
    
    public void insert(String word, int value)
    {
        TrieNode p = root;
        for(int i = 0; i < word.length(); i++)
        {
            int index = word.charAt(i) - 'a';
            if(p.nodes[index] == null)
            {
                p.nodes[index] = new TrieNode();
            }
            p = p.nodes[index];
        }
        p.value = value;
    }
    
    public boolean StartWith(String Node)
    {
        TrieNode p = SearchNode(Node);
        return p != null;
    }
    
    /*public String[] StartWithNames(String Node)
    {
        TrieNode p = SearchNode(Node);
        int i = 0;
        String[] names = new String[20];
        if (p != null)
            names.charAt[i] = p.Node;
            
    }*/
    
    public int search(String word)
    {
        TrieNode p = SearchNode(word);
        if (p == null)
            return -1;
        return p.value;
    }
    
    public TrieNode SearchNode(String word)
    {
        TrieNode p = root;
        for(int i = 0; i < word.length(); i++)
        {
            int index = word.charAt(i) - 'a';
            if (p.nodes[index] == null)
            {
                return null;
            }
            p = p.nodes[index];
            
        }
        return p;
    }
    
    
    public void SoftDelete(String word)
    {
        TrieNode p = root;
        for(int i = 0; i < word.length(); i++)
        {
            int index = word.charAt(i) - 'a';
            if (p.nodes[index] == null)
            {
                return;
            }
            p = p.nodes[index];
            
        }
        p.value = null;
       
    }
    
    public void HardDelete(String word)
    {
        HardDelete(word, root, 0);
    }
    
    private boolean HardDelete(String word, TrieNode p, int l)
    {
        if(p == null)
            return false;
        if(l == word.length())
        {
            p.value = null;
            if(hasChild(p))
            {
                return false;
            }
            return true;
        }
        int index = word.charAt(l) - 'a';
        if(HardDelete(word, p[index], l+1))
        {
            p[index] = null;
            return !(hasChild(p));
        }
        return false;
    }
    
    private boolean hasChild(TrieNode p)
    {
        for(int i = 0; i < 26; i++)
        {
            if(p.nodes[i] != null) 
                return true;
        }
        return false;
    }
    public static void main(String[] args)
    {
        Trie t = new Trie();
        t.insert("any", 56);
        t.insert("ann", 15);
        t.insert("emma", 30);
        t.insert("rob", 27);
        t.insert("roger", 56);
        System.out.println("Is any present in the trie and what is its value?? " + t.search("any"));
        System.out.println("Is celly present in the trie and what is its value?? " + t.search("celly"));
        System.out.println("Do we have any names starting with 'ro' in the trie?? " + t.StartWith("ro"));
        System.out.println("Do we have any names starting with 'pr' in the trie?? " + t.StartWith("pr"));
        t.SoftDelete("any");
        t.HardDelete("rob");
        t.HardDelete("roger");
    }
            
}
