package algorithms;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
 
public class SDS_PRO_4_6 {
    static class el{
        int y, t;
        el(int y, int t){
            this.y = y;
            this.t = t;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
         
        int TC = Integer.parseInt(br.readLine());
         
         
        while(TC-- != 0){
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());
             
            long flag[] = new long[N+1];
            for(int i = 0; i <= N; i++){
                flag[i] = Integer.MAX_VALUE;
            }
            flag[1] = 0;
             
            ArrayList<ArrayList<el>> E = new ArrayList<ArrayList<el>>();
             
            for(int i = 0; i <= M+W; i++){
                E.add(new ArrayList<el>());
            }
             
            for(int i = 0; i < M+W; i++){
                st = new StringTokenizer(br.readLine());
                int t1 = Integer.parseInt(st.nextToken());
                int t2 = Integer.parseInt(st.nextToken());
                int t3;
                if(i < M){
                    t3 = Integer.parseInt(st.nextToken());
                    E.get(t1).add(new el(t2, t3));
                    E.get(t2).add(new el(t1, t3));
                }
                else{
                    t3 = Integer.parseInt(st.nextToken()) * -1;
                    E.get(t1).add(new el(t2, t3));
                }
                 
            }
             
            int updated = 0;
            for(int i = 0; i < N; i++){
                updated = 0;
                for(int here = 1; here <= N; here++){
                    for(int k = 0; k < E.get(here).size(); k++){
                        if(flag[E.get(here).get(k).y] > flag[here] + E.get(here).get(k).t){
                            updated = 1;
                            flag[E.get(here).get(k).y] = flag[here] + E.get(here).get(k).t;
                        }
                    }
                }
                if(updated == 0){
                    break;
                }
            }
            if(updated == 0)
                System.out.println("NO");
            else
                System.out.println("YES");
                 
        }
    }
}