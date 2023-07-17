package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N14500 {
    private static int[][][][] coverType = {
            {{{0, 0}, {0, 1}, {0, 2}, {0, 3}},
                    {{0, 0}, {1, 0}, {2, 0}, {3, 0}}},
            {{{0, 0}, {0, 1}, {1, 1}, {1, 0}}},
            {{{0, 0}, {1, 0}, {1, 1}, {2, 1}},
                    {{0, 0}, {0, 1}, {1, 0}, {1, -1}}},
            {{{0, 0}, {1, 0}, {2, 0}, {2, 1}},
                    {{0, 0}, {1, 0}, {0, 1}, {0, 2}},
                    {{0, 0}, {0, 1}, {1, 1}, {2, 1}},
                    {{0, 0}, {1, 0}, {1, -1}, {1, -2}}},
            {{{0, 0}, {0, 1}, {0, 2}, {1, 1}},
                    {{0, 0}, {1, 0}, {2, 0}, {1, 1}},
                    {{0, 0}, {1, 0}, {1, -1}, {1, 1}},
                    {{0, 0}, {1, 0}, {2, 0}, {1, -1}}}
    };
    private static int[][] map;
    private static int n;
    private static int m;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(in.readLine());

            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int result=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                for(int type=0;type<5;type++){
                    for(int type2=0;type2<coverType[type].length;type2++){
                        int sum=0;
                        for (int k = 0; k < 4; k++) {
                            int nx = i + coverType[type][type2][k][0];
                            int ny = j + coverType[type][type2][k][1];

                            if (!isRange(map, nx, ny)) {
                                sum=0;
                                break;
                            }
                            sum+=map[nx][ny];
                        }
                        result=Math.max(result,sum);
                    }
                }
            }
        }

        System.out.println(result);
    }

    private static boolean isRange(int[][] map, int nx, int ny) {
        int n = map.length;
        int m = map[0].length;
        if (0 <= nx && nx < n && 0 <= ny && ny < m) return true;
        return false;
    }
}
