package algorithms;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
 
public class NUGGET {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         
        int N = Integer.parseInt(br.readLine());
         
        StringTokenizer st = new StringTokenizer(br.readLine());
         
        int[] arr = new int[N+1];
        for(int i = 1; i <= N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
         
        long sum = 0;
         
        for(int i = 1; i <= N; i++){
            if(arr[i]>sum+1){
                System.out.println(sum+1);
                return;
            }else{
                sum+=arr[i];
            }
        }
        System.out.println(sum+1);
         
    }
}
