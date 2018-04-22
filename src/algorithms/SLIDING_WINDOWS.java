package algorithms;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;
 
public class SLIDING_WINDOWS {
     
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
         
        Long arr[] = new Long[N+1];
         
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++){
            arr[i] = Long.parseLong(st.nextToken());
        }
         
        Queue<Long> up = new PriorityQueue<Long>();
        Queue<Long> down = new PriorityQueue<Long>(new Comparator<Long>() {
            @Override
            public int compare(Long o1, Long o2) {
                // TODO Auto-generated method stub
                return (int)(o2-o1);
            }
        });
         
        Long tot = new Long(0);
         
        //초기화
        for(int i = 1; i <= K; i++){
            tot += arr[i];
            up.add(arr[i]);
            down.add(arr[i]);
        }
        System.out.println(up.peek() + " " + down.peek() + " " + tot);
         
        for(int i = 2; i <= N-K+1; i++){
            Long in = arr[i+K-1];
            Long out = arr[i-1];
            tot = tot - out + in;  
            up.remove(out);
            up.add(in);
            down.remove(out);
            down.add(in);
            System.out.println(up.peek() + " " + down.peek() + " " + tot);
        }
    }
}
