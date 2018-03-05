package LeetCode000_025;

import java.math.BigInteger;

/**
 * Created by Tanya on 2017/2/21.
 */
public class Solution002 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2)
    {
        if(l1 == null || l2 == null)
        {
            System.out.print("错误！输入的链表为空！");
            return null;
        }
        BigInteger num = getValFromList(l1).add(getValFromList(l2));
        ListNode resnode = new ListNode(0);
        setInt2List(num, resnode);
        return resnode;
    }
    private BigInteger getValFromList(ListNode l)
    {
        if(l == null)
            return BigInteger.valueOf(0);
        return getValFromList(l.next).multiply(BigInteger.valueOf(10)).add(BigInteger.valueOf(l.val));
    }
    private void setInt2List(BigInteger num, ListNode l)
    {
        BigInteger invnum = num;
        boolean flag = (invnum.equals(BigInteger.ZERO));
        while(!flag)
        {

            l.val = invnum.mod(BigInteger.valueOf(10)).intValue();
            invnum = invnum.divide(BigInteger.valueOf(10));
            //if(invnum.intValue()==0)  return;
            flag = invnum.equals(BigInteger.ZERO);
            if(flag)
                return;
            ListNode nextnode = new ListNode(0);
            l.next = nextnode;
            l = nextnode;
            flag = invnum.equals(BigInteger.ZERO);
        }
    }
    public  void mains(String[] args)
    {
        ListNode test;
        ListNode list1 = new ListNode(9);
        ListNode list2 = new ListNode(1);
        test = list1;
        for(int i = 0;i<90;i++)
        {
            test.next = new ListNode(0);
            test=test.next;
            test.val=9;
        }
        test = list1;
        while(test!=null)
        {
            System.out.print(test.val);
            test = test.next;
        }
        test = list2;
        while(test!=null)
        {
            System.out.print(test.val);
            test = test.next;
        }
        Solution002 s = new Solution002();
        ListNode reslist = s.addTwoNumbers(list1, list2);
        while(reslist!=null)
        {
            System.out.print(reslist.val);
            reslist = reslist.next;
        }

    }
}