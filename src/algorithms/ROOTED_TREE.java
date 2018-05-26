package algorithms;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
 
public class ROOTED_TREE {
    static int N, R, Q;
    static ArrayList<ArrayList<Integer>> list;
     
    static ArrayList<ArrayList<Integer>> tree;
    static int[][] timestamp;
    static int[] color;
     
    static int time = 1;
     
    static void dfs(int idx){
        color[idx] = 1;
        timestamp[idx][0] = time++;
         
        int size = tree.get(idx).size();
        for(int i = 0; i < size; i++){
            int tmpNode = tree.get(idx).get(i);
            if(color[tmpNode] == 0){
                dfs(tmpNode);
            }
        }
         
        timestamp[idx][1] = time++;
        color[idx] = 2;
    }
     
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());
         
        st = new StringTokenizer(br.readLine());
         
        tree = new ArrayList<ArrayList<Integer>>();
        timestamp = new int[N+1][2];
        color = new int[N+1];
         
        for(int i = 0; i <= N; i++){
            tree.add(new ArrayList<Integer>());
        }
         
        for(int i = 1; i <= N; i++){
            int tmp = Integer.parseInt(st.nextToken());
            if(i != tmp){
                tree.get(tmp).add(i);
            }
        }
         
        dfs(R);
         
        for(int i = 0; i < Q; i++){
            st = new StringTokenizer(br.readLine());
            int t1 = Integer.parseInt(st.nextToken());
            int t2 = Integer.parseInt(st.nextToken());
             
            if(t1 == t2){
                System.out.println("YES");
                continue;
            }
             
            if(timestamp[t1][0] < timestamp[t2][0] && timestamp[t1][1] > timestamp[t2][1]){
                System.out.println("YES");
            }else{
                System.out.println("NO");
            }
        }
    }
}