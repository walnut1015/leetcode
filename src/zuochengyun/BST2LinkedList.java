package zuochengyun;

import offer.ListNode;
import offer.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * @author tanya
 * @date 2018/7/20 16:25
 */
public class BST2LinkedList {
    public ListNode convert(TreeNode root){
        TreeNode p = root;
        LinkedList<TreeNode> stack = new LinkedList<>();
        ListNode head = null, cur = null;
        while(p!=null || !stack.isEmpty()){
            if(p!=null){
                System.out.println(p.val);
                stack.push(p);
                p = p.left;
            }
            else {
                p = stack.pop();
                /*if(head==null){
                    head = new ListNode(p.val);
                    cur = head;
                }
                else {
                    cur.next = new ListNode(p.val);
                    cur = cur.next;
                }*/
                p = p.right;
            }
        }
        ListNode pre = null;
        cur = head;
        while(cur!=null){
            cur.last = pre;
            pre = cur;
            cur = cur.next;
        }
        return head;
    }
}
