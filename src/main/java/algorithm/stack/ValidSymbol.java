package algorithm.stack;

import java.util.Stack;

/**
 * 合法的括号
 */
public class ValidSymbol {

    // 合法的括号
    public boolean isValid(String s) {
        char[] sArr = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < sArr.length; i ++){
            if (sArr[i] == '['){
                stack.push(']');
            }else if (sArr[i] == '{'){
                stack.push('}');
            }else if (sArr[i] == '('){
                stack.push(')');
            }else if (!stack.isEmpty() && stack.pop() != sArr[i]){
                return false;
            }
        }
        if (!stack.isEmpty()){
            return false;
        }
        return true;
    }

    // 最长的有效括号
    public int longestValidParentheses(String s) {
        int maxLen = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    maxLen = Math.max(maxLen, i - stack.peek());
                }
            }
        }
        return maxLen;
    }

}
