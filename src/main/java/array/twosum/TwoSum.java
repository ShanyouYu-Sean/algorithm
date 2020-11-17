package array.twosum;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        if (nums != null){
            Map<Integer, Integer> map = new HashMap<>();
            for(int i = 0; i < nums.length; i ++){
                // key 是数组当前数
                int key = nums[i];
                // value 是数组下标
                int value = i;
                // check 是待检查值
                int check = target - nums[i];
                if(map.get(check) == null){
                    // 没有检查值就放进map里
                    map.put(key, value);
                }else{
                    // 检查到了就输出
                    int[] result = {map.get(check), value};
                    return result;
                }
            }
            return null;
        }
        return null;
    }
}
