package LeetCode000_025;

/**
 * Created by Tanya on 2017/2/21.
 * leetcode第11题，一直没有一个好的思路，拿到题就想着用动态规划或者
 * 分治法，一直无解。考虑分治法的时候一直试图从中间向两边扩展纵线，
 * 但看到其他人的答案发现他们采用的是从两边向中间逼近的贪心策略的方法，更简单。
 * 当然，分治法也能做出来，但是由于我的行动力不强，也没能好好思考出对应的解法。
 */
public class Solution011 {
    public static void main(String []args)
    {
        Solution011 s = new Solution011();
        int []height = {3,2,0,0,1,0,13,2,3,15,1,3};
        System.out.print(s.maxArea(height));
    }
    public int maxArea(int[] height)
    {
        int maxarea = 0;
        int len = height.length;
        int maxArea = getArea(height,0,len-1);
        int currentL = 0, currentR = len-1;
        for(int i =0,j=len-1;i<j;)
        {
            if(height[i]<height[j])
            {
                int k = i+1;
                while(k<j && height[k]<=height[i]) k++;
                if(k != j) maxArea=max(maxArea, getArea(height, k,j));
                i = k;
            }
            else
            {
                int k = j-1;
                while(k>i && height[k]<=height[j]) k--;
                if(k != i) maxArea=max(maxArea, getArea(height, i,k));
                j = k;
            }
        }
        return maxArea;

    }
    private int maxAreaDC(int[] height, int start, int end)
    {
        if(start >= end) return 0;
        int mid=(start+end)/2;
        int maxLArea = maxAreaDC(height, start, mid);
        int maxRArea = maxAreaDC(height, mid+1,end);
        int l = mid, r = mid + 1;
        int currentArea = getArea(height,l,r);
        int smaller = height[l]<height[r]?l:r;
        while(l-1>=start  && r+1<=end)
        {
            if(height[l] <= 0) l--;
            else if(height[r]<=0) r++;
            else
            {
                int a = getArea(height, l-1,r);
                int b = getArea(height, l,r+1);
                if(a>b);

            }
        }
        return 0;
    }
    private int max(int a, int b)
    {
        return a>b?a:b;
    }
    private int getArea(int []height, int l, int r)
    {
        if(l >= r)
        {
            System.out.print("Error in function getArea!");
            System.exit(-1);
        }
        int smaller = height[l]<height[r]?height[l]:height[r];
        return (r-l)*smaller;
    }
}