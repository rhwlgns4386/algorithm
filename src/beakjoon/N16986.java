package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N16986 {

    private static int N;
    private static int K;
    private static int[][] compatibility;
    private static int[][] playerInput;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        compatibility = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(in.readLine());
            for (int j = 0; j < N; j++) {
                compatibility[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        playerInput = new int[3][20];
        st = new StringTokenizer(in.readLine());
        for (int i = 0; i < 20; i++) {
            playerInput[1][i] = Integer.parseInt(st.nextToken()) - 1;
        }

        st = new StringTokenizer(in.readLine());
        for (int i = 0; i < 20; i++) {
            playerInput[2][i] = Integer.parseInt(st.nextToken()) - 1;
        }

        boolean[] visit = new boolean[N];
        if (go(visit, 0, 0, 0, 0, 0, 0, 1)) {
            System.out.println(1);
            return;
        }

        System.out.println(0);
    }

    private static boolean go(boolean[] visit, int player1Count, int player2Count, int player1Win,
            int player2Win, int heroWin, int before,
            int after) {
        if (heroWin == K) {
            return true;
        }
        if (player2Win == K) {
            return false;
        }
        if (player1Win == K) {
            return false;
        }
        if (before == 0) {
            for (int i = 0; i < N; i++) {
                if (!visit[i]) {
                    int verdict = compatibility[i][playerInput[after][after == 1 ? player1Count : player2Count]];
                    if (verdict == 2) {
                        visit[i] = true;
                        if (go(visit, player1Count + (after == 1 ? 1 : 0),
                                player2Count + (after == 2 ? 1 : 0), player1Win, player2Win,
                                heroWin + 1, 0, (after == 1 ? 2 : 1))) {
                            return true;
                        }
                        visit[i] = false;
                    } else {
                        visit[i] = true;
                        if (go(visit, player1Count + (after == 1 ? 1 : 0),
                                player2Count + (after == 2 ? 1 : 0),
                                player1Win + (after == 1 ? 1 : 0),
                                player2Win + (after == 2 ? 1 : 0),
                                heroWin, 1, 2)) {
                            return true;
                        }
                        visit[i] = false;
                    }
                }
            }
        } else {
            int verdict = compatibility[playerInput[1][player1Count]][playerInput[2][player2Count]];
            if (verdict == 2) {
                if (go(visit, player1Count + 1, player2Count + 1, player1Win + 1, player2Win,
                        heroWin, 0, 1)) {
                    return true;
                }
            } else {
                if (go(visit, player1Count + 1, player2Count + 1, player1Win, player2Win + 1,
                        heroWin, 0, 2)) {
                    return true;
                }
            }

        }
        return false;
    }
}
