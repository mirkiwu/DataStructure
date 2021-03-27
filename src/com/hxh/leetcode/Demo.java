package com.hxh.leetcode;

import java.util.Stack;

/**
 * @author huangxunhui
 * Date: Created in 18/10/7 上午11:47
 * Utils: Intellij Idea
 * Description:
 */
public class Demo {
}


class Solution{
    public boolean isVaild(String s){

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length()  ; i++) {
            char c = s.charAt(i);
            if(c == '(' || c == '[' || c == '{' ){
                stack.push(c);
            }else{
                if(stack.empty()){
                    return false;
                }
                Character topChar = stack.pop();
                if(c == ')' && topChar != '('){
                    return false;
                }
                if(c == ']' && topChar != '['){
                    return false;
                }
                if(c == '}' && topChar != '{'){
                    return false;
                }
            }
        }
        return stack.empty();
    }
}


