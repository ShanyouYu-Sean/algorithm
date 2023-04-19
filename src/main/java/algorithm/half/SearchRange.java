package algorithm.half;

/**
 * 在排序数组中查找元素的第一个和最后一个位置
 * 二分法后，双指针while向两端移动
 */
public class SearchRange {

    // 在排序数组中查找元素的第一个和最后一个位置
    // 二分法后，双指针while向两端移动
    public int[] searchRange(int[] nums, int target) {
        if(nums == null || nums.length == 0){
            return new int[]{-1, -1};
        }
        int left = 0;
        int right = nums.length - 1;
        int first = -1;
        int last = -1;
        while(left <= right){
            int mid = (left + right)/2;
            if(target > nums[mid]){
                left = mid + 1;
            }else if(target < nums[mid]){
                right = mid - 1;
            }else{
                first = mid;
                last = mid;
                break;
            }
        }
        if(first == -1 && last == -1){
            return new int[]{-1, -1};
        }
        while( (first >= 0 && nums[first] == target) ||
                (last < nums.length && nums[last] == target) ){
            if(first >= 0 && nums[first] == target){
                first--;
            }
            if(last <= nums.length && nums[last] == target){
                last++;
            }
        }
        return new int[]{first + 1, last - 1};
    }

}
