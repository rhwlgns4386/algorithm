package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N3020 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(in.readLine());
        int n=Integer.parseInt(stringTokenizer.nextToken());
        int h=Integer.parseInt(stringTokenizer.nextToken());
        int up_cnt[] = new int[h+1];
        int un_cnt[] = new int[h+1];

        for(int i=0;i<n;i++){
            int height=Integer.parseInt(in.readLine());
            if(i%2==0){
                un_cnt[height]++;
            }else{
                up_cnt[height]++;
            }
        }

        for(int i=h-1; i>0; i--){
            up_cnt[i] += up_cnt[i+1];
            un_cnt[i] += un_cnt[i+1];
        }

        int ans=n+1;
        for(int i=1;i<=h;i++){
            int cnt=up_cnt[i] + un_cnt[h-i+1];
            ans=Math.min(cnt,ans);
        }

        int count=0;
        for(int i=1;i<=h;i++){
            int cnt=up_cnt[i] + un_cnt[h-i+1];
            if(cnt==ans){
                count++;
            }
        }

        System.out.println(ans+" "+count);
    }
}
