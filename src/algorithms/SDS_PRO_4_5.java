package algorithms;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.StringTokenizer;
 
public class SDS_PRO_4_5 {
    static class el{
        int s, e, t;
        el(int s, int e, int t){
            this.s = s;
            this.e = e;
            this.t = t;
        }
         
        @Override
        public String toString(){
            return s + " " + e + " " + t;
        }
    }
     
    static int[] union;
    static int find(int idx){
        if(union[idx] == idx) return idx;
        return union[idx] = find(union[idx]);
    }
     
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
         
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
         
        union = new int[N+1];
        for(int i = 0; i <= N; i++)
            union[i] = i;
         
        ArrayList<el> list = new ArrayList<el>();
         
        long ans = 0;
         
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            ans += t;
            list.add(new el(s,e,t * -1));
        }
        for(int i = 0; i < K; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            list.add(new el(s,e,t));
        }
         
        list.sort(new Comparator<el>() {
            @Override
            public int compare(el o1, el o2) {
                return o1.t - o2.t;
            }
        });
        int cnt = 0;
         
        for(int i = 0; i < M+K; i++){
            el getI = list.get(i);
            if(i == 0 || getI.t != list.get(i-1).t){
                for(int j = i; j < M+K && list.get(j).t == getI.t;j++){
                    el getJ = list.get(j);
                    if(find(getJ.s) != find(getJ.e)) cnt++;
                }
            }
            if(find(getI.s) == find(getI.e)){
                continue;
            }
            union[find(getI.s)] = find(getI.e);
            ans += getI.t;
        }
         
        System.out.print(ans + " ");
        System.out.println(cnt <= N-1 ? "unique" : "not unique");
    }
}