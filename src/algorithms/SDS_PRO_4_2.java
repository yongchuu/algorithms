package algorithms;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
 
public class SDS_PRO_4_2 {
     
    static ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
     
    static int[] ans;
    static int[] flag;
     
    static void dfs(int idx){
        ans[idx]++;
        for(int i = 0; i < list.get(idx).size(); i++){
            if(flag[list.get(idx).get(i)] == 0){
                flag[list.get(idx).get(i)] = 1;
                dfs(list.get(idx).get(i));
            }
        }
    }
     
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         
        StringTokenizer st = new StringTokenizer(br.readLine());
         
        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
         
        int cow[] = new int[K];
        ans = new int[N+1];
        flag = new int[N+1];
         
        for(int i = 0; i < K; i++){
            cow[i] = Integer.parseInt(br.readLine());
        }
         
        for(int i = 0; i <= N; i++){
            list.add(new ArrayList<Integer>());
        }
         
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            list.get(s).add(e);
        }
         
        for(int i = 0; i < K; i++){
            flag = new int[N+1];
            flag[cow[i]] = 1;
            dfs(cow[i]);
            flag[cow[i]] = 0;
        }
         
        int tot = 0;
        for(int i = 1; i <= N; i++){
//          System.out.print(ans[i] + " ");
            if(ans[i] == K){
                tot++;
            }
        }
//      System.out.println();
        System.out.println(tot);
    }
}
