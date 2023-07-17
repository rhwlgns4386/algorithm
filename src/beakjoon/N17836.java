package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class N17836 {

    private static int[][] map;

    static class Node {
        int x;
        int y;
        int cost;

        public Node(int x, int y, int cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }
    }

    private static int N, M;

    private static final int MAX = 10000 + 1;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        int gramX = 0;
        int gramY = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(in.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 2) {
                    gramX = i;
                    gramY = j;
                }
            }
        }

        int gramTime = bfs(gramX, gramY, N - 1, M - 1, true) + bfs(0, 0, gramX, gramY, false);
        int normal = bfs(0, 0, N - 1, M - 1, false);
        int result = Math.min(gramTime, normal);

        if (result <= T) {
            System.out.println(result);
        } else {
            System.out.println("Fail");
        }
    }

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    private static int bfs(int startX, int startY, int targetX, int targetY, boolean hasGram) {
        LinkedList<Node> q = new LinkedList<>();
        q.add(new Node(startX, startY, 0));

        boolean[][] visit = new boolean[N][M];
        visit[startX][startY] = true;

        while (!q.isEmpty()) {
            Node node = q.remove();
            int x = node.x;
            int y = node.y;
            int cost = node.cost;

            if (targetX == x && targetY == y) {
                return cost;
            }

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (inRange(nx, ny) && !visit[nx][ny]) {
                    if (hasGram) {
                        q.add(new Node(nx, ny, cost + 1));
                        visit[nx][ny] = true;
                    } else if (map[nx][ny] != 1) {
                        q.add(new Node(nx, ny, cost + 1));
                        visit[nx][ny] = true;
                    }
                }
            }
        }

        return MAX;
    }

    private static boolean inRange(int x, int y) {
        return 0 <= x && x < N && 0 <= y && y < M;
    }
}
