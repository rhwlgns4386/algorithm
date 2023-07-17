package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Stack;

public class N16120 {
    private static final String ppap="PPAP";
    private static Stack<Character> stack;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String s = in.readLine();
        stack = new Stack<>();
        for(int i=s.length()-1;0<=i;i--){
            stack.add(s.charAt(i));
            while (4<=stack.size()&&isPPAP()){
                for(int j=0;j<4;j++){
                    stack.pop();
                }
                stack.add('P');
            }
        }

        if(stack.size()==1 && stack.peek()=='P'){
            System.out.println("PPAP");
        }else {
            System.out.println("NP");
        }
    }

    private static boolean isPPAP() {
        for(int i = 0; i<4; i++){
            if(!(stack.get(stack.size()-i-1)==ppap.charAt(i))){
                return false;
            }
        }
        return true;
    }
}
