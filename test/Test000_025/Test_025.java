package Test000_025;

import LeetCode000_025.ListNode;
import LeetCode000_025.Solution025;

/**
 * Created by Tanya on 2017/6/18.
 */
public class Test_025 {
    @org.junit.Test
    public void test()
    {
        ListNode head = new ListNode(0);
        ListNode prior = head;
        for(int i =1 ;i<16;i++)
        {
            prior.next = new ListNode(i);
            prior = prior.next;
        }
        Solution025 sol = new Solution025();
        ListNode res = sol.reverseKGroup(head,3);
        System.out.println();
    }
}
