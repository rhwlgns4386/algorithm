package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N10942 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        in.readLine();
        String str=in.readLine();
        str=str.replace(" ","");
        int M=Integer.parseInt(in.readLine());
        for (int i = 0; i < M; i++) {
            StringTokenizer tokenizer=new StringTokenizer(in.readLine());
            int S=Integer.parseInt(tokenizer.nextToken())-1;
            int E=Integer.parseInt(tokenizer.nextToken());

            String substring = str.substring(S, E);
            StringBuffer stringBuffer=new StringBuffer(substring);
            stringBuffer.reverse();
            System.out.println(substring.equals(stringBuffer.toString())?1:0);
        }
    }
}
