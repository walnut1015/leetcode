package LeetCode000_025;

/**
 * Created by Tanya on 2017/6/11.
 */
public class Solution019
{
    public ListNode removeNthFromEnd(ListNode head, int n)
    {
        ListNode cur = head;
        int len = 0;
        while(cur!=null)
        {
            cur = cur.next;
            len++;
        }
        if(len<n)
            return null;
        if(len == n)
            return head.next;
        cur = head;
        for(int i =0;i<len-n-1;i++)
        {
            cur = cur.next;
        }
        cur.next = cur.next.next;
        return  head;
    }
}
