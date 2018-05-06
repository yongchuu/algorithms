package algorithms;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;
 
public class SDS_PRO_6_6 {
    static class el{
        int t, d;
        el(int t, int d){
            this.t = t;
            this.d = d;
        }
        @Override
        public String toString(){
            return t + " " + d;
        }
    }
     
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
         
        StringTokenizer st;
         
        Queue<el> q = new PriorityQueue<el>(new Comparator<el>() {
            @Override
            public int compare(el o1, el o2) {
                return o1.t*o2.d - o2.t*o1.d;
            }
        });
         
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
             
            q.add(new el(t, d));
        }
         
        long time=0;
        long tot = 0;
         
        while(!q.isEmpty()){
            el tmp = q.poll();
            tot += time * tmp.d;
            time += tmp.t * 2;
        }
         
        System.out.println(tot);
         
    }
}
