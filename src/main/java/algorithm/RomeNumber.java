package algorithm;

import java.util.HashMap;
import java.util.Map;

/**
 * 罗马数字转整数
 */
public class RomeNumber {

    // 罗马数字转整数
    Map<Character, Integer> symbolValues = new HashMap<>() {{
        put('I', 1);
        put('V', 5);
        put('X', 10);
        put('L', 50);
        put('C', 100);
        put('D', 500);
        put('M', 1000);
    }};

    public int romanToInt(String s) {
        int res = 0;
        int n = s.length();
        for (int i = 0; i < n; i++) {
            int value = symbolValues.get(s.charAt(i));
            // 当前数字比后一个小，需要减
            if (i < n - 1 && value < symbolValues.get(s.charAt(i + 1))) {
                res -= value;
            } else {
                res += value;
            }
        }
        return res;
    }

}
