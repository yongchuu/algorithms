package algorithms;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;
 
public class SDS_PRO_10_1 {
     
    static int V, E, S;
    static int node[][];
    static int dflag[];
    static int bflag[];
     
     
    static void dfs(int s){
        dflag[s] = 1;
        System.out.print(s + " ");
        for(int i = 1; i <= V; i++){
            if(node[s][i] == 1 && dflag[i] == 0){
                dfs(i);
            }
        }
    }
     
    static void bfs(int s){
         
        Queue<Integer> q = new ArrayDeque<Integer>();
        q.add(s);
        bflag[s] = 1;
         
        while(!q.isEmpty()){
            int t = q.poll();
            System.out.print(t + " ");
            for(int i = 1; i <= V; i++){
                if(node[t][i] == 1 && bflag[i] == 0){
                    bflag[i] = 1;
                    q.add(i);
                }
            }
        }
    }
     
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         
        StringTokenizer st = new StringTokenizer(br.readLine());
         
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
         
        node = new int[V+1][V+1];
        dflag = new int[V+1];
        bflag = new int[V+1];
         
        for(int i = 0; i < E; i++){
            st = new StringTokenizer(br.readLine());
            int t1 = Integer.parseInt(st.nextToken());
            int t2 = Integer.parseInt(st.nextToken());
            node[t1][t2] = 1;
            node[t2][t1] = 1;
        }
         
        dfs(S);
        System.out.println();
        bfs(S);
        System.out.println();
    }
}