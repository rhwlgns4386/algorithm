package programmers.Kakao2021BlindRecruitment;

public class N72413 {
    public static void main(String[] args) {
        System.out.println(solution(6,4,6,2,new int[][]{{4, 1, 10}, {3, 5, 24}, {5, 6, 2}, {3, 1, 41}, {5, 1, 24}, {4, 6, 50}, {2, 4, 66}, {2, 3, 22}, {1, 6, 25}}));
    }

    public static int solution(int n, int s, int a, int b, int[][] fares) {
        int answer = 0;
        int[][] dist=new int[n+1][n+1];

        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                if(i==j){
                    dist[i][j]=0;
                }else {
                    dist[i][j]=20000001;
                }
            }
        }

        for(int i=0;i<fares.length;i++){
            int c = fares[i][0];
            int d = fares[i][1];
            int f = fares[i][2];

            dist[c][d]=f;
            dist[d][c]=f;
        }

        for(int k=1;k<=n;k++){
            for(int i=1;i<=n;i++){
                for(int j=1;j<=n;j++){
                    dist[i][j]=Math.min(dist[i][j],dist[i][k]+dist[k][j]);
                }
            }
        }

        answer=dist[s][a]+dist[s][b];
        for(int i=1;i<=n;i++){
            answer=Math.min(dist[s][i]+dist[i][a]+dist[i][b],answer);
        }
        return answer;
    }

}
