package offer;


import com.sun.org.apache.regexp.internal.RE;
import sun.security.krb5.internal.crypto.Des;

import java.lang.reflect.Array;
import java.math.BigInteger;
import java.util.*;

/**
 * @author tanya
 * @date 2018/4/19 20:49
 */
public class Solution2 {
    /**
     * 把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个
     * @param numbers 整数数组
     * @return 最小的拼接数字
     */
    public String PrintMinNumber(int [] numbers) {
        Integer[] numbersCopy = new Integer[numbers.length];
        for (int i = 0; i<numbers.length;i++){
            numbersCopy[i] = numbers[i];
        }
        Arrays.sort(numbersCopy,new Comparator<Integer>(){
            @Override
            public int compare(Integer num1, Integer num2){
                String str1 = num1+""+num2;
                String str2 = num2+""+num1;
                int res = str1.compareTo(str2);
                return res;
            }
        });
        StringBuilder sb = new StringBuilder();
        for(Integer num:numbersCopy){
            sb.append(num);
        }
        return sb.toString();
    }

    private List<Integer> primeNumsRecord = new ArrayList<>();
    {
        primeNumsRecord.add(1);
        primeNumsRecord.add(2);
        primeNumsRecord.add(3);
    }
    /**
     * 求按从小到大的顺序的第N个素数
     * @param index 第index个素数
     * @return 数值
     */
    public int GetPrimeNumber_Solution(int index) {
        if(index<=primeNumsRecord.size()){
            return primeNumsRecord.get(index-1);
        }
        int cur = primeNumsRecord.get(primeNumsRecord.size()-1)+1;
        while (primeNumsRecord.size()<index){
            double sqrt = Math.sqrt(cur);
            boolean flag = false;
            for(int ele: primeNumsRecord){
                if(ele!=1 && cur % ele==0){
                    flag = true;
                    break;
                }
                if(ele > sqrt){
                    break;
                }
            }
            if(!flag){
                primeNumsRecord.add(cur);
            }
            cur++;
        }

        return primeNumsRecord.get(index-1);
    }

    /**
     * 求按从小到大的顺序的第N个丑数
     * @param index 第index个素数
     * @return 数值
     * */
    public int GetUglyNumber_Solution(int index) {
        if(index<=0) {
            return 0;
        }
        int[] pointers = new int[6];
        int[] uglyNums = new int[index+1];
        uglyNums[1] = 1;
        int size = 1;
        pointers[2] = 1;
        pointers[3] = 1;
        pointers[5] = 1;
        while (size<index){
            int temp2 = uglyNums[pointers[2]]*2;
            int temp3 = uglyNums[pointers[3]]*3;
            int temp5 = uglyNums[pointers[5]]*5;
            int nextUglyNum = -1;
            if(temp2 > uglyNums[size] && temp2 <= temp3 && temp2 <= temp5){
                pointers[2] += 1;
                uglyNums[size+1] = temp2;
            }
            if(temp3 > uglyNums[size] && temp3 <= temp2 && temp3 <= temp5){
                pointers[3] += 1;
                uglyNums[size+1] = temp3;
            }
            if(temp5 > uglyNums[size] && temp5 <= temp3 && temp5 <= temp2){
                pointers[5] += 1;
                uglyNums[size+1] = temp5;
            }
            size++;
        }
        return uglyNums[index];
    }
    /**
     * 在一个字符串(1<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,并返回它的位置
     *  -->这是自己实现的第一个版本，但是没法保存“第一个uniqueChar”这一信息
     * @param str 字符串
     * @return 位置
     */
    public int FirstNotRepeatingChar1(String str) {
        int[] char2PosArray = new int['z'-'A'+1];
        Arrays.fill(char2PosArray,-1);
        char[] chars = str.toCharArray();
        for(char ch :chars){
            if(char2PosArray[ch-'A'] == -1){
                char2PosArray[ch-'A'] = 0;
            }
            else {
                char2PosArray[ch-'A'] = 1;
            }
        }
        char firstUniqueChar = ' ';
        for(int i = 0; i< char2PosArray.length;i++){
            if(char2PosArray[i] == 0){
                firstUniqueChar = (char)( 'A'+i);
                break;
            }
        }
        return str.indexOf(firstUniqueChar);
    }

    /**
     * 在一个字符串(1<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,并返回它的位置
     *  -->这是自己实现的第一个版本，但是没法保存“第一个uniqueChar”这一信息
     *  最后的解决方案是用LinkedHashMap来保存，因为这种HashMap会按照输入的顺序来保存元素
     * @param str 字符串
     * @return 位置
     */
    public int FirstNotRepeatingChar(String str) {
        Map<Character, Integer> char2Pos = new LinkedHashMap();
        char[] chars = str.toCharArray();
        for(char ch :chars){
            if(!char2Pos.containsKey(ch)){
                char2Pos.put(ch,0);
            }
            else {
                char2Pos.put(ch,1);
            }
        }
        for(Map.Entry<Character,Integer> entry: char2Pos.entrySet()){
            if(entry.getValue() == 0) {
                return str.indexOf(entry.getKey());
            }
        }
        return -1;
    }

    /**
     * 输入一个数组,求出这个数组中的逆序对的总数
     * @param array 数组
     * @return 逆序对综述
     */
    int[] arrayCopy;
    public int InversePairs(int [] array) {
        arrayCopy = new int[array.length];
        return mergeSort(array, 0, array.length-1);
    }
    public int mergeSort(int[] array, int start, int end){
        if(start >= end) {
            return 0;
        }
        if(start+1==end) {
            if(array[start]<=array[end]) {
                return 0;
            }
            else{
                int temp = array[start];
                array[start] = array[end];
                array[end] = temp;
                return 1;
            }
        }
        int mid = (start+end)/2;
        int inversePairs = (mergeSort(array,start,mid) + mergeSort(array, mid+1,end))%1000000007;
        for(int i = start;i<=mid;i++){
            arrayCopy[i] = array[i];
        }
        int i = start, j = mid +1, k = start;
        for(;i<=mid && j<=end;){
            if(arrayCopy[i] > array[j]){
                array[k++] = array[j++];
                inversePairs = (inversePairs+mid + 1 - i)%1000000007;
            }
            else {
                array[k++] = arrayCopy[i++];
            }
        }
        if(i <= mid){
            while (i<=mid){
                array[k++] = arrayCopy[i++];
            }
        }
        if(j <= end){
            while (j <= end){
                array[k++] = array[j++];
            }
        }
        return inversePairs%1000000007;
    }

    /**
     * 输入两个链表，找出它们的第一个公共结点
     * @param pHead1 链表1
     * @param pHead2 链表1
     * @return 公共结点
     */
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        ListNode pHead1Cpy = pHead1;
        Set<String> set = new HashSet<>();
        while (pHead1Cpy != null){
            set.add(pHead1Cpy.toString());
            pHead1Cpy = pHead1Cpy.next;
        }
        ListNode pHead2Cpy = pHead2;
        while (pHead2Cpy != null && !set.contains(pHead2Cpy.toString())) {
            pHead2Cpy = pHead2Cpy.next;
        }
        return pHead2Cpy;
    }

    /**
     * 统计一个数字在排序数组中出现的次数
     * 将二分查找修改为找出左边最大值和找出右边最大值的版本，复杂度为O(1)
     * @param array 排序数组
     * @param k 数字
     * @return 出现的次数
     */
    public int GetNumberOfK(int [] array , int k) {
        int index = Arrays.binarySearch(array,k);
        if(index < 0){
            return 0;
        }
        int count = 1;
        int i = index+1, j = index-1;
        while (i < array.length && array[i] == k){
            count++;
            i++;
        }
        while (j > -1 && array[j] == k){
            count++;
            j--;
        }
        return count;
    }
    public int mybinarySearch(int [] array, int target){
        //return binarySearchRight(array,0,array.length-1,target);
        return binarySearchLeft(array,0,array.length-1,target);
    }
    private int binarySearchRight(int [] array, int start, int end, int target){
        if(start == end && array[start] == target) {
            return start;
        }
        if(start == end && array[start] != target) {
            return -1;
        }
        int mid = (start+end)/2;
        return Math.max(binarySearchRight(array, start,mid,target),binarySearchRight(array,mid+1, end,target));
    }

    private int binarySearchLeft(int [] array, int start, int end, int target){
        if(start == end && array[start] == target) {
            return start;
        }
        if(start == end && array[start] != target) {
            return Integer.MAX_VALUE;
        }
        int mid = (start+end)/2;
        return Math.min(binarySearchLeft(array, start,mid,target),binarySearchLeft(array,mid+1, end,target));
    }

    /**
     * 输入一棵二叉树，求该树的深度
     * @param root 二叉树根
     * @return 该树的深度
     */
    public int TreeDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        return Math.max(TreeDepth(root.left),TreeDepth(root.right))+1;
    }

    /**
     * 输入一棵二叉树，判断该二叉树是否是平衡二叉树
     * @param root 二叉树根
     * @return 是否是平衡二叉树
     */
    public boolean IsBalanced_Solution(TreeNode root) {
        if(root == null) {
            return true;
        }
        if(-1 == treeDepth(root)){
            return false;
        }
        else {
            return true;
        }
    }
    private int treeDepth(TreeNode root){
        if(root == null){
            return 0;
        }
        int leftDepth = treeDepth(root.left);
        int rightDepth = treeDepth(root.right);
        if(leftDepth == -1 || rightDepth == -1){
            return -1;
        }
        if(leftDepth + 1 == rightDepth || rightDepth + 1 == leftDepth || leftDepth == rightDepth){
            return Math.max(leftDepth,rightDepth)+1;
        }
        else {
            return -1;
        }
    }

    /**
     * 一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字。
     * @param array  整型数组
     * @param num1 只出现一次的数字
     * @param num2 只出现一次的数字
     */
    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        if(array == null || array.length <2) {
            return;
        }
        int num = array[0];
        for(int i = 1;i< array.length;i++){
            num ^= array[i];
         }
        int temp = num;
        int index = 0;
        while ((temp & 1) ==0){
            temp>>=1;
            index++;
        }
        for(int ele:array){
            if(((ele>>index)&1)==1){
                num1[0] ^= ele;
            }
            else {
                num2[0] ^= ele;
            }
        }
    }

    /**
     * 和为S的连续正数序列
     * @param sum 和为S
     * @return 连续正数序列
     */
    public ArrayList<ArrayList<Integer> > FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer> > res = new ArrayList<>();
        int maxItemsNums = (int)Math.sqrt(2*sum);
        for(int i = maxItemsNums; i >= 2;i--) {
            ArrayList<Integer> list = new ArrayList<>();
            if (i % 2 == 0 && sum % i == i / 2) {
                for (int j = ((int) sum / i) + 1 - i / 2; j <= ((int) sum / i) + i / 2; j++) {
                    list.add(j);
                }
            }
            else if (i%2 != 0 && sum % i == 0) {
                for (int j = sum / i - (i / 2); j <= sum / i + (i / 2); j++) {
                    list.add(j);
                }
            }
            if(list.size()>0) {
                res.add(list);
            }
        }
        return res;
    }

    /**
     * 和为S的两个数字
     * @param array 整型数组
     * @param sum 和
     * @return 两个数字
     */
    public ArrayList<Integer> FindNumbersWithSum(int [] array,int sum) {
        ArrayList<Integer> res = new ArrayList<>();
        if(array == null || array.length < 2){
            return res;
        }
        int start = 0;
        int end = array.length-1;
        while (start<end){
            if(array[start]+array[end]==sum){
                res.add(array[start]);
                res.add(array[end]);
                break;
            }
            else if(array[start]+array[end]>sum){
                end--;
            }
            else {
                start++;
            }
        }
        return res;
    }

    /**
     * 对于一个给定的字符序列S，请你把其循环左移K位后的序列输出
     * @param str 给定的字符序列S
     * @param n 循环左移K位
     * @return 循环左移K位后的序列
     */
    public String LeftRotateString(String str,int n) {
        if(str== null || n>str.length()){
            return "";
        }
        return str.substring(n,str.length()).concat(str.substring(0,n));
    }

    /**
     * 翻转单词顺序列 ,例如，“student. a am I” ---> “I am a student.”
     * @param str 原字符串
     * @return 翻转后的字符串
     */
    public String ReverseSentence(String str) {
        if(str == null || str.length() == 0){
            return "";
        }
        String[] strs = str.split(" ");
        if(strs == null || strs.length == 0){
            return str;
        }
        StringBuilder sb = new StringBuilder();
        for(int i = strs.length-1;i>-1;i--){
            sb.append(strs[i]).append(" ");
        }
        sb.delete(sb.length()-1,sb.length());
        return sb.toString();
    }

    /**
     * 扑克牌顺子
     * @param numbers 抽到的扑克牌数字序列
     * @return 是否为顺子
     */
    public boolean isContinuous(int [] numbers) {
        if(numbers == null || numbers.length == 0) {
            return false;
        }
        Arrays.sort(numbers);
        int kingFlag = 0;
        int j = 0;
        for(int i = 0;i<numbers.length-1;i++){
            if(numbers[i] == 0){
                kingFlag++;
                continue;
            }
            if(numbers[i] == numbers[i+1]){
                return false;
            }
            if(numbers[i]+1 == numbers[i+1]){
                continue;
            }
            else if(numbers[i]+2 == numbers[i+1] && kingFlag>0){
                kingFlag--;
            }
            else if(numbers[i]+3 == numbers[i+1] && kingFlag>1){
                kingFlag-=2;
            }
            else if(numbers[i]+4 == numbers[i+1] && kingFlag>2){
                kingFlag-=3;
            }
            else {
                return false;
            }
        }
        return true;
    }

    /**
     * 孩子们的游戏(圆圈中最后剩下的数) ---> 方法：环的思想，将数组当成环来用
     * @param n 小朋友的个数，编号为 0 ~ n-1
     * @param m 指定的数值m
     * @return 最后留下的小朋友的编号
     */
    int[] kids;
    int size = 0;
    int n;
    public int LastRemaining_Solution(int n, int m) {
        this.n = n;
        kids = new int[n];
        for(int i =0;i<n;i++){
            kids[i] = i;
            size++;
        }
        if (size>1){
            removeMth(kids,m);
        }
        for(int i:kids){
            if(i != -1){
                return i;
            }
        }
        return -1;
    }
    private void removeMth(int[] kids ,int m){
        if(size == 1){
            return;
        }
        int i = 0;
        int j = 0;
        while (size>1){
            if(kids[j%n] != -1 && i == m-1){
                kids[j%n] = -1;
                size--;
                i = 0;
            }
            else if(kids[j%n] != -1){
                i++;
            }
            j++;
        }
    }

    /**
     * 求1+2+3+...+n，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
     * @param n 前n个数
     * @return 和
     */
    public int Sum_Solution(int n) {
        BigInteger a = new BigInteger(n+"");
        BigInteger b = new BigInteger(n+1+"");
        BigInteger c = new BigInteger(2+"");
        return a.multiply(b).divide(c).intValue();
    }

    /**
     * 写一个函数，求两个整数之和，要求在函数体内不得使用+、-、*、/四则运算符号。Add2()函数的方法是错误的，目前尚不知道问题在哪里
     * @param num1 第一个整数
     * @param num2 第二个整数
     * @return 和
     */
    public int Add2(int num1,int num2) {
        int[] resInBit = new int[32];
        Arrays.fill(resInBit,0);
        int insertIndex = 31;
        int i = 0;
        int forward = 0;
        while (i<32){
            int num1Mid = num1>>i & 1;
            int num2Mid = num2>>i & 1;
            resInBit[insertIndex--] = ((num1Mid^num2Mid + forward)==2)?0:num1Mid^num2Mid + forward;
            if((num1Mid + num2Mid + forward)>=2){
                forward = 1;
            }
            else{
                forward  = 0;
            }
            i++;
        }
        StringBuilder sb = new StringBuilder();
        int resMid = 0;
        for(int j = 1;j<32;j++){
            resMid = resMid*2 + resInBit[j];
        }
        if(resInBit[0]==0){
            return resMid;
        }
        else {
            return (1<<31 - resMid)*-1;
        }
    }
    /**
     * 写一个函数，求两个整数之和，要求在函数体内不得使用+、-、*、/四则运算符号。
     * 两个数字的按位与是进位信息，按位异或是不进位的加和结果；此方法对于负数也是适用的。
     * @param num1 第一个整数
     * @param num2 第二个整数
     * @return 和
     */
    public int Add(int num1,int num2) {
        int forward = (num1&num2)<<1;
        int resMid = num1^num2;
        while (forward!=0){
            int temp = resMid;
            resMid = resMid^forward;
            forward = (temp&forward)<<1;
        }
        return resMid;
    }

    /**
     * 将一个字符串转换成一个整数，要求不能使用字符串转换整数
     * 的库函数。 数值为0或者字符串不是一个合法的数值则返回0
     * @param str 字符串
     * @return 数字
     */
    public int StrToInt(String str) {
        if(str==null || str.length()==0){
            return 0;
        }
        char[] chars = str.toCharArray();
        int symbol = chars[0]=='-'?-1:1;
        int resMid = 0;
        int i = (chars[0]=='-'||chars[0]=='+')?1:0;
        for(;i<chars.length;i++){
            if(chars[i]-'0'<0 || chars[i]-'0'>9){
                return 0;
            }
            else{
                resMid = resMid*10 + chars[i]-'0';
            }
        }
        return resMid*symbol;
    }

    /**
     * 在一个长度为n的数组里的所有数字都在0到n-1的范围内。
     * 数组中某些数字是重复的，但不知道有几个数字是重复的。
     * 也不知道每个数字重复几次。请找出数组中任意一个重复的数字。
     * 使用了基数排序的原理，时间复杂度O(1),空间复杂度O(1)
     * @param numbers 输入的数字数组
     * @param length 数组长度
     * @param duplication 输出的重复的数字
     * @return 是否有重复数字
     */
    public boolean duplicate(int numbers[],int length,int [] duplication) {
        int resIndex = 0;
        for(int i = 0;i<length;i++){
            while (numbers[i]!= i){
                int temp = numbers[i];
                if(numbers[i] == numbers[numbers[i]]){
                    duplication[resIndex++] = temp;
                    return true;
                }
                numbers[i] = numbers[temp];
                numbers[temp] = temp;
            }
        }
        return false;
    }

    /**
     * 请实现一个函数用来匹配包括'.'和'*'的正则表达式。
     * 模式中的字符'.'表示任意一个字符，而'*'表示它前
     * 面的字符可以出现任意次（包含0次）。 在本题中，
     * 匹配是指字符串的所有字符匹配整个模式。例如，
     * 字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但是与"aa.a"和"ab*a"均不匹配
     * @param str 数组
     * @param pattern 数组
     * @return 答案
     */
    public boolean match(char[] str, char[] pattern)
    {
        String patternStr = new String(pattern);
        if((str==null ||str.length==0) &&(pattern==null ||pattern.length==0)){
            return true;
        }
        if(pattern == null || pattern.length==0){
            return false;
        }
        if((str==null ||str.length==0) && patternStr.matches(".\\*")){
            return true;
        }
        if(str==null ||str.length==0){
            return false;
        }
        str = (" " + new String(str)).toCharArray();
        pattern = (" " + new String(pattern)).toCharArray();

        boolean[][] matched = new boolean[str.length+1][pattern.length+1];
        matched[0][0] = true;
        for(int i = 1;i<pattern.length;i++){
            if(pattern[i] == '*' && matched[0][i-1]){
                matched[0][i] = true;
            }
            else if(i>1 && pattern[i] == '*' && matched[0][i-2]){
                matched[0][i] = true;
            }
            else {
                matched[0][i] = false;
            }
        }
        for(int i = 1;i<str.length;i++){
            matched[i][0] = false;
        }
        for(int i = 1;i<str.length;i++){
            for (int j = 1;j<pattern.length;j++){
                if(pattern[j]=='*'&&matched[i-1][j] && eaquals(str[i],pattern[j-1])){
                    matched[i][j] = true;
                }
                else if(j>1 && pattern[j]=='*' && matched[i][j-2]){
                    matched[i][j] = true;
                }
                else if(pattern[j] !='*'&& matched[i-1][j-1] && eaquals(str[i],pattern[j])){
                    matched[i][j] = true;
                }
                else{
                    matched[i][j] = false;
                }
            }
        }
        return matched[str.length-1][pattern.length-1];
    }
    private boolean eaquals(char a,char b){
        if(b == '.'){
            return true;
        }
        else if(a == b){
            return true;
        }
        else{
            return false;
        }
    }

    /**
     * 请实现一个函数用来找出字符流中第一个
     * 只出现一次的字符。例如，当从字符流中
     * 只读出前两个字符"go"时，第一个只出现一次
     * 的字符是"g"。当从该字符流中读出前六个字符
     * “google"时，第一个只出现一次的字符是"l"。
     * @param ch
     */
    private LinkedHashMap<Character,Integer> map = new LinkedHashMap<>();
    public void Insert(char ch)
    {
        if(map.containsKey(ch)){
            map.put(ch,map.get(ch)+1);
        }
        else {
            map.put(ch,1);
        }
    }
    public char FirstAppearingOnce()
    {
        for(char key:map.keySet()){
            if(map.get(key)==1){
                return key;
            }
        }
        return '#';
    }

    /**
     * 一个链表中包含环，请找出该链表的环的入口结点。
     * @param pHead 表头
     * @return 环入口
     */
    public ListNode EntryNodeOfLoop(ListNode pHead)
    {
        Set<ListNode> set = new HashSet<>();
        while (pHead!=null){
            if(set.contains(pHead)){
                return pHead;
            }
            set.add(pHead);
            pHead = pHead.next;
        }
        return null;
    }

    /**
     * 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，
     * 重复的结点不保留，返回链表头指针。 例如，
     * 链表1->2->3->3->4->4->5 处理后为 1->2->5
     * @param pHead
     * @return
     */
    public ListNode deleteDuplication(ListNode pHead)
    {
        ListNode temp = nextPreNode(pHead);
        while (temp!=null && temp.next != null && temp.next.val==temp.val){
            temp = nextPreNode(temp);
        }

        ListNode node = temp;
        pHead = temp;
        while (node!=null){
            temp = nextPreNode(node.next);
            while (temp!=null && temp.next != null && temp.next.val==temp.val){
                temp = nextPreNode(temp);
            }
            node.next = temp;
            node = node.next;
        }
        return pHead;
    }
    private ListNode nextPreNode(ListNode node){
        if(node == null || node.next == null){
            return node;
        }
        if(node.val == node.next.val){
            ListNode temp = node.next;
            while (temp!=null && temp.val==node.val){
                temp = temp.next;
            }
            return temp;
        }
        else{
            return node;
        }
    }

    /**
     * 给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。
     * 注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
     * @param pNode 二叉树中的那个节点，二叉树的root不给出。
     * @return 中序遍历的下一个节点
     */
    public TreeLinkNode GetNext(TreeLinkNode pNode)
    {
        TreeLinkNode node = pNode;
        if(node == null){
            return node;
        }
        if(node.right == null && node.next == null){
            return null;
        }
        else if(node.right != null) {
            node = node.right;
            while (node.left != null) {
                node = node.left;
            }
            return node;
        }
        else{
            node = pNode;
            while (node.next!=null){
                if(node.next.left == node){
                    return node.next;
                }
                node = node.next;
            }
            return null;
        }
    }

    /**
     * 请实现一个函数，用来判断一颗二叉树是不是对称的。注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。
     * @param pRoot 二叉树的root
     * @return 是否对称
     */
    boolean isSymmetrical(TreeNode pRoot)
    {
        if(pRoot == null){
            return true;
        }
        TreeNode left = pRoot.left;
        TreeNode right = pRoot.right;
        LinkedList<TreeNode> leftStack = new LinkedList<>();
        LinkedList<TreeNode> rightStack = new LinkedList<>();
        while (left != null && right != null){
            if(left.val != right.val){
                return false;
            }
            while (left !=null){
                if(right == null || right.val != left.val){
                    return false;
                }
                leftStack.push(left);
                rightStack.push(right);
                left  = left.left;
                right = right.right;
            }
            if(right != null){
                return false;
            }
            left = leftStack.pop().right;
            right = rightStack.pop().left;
        }
        return true;
    }

    /**
     * 按之字形顺序打印二叉树
     * @param pRoot 树根
     * @return
     */
    public ArrayList<ArrayList<Integer> > Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> resMid = new ArrayList<>();
        LinkedList<TreeNode> que1 = new LinkedList<>();
        LinkedList<TreeNode> que2 = new LinkedList<>();
        if(pRoot == null){
            return resMid;
        }
        que1.add(pRoot);
        while (que1.size()!=0 || que2.size()!=0){
            ArrayList<Integer> line = new ArrayList<>();
            if(que2.size()>0){
                LinkedList<TreeNode> temp = que1;
                que1 = que2;
                que2 = temp;
            }
            while (que1.size()>0){
                TreeNode node1 = que1.pollFirst();
                line.add(node1.val);
                if(node1.left != null){
                    que2.addLast(node1.left);
                }
                if(node1.right!=null){
                    que2.addLast(node1.right);
                }
            }
            resMid.add(line);
        }
        for(int i = 1;i<resMid.size();i+=2){
            resMid.set(i,reverseOrder(resMid.get(i)));
        }
        return resMid;
    }
    private ArrayList<Integer> reverseOrder(ArrayList<Integer> list){
        int size = list.size();
        for(int i = 0;i<list.size()/2;i++){
            int temp = list.get(size-1-i);
            list.set(size-1-i,list.get(i));
            list.set(i,temp);
        }
        return list;
    }

    /**
     * 序列化二叉树
     * 初始想法：二叉树应该通过中序、先序、后序中的两种来唯一确定一棵二叉树
     * 参考他人：默认每一个节点都有左右子节点，如果子节点为空，则用 # 代替。
     * @param root 二叉树根
     * @return 序列化成字符串
     */
    String Serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        if(root == null){
            sb.append('#').append(',');
            return sb.toString();
        }
        sb.append(root.val).append(',');
        sb.append(Serialize(root.left));
        sb.append(Serialize(root.right));
        return sb.toString();
    }

    /**
     * 反序列化二叉树
     * 用index来维系各个递归之间的关系。
     * @param str 序列化成的字符串
     * @return 二叉树根
     */
    private int index = 0;
    private String [] nums;
    private boolean flag = true;
    TreeNode Deserialize(String str) {
        if(str==null || str.length()==0){
            return null;
        }
        if(flag){
            nums = str.split(",");
            flag = false;
        }
        if(nums[index].equals("#")){
            index++;
            return null;
        }
        TreeNode node = new TreeNode(Integer.parseInt(nums[index++]));
        node.left = Deserialize(str);
        node.right = Deserialize(str);
        return node;
    }

    /**
     * 给定一颗二叉搜索树，请找出其中的第k小的结点。
     * 二叉搜索树中最小的树应该在先序遍历的第一个节点处。
     * @param pRoot 树根
     * @param k 第k小
     * @return 节点
     */
    int kTh;
    int indexS = 1;
    TreeNode KthNode(TreeNode pRoot, int k)
    {
        kTh = k;
        if(pRoot == null || k<=0){
            return null;
        }
        return inOrderReverse(pRoot);
    }
    TreeNode inOrderReverse(TreeNode root){
        if(indexS > kTh){
            indexS++;
            return null;
        }
        TreeNode left = null;
        TreeNode right = null;
        if(root.left!=null){
            left = inOrderReverse(root.left);
        }
        if(left!=null){
            return left;
        }
        if(indexS == kTh){
            return root;
        }
        indexS++;
        if(root.right!=null) {
            right = inOrderReverse(root.right);
        }
        if(right != null){
            return right;
        }
        return null;
    }

    ArrayList<Integer> ints = new ArrayList<>();
    public void Insert(Integer num) {
        ints.add(num);
    }

    public Double GetMedian() {
        Collections.sort(ints);
        if(ints.size()%2!=0){
            return ints.get(ints.size()/2).doubleValue();
        }
        else{
            return (ints.get(ints.size()/2-1).doubleValue()+ints.get(ints.size()/2).doubleValue())/2;
        }
    }

    /**
     * 给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。
     * @param num 滑动窗口的大小
     * @param size 数组
     * @return 所有滑动窗口里数值的最大值
     */
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2-o1;
        }
    });
    public ArrayList<Integer> maxInWindows(int [] num, int size)
    {
        ArrayList<Integer> res = new ArrayList<>();
        if(num == null || num.length<size || size <= 0){
            return res;
        }
        Map<Integer,Integer> now = new HashMap<>();
        for(int i = 0; i < size;i++){
            maxHeap.add(num[i]);
            if(now.containsKey(num[i])){
                now.put(num[i],now.get(num[i])+1);
            }
            else{
                now.put(num[i],1);
            }
        }
        res.add(maxHeap.peek());
        for(int i = size;i<num.length;i++){
            maxHeap.add(num[i]);
            if(now.get(num[i-size]) == 1 ){
                now.remove(num[i-size]);
            }
            else{
                now.put(num[i-size],now.get(num[i]-1));
            }
            if(now.containsKey(num[i])){
                now.put(num[i],now.get(num[i])+1);
            }
            else{
                now.put(num[i],1);
            }
            while (!now.containsKey(maxHeap.peek())){
                maxHeap.poll();
            }
            res.add(maxHeap.peek());
        }
        return res;
    }

    private boolean [][] hasBeen;
    private int rows,cols;
    public boolean hasPath(char[] matrix, int rows, int cols, char[] str)
    {
        this.rows = rows;
        this.cols = cols;
        hasBeen = new boolean[rows][cols];
        for(int i = 0;i<hasBeen.length;i++){
            Arrays.fill(hasBeen[i],false);
        }
        for(int i = 0;i<matrix.length;i++){
            if(str[0]==matrix[i]){
                boolean res = works(matrix, i/cols,i%cols,str,0);
                if(res){
                    return true;
                }
            }
        }
        return false;
    }
    private boolean works(char[] matrix, int startRow, int startCol, char[] str, int index){
        if(index >= str.length){
            return true;
        }
        if(startCol<0 || startRow<0 || startCol >= cols || startRow>=rows){
            return false;
        }
        if(hasBeen[startRow][startCol]){
            return false;
        }
        if(matrix[startRow*cols+startCol]!=str[index]){
            return false;
        }
        else{
            index++;
            hasBeen[startRow][startCol] = true;
            boolean res = false;
            if(index >= str.length){
                return true;
            }
            if(startCol>=1){
                res = works(matrix,startRow,startCol-1,str,index);
            }
            if(startCol<cols-1) {
                res = res||works(matrix,startRow,startCol+1,str,index);
            }
            if(startRow<rows-1) {
                res = res||works(matrix,startRow+1,startCol,str,index);

            }
            if(startRow>0){
                res = res||works(matrix,startRow-1,startCol,str,index);
            }
            hasBeen[startRow][startCol] = false;
            return res;
        }
    }
}

















