package algorithms;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
  
public class ULM_LOCAL_2003_H {
    static long max;
    static int union[][];
    static long arr[];
    static int N;
      
    static int findL(int idx){
        int a = union[idx][0];
        while(arr[idx] <= arr[a]){
            a = findL(a);
        }
        return union[idx][0] = a;
    }
    static int findR(int idx){
        int a = union[idx][1];
        while(arr[idx] <= arr[a]){
            a = findR(a);
        }
        return union[idx][1] = a;
    }
     
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
          
        while(true){
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            if(N == 0){
                break;
            }
              
            //초기화
            union = new int[N+2][2];
            arr = new long[N+2];
            max = 0;
              
            for(int i = 1; i <= N; i++){
                union[i][0] = i-1;
                union[i][1] = i+1;
                arr[i] = Integer.parseInt(st.nextToken());
            }
            arr[0] = -1;
            arr[N+1] = -1;
              
            for(int i = 1; i <= N; i++){
                union[i][0] = findL(i);
                union[i][1] = findR(i);
                  
                long tmp = (union[i][1] - union[i][0] - 1) * arr[i]; 
                if(tmp > max){
                    max = tmp;
                }
            }
              
            System.out.println(max);
        }
    }
}
