package algorithms;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ROD_CUTTING {
    static int[] d;
    static int[] cost;
     
    static int func(int idx){
//      int max = cost[idx];
//      
//      if(d[idx] != 0){
//          return d[idx];
//      }
//      
//      for(int i = 1; i < idx; i++){
//          int tmp = func(i) + cost[idx-i];
//          if(max < tmp){
//              max = tmp;
//          }
//      }
//      
//      return max;
         
        //초기화
        d[0] = 1; d[1] = cost[1];
         
        for(int i = 2; i <= idx; i++){
            int max = cost[i];
             
            for(int j = 1; j < i; j++){
                int tmp = cost[j] + d[i-j]; 
                if(tmp > max){
                    max = tmp;
                }
            }
             
            d[i] = max;
        }
         
         
        return d[idx];
    }
     
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         
        int N = Integer.parseInt(br.readLine());
         
        d = new int[N+1];
        cost = new int[N+1];
         
        StringTokenizer st = new StringTokenizer(br.readLine());
         
        for(int i = 1; i <= N; i++){
            cost[i] = Integer.parseInt(st.nextToken());
        }
         
        System.out.println(func(N));
    }
 
}