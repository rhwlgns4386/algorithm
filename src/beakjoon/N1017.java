import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class N1017 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());
        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
        ArrayList<Integer> list = new ArrayList<>();

        for(int i=0;i<N;i++){
            list.add(Integer.parseInt(stringTokenizer.nextToken()));
        }

        int firstNumber=list.get(0);

        List<Integer> subList = list.subList(1, list.size());

        Collections.sort(subList);

        boolean[] prime=new boolean[2001];
        for(int i=2; i*i<=2000; i++){
            // prime[i]가 소수라면
            if(!prime[i]){
                // prime[j] 소수가 아닌 표시
                for(int j=i*i; j<=2000; j+=i) prime[j] = true;
            }
        }

        ArrayList<Integer> result = new ArrayList<>();

        for(int i=0;i<subList.size();i++){
            int next=subList.get(i);
            if(!prime[firstNumber+next]){
                result.add(next);
            }
        }

        for(int i=0;i<result.size();i++){
            System.out.print(result.get(i)+" ");
        }
    }
}
