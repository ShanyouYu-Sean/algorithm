package algorithm.longest;

import java.util.HashSet;
import java.util.Set;

/**
 * 无重复字符的最长子串
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 */
public class LongestSubstring {

    // 无重复字符的最长子串
    public int lengthOfLongestSubstring(String s) {
        int res = 0;
        Set<Character> window = new HashSet<>();
        char[] sArray = s.toCharArray();
        int left = 0, right = 0;
        while(right < sArray.length){
            while(window.contains(sArray[right])){
                window.remove(sArray[left++]);
            }
            window.add(sArray[right]);
            res = Math.max(res, right - left + 1);
            right++;
        }
        return res;
    }
}
