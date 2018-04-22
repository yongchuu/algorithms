package algorithms;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class ICPC_2009GNY_ADJACENTBIT {
    static int[][][] ans = new int[101][101][2];
     
    static int func(int n, int k, int flag){
        if(n < 1 || k < 0 || n <= k){
            return 0;
        }
        if(ans[n][k][flag] != 0){
            return ans[n][k][flag];
        }
         
        if(flag == 0)
            ans[n][k][0] = func(n-1, k, 0) + func(n-1,k,1);
        else
            ans[n][k][1] = func(n-1, k, 0)+ func(n-1, k-1, 1);
         
        return ans[n][k][flag];
    }
     
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         
        int TC = Integer.parseInt(br.readLine());
         
        for(int tc = 1; tc <= TC; tc++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
             
            ans[1][0][0] = 1;
            ans[1][0][1] = 1;
             
            int tmp = func(N,K,0) + func(N,K,1);
             
            System.out.println(t + " " + tmp);
        }
         
    }
 
}