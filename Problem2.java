// Time Complexity : O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach
//used dfs with checking lst's left child wiht rst's right and visa versa.
//if nodes dont match return false else return true.

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

//recursion but with my logic
class Solution {
    public boolean isSymmetric(TreeNode root) {
        
        if(root.left==null && root.right==null) return true;
        else {if (root.left !=null && root.right!= null && root.left.val==root.right.val) return helper(root.left, root.right);
        else return false;
        }
    }
    private boolean helper(TreeNode lst, TreeNode rst){
        boolean sym1=false;
        boolean sym2=false;
        if(lst.left==null && lst.right==null && rst.left==null && rst.left==null) return true;
        if(lst.left==null && rst.right ==null) sym1=true;
        else if(lst.left!=null && rst.right!=null && lst.left.val == rst.right.val){
            sym1=helper(lst.left, rst.right);
        }
        if(rst.left==null && lst.right ==null) sym2=true;
        else if(rst.left!=null && lst.right!=null &&  lst.right.val == rst.left.val){
            sym2 = helper(lst.right, rst.left);
        }
        return sym1 && sym2;
    }
}
//easy logic recursion
// class Solution {
//     public boolean isSymmetric(TreeNode root) {
//         return helper(root,root);
//     }
//     private boolean helper(TreeNode lst, TreeNode rst){
//         if(lst==null && rst==null) return true;
//         if(lst==null || rst ==null) return false;
//         return lst.val==rst.val && helper(lst.left, rst.right) && helper(lst.right, rst.left);
//     }
// }
//iterative
// class Solution {
//     public boolean isSymmetric(TreeNode root) {
//         Stack<TreeNode> st = new Stack<>();
//         st.push(root);
//         st.push(root);
//         while(!st.isEmpty()){
//            TreeNode t1= st.pop();
//            TreeNode t2=st.pop(); 
//            if(t1==null && t2==null) continue;
//            if(t1==null || t2 ==null) return false;
//            if(t1.val != t2.val) return false;
//            st.push(t1.left);
//            st.push(t2.right);
//            st.push(t1.right);
//            st.push(t2.left);
//         }
//         return true;
//     }
// }