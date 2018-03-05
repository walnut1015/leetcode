package LeetCode000_025;

/**
 * Created by Tanya on 2017/6/15.
 */
public class Solution023
{
    public ListNode mergeKLists(ListNode[] lists)
    {
        if(lists==null || lists.length==0)
            return null;
        int len = lists.length;
        if(len==1)
            return lists[0];
        ListNode[] res;
        if(len%2==0)
        {
            res = new ListNode[len/2];
            for(int i =0;i<len/2;i++)
            {
                res[i]=merge2Lists(lists[2*i],lists[2*i+1]);
            }
        }
        else
        {
            res = new ListNode[len/2+1];
            for(int i =0;i<len/2;i++)
            {
                res[i]=merge2Lists(lists[2*i],lists[2*i+1]);
            }
            res[len/2] = lists[lists.length-1];
        }
        return  mergeKLists(res);
    }
    public ListNode merge2Lists(ListNode l1, ListNode l2)
    {
        ListNode ret,prior;
        ListNode pl1 = l1;
        ListNode pl2 = l2;
        if(pl1 ==null && pl2==null) return null;
        if(pl1!= null && pl2!=null)
        {
            if(pl1.val<pl2.val)
            {
                ret = pl1;
                pl1 = pl1.next;
            }
            else
            {
                ret = pl2;
                pl2 = pl2.next;
            }
        }
        else if(pl1!= null)
        {
            ret = pl1;
            pl1 = pl1.next;
        }
        else
        {
            ret = pl2;
            pl2 = pl2.next;
        }
        prior = ret;

        while(pl1!=null && pl2!=null)
        {
            if(pl1.val<pl2.val)
            {
                prior.next = pl1;
                pl1 = pl1.next;
            }
            else
            {
                prior.next = pl2;
                pl2 = pl2.next;
            }

            prior = prior.next;
        }
        if(pl1!= null)
        {
            prior.next = pl1;
        }
        else if(pl2!=null)
        {
            prior.next = pl2;
        }
        return ret;
    }
}
