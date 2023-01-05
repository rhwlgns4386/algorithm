package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class N7576 {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(in.readLine(), " ");
        int m = Integer.parseInt(tokenizer.nextToken());
        int n = Integer.parseInt(tokenizer.nextToken());

        int[][] map = new int[n][m];
        int[][] graph = new int[n][m];
        LinkedList<Pair> q = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            tokenizer = new StringTokenizer(in.readLine(), " ");
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(tokenizer.nextToken());
                graph[i][j] = -1;
                if (map[i][j] == 1) {
                    q.add(new Pair(i, j));
                    graph[i][j] = 0;
                }
            }
        }

        //bfs

        while (!q.isEmpty()) {
            Pair pair = q.remove();
            int x = pair.x;
            int y = pair.y;
            int count = graph[x][y];
            for (int k = 0; k < 4; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];
                if (0 <= nx && 0 <= ny && nx < n && ny < m) {
                    if (map[nx][ny] == 0 && graph[nx][ny]==-1) {
                        q.add(new Pair(nx, ny));
                        graph[nx][ny] = count + 1;
                    }
                }
            }
        }

        int ans = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                ans = Math.max(graph[i][j], ans);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (graph[i][j] == -1 && map[i][j] == 0) {
                    ans = -1;
                }
            }
        }

        System.out.println(ans);
    }

    static class Pair {
        public int x;
        public int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
