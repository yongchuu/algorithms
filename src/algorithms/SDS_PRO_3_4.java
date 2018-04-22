package algorithms;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class SDS_PRO_3_4 {
    static int[] union;
    static int[] arr;
     
    static int find(int idx){
        int b = union[idx];
        while(arr[idx] > arr[b]){
            b = find(b);
        }
        return union[idx] = b;
    }
     
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
         
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new int[N+1]; 
        union = new int[N+1];
         
        arr[0] = Integer.MAX_VALUE;
         
        for(int i = 1; i <= N; i++){
            union[i] = i-1;
        }
        for(int i = 1; i <= N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
         
        for(int i = 1; i <= N; i++){
            union[i] = find(i);
        }
        for(int i = 1; i <= N; i++)
            System.out.print(union[i] + " ");
    }
}
