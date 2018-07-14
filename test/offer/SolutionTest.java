package offer;

import org.junit.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * class: SolutionTest
 *
 * @author 刘天雅
 * @date 2018/03/13
 */
public class SolutionTest {

    @Test
    public void reConstructBinaryTree()
    {
        Solution sol = new Solution();
//重建二叉树测试
        /*int[] pre = {1,2,4,7,3,5,6,8};
        int[] in = {4,7,2,1,5,3,8,6};
        sol.reConstructBinaryTree(pre, in).print();*/
//两个栈模拟队列
        /*for(int i = 0;i<10;i++)
            sol.push(i);
        for(int i = 0;i<10;i++)
            System.out.println(sol.pop());*/
        //int [] array = {3,4,5,1,2};
//旋转数组最小值
        /*int [] array = {2};
        System.out.println(sol.minNumberInRotateArray(array));*/
//斐波那契数列计算
        /*System.out.println(sol.Fibonacci(0));*/
//跳台阶计算
        /*double cur = System.currentTimeMillis();
        for(int i =10000;i<100000;i++)
        {
            sol.JumpFloor(i);
        }
        System.out.println("logn时间： "+(System.currentTimeMillis()-cur)/1000+"秒");
        cur = System.currentTimeMillis();
        for(int i =10000;i<100000;i++)
        {
            sol.Fibonacci(i);
        }
        System.out.println("n时间： "+(System.currentTimeMillis()-cur)/1000+"秒");*/
//矩形覆盖
        /*System.out.println(sol.JumpFloorII(4));*/
//int中1的个数
        /*System.out.println(sol.NumberOf1(1));*/
//幂次方
        /*for(double i =0;i<10;i++)
            for(int j = 0;j<10;j++)
                if(sol.Power(i,j)!=Math.pow(i,j))
                    System.out.println("wrong!"+i+"的"+j+"次方");
        System.out.println(sol.Power(2,-3));*/
//重排序
        /*int[] ints = {1,2,3,4,7,6};
        sol.reOrderArray(ints);*/
//判断一个二叉树是否被另一个二叉树所包含
        /*TreeNode root1 = new TreeNode(1);
        TreeNode cur = root1;
        cur.left = new TreeNode(2);
        cur.right = new TreeNode(3);
        cur.left.right = new TreeNode(4);
        cur.right.left = new TreeNode(5);
        cur.right.right = new TreeNode(6);
        TreeNode root2 = cur.left;
        root2.left = cur.left.left;
        root2.right = cur.right.right;
        System.out.println(sol.HasSubtree(root1,root2));*/
        //int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        //int[][] matrix = {{1,2,3}};
//顺时针打印矩阵的元素
        /*int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        ArrayList<Integer> res = sol.printMatrix(matrix);
        for(int i:res)
            System.out.println(i);*/
//根据栈压入顺序判断弹出顺序是否合法
        /*int[] push = {1,2,3,4,5};
        int[] pop = {4,3,5,1,2};
        System.out.println(sol.IsPopOrder(push,pop));*/
//层次从上到下从左到右打印二叉树
        /*TreeNode root1 = new TreeNode(1);
        TreeNode cur = root1;
        cur.left = new TreeNode(2);
        cur.right = new TreeNode(3);
        cur.left.right = new TreeNode(4);
        cur.right.left = new TreeNode(5);
        cur.right.right = new TreeNode(6);
        ArrayList<Integer> res = sol.PrintFromTopToBottom(root1);
        for(int e:res)
            System.out.println(e);*/
//判断数组是不是BST后序遍历的结果
        /*int[] postOrder= {1,4,3,2,6,7,10,9,5};
        System.out.println(sol.VerifySquenceOfBST(postOrder));*/
//在BST中寻找总和等于target的路径
        /*TreeNode root1 = new TreeNode(1);
        TreeNode cur = root1;
        cur.left = new TreeNode(2);
        cur.right = new TreeNode(3);
        cur.left.right = new TreeNode(4);
        cur.right.left = new TreeNode(5);
        cur.right.right = new TreeNode(6);
        ArrayList<ArrayList<Integer>> res = sol.FindPath(root1,1);
            System.out.println(res);*/
//复制复杂链表
        /*RandomListNode root= new RandomListNode(1);
        root.random = root;
        root.next = new RandomListNode(2);
        root.next.random = root;
        root.next.next = new RandomListNode(3);
        root.next.next.next = null;
        root.next.next.random = root.next;
        RandomListNode res = sol.Clone(root);
        System.out.println();*/
//将BST转换成有序的双向链表
        /*TreeNode root1 = new TreeNode(10);
        TreeNode cur = root1;
        cur.left = new TreeNode(6);
        cur.right = new TreeNode(14);
        cur.left.left = new TreeNode(4);
        cur.left.right = new TreeNode(8);
        cur.right.left = new TreeNode(12);
        cur.right.right = new TreeNode(16);
        TreeNode res = sol.Convert(root1);
        System.out.println();*/
//输出字符串的所有字典序组合
        /*String str = "abc";
        ArrayList<String>res = sol.Permutation(str);
        for(String str2:res){
            System.out.println(str2);
        }*/
//输出数组的个数多余一般的数字
        /*int[] nums = {1,2,3,2,2,2,5,4,2};
        System.out.println(sol.MoreThanHalfNum_Solution(nums));*/
//输出数组中的k个最小数
        /*int[] nums = {4,5,1,6,2,7,3,8};
        ArrayList<Integer> res = sol.GetLeastNumbers_Solution(nums,8);
        for(int a:res)
            System.out.println(a);*/
        int[] nums = {6,-3,-2,7,-15,1,2,2};
        System.out.println(sol.FindGreatestSumOfSubArray(nums));
    }
}