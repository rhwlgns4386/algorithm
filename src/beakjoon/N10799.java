import java.io.*;
import java.util.Stack;

public class N10799 {
    public static void main(String[] args) throws IOException {
        Stack<Character> stack = new Stack<>();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String readLine = bufferedReader.readLine();
        int result = 0;
        Character tem=' ';
        for(Character ch:readLine.toCharArray()){
            if(ch=='('){
                stack.push(ch);
            }
            else if(ch==')'){
                stack.pop();
                if(tem=='(') result+=stack.size();
                else result+=1;
            }
            tem=ch;
        }
        System.out.println(result);
    }
}
