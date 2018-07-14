package offer;


import Other.hashcode.Entry;
import sun.reflect.generics.tree.Tree;

import java.lang.reflect.Array;
import java.util.*;

/**
 * class: Solution
 *
 * @author 刘天雅
 * @date 2018/03/13
 */
public class Solution {
    //=======根据先序中序数组重建二叉树=========//
    int[] pre;
    int[] in;

    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        this.pre = pre;
        this.in = in;
        if (!(pre.length > 0 && in.length > 0))
            return null;
        int headIndex = 0;
        int i = 0;
        for (i = 0; i < in.length; i++)
            if (in[i] == pre[0]) {
                headIndex = in[i];
                break;
            }
        TreeNode head = new TreeNode(headIndex);
        reconstructNextNode(head, 0, i, 0, in.length - 1);
        return head;
    }

    private void reconstructNextNode(TreeNode node, int preHeadIndex, int inHeadIndex, int start, int end) {
        if (start < inHeadIndex) {
            int temp = pre[preHeadIndex + 1];
            node.left = new TreeNode(temp);
            for (int i = start; i < inHeadIndex; i++)
                if (temp == in[i]) {
                    reconstructNextNode(node.left, preHeadIndex + 1, i, start, inHeadIndex - 1);
                    break;
                }
        }
        if (end > inHeadIndex) {
            int temp = pre[inHeadIndex - start + 1 + preHeadIndex];
            node.right = new TreeNode(temp);
            for (int i = inHeadIndex + 1; i <= end; i++)
                if (temp == in[i]) {
                    reconstructNextNode(node.right, inHeadIndex - start + 1 + preHeadIndex, i, inHeadIndex + 1, end);
                    break;
                }
        }
    }

    //========两个栈模拟队列=======//
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();
    private Stack<Integer> forPush = stack1;
    private Stack<Integer> forPop = stack2;
    private boolean pushed = true;

    public void push2(int node) {
        if (pushed == false) {
            while (!forPop.isEmpty())
                forPush.push(forPop.pop());
            forPush.push(node);
            pushed = true;
        } else
            forPush.push(node);
    }

    public int pop2() {
        int res;
        if (pushed) {
            while (!forPush.empty()) {
                forPop.push(forPush.pop());
            }
            res = forPop.pop();
            pushed = false;
        } else
            res = forPop.pop();
        return res;
    }

//========在旋转数组中寻找最小的数字=======//
    //没有考虑到数组中有重复数字的情况
        /*public int minNumberInRotateArray(int [] array) {
        int len = array.length;
        if(array == null ||len == 0)
            return 0;
        if(len == 1)
            return array[0];
        int start = 0,end = len;
        int mid;
        while (start < end)
        {
            mid = (start+end)/2;
            int left = 0,right=0;
            boolean flagLeft=true,flagRight=true;
            //if(array[mid]<array[(mid+1)%len] && array[mid]<array[(mid-1+len)%len])
            //    return array[mid];
            for(int i = mid+1;(i<len)||(i)%len<mid;i++)
                if(array[(i)%len]!=array[mid])
                {
                    right = (i)%len;
                    flagRight = false;
                }
            for(int i = mid-1;i>-1||(i+len)%len>mid;i--)
                if(array[(i+len)%len]!=array[mid])
                {
                    left = (i+len)%len;
                    flagLeft = false;
                }
            if(array[mid]<array[left] && array[mid]<array[right])
                return array[mid];
            else if(flagLeft && flagRight)
                return array[mid];
            else if(array[mid]<=array[len-1])
                end = mid;
            else
                start = mid+1;
        }
    return 0;
    }*/
//========斐波那契数列=======//
    public int Fibonacci(int n) {
        int pre = 0;
        int cur =1;
        if(n==0)
            return 0;
        if(n==1)
            return cur;
        for(int i = 2;i<=n;i++)
        {
            int temp = cur;
            cur+=pre;
            pre = temp;
        }
        return cur;
    }
//========跳梯子=======//
//使用矩阵幂次方，减少时间复杂度到logn.
    public int JumpFloor(int target) {
        target++;
        if(target==0)
            return 0;
        if(target==1)
            return 1;
        int[][] eles = {{2, 1}, {1, 1}};
        int[][] powerRes;
        powerRes = matrixPower(eles, target/2);
        if (target % 2 == 0) {
            return powerRes[1][0];
        }
        else {
            return powerRes[0][0];
        }
    }

    private int[][] matrixPower(int[][] eles, int power) {
        if(power == 1)
            return eles;
        else{
            int[][] half = matrixPower(eles, power/2);//呼呼做的优化
            if(power%2==0){
                return matrixMultiply(half,half);
            }else{
                return matrixMultiply(eles,matrixMultiply(half,half));
            }
        }
    }

    private int[][] matrixMultiply(int[][] eles1, int[][] eles2)
    {
        int[][] powerRes = new int[2][2];
        /*powerRes[0] = new int[2];
        powerRes[1] = new int[2];*/
        powerRes[0][0] = eles1[0][0] * eles2[0][0] + eles1[0][1] * eles2[1][0];
        powerRes[0][1] = eles1[0][0] * eles2[0][1] + eles1[0][1] * eles2[1][1];
        powerRes[1][0] = eles1[1][0] * eles2[0][0] + eles1[1][1] * eles2[1][0];
        powerRes[1][1] = eles1[1][0] * eles2[0][1] + eles1[1][1] * eles2[1][1];
        return powerRes;
    }
//========变态跳梯子=======//
    //人可以选择一次跳（1~n）步
    public int JumpFloorII(int target) {
        if(target == 1)
            return 1;
        else
            return 1<<(target-1);
    }
//========矩形覆盖=======//
    public int RectCover(int target) {
        return Fibonacci(target);//Fibonacci中target==0时应该返回0，但是target=2时应该把target==0时按照返回为1对待
    }
//========二进制中1的个数=======//
    public int NumberOf1(int n) {
        int count = 0;
        int one = 1;
        for(int i = 0;i<32;i++)
            count += 1&(n>>i);
        return count;
    }
//========数值的整数次方=======//
    public double Power(double base, int exponent) {
        if(exponent<0)
            return 1.0/myPower(base,-1*exponent);
        else
            return myPower(base, exponent);
    }
    private double myPower(double base, int exponent)
    {
        if(base ==0)
            return 0;
        if(exponent==0 || base==1)
            return 1;
        if(exponent == 1)
            return base;
        if(base==2)
            return 1<<exponent;
        else {
            double temp = Power(base, exponent/2);
            if(exponent%2 !=0)
                return temp*temp*base;
            else
                return temp*temp;
        }
    }
//========调整数组顺序使奇数位于偶数前面=======//
    public void reOrderArray(int [] array) {
        if(array==null || array.length<2)
            return;
        int lastOdd = -1;
        for(int i = 0;i<array.length;i++)
        {
            if(array[i]%2 !=0 && i - lastOdd>=2){
                int temp = array[i];
                for(int j = i-1; j>lastOdd;j--)
                    array[j+1] = array[j];
                array[lastOdd+1] = temp;
                lastOdd = lastOdd+1;
            }
            else if(array[i]%2 !=0)
                lastOdd = i;
        }
    }
//========输出该链表中倒数第k个结点=======//
    public ListNode FindKthToTail(ListNode head,int k) {
        ListNode[] nodeStack = new ListNode[1024];
        int index = -1;
        ListNode node = head;
        while (node!=null){
            nodeStack[++index] = node;
            node = node.next;
        }
        if(k>index+1)
            return null;
        return nodeStack[index+1-k];
    }
//========反转链表后，输出链表的所有元素=======//
    public ListNode ReverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur!=null)
        {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
//========合并链表=======//
    public ListNode Merge(ListNode list1,ListNode list2) {
        if(list1 == null)
            return list2;
        if(list2==null)
            return list1;
        ListNode head,cur1 , cur2;
        if(list1.val<=list2.val){
            head = list1;
            cur1 = list1.next;
            cur2 = list2;
        }
        else {
            head = list2;
            cur1 = list1;
            cur2 = list2.next;
        }
        ListNode cur = head;
        while (cur1!=null && cur2!= null)
        {
            if(cur1.val<=cur2.val){
                cur.next = cur1;
                cur = cur1;
                cur1 = cur1.next;
            }
            else {
                cur.next = cur2;
                cur = cur2;
                cur2 = cur2.next;
            }
        }
        if(cur1!=null)
            cur.next = cur1;
        else
            cur.next = cur2;
        return head;
    }
//========判断B是不是A的子结构========//
    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        if(root1==null || root2==null)
            return false;
        TreeNode cur = root1;
        TreeNode[] stack = new TreeNode[124];
        int stackTop = -1;
        if(isContained(cur, root2))
            return true;
        while (cur!=null || stackTop>-1)
        {
            while(cur!=null){
                stack[++stackTop] = cur;
                if(isContained(cur,root2))
                    return true;
                cur = cur.left;
            }
            if(stackTop>-1){
                TreeNode temp = stack[stackTop--];
                cur = temp.right;
            }
        }
        return false;
    }
    //判断以root2为根节点的树是否包含在root1为根节点的树里面
    private boolean isContained(TreeNode root1,TreeNode root2){
        if(root2 == null)
            return true;
        if(root1 == null)
            return false;
        if(root1.val != root2.val )
            return false;
        else{
            return isContained(root1.left,root2.left)&&isContained(root1.right,root2.right);
        }
    }
    //========二叉树的镜像========//
    public void Mirror(TreeNode root) {
        if(root!=null)
        {
            TreeNode temp = root.left;
            root.left = root.right;
            root.right = temp;
            Mirror(root.left);
            Mirror(root.right);
        }
    }
    //========顺时针打印矩阵数字========//
    public ArrayList<Integer> printMatrix(int [][] matrix) {
        if(matrix == null || matrix.length==0 || matrix[0]==null|| matrix[0].length==0)
            return new ArrayList<>();
        int left = 0,right = matrix[0].length-1;
        int up = 0, down = matrix.length-1;
        ArrayList<Integer> res = new ArrayList<>();
        while (left<=right && up<=down) {
            //在第up行上从left到right读取矩阵上的数字，读罢up自增1
            int printIndex = left;
            if (printIndex <= right) {
                while (printIndex <= right)
                    res.add(matrix[up][printIndex++]);
                up++;
            }
            //在第right列上从up到down读取矩阵上的数字，读罢right自减1
            printIndex = up;
            if (left<=right && printIndex <= down) {
                while (printIndex <= down)
                    res.add(matrix[printIndex++][right]);
                right--;
            }
            //在第down行上从right到left读取矩阵上的数字，读罢down自减1
            printIndex = right;
            if (up<=down && printIndex >= left) {
                while (printIndex >= left)
                    res.add(matrix[down][printIndex--]);
                down--;
            }
            //在第left列上从down到up读取矩阵上的数字，读罢left自增1
            printIndex = down;
            if (left<=right && printIndex >= up) {
                while (printIndex >= up)
                    res.add(matrix[printIndex--][left]);
                left++;
            }
        }
        return res;
    }
    //========定义栈的数据结构，请在该类型中实现一个能够得到栈最小元素的min函数========//
    int capacity=1024;
    int size = 0;
    int[] eles = new int[capacity];
    public void push(int node) {
        if(size<capacity)
            eles[size++] = node;
        else
        {
            int[] elsTemp = eles;
            eles = new int[2*capacity];
            capacity *= 2;
            for (int i = 0;i<size;i++)
                eles[i] = elsTemp[i];
            eles[size++] = node;
        }
    }

    public void pop() {
        if(size==0)
            return;
        size--;
    }

    public int top() {
        if(size == 0)
            return -1;
        return eles[--size];

    }

    public int min() {
        if(size == 0)
            return -1;
        int min = eles[0];
        for(int i = 0;i<size;i++)
            if(eles[i]<min)
                min = eles[i];
        return min;
    }
    //========栈的压入、弹出顺序判断========//
    //主要的思想就是如果某些元素比a先入栈，且比a后出栈，那么这些元素一定会保持和入栈相反的相对顺序出栈
    public boolean IsPopOrder(int [] pushA,int [] popA) {
        if(pushA==null || popA == null)
            return false;
        if(!sameEles(pushA,popA))
            return false;
        int[] pushIndexes = new int[popA.length];
        int Index = 0;
        Arrays.fill(pushIndexes,Integer.MIN_VALUE);
        for(int i = 0;i<popA.length-1;i++){
            int pushIndex = indexOf(popA[i], pushA);
            /*if(pushIndex==-1)   //已经做过数组元素是否相同的检查了。
                return false;*/
            for(int j = i+1;j<popA.length;j++){
                int temp = indexOf(popA[j], pushA);
                if(temp<pushIndex)
                    pushIndexes[Index++] = temp;
            }
            if(Index>0 && !inDecendOrder(pushIndexes))
                return false;
            Arrays.fill(pushIndexes,Integer.MIN_VALUE);
            Index = 0;
        }
        return true;
    }
    private int indexOf(int ele, int[] array)
    {
        int res = -1;
        for(int i = 0;i<array.length;i++){
            if(array[i] == ele)
                res = i;
        }
        return res;
    }
    private boolean inDecendOrder(int[] array)
    {
        int pre = array[0];
        for(int i = 1;i<array.length && array[i]!=Integer.MIN_VALUE;i++)
        {
            if(pre>array[i])
                pre = array[i];
            else
                return false;
        }
        return true;
    }
    private boolean sameEles(int[]a,int[]b)
    {
        int[] aCopy = Arrays.copyOf(a,a.length);
        int[] bCopy = Arrays.copyOf(b,b.length);
        if(a.length!=b.length) return false;
        Arrays.sort(aCopy);//注意Arrays.sort()会改变数组内本身的值，所以应该copy一份再说
        Arrays.sort(bCopy);
        for(int i = 0;i<aCopy.length;i++)
            if(aCopy[i]!=bCopy[i])
                return false;
        return true;
    }
    //========打印出二叉树的每个节点，同层节点从左至右打印========//
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        TreeNode[] queue = new TreeNode[128];
        int head = 0; //left表示待取走元素的位置
        int tail = 0;  //tail表示待插入元素的位置
        ArrayList<Integer> res = new ArrayList<>();
        queue[tail++] = root;
        TreeNode cur;
        while (head<tail){
            cur = queue[head++];
            if(cur != null)
            {
                res.add(cur.val);
                queue[tail++] = cur.left;
                queue[tail++] = cur.right;
            }
        }
        return res;
    }
    //========判断整数数组是不是某二叉搜索树的后序遍历的结果========//
    public boolean VerifySquenceOfBST(int [] sequence) {
        if(sequence == null || sequence.length == 0)
            return false;
        int root = sequence[sequence.length-1];
        if(isSequenceOfBST(sequence, 0 ,sequence.length-1))
            return true;
        else
            return false;
    }
    private boolean isSequenceOfBST(int[]sequence, int start, int end)
    {
        if(start ==4)
            System.out.println();
        if(start>=end)
            return true;
        int root = sequence[end];
        int mid = -1;
        for(int i = start;i<end;i++){
            if(sequence[i]>root ) {
                if(mid == -1)
                    mid = i;
            }
            else if(mid!= -1)
                    return false;
        }
        if(mid == -1)
            return true;
        return isSequenceOfBST(sequence, start, mid-1) && isSequenceOfBST(sequence,mid,end-1);
    }
    //========二叉树中和为某一整数的路径========//
     public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
        if(root == null )
            return new ArrayList<>();
        ArrayList<ArrayList<Integer>> res = getAllSum(root);
         Iterator<ArrayList<Integer>> iterator = res.iterator();
         res.removeIf(temp->sumOfArrayList(temp)!=target);//非常简洁
         for(ArrayList<Integer> list:res)
             reverseArray(list);

         return res;
    }
    private ArrayList<ArrayList<Integer>> getAllSum(TreeNode root)
    {
        if(root!= null)
        {
            ArrayList<ArrayList<Integer>> res = new ArrayList<>();
            ArrayList<ArrayList<Integer>> leftRes = getAllSum(root.left);
            ArrayList<ArrayList<Integer>> rightRes = getAllSum(root.right);
            if(leftRes!=null){
                for(ArrayList<Integer> list:leftRes )
                {
                    list.add(root.val);
                    res.add(list);
                }
            }
            if(rightRes!=null) {
                for (ArrayList<Integer> list : rightRes) {
                    list.add(root.val);
                    res.add(list);
                }
            }
            if(rightRes==null && leftRes == null)
            {
                ArrayList<Integer> list = new ArrayList<>();
                list.add(root.val);
                res.add(list);
            }
            return res;
        }
        return null;
    }
    private int sumOfArrayList(ArrayList<Integer> list)
    {
        int res = 0;
        if(list!=null)
        {
            for(int e:list)
                res+=e;
        }
        return res;
    }
    private void reverseArray(ArrayList<Integer> list)
    {
        int len = list.size();
        for(int i = 0;i<len/2;i++)
        {
            int temp = list.get(i);
            list.set(i,list.get(len-1-i));
            list.set(len-1-i,temp);
        }
    }
    //========赋值复杂链表=======//
    public RandomListNode Clone(RandomListNode pHead)
    {
        //方法一：先用O(n)的时间复制整个链表，再对每一个元素的random指向的元素，在另一个链表中用O(n)的时间找到，为random引用赋值。复杂度O(n)
        //方法二：Map<RandomListNode,RandomListNode>
        Map<RandomListNode,RandomListNode> map = new HashMap<>();
        RandomListNode cur = pHead;
        while (cur!=null)
        {
            RandomListNode copyNode = new RandomListNode(cur.label);
            map.put(cur,copyNode);
            cur = cur.next;
        }
        Set<Map.Entry<RandomListNode,RandomListNode>> entrySet = map.entrySet();
        for(Map.Entry<RandomListNode,RandomListNode> entry:entrySet)
        {
            entry.getValue().next = map.get(entry.getKey().next);
            entry.getValue().random = map.get(entry.getKey().random);
        }
        RandomListNode res = map.get(pHead);
        return res;
    }
    //========转换BST为排序的双向链表=======//
    //中序遍历一棵树，最后测试似乎陷入了死循环，不知道为什么
    public TreeNode Convert1(TreeNode pRootOfTree) {
        if(pRootOfTree==null)
            return null;
        TreeNode cur = pRootOfTree;
        TreeNode head;
        while (cur.left!=null)
            cur = cur.left;
        head = cur;
        cur = pRootOfTree;
        TreeNode [] stack = new TreeNode[128];
        int stackTop = 0;
        TreeNode pre = null;
        while (cur!=null || stackTop >0)
        {
            while(cur!=null){
                if(cur.left == null && pre!=null)
                    pre.left = cur;
                stack[stackTop++] = cur;
                cur = cur.left;
            }
            if(stackTop>0){
                TreeNode temp = stack[--stackTop];
                if(temp.right!=null)
                    pre = temp;
                else if(stackTop>0)
                    temp.left = stack[stackTop-1];
                else if(stackTop==0)temp.left = null;
                //System.out.println(temp);
                cur = temp.right;
            }
        }
        TreeNode node = head;
        while (node.left != null){
            TreeNode temp = node.left;
            temp.right = node;
            node = temp;
        }
        head.right = node;
        node.left = head;

        return head;
    }
    public TreeNode Convert(TreeNode pRootOfTree) {
        TreeNode head = pRootOfTree;
        if(pRootOfTree==null)
            return null;
        while (head.left!=null)
            head = head.left;
        convertTree(pRootOfTree);
        TreeNode temp,cur = head;
        while (cur.right!=null){
            temp = cur.right;
            temp.left = cur;
            cur = temp;
        }
        return head;
    }
    //不用只想着用迭代的方法来解决二叉树问题，递归该用就用
    private TreeNode convertTree(TreeNode pRootOfTree){
        if(pRootOfTree!=null){
            if(pRootOfTree.left!=null){
                TreeNode leftTail = convertTree(pRootOfTree.left);
                leftTail.right = pRootOfTree;
            }
            if(pRootOfTree.right!=null){
                TreeNode temp1 = pRootOfTree.right;
                TreeNode temp = pRootOfTree.right;
                while (temp.left!=null)
                    temp = temp.left;
                pRootOfTree.right = temp;
                return convertTree(temp1);
            }
            return pRootOfTree;
        }
        return null;
    }
    //========按字典序打印出该字符串中字符的所有排列=======//
    public ArrayList<String> Permutation(String str) {
        if(str==null || str.length()==0)
            return new ArrayList<>();
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        ArrayList<String> res = new ArrayList<>();
        int len = chars.length;
        //表示字符串中以 chars[i]作为开头
        res.add(new String(chars));
        boolean flag = true;
        while (flag){
            flag = false;
            for(int i = len-1;i>0;i--){
                if(chars[i]>chars[i-1]){
                    flag = true;
                    for(int j = len-1;j>=i;j--){
                        if(chars[j]>chars[i-1]){
                            char temp = chars[i-1];
                            chars[i-1] = chars[j];
                            chars[j] = temp;
                            for(int k = i;k<(len+i)/2;k++){
                                temp = chars[len-1+i-k];
                                chars[len-1+i-k] = chars[k];
                                chars[k] = temp;
                            }
                            res.add(new String(chars));
                            break;
                        }
                    }
                    break;
                }
            }
        }
        return res;
    }

    //========数字出现的次数超过数组长度的一半=======//
    public int MoreThanHalfNum_Solution(int [] array) {
        Map<Integer, Integer> map = new HashMap<>();
         int half = array.length/2+1;
        for (int i = 0; i < array.length; i++) {
            int curNum = array[i];
            if(map.get(curNum)==null){
                map.put(curNum,1);
            }
            else {
                map.put(curNum,map.get(curNum)+1);
            }
            if(map.get(curNum)>=half)
                return curNum;
        }
        return 0;
    }
    //========输入n个整数，找出其中最小的K个数=======//
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        if(input==null || input.length == 0 || k<1 || k>input.length)
            return new ArrayList<>();
        int[] heap = new int[k+1];
        for(int i = 1;i<=k;i++) {
            heap[i] = input[i - 1];
        }
        generateMaxHeap(heap);
        for(int i = k;i<input.length;i++){
            if(input[i]<heap[1])
                rePlaceMax(heap,input[i]);
        }
        ArrayList<Integer> res = new ArrayList<>();
        for(int i = 1;i<=k;i++)
            res.add(heap[i]);
        return res;
    }
    //建立一个大根堆
    public void generateMaxHeap(int[] nums){
        int len = nums.length-1;
        for(int i = len/2;i>0;i--){
            nums[0] = nums[i];
            int son = i*2;
            while (son<=len){
                if(son < len && nums[son]<nums[son+1])
                    son++;
                if(nums[0]>nums[son])
                    break;
                else{
                    nums[son/2] = nums[son];
                    son *= 2;
                }
            }
            nums[son/2] = nums[0];
        }
    }
    //把堆顶的最大值替换掉
    public void rePlaceMax(int[] nums, int newNum){
        if(nums.length<2)
            return ;
        nums[1] = newNum;
        int son = 2, len = nums.length-1;
        while (son <= len){
            if(son<len && nums[son]<nums[son+1])
                son++;
            if(newNum>nums[son])
                break;
            else{
                nums[son/2] = nums[son];
            }
            son *=2;
        }
        nums[son/2] = newNum;
    }

    /**
     * 数组最大连续和
     * @param array 整型数组
     * @return
     */
    public int FindGreatestSumOfSubArray(int[] array) {
        if(array == null || array.length == 0) {
            return 0;
        }
        int[] maxSum = new int[array.length];
        maxSum[0] = array[0];
        int max = array[0];
        for(int i = 1;i<array.length;i++){
            if(maxSum[i-1]>0){
                maxSum[i] = maxSum[i-1] + array[i];
            }
            else {
                maxSum[i] = array[i];
            }
            if(maxSum[i]>max) {
                max = maxSum[i];
            }
        }
        return max;
    }
    //========把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个=======//
   /* public String PrintMinNumber(int [] numbers) {
        Arrays.sort(numbers,new Comparator<>());
    }*/
}























