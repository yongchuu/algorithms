package algorithms;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;
  
public class SDS_PRO_6_5 {
      
    static class el{
        int m, v;
        el(int m, int v){
            this.m = m;
            this.v = v;
        }
          
        @Override
        public String toString(){
            return m + " : " + v;
        }
    }
      
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
          
        ArrayList<el> list = new ArrayList<el>();
        int[] bag = new int[K];
          
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
              
            list.add(new el(m,v));
        }
          
        list.sort(new Comparator<el>() {
            @Override
            public int compare(el o1, el o2) {
                if(o1.m == o2.m){
                    return o2.v - o1.v;
                }
                return o1.m - o2.m;
            }
        });
          
        for(int i = 0; i < K; i++){
            bag[i] = Integer.parseInt(br.readLine());
        }
          
        Arrays.sort(bag);
        long tot = 0;
          
        Queue<el> q = new PriorityQueue<el>(new Comparator<el>() {
            @Override
            public int compare(el o1, el o2) {
                return o2.v - o1.v;
            }
        });
          
        int cnt = 0;
        for(int i = 0; i < K; i++){
            while(cnt < list.size() && list.get(cnt).m <= bag[i]){
                q.add(list.get(cnt++));
            }
            if(!q.isEmpty()){
                tot+= q.poll().v;
            }
        }
          
        System.out.println(tot);
    }
}