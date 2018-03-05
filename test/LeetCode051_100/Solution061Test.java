package LeetCode051_100;

import LeetCode000_025.ListNode;
import LeetCode000_025.Solution;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Tanya on 2017/10/10.
 */
public class Solution061Test {

    @Test
    public void testRotateRight() throws Exception {
        ListNode head = new ListNode(1);
        ListNode prior = head;
        for(int i = 2;i<=2;i++)
        {
            ListNode next = new ListNode(i);
            prior.next = next;
            next.next = null;
            prior = next;
        }
        Solution061 sol = new Solution061();
        ListNode res = sol.rotateRight(head, 0);
        System.out.println();
    }
}