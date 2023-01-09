import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

public class N10816 {
    public static HashMap<Integer,Integer> map=new HashMap<>();
    public static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
    public static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        Integer N=Integer.parseInt(br.readLine());
        st=new StringTokenizer(br.readLine()," ");
        for(int i=0;i<N;i++){
            solution(Integer.parseInt(st.nextToken()));
        }
        Integer M=Integer.parseInt(br.readLine());
        st=new StringTokenizer(br.readLine()," ");
        for(int i=0;i<M;i++){
            int key = Integer.parseInt(st.nextToken());
            Integer value = map.containsKey(key)?map.get(key):0;
            bw.write(value+" ");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    public static void solution(Integer key){
        if(map.containsKey(key)){
            map.put(key,map.get(key)+1);
        }
        else{
            map.put(key,1);
        }
    }
}