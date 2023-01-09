import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class N17413 {
    public static void main(String[] args) throws IOException {
        boolean flag=false;
        Stack<Character> stack = new Stack<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String readLine = br.readLine();
        readLine+=" ";
        StringBuffer stringBuffer=new StringBuffer();
        for(Character ch:readLine.toCharArray()){
            if(ch=='<'){
                int size = stack.size();
                for(int i=0;i<size;i++){
                    stringBuffer.append(stack.pop());
                }
                stringBuffer.append(ch);
                flag=true;
            }
            else if(ch=='>'){
                stringBuffer.append(ch);
                flag=false;
            }
            else if(ch==' '){
                int size = stack.size();
                for(int i=0;i<size;i++){
                    stringBuffer.append(stack.pop());
                }
                stringBuffer.append(ch);
            }
            else if(flag==false) {
                stack.push(ch);
            }
            else {
                stringBuffer.append(ch);
            }
        }
        System.out.println(stringBuffer.toString());

    }
}
