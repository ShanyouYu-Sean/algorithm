package algorithm.array;

/**
 * 移动零
 * p 表示非零，碰到零就交换，然后 p 后面就都是零
 */
public class MoveZero {

    // 移动零
    public void moveZeros(int[] nums){
        if (nums == null || nums.length == 0){
            return;
        }
        int p = 0;
        for (int i = 0; i < nums.length; i++){
            if (nums[i] != 0){
                nums[p] = nums[i];
                p ++;
            }
        }
        for (int i = p; i < nums.length; i++){
            nums[i] = 0;
        }
    }

}
