package algorithms;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class SDS_PRO_2_2 {
    static final int per = 1000000000;
     
    static int[][] c;
     
    static int func(int n, int k){
        if(n < k){
            return 0;
        }
        if(n==1){
            return 1;
        }
         
        if(c[n][k] != 0){
            return c[n][k];
        }
         
        return c[n][k] = (func(n-1, k-1) % per + func(n-1, k) % per) % per;
    }
     
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         
        StringTokenizer st = new StringTokenizer(br.readLine());
         
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
         
        int max = N > K ? N : K;
         
        c = new int[2*max+2][2*max+2];
         
        //조합 초기화
        for(int i = 1; i < 2*max+2; i++){
            c[i][i] = 1;
            c[i][0] = 1;
            c[i][1] = i;
            c[i][i-1] = i;
        }
         
        int n = N+1;
        int r = K-1;
         
        System.out.println(func(n+r-1, r));
         
    }
 
}