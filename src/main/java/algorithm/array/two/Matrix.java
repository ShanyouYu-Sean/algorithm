package algorithm.array.two;

import java.util.ArrayList;
import java.util.List;

/**
 * 螺旋矩阵
 */
public class Matrix {

    // 螺旋矩阵
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if (matrix.length == 0){
            return res;
        }
        int left = 0;
        int right = matrix[0].length - 1;
        int top = 0;
        int bottom = matrix.length - 1;
        while (left <= right && top <= bottom){
            for (int i = left; i <= right; i++){
                res.add(matrix[top][i]);
            }
            top ++;
            for (int i = top; i <= bottom; i++){
                res.add(matrix[i][right]);
            }
            right --;
            for (int i = right; i >= left && top <= bottom; i++){
                res.add(matrix[bottom][i]);
            }
            bottom --;
            for (int i = bottom; i >= top && left <= right; i++){
                res.add(matrix[i][left]);
            }
            left ++;
        }
        return res;
    }

}
