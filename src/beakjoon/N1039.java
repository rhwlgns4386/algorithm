package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class N1039 {
    static class Pair {
        int number;
        int cost;

        public Pair(int number, int cost) {
            this.number = number;
            this.cost = cost;
        }
    }

    static int ans = -1;
    static int K, N;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        bfs();
        System.out.println(ans);
    }


    public static void bfs() {
        Queue<Pair> q = new LinkedList<>();
        boolean[][] visited = new boolean[1000001][K + 1];

        q.add(new Pair(N, 0));
        visited[N][0] = true;

        while (!q.isEmpty()) {
            Pair p = q.poll();

            // 교환 횟수가 K일 경우 최댓값 갱신 후 다음 숫자로 넘어감
            if (p.cost == K) {
                ans = Math.max(ans, p.number);
                continue;
            }

            int len = String.valueOf(p.number).length();

            for(int i=0;i<len-1;i++){
                for(int j=i+1;j<len;j++){
                    Integer swapNumber = swap(p.number, i, j);
                    if(swapNumber!=-1&&!visited[swapNumber][p.cost+1]){
                        q.add(new Pair(swapNumber,p.cost+1));
                        visited[swapNumber][p.cost+1]=true;
                    }
                }
            }
        }
    }

    public static int swap(int n, int i, int j) {
        char[] numArr = String.valueOf(n).toCharArray();

        if (i == 0 && numArr[j] == '0') {
            return -1;
        }

        char tmp;
        tmp = numArr[i];
        numArr[i] = numArr[j];
        numArr[j] = tmp;

        return Integer.parseInt(new String(numArr));
    }
}
