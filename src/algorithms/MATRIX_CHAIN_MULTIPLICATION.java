package algorithms;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class MATRIX_CHAIN_MULTIPLICATION {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         
        int N = Integer.parseInt(br.readLine());
         
        int flag[] = new int[N+2];
        int ans[][] = new int[N+2][N+2];
         
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N+1; i++){
            flag[i] = Integer.parseInt(st.nextToken());
        }
         
        for(int i = 2; i <= N; i++){
            for(int j = 1; j + i - 1 <= N; j++){
                int min = Integer.MAX_VALUE;
                for(int k = j; k < j+ i - 1 ; k++){
                    int tmp = ans[j][k] + ans[k+1][j+i-1] + flag[j]*flag[k+1]*flag[j+i];
                    if(min > tmp){
                        min = tmp;
                    }
                }
                ans[j][j+i-1] = min;
            }
        }
         
        System.out.println(ans[1][N]);
    }
}
