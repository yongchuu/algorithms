package algorithms;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class MAX_SUBARRAY {
    static long max = -5000000;
     
    static long arr[];
    static long ans[];
     
    static long func(int idx){
        if(idx == 0){
            return 0;
        }
        if(ans[idx]!=0){
            return ans[idx];
        }
         
        long tmp = func(idx-1);
         
        ans[idx] = (arr[idx] > arr[idx] + tmp ? arr[idx] : arr[idx] + tmp);
         
        //max = (ans[idx] > max ? ans[idx] : max);
        if(ans[idx] > max){
            max = ans[idx];
        }
         
        return ans[idx];
    }
     
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         
        int N = Integer.parseInt(br.readLine());
         
        StringTokenizer st = new StringTokenizer(br.readLine());
         
        arr = new long[N+1];
        ans = new long[N+1];
         
        for(int i = 1; i <= N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
         
        ans[0] = arr[0];
         
        func(N);
         
        System.out.println(max);
    }
 
}