package zuochengyun;

import offer.ListNode;
import offer.TreeNode;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author tanya
 * @date 2018/7/20 16:36
 */
public class BST2LinkedListTest {

    @Test
    public void convert() {
        BST2LinkedList bll = new BST2LinkedList();
        TreeNode head = new TreeNode(6);
        head.left = new TreeNode(4);
        head.right = new TreeNode(7);
        head.left.left = new TreeNode(2);
        head.left.right = new TreeNode(5);
        head.left.left.left = new TreeNode(1);
        head.left.left.right = new TreeNode(3);
        head.right.right=new TreeNode(9);
        head.right.right.left=new TreeNode(8);

        ListNode res = bll.convert(head);
        ListNode pre = null;
        while (res!=null){
            System.out.printf(res.val+"\t");
            pre = res;
            res = res.next;
        }

        while (pre!=null){
            System.out.printf(pre.val+"\t");
            pre = pre.last;
        }
        System.out.println();
    }
}