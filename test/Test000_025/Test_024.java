package Test000_025;

import LeetCode000_025.ListNode;
import LeetCode000_025.Solution024;

/**
 * Created by Tanya on 2017/6/16.
 */
public class Test_024
{
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
        Solution024 sol = new Solution024();
        ListNode res = sol.swapPairs(head);
        System.out.println();
    }
}
