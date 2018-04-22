package algorithms;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
 
public class COIN {
    static int[] coin; 
    static int[] ans; 
     
     
    static int func(int change){
        if(change < coin[0]){
            return -1;
        }
        if(ans[change] != 0){
            return ans[change];
        }
         
        int min = Integer.MAX_VALUE;
         
        for(int i = 0; i < coin.length; i++){
            if(change - coin[i] >= 0){
                int tmp = func(change-coin[i]);
                if(tmp != -1){
                    min = tmp < min ? tmp : min;
                }
            }
        }
        if(min == Integer.MAX_VALUE){
            return -1;
        }
         
        return ans[change] = min + 1;
    }
     
     
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         
        int N = Integer.parseInt(br.readLine());
         
        coin = new int[N];
         
        StringTokenizer st = new StringTokenizer(br.readLine());
         
        for(int i = 0; i < N; i++){
            coin[i] = Integer.parseInt(st.nextToken()); 
        }
         
        Arrays.sort(coin);
         
        int change = Integer.parseInt(br.readLine());
        ans = new int[change+1];
 
        for(int i = 0; i < coin.length; i++){
            ans[coin[i]] = 1;
        }
         
        System.out.println(func(change));
    }
 
}
