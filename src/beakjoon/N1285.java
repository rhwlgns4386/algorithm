package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class N1285 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(in.readLine());
        char [][]a=new char[N][N];

        for(int i=0;i<N;i++){
            a[i]=in.readLine().toCharArray();
        }

        int answer = Integer.MAX_VALUE;
        for (int bit = 0; bit < (1<<N); bit++) {
            int sum=0;
            //열
            for(int j=0; j<N; j++) {
                int back = 0;
                //행
                for (int i = 0; i < N; i++) {
                    char curr = a[i][j];
                    if((bit & (1<<i)) != 0) {
                        curr = reverse(curr);
                    }
                    if(curr == 'T')
                        back++;
                }
                sum += Math.min(back, N-back);
            }
            answer = Math.min(answer, sum);
        }
        System.out.println(answer);
    }

    public static char reverse(char curr) {
        if(curr == 'T')
            return 'H';
        else
            return 'T';
    }
}
