package LeetCode051_100;

import LeetCode000_025.ListNode;

/**
 * Created by Tanya on 2017/10/10.
 */
public class Solution061
{
    public ListNode rotateRight(ListNode head, int k)
    {
        if(head==null || head.next==null )
            return head;
        int len = 1;
        ListNode node1 = head;
        for(;node1.next!=null;node1=node1.next)
            len++;
        //node1.next=head;一个错误的地方，把没有尽头的list返回给了OJ，结果导致内存不够以及超时，哈哈哈哈。
        if(k%len==0)
            return head;
        node1.next=head;
        ListNode priorNode = head;
        for(int i = 1;i< len-k%len ;i++)
            priorNode = priorNode.next;
        ListNode newHead = priorNode.next;
        priorNode.next=null;

        return newHead;

    }
}
