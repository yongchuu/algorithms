package algorithms;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;
 
public class SDS_PRO_4_1 {
     
    static class el{
        int y, x, v;
        el(int y, int x, int v){
            this.y = y;
            this.x = x;
            this.v = v;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         
        StringTokenizer st = new StringTokenizer(br.readLine());
         
        int W = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());
         
        int arr[][] = new int[H+2][W+2];
         
        int ans[][] = new int[H+2][W+2];
         
        Queue<el> q = new ArrayDeque<el>();
         
        for(int i = 0; i <= H+1; i++){
            for(int j = 0; j <= W+1; j++){
                arr[i][j] = 1;
            }
        }
         
        int sY = 0;
        int sX = 0;
        int eY = 0;
        int eX = 0;
         
        for(int i = 0; i < H; i++){
            String tmp = br.readLine();
             
            for(int j = 0; j < W; j++){
                if(tmp.charAt(j) == 'S'){
                    sY = i+1;
                    sX = j+1;
                    arr[sY][sX] = 1;
                }else if(tmp.charAt(j) == 'E'){
                    eY = i+1;
                    eX = j+1;
                    arr[eY][eX] = 2;
                }else if(tmp.charAt(j) == 'O'){
                    arr[i+1][j+1] = 0;
                }
            }
        }
         
        q.add(new el(sY, sX, 0));
         
        while(!q.isEmpty()){
            el tmpEl = q.poll();
            int ty = tmpEl.y;
            int tx = tmpEl.x;
            int tv = tmpEl.v;
             
            if(arr[ty-1][tx] != 1){
                if(arr[ty-1][tx] == 2){
                    System.out.println(tv+1);
                    return;
                }
                 
                arr[ty-1][tx] = 1;
                ans[ty-1][tx] = tv+1;
                q.add(new el(ty-1, tx, tv+1));
            }
            if(arr[ty+1][tx] != 1){
                if(arr[ty+1][tx] == 2){
                    System.out.println(tv+1);
                    return;
                }
                arr[ty+1][tx] = 1;
                ans[ty+1][tx] = tv+1;
                q.add(new el(ty+1, tx, tv+1));
            }
            if(arr[ty][tx-1] != 1){
                if(arr[ty][tx-1] == 2){
                    System.out.println(tv+1);
                    return;
                }
                arr[ty][tx-1] = 1;
                ans[ty][tx-1] = tv+1;
                q.add(new el(ty, tx-1, tv+1));
            }
            if(arr[ty][tx+1] != 1){
                if(arr[ty][tx+1] == 2){
                    System.out.println(tv+1);
                    return;
                }
                arr[ty][tx+1] = 1;
                ans[ty][tx+1] = tv+1;
                q.add(new el(ty, tx+1, tv+1));
            }
        }
         
        System.out.println("-1");
    }
}