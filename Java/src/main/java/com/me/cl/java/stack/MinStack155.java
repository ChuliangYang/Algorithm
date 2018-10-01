package com.me.cl.java.stack;

import java.util.Stack;

/**
 * 155.
 * Min Stack
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
 *
 * push(x) -- Push element x onto stack.
 * pop() -- Removes the element on top of the stack.
 * top() -- Get the top element.
 * getMin() -- Retrieve the minimum element in the stack.
 * Example:
 *
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin();   --> Returns -3.
 * minStack.pop();
 * minStack.top();      --> Returns 0.
 * minStack.getMin();   --> Returns -2.
 */
public class MinStack155 {
    Stack<Integer> backed;
    Stack<Integer> minStack;
    /** initialize your data structure here. */
    public MinStack155() {
        backed=new Stack<>();
        minStack=new Stack<>();
    }

    public void push(int x) {
        backed.push(x);
        if(minStack.isEmpty()||(!minStack.isEmpty()&&x<=minStack.peek())){
            minStack.push(x);
        }
    }

    public void pop() {
        if(backed.peek().equals(minStack.peek())){
            minStack.pop();
        }
        backed.pop();
    }

    public int top() {
        return backed.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
