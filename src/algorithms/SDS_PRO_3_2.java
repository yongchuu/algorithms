package algorithms;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class SDS_PRO_3_2 {
    static int[] union;
     
    static int find(int idx){
        if(union[idx] == idx) return idx;
        return union[idx] = find(union[idx]);
    }
     
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int Q = Integer.parseInt(br.readLine());
         
        union = new int[N+1];
         
        for(int i = 0; i <= N; i++){
            union[i] = i;
        }
         
        StringTokenizer st;
         
        while(Q--!=0){
            st = new StringTokenizer(br.readLine());
            int q = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
             
            if(q == 0){
                union[find(a)] = find(b);
            }else{
                System.out.println(find(a) == find(b) ? 1 : 0);
            }
        }
         
         
    }
}
