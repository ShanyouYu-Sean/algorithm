package algorithm;

/**
 * 斐波那契数列
 * （跳台阶）
 */
public class JumpFloor {

    // 斐波那契数列（跳台阶）
    public int jumpFloor(int target){
        if (target <= 1){
            return target;
        }
        int cur = 0;
        int p1 = 0;
        int p2 = 1;
        // 跳台阶 i = 1, 斐波那契 i = 2
        for (int i = 2; i <= target; i++){
            cur = p1 + p2;
            p1 = p2;
            p2 = cur;
        }
        return cur;
    }

}
