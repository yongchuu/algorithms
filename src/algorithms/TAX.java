package algorithms;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;
 
public class TAX {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         
        StringTokenizer st = new StringTokenizer(br.readLine());
         
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
         
        Queue<Integer> sorted = new PriorityQueue<Integer>();
         
        //초기화
        for(int i = 0; i < K; i++){
            sorted.add(-1000000000);
        }
        
        Object[] list = new Object[K+1];
         
        st = new StringTokenizer(br.readLine());
         
        for(int i = 0; i < N; i++){
            int tmp = Integer.parseInt(st.nextToken());
             
            list = sorted.toArray();
            for(int j = 0; j < K; j++){
                if(((int)list[j] + tmp) > sorted.peek()){
                    sorted.poll();
                    sorted.add((int)list[j] + tmp);
                }
            }
        }
        int ans = 0;
        while(!sorted.isEmpty()){
            ans = sorted.poll();
        }
        System.out.println(ans);
    }
}