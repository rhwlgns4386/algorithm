import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N11729 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(in.readLine());
        StringBuilder stringBuilder = new StringBuilder();
        System.out.println(solution(1,3,n,stringBuilder)-1);
        System.out.println(stringBuilder);
    }

    private static int solution(int before, int after, int n,StringBuilder sb) {
        if(n==0) return 1;
        int cnt=0;
        cnt+=solution(before,6-before-after,n-1,sb);
        sb.append(n+"\n");
        sb.append(before+" "+after+"\n");
        cnt+=solution(6-before-after,after,n-1,sb);
        return cnt;
    }
}
