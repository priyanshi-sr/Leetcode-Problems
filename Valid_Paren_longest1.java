package Leetcode;

import java.util.ArrayList;
import java.util.Scanner;

public class Valid_Paren_longest1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        System.out.println(longestValidParentheses(s));
    }

    public static int longestValidParentheses(String s) {
        ArrayList<Character> openingBrackets = new ArrayList<>();
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                openingBrackets.add(ch);
            } else if (ch == ')' && !openingBrackets.isEmpty() && Valid(openingBrackets.get(openingBrackets.size() - 1), ch)) {
                openingBrackets.remove(openingBrackets.size() - 1);
                count += 2;
            }
        }
        return count;
    }

    private static boolean Valid(char o, char c) {
        return (o == '(' && c == ')');
    }


}

// ALTERNATE SOLUTION
//class Solution {
//    public int longestValidParentheses(String s) {
//        int ans = 0,left = 0,right = 0;
//        for(int i = 0; i < s.length(); i++){
//            if(s.charAt(i) == '('){
//                left++;
//            }else{
//                right++;
//            }if(left == right){
//                ans = Math.max(ans, left * 2);
//            }else if(right > left){
//                left = 0; right = 0;
//            }
//        }
//        left = 0; right = 0;
//        for(int i = s.length() - 1; i >= 0 ; i--){
//            if(s.charAt(i) == '('){
//                left++;
//            }else{
//                right++;
//            }if(left == right){
//                ans = Math.max(ans, right * 2);
//            }else if(right < left){
//                left = 0; right = 0;
//            }
//        }
//        return ans;
//    }
//}
