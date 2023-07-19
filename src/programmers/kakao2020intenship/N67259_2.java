package programmers.kakao2020intenship;

import java.util.Arrays;
import java.util.LinkedList;

public class N67259_2 {

    public static void main(String[] args) {
        N67259_2 main = new N67259_2();
        System.out.println(main.solution(new int[][]{{0, 0, 0}, {0, 0, 0}, {0, 0, 0}}));
        System.out.println(main.solution(new int[][]{{0, 0, 0, 0, 0, 0, 0, 1}, {0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 1, 0, 0}, {0, 0, 0, 0, 1, 0, 0, 0}, {0, 0, 0, 1, 0, 0, 0, 1}, {0, 0, 1, 0, 0, 0, 1, 0}, {0, 1, 0, 0, 0, 1, 0, 0}, {1, 0, 0, 0, 0, 0, 0, 0}}));
        System.out.println(main.solution(new int[][]{{0, 0, 1, 0}, {0, 0, 0, 0}, {0, 1, 0, 1}, {1, 0, 0, 0}}));
        System.out.println(main.solution(new int[][]{{0, 0, 0, 0, 0, 0}, {0, 1, 1, 1, 1, 0}, {0, 0, 1, 0, 0, 0}, {1, 0, 0, 1, 0, 1}, {0, 1, 0, 0, 0, 1}, {0, 0, 0, 0, 0, 0}}));
    }

    static class Node {
        int x;
        int y;
        int direction;
        int cost;

        public Node(int x, int y, int direction, int cost) {
            this.x = x;
            this.y = y;
            this.direction = direction;
            this.cost = cost;
        }

    }

    static int N, M;

    public int solution(int[][] board) {
        N = board.length;
        M = board[0].length;
        return bfs(0, 0, board);
    }

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    private static int bfs(int startX, int startY, int[][] board) {
        LinkedList<Node> q = new LinkedList<>();
        q.add(new Node(startX, startY, 0, 0));
        q.add(new Node(startX, startY, 1, 0));

        int[][] dp = new int[N][M];
        for (int i = 0; i < N; i++) {
            Arrays.fill(dp[i], 376000);
        }
        dp[0][0] = 0;

        while (!q.isEmpty()) {
            Node node = q.remove();
            int x = node.x;
            int y = node.y;

            if (x == N - 1 && y == M - 1) {
                dp[N - 1][M - 1] = Math.min(dp[N - 1][M - 1], node.cost);
                continue;
            }

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (inRange(nx, ny) && board[nx][ny] != 1) {
                    int nCost = calcCost(node.direction, i, node.cost);
                    if (nCost < dp[nx][ny]) {
                        q.add(new Node(nx, ny, i, nCost));
                        dp[nx][ny] = nCost;
                    } else if (nCost <= dp[nx][ny] + 400) {
                        q.add(new Node(nx, ny, i, nCost));
                    }
                }
            }
        }

        return dp[N - 1][M - 1];
    }

    private static int calcCost(int direction, int i, int cost) {
        if (i == direction) {
            return cost + 100;
        }
        return cost + 600;
    }


    private static boolean inRange(int x, int y) {
        return 0 <= x && x < N && 0 <= y && y < M;
    }
}
