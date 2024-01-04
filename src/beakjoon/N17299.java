package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Stack;
import java.util.StringTokenizer;

public class N17299 {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        
        int n=Integer.parseInt(in.readLine());
        StringTokenizer st = new StringTokenizer(in.readLine());
        int[] A = new int[n];
        HashMap<Integer, Integer> F = new HashMap<>();
        for(int i=0;i<n;i++){
            A[i]=Integer.parseInt(st.nextToken());
            if(!F.containsKey(A[i])){
                F.put(A[i],0);
            }
            F.put(A[i],F.get(A[i])+1);
        }

        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<n;i++){
            while (!stack.isEmpty() && F.get(A[stack.peek()])<F.get(A[i])){
                result[stack.pop()]=A[i];
            }
            stack.push(i);
        }

        while (!stack.isEmpty()){
            result[stack.pop()]=-1;
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<n; i++) {
            sb.append(result[i] + " ");
        }
        System.out.println(sb);
    }
}
