package Test000_025;

import LeetCode000_025.ListNode;
import LeetCode000_025.Solution021;

/**
 * Created by Tanya on 2017/6/15.
 */
public class Test_021
{
    @org.junit.Test
    public void test()
    {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        Solution021 sol = new Solution021();
        sol.mergeTwoLists(l1,l2);
    }
}
