package algorithm.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 先排序, 然后左右指针两端迫近
 */
public class ThreeSum {

    // 2 sum
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++){
            int a = target - nums[i];
            if (!map.containsKey(a)){
                map.put(nums[i], i);
            }else {
                return new int[]{i, map.get(a)};
            }
        }
        return new int[0];
    }

    // 3 sum
    // 先排序, 然后左右指针两端迫近
    public List<List<Integer>> threeSum(int[] num) {
        List<List<Integer>> res = new ArrayList<>();
        if (num.length < 3){
            return res;
        }
        Arrays.sort(num);
        for (int i = 0; i < num.length; i++){
            // 确定枚举值, 相同的跳过
            if (i > 0 && num[i] == num[i-1]){
                continue;
            }
            int left =  i + 1, right = num.length - 1;
            int sum = 0 - num[i];
            while (left < right){
                if (num[left] + num[right] == sum){
                    res.add(Arrays.asList(num[i], num[left], num[right]));
                    // 相同的跳过
                    while (left < right && num[left] == num[left + 1]){
                        left ++;
                    }
                    // 相同的跳过
                    while (left < right && num[right] == num[right - 1]){
                        right --;
                    }
                    // 指针迫近
                    left ++;
                    right --;
                }else if (num[left] + num[right] > sum){
                    right --;
                }else {
                    left ++;
                }
            }
        }
        return res;
    }
}
