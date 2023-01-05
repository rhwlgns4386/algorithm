package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N14501 {
    public static int N;
    public static int[] tList;
    public static int[] pList;
    public static void main(String[] args) throws IOException {
        /*
        N+1일날 퇴사
        N 일동안 최대한 많은 상담을 진행
        퇴사전 까지의 최대 수익 구하기

        입력
        1<=N<=15
        1=<Ti<=5
        1=<Pi<=1000
         */

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        N=Integer.parseInt(in.readLine());
        tList=new int[N+1];
        pList=new int[N+1];

       for (int i = 1; i <=N; i++) {
           StringTokenizer st = new StringTokenizer(in.readLine(), " ");
           tList[i]=Integer.parseInt(st.nextToken());
           pList[i]=Integer.parseInt(st.nextToken());
       }


        int solution = solution(1, 0);
        System.out.println(solution);
    }

    /*
    끝나는경우:
    day==N+1=return p
    n+1<day=return 0;
    진행: 위 두경우가 되지않는경우
     */
    public static int solution(int day,int p){
        if(day==N+1){
            return p;
        }
        int result=0;
        if(day + tList[day]<=N+1){
            result= solution(day + tList[day], p + pList[day]);
        }
        p=Math.max(result,solution(day+1,p));
        return p;
    }
}
