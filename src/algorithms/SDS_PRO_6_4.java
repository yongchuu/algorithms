package algorithms;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class SDS_PRO_6_4 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
         
        int arr[] = new int[N+1];
         
        StringTokenizer st = new StringTokenizer(br.readLine());
        int ans = 0;
        for(int i = 0; i < N; i++){
            int x = Integer.parseInt(st.nextToken());
            if(arr[x] == 0){
                ans++;
                arr[x-1]++;
            }else{
                arr[x]--; arr[x-1]++;
            }
        }
         
         
        System.out.println(ans);
    }
}
