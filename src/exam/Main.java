package exam;

import java.util.*;

/**
 * @author tanya
 * @date 2018/5/22 10:57
 */
public class Main
{
    public static class FIFOCache<K,V>{

        private class Node{
            private Node next;
            private Node prior;
            private V value;
            private K key;
            public Node(K key,V value){
                this.key = key;
                this.value = value ;
            }
            public void setNext(Node next) {
                this.next = next;
            }

            public void setValue(V value) {
                this.value = value;
            }
        }
        private HashMap<K,Node> map;
        private final int  SIZE;
        private int curSize = 0;
        private Node head = null;
        private Node tail = null;
        public FIFOCache(int size){
            SIZE = size;
            map = new HashMap<>();
        }
        public void put(K key, V value){
            if(!map.containsKey(key)){
                Node insert = new Node(key,value);
                map.put(key, insert);
                insert.next = head;
                insert.prior = null;
                if(head!=null){
                    head.prior = insert;
                }
                if(head == null){
                    tail = insert;
                }
                head = insert;
                curSize++;
                if(curSize > SIZE){
                    map.remove(tail.key);
                    tail.prior.next = null;
                    tail = tail.prior;
                    curSize--;
                }
            }
            else{
                map.get(key).setValue(value);
            }
        }
        public V get(K key){
            if(!map.containsKey(key)){
                return null;
            }
            else{
                Node node  = map.get(key);
                if(node == head){
                    return head.value;
                }
                if(node == tail){
                    tail = tail.prior;
                }
                if(node.prior!=null) {
                    node.prior.next = node.next;
                }
                if(node.next!=null){
                    node.next.prior = node.prior;
                }
                node.next = head;
                node.prior = null;
                head.prior = node;
                head = node;
                return node.value;
            }
        }
    }
    public static void main5(String[] args) {
        Scanner in = new Scanner(System.in);
        int size = in.nextInt();
        FIFOCache<Integer,Integer> cache = new FIFOCache<>(size);
        String input;
        while (in.hasNext()){
            input = in.nextLine();
            String[] strs = input.split(" ");
            if(strs.length==3 && strs[0].equals("p")  ){
                cache.put(Integer.parseInt(strs[1]),Integer.parseInt(strs[2]));
            }
            else if(strs.length==2 &&  strs[0].equals("g") ){
                Integer res = cache.get(Integer.parseInt(strs[1]));
                if(res==null){
                    System.out.println(-1);
                }
                else{
                    System.out.println(res);
                }
            }
        }
    }

    public static void main6(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        Map<Integer,List<Integer>> nodes1 = new HashMap<>();
        for(int i = 0; i<n-1;i++) {
            int x = in.nextInt();
            int y = in.nextInt();
            if(!nodes1.containsKey(x)){
                nodes1.put(x, new ArrayList<Integer>());
            }
            if(!nodes1.containsKey(y)){
                nodes1.put(y, new ArrayList<Integer>());
            }
            nodes1.get(x).add(y);
            nodes1.get(y).add(x);
        }
        Set<Integer> visited = new HashSet<>();
        List<Integer> cur = new LinkedList<>();
        int hight = 0;
        cur.add(1);
        while (!cur.isEmpty()){
            List<Integer> next = new LinkedList<>();
            for(int node:cur) {
                for (int ele : nodes1.get(node)) {
                    if (!visited.contains(ele)) {
                        next.add(ele);
                        visited.add(ele);
                    }
                }
            }
            hight++;
            cur = next;
        }
        System.out.println(2*n-1-hight);
    }

    private static Set<Integer> h = new HashSet<>();
    private static Map<Integer, Integer> counts = new HashMap<>();
    private static int t;
    private static int answer;
    public static void main7(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        t = in.nextInt();
        int[] numbers = new int[n];
        for(int i = 0; i<n;i++){
            numbers[i] = in.nextInt();
        }
        for(int i = 0;i<k;i++){
            modify(numbers[i], true);
        }
        if(h.size()>0){
            answer=1;
        }
        for(int i = k;i<n;i++){
            modify(numbers[i-k],false);
            modify(numbers[i],true);
            if(h.size()>0){
                answer += 1;
            }
        }
        System.out.println(answer);

    }
    private static void modify(int a, boolean b){
    if(counts.containsKey(a)){
        if(b){
            counts.put(a, counts.get(a)+1);
        }
        else {
            counts.put(a,counts.get(a)-1);
        }
    }
    else{
        counts.put(a,1);
    }
    if(!b && counts.get(a)==(t-1)){
        h.remove(a);
    }
    if(counts.get(a)==t){
        h.add(a);
    }
}
    /**
     * 判断一个点是否在多边形内部
     */
    private static int count = 0;
    public static void main8(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] strs1 = in.nextLine().split(",");
        int startX = Integer.parseInt(strs1[0]);
        int startY = Integer.parseInt(strs1[1]);
        List<Integer> xOrdinates = new ArrayList<>();
        List<Integer> yOrdinates = new ArrayList<>();

        String[]strs2 = in.nextLine().split(",");
        for(String str:strs2){
            xOrdinates.add(Integer.parseInt(str));
            yOrdinates.add(Integer.parseInt(str));
        }

        count = xOrdinates.size();
        //查询线段相交的数目
        if(contains2(xOrdinates,yOrdinates,startX,startY)){
            System.out.println("yes,0");
        }
        else {
            System.out.print("no");
        }
    }
    static private boolean contains(List<Integer> xOrdinates, List<Integer> yOrdinates,int x0, int y0){
        int cross = 0;
        for(int i = 0; i<count ;i++){
            boolean condA , condB ;
            int y1Index =  i%count, y2Index = (i+1)%count;
            double slope = (yOrdinates.get(y1Index)-yOrdinates.get(y2Index))/(double)(xOrdinates.get(y1Index)-xOrdinates.get(y2Index));
            condA = xOrdinates.get(y1Index)<=x0 && (x0<xOrdinates.get(y2Index));
            condB = xOrdinates.get(y2Index)<=x0 && (x0<xOrdinates.get(y1Index));
            boolean above = (y0<slope*(x0-xOrdinates.get(y1Index)) + yOrdinates.get(y1Index));
            if((condA||condB)&&above){
                cross++;
            }
        }
        return cross%2!=0;
    }
    static private boolean contains2(List<Integer> xOrdinates, List<Integer> yOrdinates,int x0, int y0){
        if(count < 3)
        {
            return false;
        }
        boolean result = false;

        for(int i = 0, j = count - 1; i < count; i++)
        {
            int x1 = xOrdinates.get(i);
            int x2 = xOrdinates.get(j);
            int y1 = yOrdinates.get(i);
            int y2 = yOrdinates.get(i);

            if(x1 < x0 && x2 >= x0 || x2 < x0 && x1 >= x0)
            {
                if(y1 + (x0 - x1) / (x2 - x1) * (y2 - y2) < y0)
                {
                    result = !result;
                }
            }
            j = i;
        }
        return result;
    }

    public static void main9(String[] args) {
        Scanner in = new Scanner(System.in);
        int pairs = in.nextInt();
        int [][] communities = new int[pairs][2];
        for(int i =0;i<pairs;i++){
            communities[i][0] = in.nextInt();
            communities[i][1] = in.nextInt();
        }
        for(int i =0;i<pairs;i++){
            System.out.println("0 ");
            if(communities[i][0]<3 || communities[i][0]==communities[i][1]){
                System.out.println(0);
                continue;
            }
            if(communities[i][1] <= communities[i][0]/2){
                System.out.println(communities[i][1]-1);
                continue;
            }
            else {
                System.out.println(communities[i][0] - communities[i][1]);
            }
        }
    }

    private static final int CROW = 10;
    private static int[][] chess;
    public static void main11(String[] args) {

        chess = new int[CROW][CROW];
        Scanner in = new Scanner(System.in);
        for(int i = 0;i<CROW;i++){
            String str = in.nextLine();
            for(int j = 0; j < CROW; j++){
                int temp = str.charAt(j)-'0';
                chess[i][j] = temp;
            }
        }
        int startY = in.nextInt();
        int startX = in.nextInt();
        System.out.println(canWalkOut(startX,startY)?"1":"0");
    }
    private static boolean canWalkOut(int i, int j){
        if(i <0 || j <0 || i>CROW-1 || j>CROW-1 ||chess[i][j] !=0){
            return false;
        }
        if(i ==0 || j ==0 || i==CROW-1 || j==CROW-1 ){
            if(chess[i][j] ==0) {
                return true;
            }
        }
        chess[i][j] = -1;
        return canWalkOut(i+1,j)||canWalkOut(i,j+1)||canWalkOut(i-1,j)||canWalkOut(i,j-1);
    }

    public static void main15(String[] args) {
        Scanner in = new Scanner(System.in);
        char[] chars = in.nextLine().toCharArray();
        int len = chars.length;
        Set<Character> preChars = new HashSet<>();
        boolean flag = true;
        int maxLen = 0;
        preChars.add(chars[0]);
        for(int i = 1; i < len;i++){
            for(int j = i; j<len; j++){
                if(preChars.contains(chars[j])){
                    i = j-1;
                    break;
                }
                else {
                    preChars.add(chars[j]);
                }
            }
            maxLen = Math.max(maxLen, preChars.size());
            preChars = new HashSet<>();
        }
        System.out.println(maxLen);
    }
    private static String ip;
    public static void main12(String[] args) {
        Scanner in = new Scanner(System.in);
        ip = in.nextLine();
        System.out.println(possibleIPs(ip, 0,1));
    }
    private static int possibleIPs(String str,int curIndex,int groupId){
        if(groupId>4 || curIndex>=ip.length() || ip.length()-curIndex>(5-groupId)*3 || ip.length()-curIndex<5-groupId){
            return 0;
        }
        if(groupId == 4 && getInt(str, curIndex, str.length()-1)<255){
            return 1;
        }
        else if(groupId==4){
            return 0;
        }
        int res = 0;
        if(str.charAt(curIndex)=='0'){
            res += possibleIPs(str, curIndex+1,groupId+1);
        }
        else {
            for (int i = 1; i < 3; i++) {
                res += possibleIPs(str, curIndex + i, groupId + 1);
            }
            if (getInt(str, curIndex, curIndex + 2) <= 255) {
                res += possibleIPs(str, curIndex + 3, groupId + 1);
            }
        }
        return res;
    }
    private static int getInt(String str, int startIndex, int endIndex){
        int res = 0;
        if(str.charAt(startIndex)=='0' && endIndex>startIndex){
            return 256;
        }
        for(int i = startIndex;i<=endIndex && i<str.length();i++){
            res = res*10 + str.charAt(i)-'0';
        }
        return res;
    }
    static int m;
    static int[][] map;
    public static void main13(String[] args) {
        Scanner scanner = new Scanner(System.in);
        m = scanner.nextInt();
        map = new int[m][m];
        for(int i=0;i<m;i++){
            for(int j=0;j<m;j++){
                map[i][j] = scanner.nextInt();
            }
        }
        int res = 0;
        for(int i=0;i<m;i++){
            for(int j=0;j<m;j++){
                res+=flood(i,j);
            }
        }
        System.out.println(res);
    }
    public static int flood(int i, int j){
        if(i<0 || i>m-1 || j<0||j>m-1 || map[i][j]!=1){
            return 0;
        }
        map[i][j] = -1;
        flood(i+1,j);
        flood(i, j+1);
        flood(i-1,j);
        flood(i,j-1);
        return 1;
    }
    private static class Param{
        public int index;
        public int value;
        public Param(int index,int value){
            this.index = index;
            this.value = value;
        }
    }
    private static class MyComparator implements Comparator<Param>{
        @Override
        public int compare(Param o1, Param o2) {
            return o1.value-o2.value;
        }
    }
    public static void main1(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] products = new int[n][3];
        Param[] params1 = new Param[n];
        Param[] params2 = new Param[n];
        Param[] params3 = new Param[n];
        for(int i = 0;i<n;i++){
            int a = scanner.nextInt(),b = scanner.nextInt(),c = scanner.nextInt();
            params1[i] = new Param(i, a);
            params2[i] = new Param(i, b);
            params3[i] = new Param(i, c);
            products[i][0] = a;
            products[i][1] = b;
            products[i][2] = c;
        }
        Arrays.sort(params1, new MyComparator());
        Arrays.sort(params2, new MyComparator());
        Arrays.sort(params3, new MyComparator());
        Map<Integer,Integer> map1 = new HashMap<>(100000);
        Map<Integer,Integer> map2 = new HashMap<>(100000);
        Map<Integer,Integer> map3 = new HashMap<>(100000);
        for(int i = 0;i<n;i++){
            map1.put(params1[i].index,i);
            map2.put(params2[i].index,i);
            map3.put(params3[i].index,i);
        }

    }

    public static void main14(String[] args) {
        String str1 = "abc";
        String str2 = "abc";
        System.out.println(str1==str2);
        String str3 = new String("abc");
        System.out.println(str1==str3);
        System.out.println(str1.intern()==str2.intern());
        Vector<Integer> v;
    }

/*        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            int T = scanner.nextInt();
            for(int i=0;i<T;i++){
                judge(scanner);
            }
        }*/

    private static Map<Integer,List<Integer>> fromto = new HashMap<>();
    private static Map<Integer,List<Integer>> tofrom = new HashMap<>();

    public static void main16(String [] args ){
        Scanner scanner = new Scanner(System.in);
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            fromto = new HashMap<>();
            tofrom = new HashMap<>();
            List<Integer> remain = new ArrayList<>();
            for(int i=0;i<n;i++){
                fromto.put(i,new ArrayList<>());
                tofrom.put(i,new ArrayList<>());
            }
            for(int i=0;i<m;i++){
                int n1 = scanner.nextInt()-1;
                int n2 = scanner.nextInt()-1;
                fromto.get(n1).add(n2);
                tofrom.get(n2).add(n1);
            }
            int res = 0;
            for(int i = 0;i<n;i++){
                if(valid(i)){
                    res++;
                }
            }
            System.out.println(res);
        }
        private static boolean valid(int i){
            Set<Integer> visited = new HashSet<>();
            LinkedList<Integer> cur = new LinkedList<>();
            int fromtoNums = 0,tofromNums = 0;
            cur.addAll(fromto.get(i));
            visited.addAll(cur);
            fromtoNums+=cur.size();
            while (cur.size()>0){
                List<Integer> tos = fromto.get(cur.poll());
                for(int to:tos){
                    if(!visited.contains(to)){
                        cur.offer(to);
                        visited.add(to);
                        fromtoNums++;
                    }
                }
            }
            visited = new HashSet<>();
            cur = new LinkedList<>();
            cur.addAll(tofrom.get(i));
            tofromNums+=cur.size();
            visited.addAll(cur);
            while (cur.size()>0){
                List<Integer> froms = tofrom.get(cur.poll());
                for(int from:froms){
                    if(!visited.contains(from)){
                        cur.offer(from);
                        visited.add(from);
                        tofromNums++;
                    }
                }
            }
            return tofromNums>fromtoNums;

        }

        private static boolean valid(Map<Integer,List<Integer>> paths,List<Integer> remain){
            if(remain.size()==0){
                return true;
            }
            int root = remain.get(0);
            List<Integer> currentList = new ArrayList<>(remain);
            List<Integer> to = paths.get(root);
            to.retainAll(remain);
            currentList.removeAll(to);
            Set<Integer> target = new HashSet<>();
            currentList.forEach(from->{
                target.addAll(paths.get(from));
            });
            for (Integer from  : currentList) {
                if(target.contains(from)){
                    return false;
                }
            }
            for (Integer from : currentList) {
                if (!paths.get(from).containsAll(to)){
                    return false;
                }
            }
            return valid(paths,to);
        }

    public static void main17(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] nums = new int[n][3];
        for(int i =0;i<n;i++){
            nums[i][0] = scanner.nextInt();
            nums[i][1] = scanner.nextInt();
            nums[i][2] = scanner.nextInt();
        }
        for(int i = 0;i<n;i++){
            boolean flag = false;
            for(int j = 1;j<=nums[i][1];j++){
                if(j*nums[i][0]%nums[i][1]==nums[i][2]){
                    System.out.println("YES");
                    flag = true;
                    break;
                }
            }
            if(!flag)System.out.println("NO");
        }
    }

    public static void main18(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        if(str==null||str.length()==0 ){
            return;
        }
        char[] chars = str.toCharArray();
        StringBuilder sb = new StringBuilder();
        char cur = chars[0];
        int curCount = -1;
        for(int i = 0;i<str.length();i++){
            if(chars[i] == cur){
                curCount++;
            }
            else {
                if(curCount>0){
                    sb.append(curCount);
                }
                sb.append(cur);
                curCount = 0;
                cur = chars[i];
            }
        }
        if(curCount>0){
            sb.append(curCount);
        }
        sb.append(cur);
        System.out.println(sb.toString());
    }

    public static void main111(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] strs1 = scanner.nextLine().split(" ");
        String[] strs2 = scanner.nextLine().split(" ");
        int len = strs1.length;
        int[] bfs = new int[len];
        int[] inOrder = new int[len];
        Map<Integer, Integer> bfsMap = new HashMap<>();
        for(int i = 0;i<len;i++){
            bfs[i] = Integer.parseInt(strs1[i]);
            inOrder[i] = Integer.parseInt(strs2[i]);
        }

    }


    public static void main110(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> mid = new ArrayList<>();
        List<Integer> level = new ArrayList<>();
        String[] levelStr = scanner.nextLine().split(" ");
        String[] preStr = scanner.nextLine().split(" ");
        Arrays.asList(levelStr).forEach(num->{
            level.add(Integer.valueOf(num));
        });
        Arrays.asList(preStr).forEach(num->{
            mid.add(Integer.valueOf(num));
        });
        Node tree = construct(mid,level);
        StringJoiner leaf = new StringJoiner(" ");
        StringJoiner pre = new StringJoiner(" ");
        StringJoiner post = new StringJoiner(" ");
        getLeaf(tree,leaf);
        getPre(tree,pre);
        getPost(tree,post);
        System.out.println(leaf.toString());
        System.out.println(pre.toString());
        System.out.println(post.toString());
    }

    private static void getLeaf(Node n, StringJoiner sj){
        if(n==null){
            return;
        }
        if(n.left==null&&n.right==null){
            sj.add(String.valueOf(n.val));
        }
        getLeaf(n.left,sj);
        getLeaf(n.right,sj);
    }

    private static void getPre(Node n, StringJoiner sj){
        if(n==null){
            return;
        }
        sj.add(String.valueOf(n.val));
        getPre(n.left,sj);
        getPre(n.right,sj);
    }

    private static void getPost(Node n, StringJoiner sj){
        if(n==null){
            return;
        }
        getPost(n.left,sj);
        getPost(n.right,sj);
        sj.add(String.valueOf(n.val));
    }

    private static Node construct(List<Integer> mid,List<Integer> level){
        if(mid.size()==0){
            return null;
        }
        Node cur = new Node();
        cur.val = level.get(0);
        int idx = mid.indexOf(cur.val);
        List<Integer> leftLevel = new ArrayList<>();
        List<Integer> leftmid = mid.subList(0,idx);
        List<Integer> rightLevel = new ArrayList<>();
        List<Integer> rightmid = mid.subList(idx+1,mid.size());
        Set<Integer> left = new HashSet<>(leftmid);
        Set<Integer> right = new HashSet<>(rightmid);
        for(int i=0;i<level.size();i++){
            int num = level.get(i);
            if(left.contains(num)){
                leftLevel.add(num);
            }else if(right.contains(num)){
                rightLevel.add(num);
            }
        }
        cur.left = construct(leftmid,leftLevel);
        cur.right = construct(rightmid,rightLevel);
        return cur;
    }

    static class Node{
        Node left;
        Node right;
        int val;
    }

    public static void main10211(String[] args) {
        Scanner in = new Scanner(System.in);
        String m = in.nextLine();
        int[] occurrences = new int[26];
        Arrays.fill(occurrences,0);
        for(char c: m.toCharArray()){
            occurrences[c-'a'] += 1;
        }
        Arrays.sort(occurrences);
        int res = 0;
        for(int i = 0;i < occurrences.length-2;i++){
            res += occurrences[i]*occurrences[i];
        }
        int temp = occurrences[24]+occurrences[25];
        res += temp*temp;
        System.out.println(res);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String version1 = in.nextLine();
        String version2 = in.nextLine();
        String[] vStrs1 = version1.split("\\.");
        String[] vStrs2 = version2.split("\\.");
        int i = 0;
        for(;i<vStrs1.length && i<vStrs2.length;i++){
            if(toInt(vStrs1[i])>toInt(vStrs2[i])){
                System.out.println("1");
                return;
            }
            else if(toInt(vStrs1[i])<toInt(vStrs2[i])){
                System.out.println("-1");
                return;
            }
        }
        if(vStrs1.length == vStrs2.length){
            System.out.println("0");
            return;
        }
        if(i<vStrs1.length){
            boolean allzero = true;
            for(;i<vStrs1.length;i++){
                if(toInt(vStrs1[i])!=0){
                    allzero = false;
                    break;
                }
            }
            if(!allzero){
                System.out.println("1");
            }
            else {
                System.out.println("0");
            }
            return;
        }
        if(i<vStrs2.length){
            boolean allzero = true;
            for(;i<vStrs2.length;i++){
                if(toInt(vStrs2[i])!=0){
                    allzero = false;
                    break;
                }
            }
            if(!allzero){
                System.out.println("-1");
            }
            else {
                System.out.println("0");
            }
        }
    }
    private static int toInt(String numStr){
        int i = 0;
        while (i<numStr.length() && numStr.charAt(i)=='0') {
            i++;
        }
        if(i==numStr.length()){
            return 0;
        }
        return Integer.parseInt(numStr.substring(i));
    }
}













