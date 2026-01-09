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
    private class NodeDepth{
        TreeNode node;
        int depth;
        NodeDepth(TreeNode node,int depth){
            this.node=node;
            this.depth=depth;
        }
    }
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        return dfs(root).node;
    }
    private NodeDepth dfs(TreeNode node){
        if(node==null) return new NodeDepth(null,0);
        NodeDepth lres=dfs(node.left);
        NodeDepth rres=dfs(node.right);
        if(lres.depth>rres.depth){
            return new NodeDepth(lres.node,lres.depth+1);
        }else if(rres.depth>lres.depth){
            return new NodeDepth(rres.node,rres.depth+1);
        }else{
            return new NodeDepth(node,lres.depth+1);
        }
    }
}