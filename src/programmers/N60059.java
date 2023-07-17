package programmers;

public class N60059 {
    public static void main(String[] args) {
        testing(new int[][]{{0, 0, 0}, {1, 0, 0}, {0, 1, 1}},new int[][]{{1, 1, 1},{1, 1, 0},{1, 0, 1}},true);
    }

    private static void testing(int[][] key, int[][] lock, boolean result) {
        boolean solution = new N60059().solution(key, lock);
        if(solution==result){
            System.out.println("성공");
        }else{
            System.out.println("실패");
        }
    }

    static int N,M;
    public boolean solution(int[][] key, int[][] lock) {
        M=key.length;
        N=lock.length;
        int[][] lockMap=new int[20+(20*2)][20+(20*2)];
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                lockMap[20+i][20+j]=lock[i][j];
            }
        }

        for(int i=0;i<40;i++){
            for(int j=0;j<40;j++){
                for(int k=0;k<4;k++){
                    int[][] rotate = rotate(key);
                    key=rotate;
                    putKey(i,j,key,lockMap,1);

                    if(isOpen(lockMap)){
                        return true;
                    }

                    putKey(i,j,key,lockMap,-1);
                }
            }
        }
        return false;
    }

    private int[][] rotate(int[][] key) {
        int[][] rotate = new int[M][M];
        for(int i=0;i<M;i++){
            for(int j=0;j<M;j++){
                rotate[j][M-i-1]=key[i][j];
            }
        }

        return rotate;
    }

    private boolean isOpen(int[][] lockMap) {
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(lockMap[20+i][20+j]!=1){
                    return false;
                }
            }
        }
        return true;
    }

    private boolean putKey(int x, int y, int[][] key, int[][] lockMap, int alpha) {
        boolean isPut=true;
        for(int i=0;i<M;i++){
            for(int j=0;j<M;j++){
                if(key[i][j]+lockMap[x+i][y+j]>1){
                    isPut=false;
                }

                lockMap[x+i][y+j]+=(key[i][j]*alpha);
            }
        }

        return isPut;
    }
}
