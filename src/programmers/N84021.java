package programmers;

public class N84021 {
    public static void main(String[] args) {
        N84021 n84021 = new N84021();
    }
    public int solution(int[][] game_board, int[][] table) {
        int answer = -1;

        return answer;
    }

    public int[][] rotate(int[][] game_board) {
        int[][] map = new int[game_board[0].length][game_board.length];

        for(int i=0;i<game_board.length;i++){
            for(int j=0;j<game_board[0].length;j++){
                map[game_board[0].length-j-1][i]=game_board[i][j];
            }
        }
        return map;
    }
}
