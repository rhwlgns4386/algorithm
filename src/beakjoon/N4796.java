package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N4796 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int count=0;
        while (true){
            StringTokenizer st = new StringTokenizer(in.readLine());
            count++;
            int l=Integer.parseInt(st.nextToken());
            int p=Integer.parseInt(st.nextToken());
            int v=Integer.parseInt(st.nextToken());
            if(l+p+v==0){
                break;
            }

            int result=l*(v/p);
            v-=p*(v/p);
            if (l <= v) {
                result+=l;
            }else{
                result+=v;
            }

            System.out.println(String.format("Case %d: %d",count,result));
        }
    }
}
