package algorithms;

import java.io.BufferedReader;
import java.io.InputStreamReader;
 
public class LCS {
     
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         
        String s1 = br.readLine();
        String s2 = br.readLine();
         
        int[][] arr = new int[s1.length()+1][s2.length()+1];
        //1: 위쪽   2: 왼쪽  3. 대각선
        int[][] ans = new int[s1.length()+1][s2.length()+1];
         
        for(int i = 1; i <= s1.length(); i++){
            for(int j = 1; j <= s2.length(); j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    arr[i][j] = arr[i-1][j-1] + 1;
                    ans[i][j] = 3;
                }else{
                    if( arr[i-1][j] > arr[i][j-1] ){
                        arr[i][j] = arr[i-1][j];
                        ans[i][j] = 1;
                    }else{
                        arr[i][j] = arr[i][j-1];
                        ans[i][j] = 2;
                    }
                }
            }
        }
        int j = s2.length();
         
        String a = "";
         
        for(int i = s1.length(); i > 0 && j > 0; i--){
            if(ans[i][j] == 3){
                a += s1.charAt(i-1);
                j--;
            }else if(ans[i][j] == 2){
                j--;
                i++;
            }
        }
         
        for(int i = a.length()-1; i >= 0; i--){
            System.out.print(a.charAt(i));
        }
        System.out.println();
    }
 
}