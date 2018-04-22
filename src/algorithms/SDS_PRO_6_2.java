package algorithms;

import java.io.BufferedReader;
import java.io.InputStreamReader;
 
public class SDS_PRO_6_2 {
    static char[] flag;
    static char[][] str;
     
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         
        flag = br.readLine().toCharArray();
        char[] tmp1 = br.readLine().toCharArray();
        char[] tmp2 = br.readLine().toCharArray();
        str = new char[2][tmp1.length];
        str[0] = tmp1;
        str[1] = tmp2;
         
         
        int d[][][] = new int[flag.length][2][str[0].length]; 
         
        for(int j = 0; j < str[0].length; j++){
            if(str[0][j] == flag[0]){
                d[0][0][j] = 1;
            }
            if(str[1][j] == flag[0]){
                d[0][1][j] = 1;
            }
        }
         
        for(int i = 1; i < flag.length; i++){
            for(int j = 0; j < 2; j++){
                 
                for(int k = 1; k < str[0].length; k++){
                    int tot = 0;
                    int revJ =  (j == 1 ? 0 : 1);
                     
                    if(flag[i] == str[j][k]){
                        for(int l = 0; l < k; l++){
                            tot += d[i-1][revJ][l];
                        }
                    }
                     
                    d[i][j][k] = tot;
                }
                 
            }
        }
         
        int ans = 0;
         
//      for(int i = 0; i < flag.length; i++){
//          for(int j = 0; j < 2; j++){
//              for(int k = 0; k < str[0].length; k++){
//                  System.out.print(d[i][j][k]+" ");
//              }
//              System.out.println();
//          }
//      }
         
        for(int j = 0; j < str[0].length; j++){
            ans += d[flag.length-1][0][j]; 
            ans += d[flag.length-1][1][j]; 
        }
         
         
        System.out.println(ans);
    }
}