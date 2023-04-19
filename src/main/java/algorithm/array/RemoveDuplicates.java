package algorithm.array;

/**
 * 删除有序数组中的重复项
 * 返回删除后数组的新长度
 * 原地 删除
 * 双指针，碰到了重复的右指针 + 1
 * 不重复左指针 + 1，右指针值覆盖左指针
 */
public class RemoveDuplicates {

    // 删除有序数组中的重复项
    // 双指针，碰到了重复的右指针 + 1，不重复左指针 + 1，右指针值覆盖左指针
    public int removeDuplicates(int[] nums) {
        if(nums == null || nums.length == 1){
            return 1;
        }
        int i = 0, j = 1;
        while(j < nums.length){
            if (nums[i] != nums[j]) {
                i++;
                nums[i] = nums[j];
            }
            j++;
        }
        return i + 1;
    }

}
