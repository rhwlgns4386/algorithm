package beakjoon;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.util.Scanner;
import java.util.Stack;

public class N1874 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Stack<Integer> stack = new Stack<>();
        StringBuffer str=new StringBuffer();
        Integer count=in.nextInt();
        Integer start=0;
        for(int i=0;i<count;i++){
            int value=in.nextInt();
            if(start<value){
                for(int j=start+1;j<=value;j++){
                    stack.push(j);
                    str.append("+").append("\n");
                }
                start=value;
            }
            else if(stack.peek()!=value){
                return;
            }

            stack.pop();
            str.append("-").append("\n");
        }
        System.out.println(str);
    }
}
