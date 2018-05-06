package algorithms;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class KOI_2008RH_AMEOBA {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         
        StringTokenizer st = new StringTokenizer(br.readLine());
         
         
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
         
        long D[] = new long[N+1];
        long arr[] = new long[N+1];
         
        //초기화
        D[0] = 1;
        arr[0] = 1;
        long ans= 0;
         
        for(int i = 1; i <= N; i++){
            if(i - a >= 0){
                D[i] = (arr[i-a] - (i-b>=0 ? arr[i-b]:0) + 1000) % 1000;
            }
            arr[i] = arr[i-1] + D[i] % 1000;
        }
        for(int i = N-d+1; i<= N; i++){
            if(i>=0) ans = (ans + D[i]) % 1000;
        }
         
        System.out.println(ans);
    }
}
