package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class N1918 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String infix = in.readLine();

        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        for(int i=0;i<infix.length();i++){
            Character here = infix.charAt(i);

            switch (here){
                case '+':
                case '-':
                case '*':
                case '/':
                    while (!stack.isEmpty() && findOrder(stack.peek())>=findOrder(here)){
                        sb.append(stack.pop());
                    }
                    stack.add(here);
                    break;
                case '(':
                    stack.add(here);
                    break;
                case ')':
                    while(!stack.isEmpty() && stack.peek() != '('){
                        sb.append(stack.pop());
                    }
                    stack.pop();
                    break;
                default:
                    sb.append(here);
            }
        }

        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        System.out.println(sb);
    }

    private static int findOrder(Character peek) {
       switch (peek){
           case '(':
           case ')':
               return 0;
           case '*':
           case '/':
               return 2;
           case '+':
           case '-':
               return 1;
           default:
               return -1;
       }
    }
}
