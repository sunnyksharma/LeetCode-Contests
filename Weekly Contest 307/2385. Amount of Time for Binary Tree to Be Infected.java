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
class Solution {
    public int amountOfTime(TreeNode root, int start) {
        Pair ans = helper(root, 0, start, false);
        return ans.timeNeeded;
    }
    
    public Pair helper(TreeNode root, int level, int start, boolean flag){
        if(root == null) return new Pair(0,false,0);
        
        Pair left = helper(root.left, level+1, start, flag);
        Pair right = helper(root.right, level + 1, start, flag);
        if(root.val == start) {
            return new Pair(0, true, Math.max(left.timeNeeded, right.timeNeeded));
        }
        if(left.infected){
            return new Pair(left.level + 1, true, Math.max(left.timeNeeded,right.timeNeeded + left.level+1));
        } else if(right.infected){
            return new Pair(right.level + 1, true, Math.max(right.timeNeeded,left.timeNeeded + right.level+1));
        } else{
            return new Pair(0,false,Math.max(left.timeNeeded,right.timeNeeded)+1);
        }
    }
    
    public class Pair{
        int level;
        boolean infected;
        int timeNeeded;
        public Pair(int l, boolean i , int t){
            this.level = l;
            this.infected = i;
            this.timeNeeded = t;
        }
    }
}
