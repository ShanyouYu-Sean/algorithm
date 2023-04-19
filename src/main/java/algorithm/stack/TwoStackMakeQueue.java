package algorithm.stack;

import java.util.Stack;

/**
 * 两个栈组成队列
 */
public class TwoStackMakeQueue {

    // 两个栈组成队列
    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();
    public void push(int node){
        stack1.push(node);
    }
    public int pop(){
        if (!stack2.isEmpty()){
            return stack2.pop();
        }else {
            while (!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
            return !stack2.isEmpty() ? stack2.pop() : -1;
        }
    }

}
