package programmers;

import java.io.IOException;
import java.util.Arrays;

public class N214289 {
    public static void main(String[] args) throws IOException {
//        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(in.readLine());
//        int a=Integer.parseInt(st.nextToken());
//        int b=Integer.parseInt(st.nextToken());
//        int s=Integer.parseInt(st.nextToken());
//
//        System.out.println((b *Math.ceil((s/(double)2))));
//        System.out.println(a*s);

        Solution solution = new Solution();
        System.out.println( solution.solution(28,18,26,10,8,new int[]{0, 0, 1, 1, 1, 1, 1}));
        System.out.println( solution.solution(-10,-5,5,5,1,new int[]{0, 0, 0, 0, 0, 1, 0}));
        System.out.println( solution.solution(11,8,10,10,1,new int[]{0, 1, 1, 1, 1, 1, 1, 0, 0, 0, 1, 1}));
        System.out.println( solution.solution(11,8,10,10,100,new int[]{0, 1, 1, 1, 1, 1, 1, 0, 0, 0, 1, 1}));
    }

    static class Solution {
        /*
        에어컨은 t1~t2를 유지 -10<t1<t2<=40
        희망온도==실내온도 b원 1<=a,b<=100
        아니라면 a원
        off시 초당 실외온도쪽으로 실내온도 1 감소 or 증가
        -10<=실외 온도<=40
        출력 최소값
        a<b 왔다갔다하는게 존나 이득
        첫 번째 숫자 인덱스를 기록할 필요는 있음

        시간복잡도 : 1000^2
        */
        public int solution(int temperature, int t1, int t2, int a, int b, int[] onboard) {

            int answer=100*1000+1;
            t1+=10;
            t2+=10;
            temperature+=10;

            int[][] dp=new int[onboard.length+1][Math.max(t2,temperature)+2];

            for(int i=0;i<onboard.length+1;i++){
                Arrays.fill(dp[i],100*1000+1);
            }

            dp[0][temperature]=0;

            for(int i=0;i<onboard.length;i++){
                int start=Math.min(t1,temperature);
                int end=Math.max(t2,temperature);

                if(onboard[i]==1){
                    start=t1;
                    end=t2;
                }

                for(int j=start;j<=end;j++){
                    if(temperature<j){
                        dp[i+1][j]=Math.min(dp[i+1][j],dp[i][j]+b);
                        if(j!=0) {
                            dp[i + 1][j - 1] = Math.min(dp[i + 1][j - 1], dp[i][j]);
                        }
                        dp[i+1][j+1]=Math.min(dp[i+1][j+1],dp[i][j]+a);
                    }else if(temperature>j){
                        dp[i+1][j]=Math.min(dp[i+1][j],dp[i][j]+b);
                        if(j!=0){
                            dp[i+1][j-1]=Math.min(dp[i+1][j-1],dp[i][j]+a);
                        }
                        dp[i+1][j+1]=Math.min(dp[i+1][j+1],dp[i][j]);
                    }else if(temperature==j){
                        dp[i+1][j]=Math.min(dp[i+1][j],dp[i][j]);
                        if(temperature<t1){
                            dp[i+1][j+1]=Math.min(dp[i+1][j+1],dp[i][j]+a);
                        }else{
                            dp[i+1][j-1]=Math.min(dp[i+1][j-1],dp[i][j]+a);
                        }
                    }
                }
            }

            for(int i=0;i<dp[0].length;i++){
                answer=Math.min(dp[onboard.length][i],answer);
            }

            return answer;
        }
    }
}
