package programmers.Kakao2022BlindRecruitment;

public class N92344 {
    public static void main(String[] args) {
        int[][] board={{5,5,5,5,5},{5,5,5,5,5},{5,5,5,5,5},{5,5,5,5,5}};
        int[][] skill={{1,0,0,3,4,4},{1,2,0,2,3,2},{2,1,0,3,1,2},{1,0,1,3,3,1}};
        System.out.println(solution(board,skill));
    }

    public static int solution(int[][] board, int[][] skill) {
        int answer = 0;
        int n=board.length;
        int m=board[0].length;
        int[][] cumulativeSumList=new int[n+1][m+1];
        for(int i=0;i<skill.length;i++){
            int type = skill[i][0];
            int r1=skill[i][1];
            int c1=skill[i][2];
            int r2=skill[i][3];
            int c2=skill[i][4];
            int degree=skill[i][5];

            if(type==1){
                cumulativeSumList[r1][c1]+=-degree;
                cumulativeSumList[r1][c2+1]+=degree;
                cumulativeSumList[r2+1][c2+1]+=-degree;
                cumulativeSumList[r2+1][c1]+=degree;
            }
            else {
                cumulativeSumList[r1][c1]+=degree;
                cumulativeSumList[r1][c2+1]+=-degree;
                cumulativeSumList[r2+1][c2+1]+=degree;
                cumulativeSumList[r2+1][c1]+=-degree;
            }
        }

        for (int i = 0; i < m; i++) {
            int sum=0;
            for (int j = 0; j < n; j++) {
                sum+=cumulativeSumList[j][i];
                cumulativeSumList[j][i]=sum;
            }
        }

        for (int i = 0; i < n; i++) {
            int sum=0;
            for (int j = 0; j < m; j++) {
                sum+=cumulativeSumList[i][j];
                cumulativeSumList[i][j]=sum;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
               if(board[i][j]+cumulativeSumList[i][j]>0){
                   answer++;
               }
            }
        }

        return answer;
    }
}
