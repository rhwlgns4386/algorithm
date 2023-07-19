package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class N2146 {
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

    private static int N;
    private static int[][] map, group;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(in.readLine());

        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        group = new int[N][N];
        int groupCount = 1;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 1 && group[i][j] == 0) {
                    dfs(i, j, groupCount++);
                }
            }
        }

        int answer = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 1) {
                    answer = Math.min(answer, bfs(i, j));
                }
            }
        }

        System.out.println(answer);
    }

    static int[] dx = {0, 1, 0, -1};

    static int[] dy = {1, 0, -1, 0};

    private static int bfs(int i, int j) {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(i, j, 0));

        boolean[][] visit = new boolean[N][N];
        visit[i][j] = true;

        while (!q.isEmpty()) {
            Node node = q.remove();
            int x = node.x;
            int y = node.y;
            int cost = node.cost;

            if (map[x][y] == 1 && group[x][y] != group[i][j]) {
                return cost - 1;
            }

            for (int idx = 0; idx < 4; idx++) {
                int nx = x + dx[idx];
                int ny = y + dy[idx];

                if (inRange(nx, ny) && group[nx][ny] != group[i][j] && !visit[nx][ny]) {
                    q.add(new Node(nx, ny, cost + 1));
                    visit[nx][ny] = true;
                }
            }
        }

        return Integer.MAX_VALUE;
    }

    private static void dfs(int x, int y, int groupCount) {
        group[x][y] = groupCount;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (inRange(nx, ny) && map[nx][ny] == 1 && group[nx][ny] == 0) {
                dfs(nx, ny, groupCount);
            }
        }
    }

    private static boolean inRange(int x, int y) {
        return 0 <= x && x < N && 0 <= y && y < N;
    }
}
