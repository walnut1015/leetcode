package zuochengyun;

import offer.TreeNode;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author tanya
 * @date 2018/7/21 17:07
 */
public class SolutionTest {
    private Solution sol = new Solution();

    @Test
    public void serializeBT() {
        TreeNode head = new TreeNode(6);
        head.left = new TreeNode(4);
        head.right = new TreeNode(7);
        head.left.left = new TreeNode(2);
        head.left.right = new TreeNode(5);
        head.left.left.left = new TreeNode(1);
        head.left.left.right = new TreeNode(3);
        head.right.right=new TreeNode(9);
        head.right.right.left=new TreeNode(8);
        //System.out.println(sol.serializeBT(head));
        sol.deSerializeBT(sol.serializeBT(head));
    }
}