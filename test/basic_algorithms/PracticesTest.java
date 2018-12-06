package basic_algorithms;

import org.junit.Before;
import org.junit.Test;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;

/**
 * @author tanya
 * @date 2018/8/30 21:36
 */
public class PracticesTest {

    Practices practices = new Practices();
    @Test
    public void sort() {
        int[] nums = {4,2,5,10,3,7,9};
        practices.insertSort(nums);
        for (int ele: nums) {
            System.out.print(ele + "\t");
        }
        System.out.println();
    }

    @Test
    public void binarySearch(){
        int[] nums = {2,3,4,5,7,9,10};
        System.out.println(practices.binarySearch(nums,0,nums.length-1,4));
    }
}