package algorithms;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;
 
public class SHORTEST_PATH {
     
    static class ic{
        int go;
        long charge;
        ic(int go, long charge){
            this.go = go;
            this.charge = charge;
        }
    }
     
    static ArrayList<ArrayList<ic>> node = new ArrayList<ArrayList<ic>>();
    static ArrayList<ic> tlist = new ArrayList<ic>();
    static Queue<ic> q = new PriorityQueue<ic>(new Comparator<ic>() {
        @Override
        public int compare(ic o1, ic o2) {
            return (int)(o1.charge - o2.charge);
        }
    });
     
    static long dist[];
     
    static void dijkstra(){
        while(!q.isEmpty()){
            ic tic = q.poll();
             
            int size = node.get(tic.go).size();
             
            for(int i = 0; i < size; i++){
                ic t = node.get(tic.go).get(i);
                 
                if(dist[t.go] > tic.charge + t.charge){
                    dist[t.go] = tic.charge + t.charge;
                    q.add(new ic(t.go, tic.charge + t.charge));
                }
            }
        }
    }
     
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
         
        dist = new long[N+1];
         
        for(int i = 0; i <= N; i++){
            node.add(new ArrayList<ic>());
        }
         
        for(int i = 1; i <= M; i++){
            st = new StringTokenizer(br.readLine());
            int t1 = Integer.parseInt(st.nextToken());
            int t2 = Integer.parseInt(st.nextToken());
            long t3 = Long.parseLong(st.nextToken());
            node.get(t1).add(new ic(t2, t3));
            node.get(t2).add(new ic(t1, t3));
        }
         
//      q.add(new ic(1,0));
         
        for(int i = 0; i < node.get(1).size(); i++){
            q.add(new ic(node.get(1).get(i).go, node.get(1).get(i).charge));
        }
        dist[1] = 0;
        for(int i = 2; i <= N; i++){
            dist[i] = Long.MAX_VALUE;
        }
         
        dijkstra();
         
        if(dist[N] == Long.MAX_VALUE){
            System.out.println("-1");
        }else{
            System.out.println(dist[N]);
        }
    }
}
