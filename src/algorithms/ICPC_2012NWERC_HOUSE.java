package algorithms;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;
 
public class ICPC_2012NWERC_HOUSE {
    static long[] arr;
     
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         
        //StringTokenizer st = new StringTokenizer(br.readLine());
        long X = Long.parseLong(br.readLine());
         
        X *= 10000000;
         
        int N = Integer.parseInt(br.readLine());
         
        arr = new long[N];
         
         
        for(int i = 0; i < N; i++){
            arr[i] = Long.parseLong(br.readLine());
        }
         
        Arrays.sort(arr);
         
        for(int i = 0; i < N; i++){
            int right = N-1;
            int left = (N-1+i)/2;
            while(left < right){
                if(i != left && arr[left] + arr[i] == X){
                    System.out.println("yes " + arr[i] + " " +arr[left]);
                    return;
                }else if(arr[i] + arr[left] > X){
                    right = left;
                    left = (i + left) / 2;
                }else{
                    left = (right + left+1) / 2;
                }
            }
            //left == right 한번 더 체크
            if(i != left && arr[left] + arr[i] == X){
                System.out.println("yes " + arr[i] + " " + arr[left]);
                return;
            }
        }
         
        System.out.println("danger");
    }
}
