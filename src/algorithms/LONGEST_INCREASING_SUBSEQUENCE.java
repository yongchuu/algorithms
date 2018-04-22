package algorithms;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class LONGEST_INCREASING_SUBSEQUENCE {
 
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         
        int N = Integer.parseInt(br.readLine());
         
        int[] arr = new int[N];
        int[] flag = new int[N];
        int fIdx = 0;
         
        StringTokenizer st = new StringTokenizer(br.readLine());
         
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
         
        flag[fIdx++] = arr[0];
        for(int i = 1; i < N; i++){
            if(flag[fIdx-1] < arr[i]){
                flag[fIdx++] = arr[i];
            }else{
                //lower_bound
                int l = 0;
                int r = fIdx;
                int m = fIdx / 2;
                 
                while(l + 1 < r){
                    if(flag[m] > arr[i]){
                        r=m;
                        m = (l + m) / 2;
                    }else{
                        l = m;
                        m = (m + r) / 2;
                    }
                }
                flag[m+1] = arr[i];
                 
                 
//              for(int j = 0; j < fIdx; j++){
//                  if(flag[j] > arr[i]){
//                      flag[j] = arr[i];
//                      break;
//                  }
//              }
            }
//          for(int j = 0; j < fIdx; j++){
//              System.out.print(flag[j]+" ");
//          }
//          System.out.println();
        }
         
        System.out.println(fIdx);
    }
}