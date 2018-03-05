package Test000_025;

import LeetCode000_025.ListNode;
import LeetCode000_025.Solution023;

/**
 * Created by Tanya on 2017/6/15.
 */
public class Test_023
{
    @org.junit.Test
    public void test()
    {
        ListNode[] lists = new ListNode[3];
        lists[0] = new ListNode(0);
        ListNode prior = lists[0];
        for(int i =1 ;i<16;i++)
        {
            prior.next = new ListNode(i*i);
            prior = prior.next;
        }
        lists[1] = new ListNode(0);
        prior = lists[1];
        for(int i =1 ;i<17;i++)
        {
            prior.next = new ListNode(i*15);
            prior = prior.next;
        }
        lists[1] = new ListNode(0);
        prior = lists[2];
        for(int i =1 ;i<20;i++)
        {
            prior.next = new ListNode(i*i*i);
            prior = prior.next;
        }

        Solution023 sol = new Solution023();
        ListNode ret = sol.mergeKLists(lists);
        System.out.println();
    }
}
