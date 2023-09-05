package programmers;

import java.lang.Math;
import java.util.*;
public class N87391 {
    public static void main(String[] args) {
        Solution solution = new Solution();
//        System.out.println(solution.solution(2,2,0,0,new int[][]{{2,1},{0,1},{1,1},{0,1},{2,1}}));
        System.out.println(solution.solution(2,5,0,0,new int[][]{{3,1},{2,2},{1,1},{2,3},{0,1},{2,1}}));
    }
    static class Solution {
        /*
        * 0 좌측
        * 1 우측
        * 2 상단
        * 3 하단
        * */
        public long solution(int n, int m, int x, int y, int[][] queries) {

            int x1 = x, y1 = y;
            int x2 = x, y2 = y;

            for(int i=queries.length-1; 0<=i; i--){
                if(queries[i][0]==2){
                    if(x1!=0)x1+=queries[i][1];
                    x2=x2+queries[i][1]<n-1?x2+queries[i][1]:n-1;
                    if(n<x1) return 0;
                }else if(queries[i][0]==3){
                    x1=x1-queries[i][1]>0?x1-queries[i][1]:0;
                    if(x2!=n)x2-=queries[i][1];
                    if(x2<0) return 0;
                }else if(queries[i][0]==0){
                    if(y1!=0)y1+=queries[i][1];
                    y2=y2+queries[i][1]<m-1?y2+queries[i][1]:m-1;
                    if(m<y1)return 0;
                }else{
                    y1=y1+queries[i][1]>0?y1+queries[i][1]:0;
                    if(y2!=m)y2+=queries[i][1];
                    if(y2<0) return 0;
                }
            }

            long X = x2-x1+1;
            long Y = y2-y1+1;

            return X*Y;

        }
    }
}
