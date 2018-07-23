package zuochengyun;
import offer.ListNode;
import offer.TreeNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;


/**
 * @author tanya
 * @date 2018/7/19 8:09
 */
public class Solution {
    public static ListNode ListNodePartition(ListNode head, int num){
        if(head==null){
            return head;
        }
        ListNode small = null, smallTail = null;
        ListNode mid = null, midTail = null;
        ListNode large = null, largeTail = null;
        ListNode next;
        while (head!=null){
            next = head.next;
            head.next = null;
            if(head.val<num){
                if(small == null){
                    small = head;
                    smallTail = head;
                }
                else {
                    smallTail.next = head;
                    smallTail = smallTail.next;
                }
            }
            if(head.val==num){
                if(mid == null){
                    mid = head;
                    midTail = head;
                }
                else {
                    midTail.next = head;
                    midTail = midTail.next;
                }
            }
            else{
                if(large == null){
                    large = head;
                    largeTail = head;
                }
                else {
                    largeTail.next = head;
                    largeTail = largeTail.next;
                }
            }
            head = next;
        }


        smallTail.next = mid;
        midTail.next = large;
        return small;
    }
    //用先序遍历的方式将二叉树序列化
    public String serializeBT(TreeNode head)
/**
 *  public TreeNode deSerializeBT(String str){
        String[] eles = str.split("!");
        if(eles.length==0){
            return null;
        }
        TreeNode head = new TreeNode(Integer.parseInt(eles[0]));
        LinkedList<TreeNode> stack = new LinkedList<>();
        stack.push(head);
        int index = 1;
        int len = eles.length;

        TreeNode p = null;
        while (!stack.isEmpty()){
            if (index<len && !eles[index].equals("#")){
                p = new TreeNode(Integer.parseInt(eles[index]));
                stack.peek().left = p;
                stack.push(p);
                index++;
            }
            //进入此语句块说明要么index==len，要么eles[index].equals("#") = true
            else{
                //如果当前到的是一个叶节点，则把叶节点pop
                if(index+1<len && !eles[index-1].equals("#")&& eles[index+1].equals("#")){
                    stack.pop();
                    index+=2;
                }
                if(!eles[index-1].equals("#") && !eles[index+1].equals("#")){
                    TreeNode temp = new TreeNode(Integer.parseInt(eles[++index]));
                    stack.pop().right = temp;
                    stack.push(temp);
                }
               else{
                    while (index<len && eles[index].equals("#")){
                        stack.pop();
                        index++;
                    }
                    if(index<len){
                        TreeNode temp = new TreeNode(Integer.parseInt(eles[index++]));
                        stack.pop().right = temp;
                        stack.push(temp);
                    }
                }
            }
        }

        return head;
    }*/
    public TreeNode deSerializeBT(String str){
        Queue<String> queue = new LinkedList<>();
        LinkedList<TreeNode> stack = new LinkedList<>();
        String[] strs = str.split("!");
        for(String ele: strs){
            queue.offer(ele);
        }
        TreeNode head = new TreeNode(Integer.parseInt(queue.poll()));
        stack.push(head);
        TreeNode last = head;
        while (!stack.isEmpty()){
            if(last!=null){
                last = getNodeByString(queue.poll());
                stack.peek().left = last;
                if(last != null){
                    stack.push(last);
                }
            }
            else {
                last = getNodeByString(queue.poll());
                stack.pop().right = last;
                if(last!=null){
                    stack.push(last);
                }
            }
        }
        return head;
    }

    private TreeNode getNodeByString(String str){
        if(str.equals("#")) {
            return null;
        }
        else {
            return new TreeNode(Integer.parseInt(str));
        }
    }
}











