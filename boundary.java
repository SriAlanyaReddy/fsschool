import java.util.*;
class TreeNode{
    TreeNode left,right;
    int val;
    TreeNode(int val){
        this.val=val;
    }
}
class TreeBuilder{
    public TreeNode buildTree(int[] levelorder){
        int rootvalue=levelorder[0];
        
        Queue<TreeNode>q=new LinkedList<>();
        TreeNode root=new TreeNode(rootvalue);
        q.offer(root);
         int i=1;
        int n=levelorder.length;
        while(i<n){
            TreeNode current=q.poll();
            if(i<n && levelorder[i]!=-1){
                current.left=new TreeNode(levelorder[i]);
                q.offer(current.left);
            }
            i++;
            if(i<n && levelorder[i]!=-1){
                current.right=new TreeNode(levelorder[i]);
                q.offer(current.right);
            }
            i++;
        }
        return root;
    }
    public void printBoundary(TreeNode root,List<Integer>a){
        
        if(root==null) return ;
        a.add(root.val);
        findleft(root.left,a);
        leaves(root,a);
        findright(root.right,a);
    }
    public void leaves(TreeNode root,List<Integer>a){
        if(root==null) return;
        if(root.left!=null && root.right==null) a.add(root.val);
        leaves(root.left,a);
        leaves(root.right,a);
    }
    public void findleft(TreeNode root,List<Integer>a){
        if(root==null ||(root.left==null && root.right==null)) return;
        a.add(root.val);
        if(root.left!=null){
        findleft(root.left,a);
        }
        if(root.right!=null){
            findleft(root.right,a);
            
        }
        
        
    }
    public void findright(TreeNode root,List<Integer> a){
        if(root==null ||(root.left==null && root.right==null) ) return;
        if(root.right!=null){
            findright(root.right,a);
        }
        if(root.left!=null){
            findright(root.left,a);
        }
        a.add(root.val);
        
    }
}
class Solution{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String s[]=sc.nextLine().split(" ");
        int n=s.length;
        int a[]=new int[n];
        for(int i=0;i<n;i++){
            a[i]=Integer.parseInt(s[i]);
        }
        TreeBuilder tree=new TreeBuilder();
        TreeNode root=tree.buildTree(a);
        List<Integer>res=new ArrayList<>();
        tree.printBoundary(root,res);
        System.out.println(res);
    }
    
}
