package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class N2504 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line = in.readLine();
        Queue<Character> q = new LinkedList<>();
        for(int i=0;i<line.length();i++){
            q.add(line.charAt(i));
        }

        int ans=0;
        while (!q.isEmpty()){
            int result = go(q);
            if(result==0){
                ans=0;
                break;
            }
            ans+=result;
        }
        System.out.println(ans);
    }

    private static int go(Queue<Character> line) {
        Character pre = line.remove();
        if(pre.equals(')') || pre.equals(']')) return 0;

        int sum=0;
        while (!line.isEmpty()){
            if(line.peek().equals('(') || line.peek().equals('[')){
                int result=go(line);
                if(result==0){
                    return 0;
                }
                sum+=result;
            }else{
                break;
            }
        }

        if(line.isEmpty()){
            return 0;
        }

        Character suf = line.remove();
        if(pre.equals('(') && suf.equals(')')){
            if(sum==0){
                return 2;
            }
            return sum*2;
        }

        if(pre.equals('[') && suf.equals(']')){
            if(sum==0){
                return 3;
            }
            return sum*3;
        }

        return 0;
    }
}
