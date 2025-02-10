Write a program to construct a binary tree from level-order input, while treating -1 
as a placeholder for missing nodes. The program reads input, constructs the tree, 
and provides an in-order traversal to verify correctness.

Input Format:
---------------
Space separated integers, level order data (where -1 indiactes null node).

Output Format:
-----------------
Print the in-order data of the tree.


Sample Input:
----------------
1 2 3 -1 -1 4 5

Sample Output:
----------------
2 1 4 3 5

Explanation:
--------------
    1
   / \
  2   3
     / \
    4   5


Sample Input:
----------------
1 2 3 4 5 6 7

Sample Output:
----------------
4 2 5 1 6 3 7

Explanation:
--------------
        1
       / \
      2   3
     / \  / \
    4  5 6  7
  import java.util.*;

class TreeNode 

{


    int data;
    TreeNode left, right;

    TreeNode(int data) 

{


        this.data = data;
        this.left = null;
        this.right = null;
    

}

}

class BinaryTree 

{



    static TreeNode buildTree(int[] arr) 

{


        if (arr.length == 0 || arr[0] == -1) return null;

        TreeNode root = new TreeNode(arr[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int i = 1;

        while (i < arr.length) 

{


            TreeNode current = queue.poll();
            
          
            if (i < arr.length && arr[i] != -1) 

{


                current.left = new TreeNode(arr[i]);
                queue.add(current.left);
            

}
            i++;

          
            if (i < arr.length && arr[i] != -1) 

{


                current.right = new TreeNode(arr[i]);
                queue.add(current.right);
            

}
            i++;
        

}
        return root;
    

}

    static void inorderTraversal(TreeNode root, List<Integer> result) 

{


        if (root == null) return;
        inorderTraversal(root.left, result);
        result.add(root.data);
        inorderTraversal(root.right, result);
    

}

}

public class Solution 

{


    public static void main(String[] args) 

{


        Scanner sc = new Scanner(System.in);
        
    
        String[] input = sc.nextLine().split(" ");
        int[] arr = new int[input.length];
        
        for (int i = 0; i < input.length; i++) 

{


            arr[i] = Integer.parseInt(input[i]);
        

}

       
        TreeNode root = BinaryTree.buildTree(arr);

    
        List<Integer> result = new ArrayList<>();
        BinaryTree.inorderTraversal(root, result);

        for (int num : result) 

{


            System.out.print(num+ " ");
        

}
        
      
    

}

}
