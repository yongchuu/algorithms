package algorithms;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class RIGHTDOWN {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         
        StringTokenizer st = new StringTokenizer(br.readLine());
         
        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
         
        int arr[][] = new int[H+1][W+1];
         
        int flag[][] = new int[H+1][W+1];
         
         
        //입력
        for(int i = 1; i <= H; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= W; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
         
        flag[1][1] = N-1;
         
        for(int i = 1; i <= H; i++){
            for(int j = 1; j <= W; j++){
                if(i == 1 && j == 1) continue;
                if(arr[i][j-1] == 1){
                    flag[i][j] += (flag[i][j-1] / 2) + flag[i][j-1] % 2;
                }else{
                    flag[i][j] += flag[i][j-1] / 2;
                }
                if(arr[i-1][j] == 0){
                    flag[i][j] += (flag[i-1][j] / 2) + flag[i-1][j] % 2;
                }else{
                    flag[i][j] += (flag[i-1][j] / 2);
                }
            }
        }
         
        for(int i = 1; i <= H; i++){
            for(int j = 1; j <= W; j++){
                arr[i][j] = (arr[i][j] + flag[i][j])%2;
            }
        }
         
        int i=1, j=1;
        while(i<=H && j<=W){
            if(arr[i][j] == 0){
                i++;
            }else{
                j++;
            }
        }
         
        System.out.println(i + " " + j);
    }
}
