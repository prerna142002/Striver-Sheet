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

    // root left right
    
    TreeNode solve(int[] preorder, int start, int end){
        if(start>end) return null;
        int rootVal = preorder[start];
        TreeNode node = new TreeNode(rootVal);
        int i=start+1;
        for(;i<=end;i++){
            if(preorder[i]>rootVal) break;
        }
        node.left = solve(preorder,start+1,i-1);
        node.right = solve(preorder,i,end);
        return node;
    }

    public TreeNode bstFromPreorder(int[] preorder) {
        return solve(preorder,0,preorder.length-1);
    }
}
