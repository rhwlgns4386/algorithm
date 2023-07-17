package programmers;

import java.util.Arrays;


public class N60061 {

    public static void main(String[] args) {
        testing(5,new int[][]{{1,0,0,1},{1,1,1,1},{2,1,0,1},{2,2,1,1},{5,0,0,1},{5,1,0,1},{4,2,1,1},{3,2,1,1}},new int[][]{{1,0,0},{1,1,1},{2,1,0},{2,2,1},{3,2,1},{4,2,1},{5,0,0},{5,1,0}});
        testing(5,new int[][]{{0,0,0,1},{2,0,0,1},{4,0,0,1},{0,1,1,1},{1,1,1,1},{2,1,1,1},{3,1,1,1},{2,0,0,0},{1,1,1,0},{2,2,0,1}},new int[][]{{0,0,0},{0,1,1},{1,1,1},{2,1,1},{3,1,1},{4,0,0}});

    }

    private static void testing(int n, int[][] input, int[][] result) {
        N60061 main = new N60061();
        int[][] solution = main.solution(n, input);
        for(int i=0;i<result.length;i++){
            for(int j=0;j<result[i].length;j++){
                try{
                    if(result[i][j]!=solution[i][j]){
                        System.out.println("실패");

                        for(int[] a:solution){
                            System.out.print(Arrays.toString(a)+" ");
                        }
                        System.out.println();
                        return;
                    }
                }catch (ArrayIndexOutOfBoundsException e){
                    System.out.println("실패");

                    for(int[] a:solution){
                        System.out.print(Arrays.toString(a)+" ");
                    }
                    System.out.println();
                    return;
                }

            }
        }

        System.out.println("성공");
    }

    static int N;
    private boolean[][] pillar;
    private boolean[][] bo;

    private static final int pillarNumber=0;
    public int[][] solution(int n, int[][] build_frame) {
        N=n+3;

        pillar = new boolean[N][N];
        bo = new boolean[N][N];

        for(int[] command:build_frame){
            int x=command[0];
            int y=command[1];
            int a=command[2];
            int b=command[3];

            build(x,y,a,b);


            if(!check()){
                build(x,y,a,Math.abs(b-1));
            }
        }

        int[][] answer=new int[countStructure()][3];
        int idx=0;
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(pillar[i][j]){
                    answer[idx][0]=i;
                    answer[idx][1]=j;
                    answer[idx++][2]=0;
                }
                if(bo[i][j]){
                    answer[idx][0]=i;
                    answer[idx][1]=j;
                    answer[idx++][2]=1;
                }
            }
        }

        return answer;
    }

    private int countStructure() {
        int count=0;
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(pillar[i][j]){
                   count++;
                }
                if(bo[i][j]){
                    count++;
                }
            }
        }

        return count;
    }

    private boolean check() {
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(pillar[i][j] && !isPillarOk(i, j)){
                     return false;
                }
                if(bo[i][j] && !isBoOk(i, j)){
                    return false;
                }
            }
        }

        return true;
    }

    private boolean isBoOk(int x, int y) {
        if(y > 0 && pillar[x][y -1] || pillar[x + 1][y -1]) return true;
        else if(x > 0 && bo[x -1][y] && bo[x + 1][y]) return true;
        return false;
    }

    private boolean isPillarOk(int x, int y) {
        if(y == 0) return true;
        else if(x > 0 && bo[x -1][y] || bo[x][y] ) return true;
        else if(y > 0 && pillar[x][y -1]) return true;
        return false;
    }

    private void build(int x, int y, int a, int b) {
        if(b==1){
            if(a==pillarNumber){
                pillar[x][y]=true;
            }else{
                bo[x][y]=true;
            }
        }else{
            if(a==pillarNumber){
                pillar[x][y]=false;
            }else{
                bo[x][y]=false;
            }
        }
    }
}
