import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N11047 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(in.readLine(), " ");
        int n=Integer.parseInt(stringTokenizer.nextToken());
        int k=Integer.parseInt(stringTokenizer.nextToken());

        int[] coins=new int[n];

        for(int i=0;i<n;i++){
            coins[i]=Integer.parseInt(in.readLine());
        }
        int cnt=0;
        for(int i=n-1;i>=0;i--){
            cnt+=k/coins[i];
            k%=coins[i];
        }

        System.out.println(cnt);

    }
}
