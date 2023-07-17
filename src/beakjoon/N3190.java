package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class N3190 {
    static int[] dx = {0, -1, 0, 1};
    static int[] dy = {1, 0, -1, 0};
    private static int n;
    private static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(in.readLine());

        int k = Integer.parseInt(in.readLine());
        map = new int[n][n];
        for (int i = 0; i < k; i++) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            map[x][y] = 2;
        }

        LinkedList<int[]> q = new LinkedList<>();
        int l = Integer.parseInt(in.readLine());
        for (int i = 0; i < l; i++) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            int x = Integer.parseInt(st.nextToken());
            String c = st.nextToken();
            q.add(new int[]{x, c.equals("L") ? 1 : -1});
        }

        map[0][0] = 1;
        int x = 0;
        int y = 0;
        int direction = 0;
        LinkedList<int[]> tailQ = new LinkedList<>();
        tailQ.add(new int[]{0, 0});
        for (int time = 1; ; time++) {

            int nx = x + dx[direction];
            int ny = y + dy[direction];
            if (!inRange(nx, ny) || map[nx][ny] == 1) {
                System.out.println(time);
                break;
            }
            if (map[nx][ny] != 2) {
                int[] tale = tailQ.remove();
                map[tale[0]][tale[1]] = 0;
            }
            map[nx][ny] = 1;
            x = nx;
            y = ny;
            tailQ.add(new int[]{x, y});

            if (!q.isEmpty() && q.peek()[0] == time) {
                direction = next(direction, q.peek()[1]);
                q.remove();
            }
        }
    }

    private static int next(int direction, int i) {
        return (direction + i+4)%4;
    }

    private static boolean inRange(int x, int y) {
        return 0 <= x && x < n && 0 <= y && y < n;
    }
}
