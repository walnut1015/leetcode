package LeetCode000_025;

/**
 * Created by Tanya on 2017/6/15.
 *维护一个表示前一个当前节点的cur，以及一个表示当前结点上一个节点的prior。
 */
public class Solution024
{
    public ListNode swapPairs(ListNode head)
    {
        if(head==null || head.next==null)
            return head;
        ListNode newHead = head.next;
        head.next = head.next.next;
        newHead.next = head;
        ListNode cur = head.next;
        ListNode prior = head;
        while(prior.next!= null) //仅当接下来还剩至少两个非空node时，才继续处理。
        {
            if(prior.next.next==null)//若把这个判断写在while判断里面，则会引发空指针Exception
                break;
            cur = prior.next;
            swap2Nodes(prior, cur, cur.next);
            prior = cur;
        }
        return newHead;
    }
    private void swap2Nodes(ListNode prior, ListNode left, ListNode right)
    {
        left.next = right.next;
        right.next = left;
        prior.next = right;
    }
}
