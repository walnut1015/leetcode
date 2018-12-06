package basic_algorithms;

/**
 * @author tanya
 * @date 2018/8/30 15:03
 */
public class Practices {
    public int[] sort(int[] nums){
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }
    private void quickSort(int[] nums, int start, int end){
        int i = start, j = end;
        if(i > j || start <0 || end >= nums.length ){
            return ;
        }
        int key = nums[i];
        while (i<j){
            //目前key位于数组的其实位置，所以和key进行交换的数值a，是位于数组首位的
            //要想依然保持比key小，则需要从j 遍历到i，以使得最后 i == j
            //停下来的时候 nums[j] < key.
            while (i<j && nums[j] >= key){
                j--;
            }
            while (i < j && nums[i] <= key){
                i++;
            }
            swap(nums, i, j);
        }
        swap(nums, start, j);
        quickSort(nums, start, j - 1);
        quickSort(nums, j + 1, end);
    }
    private void swap(int[] nums, int leftIndex, int rightIndex){
        int temp = nums[leftIndex];
        nums[leftIndex] = nums[rightIndex];
        nums[rightIndex] = temp;
    }

    public void bubbleSort(int[] nums){
        int len = nums.length;
        int count = 0;
        for(int i = 0; i < len; i++){
            boolean swapped = false;
            for(int j = 0; j < len - i - 1; j++){
                if(nums[j] > nums[j+1]){
                    swap(nums, j, j+1);
                    swapped = true;
                    count++;
                }
            }
            if(!swapped){
                break;
            }
        }
        System.out.println("一共交换"+count+"次");
    }
    public void insertSort(int[] nums){
        if(nums == null || nums.length<2){
            return;
        }
        for(int i = 1; i < nums.length;i++){
            int temp = nums[i];
            int j = i - 1;
            for(; j>-1;j--){
                if(nums[j] > temp){
                    nums[j+1] = nums[j];
                }
                else {
                    break;
                }
            }
            nums[j+1] = temp;
        }
    }

    /**
     * 二分查找算法
     * @param nums
     * @param start
     * @param end
     * @param target
     * @return target在nums中的位置
     */
    public int binarySearch(int[] nums,int start,int end, int target){
        if(start>end){
            return -1;
        }
        int mid = (start+end)/2;
        if(target == nums[mid]){
            return mid;
         }
        else if(target > nums[mid]){
            return binarySearch(nums, mid+1,end,target);
        }
        else{
            return binarySearch(nums, start, mid - 1, target);
        }
    }
}
