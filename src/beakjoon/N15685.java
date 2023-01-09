import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class N15685 {
    private static boolean[][] vertex=new boolean[101][101];
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(in.readLine());
        for(int i=0;i<n;i++){
            StringTokenizer stringTokenizer = new StringTokenizer(in.readLine(), " ");
            int y=Integer.parseInt(stringTokenizer.nextToken());
            int x=Integer.parseInt(stringTokenizer.nextToken());
            int d=Integer.parseInt(stringTokenizer.nextToken());
            int g=Integer.parseInt(stringTokenizer.nextToken());
            vertex[x][y]=true;

            switch (d){
                case 0:
                    if(function0(x,y)){
                        y+=1;
                    }
                    break;
                case 1:
                    if(function1(x,y)){
                        x-=1;
                    }
                    break;
                case 2:
                    if(function2(x,y)){
                        y-=1;
                    }
                    break;
                case 3:
                    if(function3(x,y)){
                        x+=1;
                    }
                    break;
            }
            go(x,y,d,g);
        }
        int count=0;
        for(int i=0;i<101;i++){
            for(int j=0;j<101;j++){
                if(i+1<101 &&j+1<101){
                    if(vertex[i][j]&&vertex[i][j+1]&&vertex[i+1][j+1]&&vertex[i+1][j]){
                        count+=1;
                    }
                }
            }
        }

        System.out.println(count);
    }

    private static void go(int x, int y,int d, int g) {
        ArrayList<Integer> dList=new ArrayList<>();
        Stack<Integer> stack=new Stack<>();
        dList.add(d);
        for(int i=0;i<g;i++){
            for(Integer item:dList){
                stack.add(item);
            }
            int len=stack.size();
            for(int j=0;j<len;j++){
                switch (stack.pop()){
                    case 0:
                        if(function1(x,y)){
                            x-=1;
                        }
                        dList.add(1);
                        break;
                    case 1:
                        if(function2(x,y)){
                            y-=1;
                        }
                        dList.add(2);
                        break;
                    case 2:
                        if(function3(x,y)){
                            x+=1;
                        }
                        dList.add(3);
                        break;
                    case 3:
                        if(function0(x,y)){
                            y+=1;
                        }
                        dList.add(0);
                        break;
                }
            }
        }
    }

    private static boolean function0(int x,int y){
        if(y+1<101){
            vertex[x][y+1]=true;
            return true;
        }
        return false;
    }

    private static boolean function1(int x,int y){
        if(x-1>=0){
            vertex[x-1][y]=true;
            return true;
        }
        return false;
    }

    private static boolean function2(int x,int y){
        if(y-1>=0){
            vertex[x][y-1]=true;
            return true;
        }
        return false;
    }

    private static boolean function3(int x,int y){
        if(x+1<101){
            vertex[x+1][y]=true;
            return true;
        }
        return false;
    }

}
