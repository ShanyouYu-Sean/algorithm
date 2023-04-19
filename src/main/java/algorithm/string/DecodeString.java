package algorithm.string;

import java.util.Stack;

public class DecodeString {

	// 字符串解码
	public String decodeString(String s) {
		Stack<Character> stack = new Stack<>();
		for(char c : s.toCharArray()) {
			// 把所有的字母push进去，除了]
			if( c != ']') {
				stack.push(c);
			}else {
				//step 1: 取出[] 内的字符串
				StringBuilder sb = new StringBuilder();
				while(!stack.isEmpty() && Character.isLetter(stack.peek())){
					sb.insert(0, stack.pop());
				}
				String sub = sb.toString(); //[ ]内的字符串
				stack.pop(); // 去除[
				//step 2: 获取倍数数字
				sb = new StringBuilder();
				while(!stack.isEmpty() && Character.isDigit(stack.peek())){
					sb.insert(0, stack.pop());
				}
				int count = Integer.parseInt(sb.toString()); //倍数
				//step 3: 根据倍数把字母再push回去
				while(count > 0) {
					for(char ch : sub.toCharArray()){
						stack.push(ch);
					}
					count--;
				}
			}
		}
		//把栈里面所有的字母取出来
		StringBuilder res = new StringBuilder();
		while(!stack.isEmpty()){
			res.insert(0, stack.pop());
		}
		return res.toString();
	}
}
