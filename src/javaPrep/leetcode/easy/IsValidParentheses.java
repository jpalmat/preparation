package javaPrep.leetcode.easy;

import java.util.Stack;

public class IsValidParentheses {

    public static void main(String[] args) {
        System.out.println(isValid("()"));
    }



    public static boolean isValid(String s){
        Stack<String> stack = new Stack<>();

        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i)=='(' || s.charAt(i)=='[' || s.charAt(i)=='{'){
                stack.push(String.valueOf(s.charAt(i)));
                continue;
            }

            if(s.charAt(i)==')' && !stack.isEmpty() && stack.peek().equals("(")){
                stack.pop();

            } else if(s.charAt(i)==']' && !stack.isEmpty() && stack.peek().equals("[")){
                stack.pop();
            } else if(s.charAt(i)=='}' && !stack.isEmpty() && stack.peek().equals("{")){
                stack.pop();
            } else {
                return false;
            }
        }

        return stack.isEmpty();
    }
}
