package LeetCode000_025;

/**
 * Created by Tanya on 2017/6/18.
 */
public class Solution025
{
    public ListNode reverseKGroup(ListNode head, int k)
    {
        if(head==null || k<2)
            return head;
        ListNode curNode = head;
        ListNode kthNode;// = null;//kthNode是长度为k的节点序列中的新的头部。
        ListNode prior;
        if((kthNode = longerThan(curNode, k))!=null) //在函数中给kthNode赋的值没有用啊。
        {
            ListNode temp = kthNode.next;
            reverseKNodes(curNode, k);
            curNode.next = temp;
            head = kthNode;
            prior = curNode;
            curNode = temp;

            while((kthNode = (longerThan(curNode, k)))!=null)
            {
                temp = kthNode.next;
                reverseKNodes(curNode, k);
                prior.next = kthNode;
                curNode.next = temp;

                prior = curNode;
                curNode = temp;
            }
        }
        return head;
    }
    private ListNode longerThan(ListNode node, int k)//直接在函数中改引用的指向地址是无效的，但是在引用中修改引用指向地址的对象的值，是可以的。
    {
        int len = 0;
        while(node != null)
        {
            len++;
            if(len==k)
            {
                return node;
            }
            node = node.next;
        }
        return null;
    }
    private void reverseKNodes(ListNode head, int k)
    {
        ListNode firstNode = head;
        ListNode secondNode = head.next;

        for(int i = 0;i<k-1;i++)
        {
            ListNode temp =secondNode.next;
            secondNode.next = firstNode;
            firstNode = secondNode;
            secondNode = temp;
        }
        //return firstNode; //返回长度为k的节点序列中的新的头部。
    }
    //他人的貌似更简洁的做法。
    public ListNode reverseKGroup2(ListNode head, int k)
    {
        if (head==null||head.next==null||k<2) return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode tail = dummy, prev = dummy,temp;
        int count;
        while(true)
        {
            count =k;
            while(count>0&&tail!=null)
            {
                count--;
                tail=tail.next;
            }
            if (tail==null) break;//Has reached the end


            head=prev.next;//for next cycle
            // prev-->temp-->...--->....--->tail-->....
            // Delete @temp and insert to the next position of @tail
            // prev-->...-->...-->tail-->head-->...
            // Assign @temp to the next node of @prev
            // prev-->temp-->...-->tail-->...-->...
            // Keep doing until @tail is the next node of @prev
            while(prev.next!=tail)
            {
                temp=prev.next;//Assign
                prev.next=temp.next;//Delete

                temp.next=tail.next;
                tail.next=temp;//Insert
            }
            tail=head;
            prev=head;
        }
        return dummy.next;

    }
}
