package algorithms;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
 
public class BECOME_ONE {
     
    static class el{
        int idx, cnt;
        el(int idx, int cnt){
            this.idx = idx;
            this.cnt = cnt;
        }
         
        @Override
        public String toString(){
            return idx + " " + cnt;
        }
    }
     
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         
        int N = Integer.parseInt(br.readLine());
         
        int flag[] = new int[N+1];
         
        Queue<el> q = new ArrayDeque<el>();
        q.add(new el(1,0));
        flag[1] = 1;
         
        while(!q.isEmpty()){
            el now = q.poll();
             
            if(now.idx == N){
                System.out.println(now.cnt);
                return;
            }
             
            if(now.idx * 3 <= N && flag[now.idx * 3] == 0){
                if(now.idx * 3 == N){
                    System.out.println(now.cnt+1);
                    return;
                }
                q.add(new el(now.idx * 3, now.cnt + 1));
                flag[now.idx * 3] = 1;
            }
            if(now.idx * 2 <= N && flag[now.idx * 2] == 0){
                if(now.idx * 2 == N){
                    System.out.println(now.cnt+1);
                    return;
                }
                q.add(new el(now.idx * 2, now.cnt + 1));
                flag[now.idx * 2] = 1;
            }
            if(now.idx + 1 <= N && flag[now.idx + 1] == 0){
                if(now.idx + 1 == N){
                    System.out.println(now.cnt+1);
                    return;
                }
                q.add(new el(now.idx + 1, now.cnt + 1));
                flag[now.idx + 1] = 1;
            }
        }
    }
}
