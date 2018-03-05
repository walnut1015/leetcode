package LeetCode051_100;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Tanya on 2017/10/9.
 */
public class Solution060Test {

    @Test
    public void testGetPermutation() throws Exception {
        Solution060 sol = new Solution060();
        for(int i = 1;i<=120;i++)
            System.out.println(sol.getPermutation(5,i));
    }
}