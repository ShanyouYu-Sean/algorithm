package algorithm.stack;

import java.util.Stack;

/**
 * 包含min函数的栈
 * 通过一个辅助的最小栈来实现
 */
public class MinStack {

    public MinStack() {

    }

    // 包含min函数的栈
    Stack<Integer> s1 = new Stack<>();
    Stack<Integer> min = new Stack<>();
    public void push(int x) {
        s1.push(x);
        if(min.isEmpty()){
            min.push(x);
        }else{
            if(x < min.peek()){
                min.push(x);
            }else{
                min.push(min.peek());
            }
        }
    }
    public void pop() {
        s1.pop();
        min.pop();
    }
    public int top() {
        return s1.peek();
    }
    public int min() {
        return min.peek();
    }

}
