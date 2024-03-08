package Leetcode;

import java.util.ArrayList;
import java.util.Scanner;

public class Valid_parenthesis {
    public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String s = sc.next();
        System.out.println(Bracket(s));
    }
    public static boolean Bracket(String s){
        ArrayList<Character> openingBrackets=new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(ch == '('|| ch =='{' || ch=='['){
                openingBrackets.add(ch);
            } else if (ch == ')'|| ch=='}' || ch==']') {
                if (openingBrackets.isEmpty()|| !Valid(openingBrackets.remove(openingBrackets.size()-1),ch)){
                return false;
                }

            }

        }

    return openingBrackets.isEmpty();

    }

    private static boolean Valid(char o, char c) {
        return (o == '(' && c == ')') || (o == '{' && c == '}') || (o == '[' && c == ']');
    }


}
