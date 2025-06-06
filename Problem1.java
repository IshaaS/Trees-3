// Time Complexity : O(n*h)
// Space Complexity : O(n*h)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
//deep copy of list as list is datastructure of datastructure thus we cannot pass same reference every time
// whenever sum is equal to taregt add the path
//sum should be local
class Solution {
    List<List<Integer>> result;
    int target;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        this.target=targetSum;
        this.result=new ArrayList<>();
        helper(root,0,new ArrayList<>());
        return result;
    }
    private void helper(TreeNode root, int currentSum, List<Integer> path){
        //base
        if(root==null) return;
        //logic
        currentSum+=root.val;
        path.add(root.val);
        if(root.left==null && root.right==null){
            if(currentSum==target){
                result.add(path);
            }
        }
        helper(root.left, currentSum, new ArrayList<>(path));
        helper(root.right, currentSum, new ArrayList<>(path));
    }
}

// Time Complexity :O(n)
// Space Complexity :O(n*h)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach
//backtrack, every time we check left and right of a node, we remove the node from the path.
// 
class Solution {
    List<List<Integer>> result;
    int target;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        this.target=targetSum;
        this.result=new ArrayList<>();
        helper(root,0,new ArrayList<>());
        return result;
    }
    private void helper(TreeNode root, int currentSum, List<Integer> path){
        //base
        if(root==null) return;
        //logic
        currentSum+=root.val;
        path.add(root.val);
        if(root.left==null && root.right==null){
            if(currentSum==target){
                result.add(new ArrayList<>(path));
            }
        }
        //recursion
        helper(root.left, currentSum, path);
        helper(root.right, currentSum, path);
        //backtrack
        path.remove(path.size()-1);
    }
}