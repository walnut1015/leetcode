package basic_algorithms;

import offer.TreeNode;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public void preOrderVisit(TreeNode root) {
        //实现对一个树的先序遍历
        TreeNode cur = root;
        TreeNode[] stack = new TreeNode[124];
        int index = -1;
        while (cur != null || index > -1) {
            while (cur != null) {
                stack[++index] = cur;
                System.out.println(cur);
                cur = cur.left;
            }
            if (index > -1) {
                TreeNode temp = stack[index--];
                cur = temp.right;
            }
        }
    }

    /**
     * 实现对一个树的中遍历
     */
    public void indOrderVisit(TreeNode root) {
        if (root == null){
            return;
        }
        TreeNode[] stack = new TreeNode[124];
        int index = -1;
        TreeNode cur = null;
        cur = root;
        while (cur != null || index > -1) {
            while (cur != null) {
                stack[++index] = cur;
                cur = cur.left;
            }
            if (index > -1) {
                TreeNode temp = stack[index--];
                System.out.println(temp);
                //if(temp.right!=null)
                cur = temp.right;
            }
        }
    }

    public void postOrderVisit_1(TreeNode root) {
        if (root == null){
            return;
        }
        TreeNode[] stack = new TreeNode[124];
        int index = -1;
        TreeNode cur = null;
        cur = root;
        while (cur != null || index > -1) {
            while (cur != null) {
                cur.isFirst = true;
                stack[++index] = cur;
                cur = cur.left;
            }
            if (index > -1) {
                TreeNode temp = stack[index];
                if (temp.isFirst) {
                    temp.isFirst = false;
                    cur = temp.right;
                } else {
                    System.out.println(stack[index--]);
                    cur = null;
                }
            }
        }
    }

    public void postOrderVisit2(TreeNode root) {
        if (root == null){
            return;
        }
        TreeNode[] stack = new TreeNode[124];
        int index = -1;
        TreeNode cur = null;
        cur = root;

        while (cur != null || index > -1) {
            while (cur != null) {
                cur.isFirst = true;
                stack[++index] = cur;
                cur = cur.left;
            }
            if (index > -1) {

            }
        }
    }
    public static int[] leastSteps;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int destination = scanner.nextInt();
        leastSteps = new int[destination*2];
        Arrays.fill(leastSteps,Integer.MAX_VALUE);
        leastSteps[0] = 0;
        leastSteps[1] = 1;
        leastSteps[2] = 2;
        for(int i = 1;i<2*destination;i++){
            leastSteps(leastSteps[i],i,destination);
        }
        System.out.println(leastSteps[destination]);
    }
    static private int leastSteps(int curSteps, int curPos, int destination){
        int minStep = Integer.MAX_VALUE;;
        if(curPos>=2*destination && curPos < 0)
            minStep = Integer.MAX_VALUE;
        else if(curPos == destination)
            return 0;
        else{
            if(curPos>0 && leastSteps[curPos-1] >= curSteps+1){
                leastSteps[curPos-1] = curSteps+1;
                minStep = Math.min(minStep,leastSteps(curSteps+1,curPos-1,destination));
            }
            if(curPos<destination*2-1 && leastSteps[curPos+1] >= curSteps+1){
                leastSteps[curPos+1] = curSteps+1;
                minStep = Math.min(minStep,leastSteps(curSteps+1,curPos+1,destination));
            }
            if(curPos<destination && leastSteps[curPos*2] >= curSteps+1){
                leastSteps[curPos*2] = curSteps+1;
                minStep = Math.min(minStep,leastSteps(curSteps+1,curPos*2,destination));
            }
        }
        return  minStep;
    }
    static private int min(int a, int b, int c){
        int min = a;
        if(min<b){
            min = b;
        }
        if(min<c){
            min = c;
        }
        return min;
    }
    private boolean isVertical(int x1,int y1, int x2, int y2, int x3,int y3)
    {
        if((x2-x1)*(x3-x1)+(y2-y1)*(y3-y1)==0) {
            if ((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1) == (x3 - x1) * (x3 - x1) + (y3 - y1) * (y3 - y1)) {
                return true;
            }
        }
        if((x1-x2)*(x3-x2)+(y1-y2)*(y3-y2)==0) {
            if ((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2) == (x3 - x2) * (x3 - x2) + (y3 - y2) * (y3 - y2)) {
                return true;
            }
        }
        if((x2-x3)*(x1-x3)+(y2-y3)*(y1-y3)==0) {
            if ((x2 - x3) * (x2 - x3) + (y2 - y3) * (y2 - y3) == (x1 - x3) * (x1 - x3) + (y1 - y3) * (y1 - y3)) {
                return true;
            }
        }
        return false;
    }
}
