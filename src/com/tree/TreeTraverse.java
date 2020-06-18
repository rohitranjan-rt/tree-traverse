package com.tree;

import java.util.Stack;

public class TreeTraverse {
	
	// Tree Structure
    static class Node 
    {  
        Node left;  
        Node right;  
        int data;  
    }; 
  
    // Function to create a new node  
    static Node newNode(int key)  
    {  
        Node node = new Node();  
        node.left = node.right = null;  
        node.data = key;  
        return node;  
    }  
  
    // Function to Print all the leaf nodes  
    // of Binary tree using one stack  
    static void traverseLeaves(Node p)  
    {  
        // stack to store the nodes  
        Stack<Node> s = new Stack<>();  
  
        while (true)  
        {  
            // If p is not null then push  
            // it on the stack  
            if (p != null)  
            {  
                s.push(p);  
                p = p.right;  
            }  
  
            else 
            {  
                // If stack is empty then come out  
                // of the loop  
                if (s.empty())  
                    break;  
                else
                {  
                    // If the node on top of the stack has its  
                    // left subtree as null then pop that node and  
                    // print the node only if its right 
                    // subtree is also null  
                    if (s.peek().left == null)  
                    {  
                        p = s.peek();  
                        s.pop();  
  
                        // Print the leaf node  
                        if (p.right == null)  
                            System.out.print( p.data+" ");  
                    }  
  
                    while (p == s.peek().left)  
                    {  
                        p = s.peek();  
                        s.pop();  
  
                        if (s.empty())  
                            break;  
                    }  
  
                    // If stack is not empty then assign p as  
                    // the stack's top node's left child  
                    if (!s.empty())  
                        p = s.peek().left;  
                    else
                        p = null;  
                }  
            }  
        }  
    }
    public static void main(String[] args) 
    {
    	Node root = newNode(1);  
        root.left = newNode(3);  
        root.right = newNode(10);  
        root.left.left = newNode(1);  
        root.left.right = newNode(6);  
        root.right.right = newNode(14);
        root.right.right.left = newNode(13);
        root.left.right.left = newNode(4);
        root.left.right.right = newNode(7);  
        
        System.out.println("Traversal of leaves from right to left");
        traverseLeaves(root);  
    }
}  
