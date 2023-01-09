import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N14890 {
    /*
    경사로를 놓은 곳에 또 경사로를 놓는 경우
    낮은 칸과 높은 칸의 높이 차이가 1이 아닌 경우
    낮은 지점의 칸의 높이가 모두 같지 않거나, L개가 연속되지 않은 경우
    경사로를 놓다가 범위를 벗어나는 경우
     */
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(in.readLine(), " ");
        int n = Integer.parseInt(stringTokenizer.nextToken());
        int l = Integer.parseInt(stringTokenizer.nextToken());

        int[][] map = new int[n][n];

        for (int i = 0; i < n; i++) {
            stringTokenizer = new StringTokenizer(in.readLine(), " ");
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(stringTokenizer.nextToken());
            }
        }

        boolean[] check = new boolean[n];
        int count = 0;

        for (int i = 0; i < n; i++) {
            Arrays.fill(check, false);
            loop1:
            for (int j = 0; j < n; j++) {
                if (j == n - 1) {
                    count += 1;
                    break;
                }
                int height = map[i][j];
                int nextHeight = map[i][j + 1];
                int checkNum = height - nextHeight;
                if (checkNum == 0) continue;
                if (Math.abs(checkNum) != 1) break;
                if (checkNum == 1) {
                    for (int k = 1; k <= l; k++) {
                        if (j + k >= n || check[j + k] || map[i][j + k] != nextHeight) break loop1;
                        check[j + k] = true;
                    }
                } else if(checkNum==-1) {
                    for (int k = 0; k < l; k++) {
                        if (j - k <0 ||check[j - k]||map[i][j - k] != height) break loop1;
                        check[j - k] = true;
                    }
                }
            }
        }

        for (int j = 0; j < n; j++) {
            Arrays.fill(check, false);
            loop1:
            for (int i = 0; i < n; i++) {
                if ( i== n - 1) {
                    count += 1;
                    break;
                }
                int height = map[i][j];
                int nextHeight = map[i+1][j];
                int checkNum = height - nextHeight;
                if (checkNum == 0) continue;
                if (Math.abs(checkNum) != 1) break;
                if (checkNum == 1) {
                    for (int k = 1; k <= l; k++) {
                        if (i + k >= n || check[i + k] || map[i+k][j] != nextHeight) break loop1;
                        check[i + k] = true;
                    }
                } else if(checkNum==-1) {
                    for (int k = 0; k < l; k++) {
                        if (i - k <0 ||check[i - k]||map[i-k][j] != height) break loop1;
                        check[i - k] = true;
                    }
                }
            }
        }
        System.out.println(count);
    }
}
