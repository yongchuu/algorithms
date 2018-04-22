package algorithms;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class WASTE {
    static int[][] arr;
    static int[][] ans;
     
     
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         
        int N = Integer.parseInt(br.readLine());
        arr = new int[N+1][N+1];
        ans = new int[N+1][N+1];
         
        StringTokenizer st;
         
        for(int i = 1; i <= N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= N; j++){
                arr[i][j] = Integer.parseInt(st.nextToken()); 
            }
        }
         
         
        for(int i = 1; i <= N; i++){
            for(int j = 1; j <= N; j++){
                ans[i][j] = (ans[i-1][j] > ans[i][j-1] ? ans[i-1][j] : ans[i][j-1]) + arr[i][j];
            }
        }
         
         
        System.out.println(ans[N][N]);
         
    }
}