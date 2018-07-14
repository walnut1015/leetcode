
package offer;

import java.util.LinkedList;

/**
 * class: TreeNode
 *
 * @author 刘天雅
 * @date 2018/03/13
 */
 public class TreeNode {
     public int val;
     public TreeNode left;
     public TreeNode right;
     public TreeNode(int x) { val = x; }
     public boolean isFirst = true;

    public void print()
     {
         System.out.print(val+" ");
         /*LinkedList<TreeNode> stack = new LinkedList<>();
         TreeNode node = this.left;
         stack.addLast(this.right);
         while (!stack.isEmpty())
         {

         }
         return null;//TODO:Delete*/

         if(this.left !=null)
             this.left.print();
         if(this.right!=null)
             this.right.print();
     }
 }
