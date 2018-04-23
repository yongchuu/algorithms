package algorithms;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;
 
public class SDS_PRO_10_2 {
    static int V, E;
    static ArrayList<ArrayList<Integer>> Node = new ArrayList<ArrayList<Integer>>();
    static int[] inDgree;
    static Queue<Integer> q = new PriorityQueue<Integer>();
     
    static void dfs(){
        while(!q.isEmpty()){
            int tmp = q.poll();
            inDgree[tmp] = -1;
             
            System.out.print(tmp + " ");
             
            int size = Node.get(tmp).size();
            for(int i = 0; i < size; i++){
                int ti = Node.get(tmp).get(i);
                if(inDgree[ti] != -1){
                    inDgree[ti]--;
                     
                    if(inDgree[ti] == 0){
                        q.add(ti);
                    }
                }
            }
        }
    }
     
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         
        StringTokenizer st = new StringTokenizer(br.readLine());
         
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
         
        for(int i = 0; i <= V; i++){
            Node.add(new ArrayList<Integer>());
        }
        inDgree = new int[V+1];
         
        for(int i = 0; i < E; i++){
            st = new StringTokenizer(br.readLine());
            int t1 = Integer.parseInt(st.nextToken());
            int t2 = Integer.parseInt(st.nextToken());
            Node.get(t1).add(t2);
            inDgree[t2]++;
        }
         
        for(int i = 1; i <= V; i++){
            if(inDgree[i] == 0){
                q.add(i);
                inDgree[i] = -1;
            }
        }
         
        dfs();
    }
}
