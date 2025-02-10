You are developing an application for a garden management system where each tree 
in the garden is represented as a binary tree structure. The system needs to 
allow users to plant new trees in a systematic way, ensuring that each tree is 
filled level by level.

A gardener wants to:
 - Plant trees based on user input.
 - Ensure trees grow in a balanced way by filling nodes level by level.
 - Inspect the garden layout by performing an in-order traversal, which helps 
   analyze the natural arrangement of trees.

Your task is to implement a program that:
    - Accepts a list of N tree species (as integers).
    - Builds a binary tree using level-order insertion.
    - Displays the in-order traversal of the tree.

Input Format:
-------------
- An integer N representing the number of tree plants.
- A space-separated list of N integers representing tree species.

Output Format:
--------------
A list of integers, in-order traversal of tree.


Sample Input:
-------------
7
1 2 3 4 5 6 7

Sample Output:
--------------
4 2 5 1 6 3 7


Explanation:
------------
The tree looks like this:

        1
       / \
      2   3
     / \  / \
    4   5 6  7
The in order is : 4 2 5 1 6 3 7
import java.util.*;

class Tree 

{


    int data;
    Tree left, right;

    Tree(int data) 

{


        this.data = data;
        this.left = null;
        this.right = null;
    

}

    static Tree insertLevelOrder(int[] arr) 

{


        if (arr.length == 0) return null;

        Tree root = new Tree(arr[0]);
        Queue<Tree> q = new LinkedList<>();
        q.add(root);
        int i = 1;

        while (i < arr.length) 

{


            Tree current = q.poll();
            if (i < arr.length) 

{


                current.left = new Tree(arr[i++]);
                q.add(current.left);
            

}
            if (i < arr.length) 

{


                current.right = new Tree(arr[i++]);
                q.add(current.right);
            

}
        

}
        return root;
    

}

 
    static void inorder(Tree root, List<Integer> res) 

{


        if (root == null) return;
        inorder(root.left, res);
        res.add(root.data);
        inorder(root.right, res);
    

}

}

class Solution 

{


    public static void main(String[] args) 

{


        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a[] = new int[n];
        for (int i = 0; i < n; i++) 

{


            a[i] = sc.nextInt();
        

}

        
        Tree root = Tree.insertLevelOrder(a);

        List<Integer> res = new ArrayList<>();
        Tree.inorder(root, res);

  
        System.out.println(res);

        sc.close();
    

}

}
