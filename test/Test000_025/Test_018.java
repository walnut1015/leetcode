package Test000_025; /**
 * Created by Tanya on 2017/6/11.
 */
import LeetCode000_025.Solution018;
import org.junit.Test;
import java.util.List;

public class Test_018 {
    @Test
    public void test()
    {
        Solution018 sol = new Solution018();
        int []nums = {-495,-477,-464,-424,-411,-409,-363,-337,-328,-328,-325,-320,-310,-285,-278,-235,-208,-151,-149,-147,-144,-132,-115,-107,-101,-98,-83,-58,-58,-56,-51,-46,-45,-7,0,4,4,21,51,52,57,60,104,109,124,141,158,205,206,241,278,278,291,314,379,416,437,447,452,496};
        List<List<Integer>> res = sol.fourSum2(nums,-1371);
        System.out.println();
    }
}
