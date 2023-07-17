package programmers;


import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class N142085 {
    public static int solution(int n, int k, int[] enemy) {
        return go(n,k,enemy);
    }

    private static int go(int n, int k, int[] enemy) {
        int L=0;
        int R=enemy.length;

        while (L<R){
            int mid=(L+R)/2;
            if(isPass(mid,n,k,enemy)){
                L=mid+1;
            }else{
                R=mid;
            }
        }

        return L;
    }

    private static boolean isPass(int mid, int n, int k, int[] enemy) {
        List<Integer> collect = IntStream.range(0,mid+1).map(i->enemy[i]).boxed().sorted().collect(Collectors.toList());
        int size=collect.size();

        for(int i=0;i<size;i++){
            Integer el = collect.get(i);
            if(el<=n){
                n-=el;
                continue;
            }

            return k>=size-i;
        }

        return true;
    }
}
