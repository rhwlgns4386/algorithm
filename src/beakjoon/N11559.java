package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;

public class N11559 {
    static int n = 12;
    static int m = 6;
    private static int[][] map;

    public static void main(String[] args) throws IOException {
        map = new int[n][m];
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < n; i++) {
            String s = in.readLine();
            for (int j = 0; j < m; j++) {
                if (s.charAt(j) != '.') {
                    switch (s.charAt(j)) {
                        case 'R':
                            map[i][j] = 1;
                            break;
                        case 'G':
                            map[i][j] = 2;
                            break;
                        case 'B':
                            map[i][j] = 3;
                            break;
                        case 'P':
                            map[i][j] = 4;
                            break;
                        case 'Y':
                            map[i][j] = 5;
                            break;
                    }
                }
            }
        }

        int count = 0;
        do{
            count += getCount();
        }while (gravity());

        System.out.println(count);
    }

    private static int getCount() {
        int count=0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] != 0 && bfs(i, j)) {
                    count=1;
                }
            }
        }
        return count;
    }

    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    private static boolean bfs(int startx, int starty) {
        int find = map[startx][starty];
        LinkedList<int[]> q = new LinkedList<>();
        q.add(new int[]{startx, starty});

        boolean[][] visits = new boolean[n][m];
        visits[startx][starty] = true;
        map[startx][starty] = 0;

        int count = 1;
        while (!q.isEmpty()) {
            int[] node = q.remove();
            int x = node[0];
            int y = node[1];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (isRange(nx, ny) && map[nx][ny] == find && !visits[nx][ny]) {
                    q.add(new int[]{nx, ny});
                    visits[nx][ny] = true;
                    map[nx][ny] = 0;
                    count++;
                }
            }
        }

        if (count < 4) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (visits[i][j]) {
                        map[i][j] = find;
                    }
                }
            }
            return false;
        }
        return true;
    }


    private static boolean gravity() {
        boolean isMove=false;
        for (int i = n - 1; 0 <= i; i--) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] != 0) {
                    if(move(i, j)){
                        isMove=true;
                    }
                }
            }
        }
        return isMove;
    }


    private static boolean move(int x, int y) {
        int nx = x+dx[0];
        while (true) {
            if (!isRange(nx, y)) {
                if (nx-dx[0] == x) return false;
                map[nx - dx[0]][y] = map[x][y];
                map[x][y] = 0;
                return true;
            }
            if(map[nx][y] != 0){
                if (nx-dx[0] == x) return false;
                map[nx - dx[0]][y] = map[x][y];
                map[x][y] = 0;
                return true;
            }
            nx += dx[0];
        }
    }


    private static boolean isRange(int x, int y) {
        if (0 <= x && x < n && 0 <= y && y < m) return true;
        return false;
    }
}
