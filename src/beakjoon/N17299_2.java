package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Stack;
import java.util.StringTokenizer;

public class N17299_2 {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int n=Integer.parseInt(in.readLine());
        StringTokenizer st = new StringTokenizer(in.readLine());
        Stack<Integer> stack = new Stack<>();
        HashMap<Integer, Integer> F = new HashMap<>();
        for(int i=0;i<n;i++){
            stack.add(Integer.parseInt(st.nextToken()));
            if(!F.containsKey(stack.peek())){
                F.put(stack.peek(),0);
            }
            F.put(stack.peek(),F.get(stack.peek())+1);
        }

        Stack<Integer> history = new Stack<>();
        Stack<Integer> result=new Stack<>();
        while (!stack.isEmpty()){
            Integer pop = stack.pop();
            while (!history.isEmpty()&&F.get(pop)>=F.get(history.peek())) history.pop();
            if(history.isEmpty()){
                result.add(-1);
            }else{
                result.add(history.peek());
            }
            history.add(pop);
        }

        StringBuilder sb = new StringBuilder();
        while (!result.isEmpty()){
            sb.append(result.pop()+" ");
        }
        System.out.println(sb);
    }
}
