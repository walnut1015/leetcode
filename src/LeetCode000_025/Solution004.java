package LeetCode000_025;

public class Solution004 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        double median = 0;
        int len1 = nums1.length;
        int len2 = nums2.length;
        int len = len1+len2;
        median = findKthNum(nums1, 0, len1-1, nums2, 0, len2-1, (len1+len2+1)/2);
        if(len%2 == 0)
        {
            int median2 = findKthNum(nums1, 0, len1-1, nums2, 0, len2-1, (len1+len2+1)/2+1);
            median = (median+median2)/2.0;
        }
        return median;
    }
    private int findKthNum(int[] a,int abeg, int aend, int[]b, int bbeg, int bend, int k)
    {
        if(abeg>aend)
            return b[bbeg+k-1];
        if(bbeg>bend)
            return a[abeg+k-1];
        int amid = (aend + abeg) / 2;
        int bmid = (bend + bbeg) / 2;
        if(a[amid] <= b[bmid])
        {
            int x = amid - abeg + bmid - bbeg + 1; //两个数组组合之后排在b[bmid]之前的数字个数至少为x
            if(k <= x)
                return findKthNum(a,abeg, aend, b, bbeg, bmid-1, k);
            else
                return findKthNum(a,amid+1, aend, b, bbeg, bend,k-(amid - abeg +1));
        }
        else
        {
            int y = bmid - bbeg + amid - abeg + 1;
            if(k <= y)
                return findKthNum(a,abeg, amid-1, b, bbeg, bend, k);
            else
                return findKthNum(a,abeg, aend, b, bmid+1, bend,k-(bmid - bbeg +1));
        }

    }
    public static void main1(String []args)
    {
        int []nums1 = {1,2};
        int []nums2 = {3,4};
        Solution004 s = new Solution004();
        System.out.print(s.findMedianSortedArrays(nums1,nums2));
    }
}