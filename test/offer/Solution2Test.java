package offer;

import org.junit.Before;
import org.junit.Test;

import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import static org.junit.Assert.*;

/**
 * @auther tanya
 * @date 2018/4/19 21:07
 */
public class Solution2Test {
    Solution2 sol;
    @Before
    public void init(){
        sol = new Solution2();
    }
    @Test
    public void printMinNumber() {
        int[] nums = {3,32,321};
        System.out.println(sol.PrintMinNumber(nums));
    }
    @Test
    public void GetPrimeNumber_Solution() {
        for(int i = 1;i <= 10;i++) {
            System.out.println(sol.GetPrimeNumber_Solution(i));
        }
    }
    @Test
    public void GetUglyNumber_Solution() {
        for(int i = 1;i <= 10;i++) {
            System.out.println(sol.GetUglyNumber_Solution(i));
        }
    }

    @Test
    public void FirstNotRepeatingChar() {
        //String str = "abOabp";
        String str = "google";
        System.out.println( sol.FirstNotRepeatingChar(str));
    }
    @Test
    public void InversePairs() {
        /*int[] ints = {8,	6,	1,	7,	5	};
        System.out.println(sol.InversePairs(ints));*/
        for(int i = 0;i<=10;i++){
            int[] ints = new int[5];
            Random rand = new Random();
            ints[0] = rand.nextInt(10);
            ints[1] = rand.nextInt(10);
            ints[2] = rand.nextInt(10);
            ints[3] = rand.nextInt(10);
            ints[4] = rand.nextInt(10);
            int[] ints2 = Arrays.copyOfRange(ints, 0,5);
            int[] ints3 = Arrays.copyOfRange(ints, 0,5);
            int correct = inversePairs2(ints), wrong = sol.InversePairs(ints2);
            if(correct!=wrong){
                System.out.print("错误，正确答案为"+correct+" 错误答案为"+wrong+" ，输入为： ");
                for(int k:ints3){
                    System.out.print(k+"\t");
                }
                System.out.println();
            }
        }
    }
    public int inversePairs2(int[] nums){
        int res = 0;
        for(int i = 0;i<nums.length-1;i++){
            for(int j = i+1;j<nums.length;j++){
                if(nums[i]>nums[j]){
                    res++;
                }
            }
        }
        return res;
    }

    @Test
    public void FindFirstCommonNode(){
        ListNode node = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(5);
        ListNode node5 = new ListNode(4);
        node.next = node2;
        node2.next = node3;
        node3.next = node4;
        node5.next = node4;
        System.out.println(sol.FindFirstCommonNode(node, node5));
    }

    @Test
    public void GetNumberOfK(){
        int[] ints = {1,2,2,2,3,5};
        System.out.println(sol.mybinarySearch(ints, 2));
        //System.out.println(sol.GetNumberOfK(ints, 2));
    }

    @Test
    public void FindContinuousSequence(){

        ArrayList<ArrayList<Integer>> res = sol.FindContinuousSequence(200);
        for(ArrayList<Integer> list :res){
            for(int ele:list){
                System.out.printf(ele+"\t");
            }
            System.out.println();
        }
        //System.out.println(sol.GetNumberOfK(ints, 2));
    }

    @Test
    public void FindNumbersWithSum(){
        int[] nums = {5,7,9,11,17};
        System.out.println(sol.FindNumbersWithSum(nums, 16));
    }

    @Test
    public void LeftRotateString(){
        System.out.println(sol.LeftRotateString("abcXYZdef", 3));
    }

    @Test
    public void ReverseSentence(){
        System.out.println(sol.ReverseSentence(" "));
    }

    @Test
    public void isContinuous(){
        int[] nums = {1,3,0,0,5};
        System.out.println(sol.isContinuous(nums));
    }

    @Test
    public void LastRemaining_Solution(){
        System.out.println(sol.LastRemaining_Solution(5,3));
    }

    @Test
    public void Sum_Solution(){
        System.out.println(sol.Sum_Solution(3));
    }
    @Test
    public void Add(){
        Random rand = new Random();
        for(int i = 0;i<10;i++){
            int a = rand.nextInt();
            int b = rand.nextInt();
            int res = sol.Add(a,b);
            if(res != a+b){
                System.out.println("错误！"+a+"+"+b+"="+res+"===>正确："+(a+b));
            }
        }
    }
    @Test
    public void StrToInt()
    {
        Random rand = new Random();
        for(int i = 0;i<10;i++){
            int num = rand.nextInt();
            String a = num+"";
            int res = sol.StrToInt(a);
            if(res != num){
                System.out.println("错误！"+res+" != "+num);
            }
        }
    }
    @Test
    public void duplicate(){
        int[] a = {2,3,1,0,2,5,3};
        int[] dup = new int[7];
        System.out.println(sol.duplicate(a,7,dup));
        System.out.println();
    }
    @Test
    public void match(){
        System.out.println(sol.match("aaba".toCharArray(),"ab*a*c*a".toCharArray()));
    }

    @Test
    public void deleteDuplication(){
        ListNode a = new ListNode(1);
        ListNode fhead = a;
        a.next = new ListNode(1);
        a = a.next;
        a.next = new ListNode(3);
        a = a.next;
        a.next = new ListNode(3);
        a = a.next;
        a.next = new ListNode(4);
        a = a.next;
        a.next = new ListNode(4);
        a = a.next;
        a.next = new ListNode(5);
        a = a.next;
        ListNode head = sol.deleteDuplication(fhead);
        System.out.println();
    }
    @Test
    public void GetNext(){
        TreeLinkNode root = new TreeLinkNode(5);
        TreeLinkNode four = new TreeLinkNode(4);
        TreeLinkNode three = new TreeLinkNode(3);
        TreeLinkNode two = new TreeLinkNode(2);
        root.left = four;
        four.next = root;
        four.right = three;
        three.next = four;
        three.right = two;
        two.next = three;
        TreeLinkNode next = sol.GetNext(root);

    }
    @Test
    public void Print(){
        TreeNode one = new TreeNode(8);
        TreeNode two = new TreeNode(6);
        TreeNode three = new TreeNode(10);
        TreeNode four = new TreeNode(5);
        TreeNode five = new TreeNode(7);
        TreeNode six = new TreeNode(9);
        TreeNode seven = new TreeNode(11);
        one.left = two;
        one.right = three;
        two.left = four;
        two.right = five;
        three.left = six;
        three.right = seven;
        //String serializedStr = sol.Serialize(one);
        //TreeNode res = sol.Deserialize(serializedStr);
        //ArrayList<ArrayList<Integer>> res = sol.Print(one);
        TreeNode res = sol.KthNode(one,3);
        System.out.println();
    }
    @Test
    public void maxInWindows(){
        int[] ints ={2,3,4,2,6,2,5,1};
        System.out.println(sol.maxInWindows(ints,3));
    }
    @Test
    public void hasPath(){
        /*char[] matrix = {'a','b','c','e'
                        ,'s','f','c','s'
                        ,'a','d','e','e'};*/
/*        char[] matrix = "A".toCharArray();
        char[] str = "A".toCharArray();
        System.out.println(sol.hasPath(matrix,1,1,str));*/
        try {
            InputStreamReader br = new InputStreamReader(new FileInputStream(new File("C:\\Users\\Tanya\\Desktop\\后续问题.txt")),"UTF-8");
            int buffer;
            while ((buffer = br.read())!=-1){

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}