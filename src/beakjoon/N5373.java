package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N5373 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int T=Integer.parseInt(in.readLine());

        StringBuilder ouputBuffer = new StringBuilder();
        while (T-->0){
            char[][][] cube=generateCube();
            int rotateCount=Integer.parseInt(in.readLine());

            StringTokenizer st = new StringTokenizer(in.readLine());
            for(int i=0;i<rotateCount;i++){
                String rotateDirection = st.nextToken();
                rotateCube(cube,rotateDirection.charAt(0),rotateDirection.charAt(1));
            }

            for(int i=0;i<3;i++){
                for(int j=0;j<3;j++){
                    ouputBuffer.append(cube[0][i][j]);
                }
                ouputBuffer.append('\n');
            }
        }
        System.out.println(ouputBuffer);
    }

    /*
0:위(흰)
1:앞(빨)
2:아래(노)
3:뒷면(오)
4:왼쪽(초)
5:오른쪽(파)
 */
    private static void rotateCube(char[][][] cube, char face, char direction) {
        if(face=='U'){
            if(direction=='+'){
                char[] temp=new char[3];
                temp[0]=cube[3][2][0];
                temp[1]=cube[3][2][1];
                temp[2]=cube[3][2][2];

                cube[3][2][0]=cube[4][2][2];
                cube[3][2][1]=cube[4][1][2];
                cube[3][2][2]=cube[4][0][2];

                cube[4][0][2]=cube[1][0][0];
                cube[4][1][2]=cube[1][0][1];
                cube[4][2][2]=cube[1][0][2];

                cube[1][0][0]=cube[5][2][0];
                cube[1][0][1]=cube[5][1][0];
                cube[1][0][2]=cube[5][0][0];

                cube[5][0][0]=temp[0];
                cube[5][1][0]=temp[1];
                cube[5][2][0]=temp[2];

                roate(cube,0,1);
            }else{
                char[] temp=new char[3];
                temp[0]=cube[3][2][0];
                temp[1]=cube[3][2][1];
                temp[2]=cube[3][2][2];

                cube[3][2][0]=cube[5][0][0];
                cube[3][2][1]=cube[5][1][0];
                cube[3][2][2]=cube[5][2][0];

                cube[5][0][0]=cube[1][0][2];
                cube[5][1][0]=cube[1][0][1];
                cube[5][2][0]=cube[1][0][0];

                cube[1][0][0]=cube[4][0][2];
                cube[1][0][1]=cube[4][1][2];
                cube[1][0][2]=cube[4][2][2];

                cube[4][0][2]=temp[2];
                cube[4][1][2]=temp[1];
                cube[4][2][2]=temp[0];

                roate(cube,0,-1);
            }

        }else if(face=='D'){
            if(direction=='+'){
                char[] temp=new char[3];
                temp[0]=cube[3][0][0];
                temp[1]=cube[3][0][1];
                temp[2]=cube[3][0][2];

                cube[3][0][0]=cube[5][0][2];
                cube[3][0][1]=cube[5][1][2];
                cube[3][0][2]=cube[5][2][2];

                cube[5][0][2]=cube[1][2][2];
                cube[5][1][2]=cube[1][2][1];
                cube[5][2][2]=cube[1][2][0];

                cube[1][2][0]=cube[4][0][0];
                cube[1][2][1]=cube[4][1][0];
                cube[1][2][2]=cube[4][2][0];

                cube[4][2][0]=temp[0];
                cube[4][1][0]=temp[1];
                cube[4][0][0]=temp[2];

                roate(cube,2,1);
            }else{
                char[] temp=new char[3];
                temp[0]=cube[3][0][0];
                temp[1]=cube[3][0][1];
                temp[2]=cube[3][0][2];

                cube[3][0][0]=cube[4][2][0];
                cube[3][0][1]=cube[4][1][0];
                cube[3][0][2]=cube[4][0][0];

                cube[4][0][0]=cube[1][2][0];
                cube[4][1][0]=cube[1][2][1];
                cube[4][2][0]=cube[1][2][2];

                cube[1][2][0]=cube[5][2][2];
                cube[1][2][1]=cube[5][1][2];
                cube[1][2][2]=cube[5][0][2];

                cube[5][2][2]=temp[2];
                cube[5][1][2]=temp[1];
                cube[5][0][2]=temp[0];

                roate(cube,2,-1);
            }

        }else if(face=='F'){
            if(direction=='+'){
                char[] temp=new char[3];
                temp[0]=cube[0][2][0];
                temp[1]=cube[0][2][1];
                temp[2]=cube[0][2][2];

                cube[0][2][0]=cube[4][2][0];
                cube[0][2][1]=cube[4][2][1];
                cube[0][2][2]=cube[4][2][2];

                cube[4][2][0]=cube[2][0][2];
                cube[4][2][1]=cube[2][0][1];
                cube[4][2][2]=cube[2][0][0];

                cube[2][0][0]=cube[5][2][2];
                cube[2][0][1]=cube[5][2][1];
                cube[2][0][2]=cube[5][2][0];

                cube[5][2][0]=temp[0];
                cube[5][2][1]=temp[1];
                cube[5][2][2]=temp[2];

                roate(cube,1,1);
            }else{
                char[] temp=new char[3];
                temp[0]=cube[0][2][0];
                temp[1]=cube[0][2][1];
                temp[2]=cube[0][2][2];

                cube[0][2][0]=cube[5][2][0];
                cube[0][2][1]=cube[5][2][1];
                cube[0][2][2]=cube[5][2][2];

                cube[5][2][0]=cube[2][0][2];
                cube[5][2][1]=cube[2][0][1];
                cube[5][2][2]=cube[2][0][0];

                cube[2][0][0]=cube[4][2][2];
                cube[2][0][1]=cube[4][2][1];
                cube[2][0][2]=cube[4][2][0];

                cube[4][2][0]=temp[0];
                cube[4][2][1]=temp[1];
                cube[4][2][2]=temp[2];

                roate(cube,1,-1);
            }

        }else if(face=='B'){
            if(direction=='+'){
                char[] temp=new char[3];
                temp[0]=cube[0][0][0];
                temp[1]=cube[0][0][1];
                temp[2]=cube[0][0][2];

                cube[0][0][0]=cube[5][0][0];
                cube[0][0][1]=cube[5][0][1];
                cube[0][0][2]=cube[5][0][2];

                cube[5][0][0]=cube[2][2][2];
                cube[5][0][1]=cube[2][2][1];
                cube[5][0][2]=cube[2][2][0];

                cube[2][2][0]=cube[4][0][2];
                cube[2][2][1]=cube[4][0][1];
                cube[2][2][2]=cube[4][0][0];

                cube[4][0][0]=temp[0];
                cube[4][0][1]=temp[1];
                cube[4][0][2]=temp[2];

                roate(cube,3,1);

            }else{
                char[] temp=new char[3];
                temp[0]=cube[0][0][0];
                temp[1]=cube[0][0][1];
                temp[2]=cube[0][0][2];

                cube[0][0][0]=cube[4][0][0];
                cube[0][0][1]=cube[4][0][1];
                cube[0][0][2]=cube[4][0][2];

                cube[4][0][0]=cube[2][2][2];
                cube[4][0][1]=cube[2][2][1];
                cube[4][0][2]=cube[2][2][0];

                cube[2][2][0]=cube[5][0][2];
                cube[2][2][1]=cube[5][0][1];
                cube[2][2][2]=cube[5][0][0];

                cube[5][0][0]=temp[0];
                cube[5][0][1]=temp[1];
                cube[5][0][2]=temp[2];

                roate(cube,3,-1);
            }

        }else if(face=='L'){
            if(direction=='+'){
                char[] temp=new char[3];
                temp[0]=cube[0][0][0];
                temp[1]=cube[0][1][0];
                temp[2]=cube[0][2][0];

                cube[0][0][0]=cube[3][0][0];
                cube[0][1][0]=cube[3][1][0];
                cube[0][2][0]=cube[3][2][0];

                cube[3][2][0]=cube[2][2][0];
                cube[3][1][0]=cube[2][1][0];
                cube[3][0][0]=cube[2][0][0];

                cube[2][0][0]=cube[1][0][0];
                cube[2][1][0]=cube[1][1][0];
                cube[2][2][0]=cube[1][2][0];

                cube[1][0][0]=temp[0];
                cube[1][1][0]=temp[1];
                cube[1][2][0]=temp[2];

                roate(cube,4,1);
            }else{

                char[] temp=new char[3];
                temp[0]=cube[0][0][0];
                temp[1]=cube[0][1][0];
                temp[2]=cube[0][2][0];

                cube[0][0][0]=cube[1][0][0];
                cube[0][1][0]=cube[1][1][0];
                cube[0][2][0]=cube[1][2][0];

                cube[1][2][0]=cube[2][2][0];
                cube[1][1][0]=cube[2][1][0];
                cube[1][0][0]=cube[2][0][0];

                cube[2][0][0]=cube[3][0][0];
                cube[2][1][0]=cube[3][1][0];
                cube[2][2][0]=cube[3][2][0];

                cube[3][0][0]=temp[0];
                cube[3][1][0]=temp[1];
                cube[3][2][0]=temp[2];

                roate(cube,4,-1);
            }
        }else{
            //R
            if(direction=='+'){

                char[] temp=new char[3];
                temp[0]=cube[0][0][2];
                temp[1]=cube[0][1][2];
                temp[2]=cube[0][2][2];

                cube[0][0][2]=cube[1][0][2];
                cube[0][1][2]=cube[1][1][2];
                cube[0][2][2]=cube[1][2][2];

                cube[1][0][2]=cube[2][0][2];
                cube[1][1][2]=cube[2][1][2];
                cube[1][2][2]=cube[2][2][2];

                cube[2][0][2]=cube[3][0][2];
                cube[2][1][2]=cube[3][1][2];
                cube[2][2][2]=cube[3][2][2];

                cube[3][0][2]=temp[0];
                cube[3][1][2]=temp[1];
                cube[3][2][2]=temp[2];

                roate(cube,5,1);

            }else{
                char[] temp=new char[3];
                temp[0]=cube[0][0][2];
                temp[1]=cube[0][1][2];
                temp[2]=cube[0][2][2];

                cube[0][0][2]=cube[3][0][2];
                cube[0][1][2]=cube[3][1][2];
                cube[0][2][2]=cube[3][2][2];

                cube[3][0][2]=cube[2][0][2];
                cube[3][1][2]=cube[2][1][2];
                cube[3][2][2]=cube[2][2][2];

                cube[2][0][2]=cube[1][0][2];
                cube[2][1][2]=cube[1][1][2];
                cube[2][2][2]=cube[1][2][2];

                cube[1][0][2]=temp[0];
                cube[1][1][2]=temp[1];
                cube[1][2][2]=temp[2];

                roate(cube,5,-1);
            }
        }
    }

    private static void roate(char[][][] cube,int idx, int direction) {
        char[][] temp=new char[3][3];
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++) temp[i][j]=cube[idx][i][j];
        }
        if(direction==1){
            for(int i=0;i<3;i++){
                for(int j=0;j<3;j++) cube[idx][j][2-i]=temp[i][j];
            }
        }else{
            for(int i=0;i<3;i++){
                for(int j=0;j<3;j++) cube[idx][2-j][i]=temp[i][j];
            }
        }
    }

    /*
    0:하단
    1:앞
    2:아래
    3:뒷면
    4:왼쪽
    5:오른쪽
     */
    private static char[][][] generateCube() {
        char[][][] cube = new char[6][3][3];
        for(int i=0;i<6;i++){
            char[][] face = cube[i];
            char faceChar=findFaceChar(i);
            for(int j=0;j<3;j++){
                Arrays.fill(face[j],faceChar);
            }

        }
        return cube;
    }

    private static char findFaceChar(int idx) {
        switch (idx){
            case 0:
                return 'w';
            case 1:
                return 'r';
            case 2:
                return 'y';
            case 3:
                return 'o';
            case 4:
                return 'g';
            default:
                return 'b';
        }
    }

}
