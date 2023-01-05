package algospot;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CLOCKSYNC {
    public static int C, INF=9999, SWITCH=10, CLOCKS=16;
    /* 스위치와 연결된 시계 정보 */
    public static int[][] linkedClock = {
            {0, 1, 2},
            {3, 7, 9, 11},
            {4, 10, 14, 15},
            {0, 4, 5, 6, 7},
            {6, 7, 8, 10, 12},
            {0, 2, 14, 15},
            {3, 14, 15},
            {4, 5, 7, 14, 15},
            {1, 2, 3, 4, 5},
            {3, 4, 5, 9, 13}
    };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int C = Integer.parseInt(br.readLine());

        for (int i = 0; i < C; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int[] clocks = new int[CLOCKS];
            for (int j = 0; j < CLOCKS; j++) {
                clocks[j] = Integer.parseInt(st.nextToken())%4;
            }

            System.out.println(solution(clocks));
        }
    }

    private static int solution(int[] clocks) {

        int result=go(clocks,0);
        return result!=INF?result:-1;
    }

    private static int go(int[] clocks,int sweetch) {
        if(sweetch==SWITCH) return areAligned(clocks)?0:INF;

        int result=INF;
        for (int i = 0; i < 4; i++) {
            result=Math.min(go(clocks,sweetch+1)+i,result);
            updateClocks(clocks,sweetch);
        }

        return result;
    }

    private static void updateClocks(int[] clocks, int swtch) {
        for (int i = 0; i < linkedClock[swtch].length; i++) {
            int nClock=linkedClock[swtch][i];
            clocks[nClock] += 3;
            if(clocks[nClock]==15) clocks[nClock]=3;
        }
    }

    public static boolean areAligned(int[] clocks) {
        for(int ck=0; ck<CLOCKS; ck++)
            if (clocks[ck] % 4 != 0) // 12시를 가리키지 않는 시계가 있을 경우
                return false;
        return true;
    }
}
