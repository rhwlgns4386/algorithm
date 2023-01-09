import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N1300 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        long n=Integer.parseInt(in.readLine());
        long k=Integer.parseInt(in.readLine());

        long left=1;
        long right=n*n;
        long ans=0;
        while (left<=right){
            long cnt=0;
            long mid=(left+right)/2;
            for(long i=1;i<=n;i++){
                cnt+=Math.min(n,mid/i);
            }
            if(cnt>=k){
                ans=mid;
                right=mid-1;
            }
            else {
                left=mid+1;
            }
        }
        System.out.println(ans);
    }
}
