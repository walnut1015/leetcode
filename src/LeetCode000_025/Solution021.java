package LeetCode000_025;

/**
 * Created by Tanya on 2017/6/14.
 */
public class Solution021
{
    public ListNode mergeTwoLists(ListNode l1, ListNode l2)
    {
        if(l1==null ) return l2;
        else if(l2==null ) return l1;
        else if(l1.val<l2.val)
        {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        }
        else
        {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }

    }
    /*自己做的解决方案，不够简洁*/
    public ListNode mergeTwoLists2(ListNode l1, ListNode l2)
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
