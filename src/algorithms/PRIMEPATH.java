package algorithms;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;
 
public class PRIMEPATH {
    static class Ic {
        int cnt, p;
        Ic(int p, int cnt){
            this.p = p;
            this.cnt = cnt;
        }
    }
    static Queue<Integer> prime = new PriorityQueue<Integer>();
    static Queue<Ic> q = new ArrayDeque<Ic>();
     
    static int[] che = new int[10000];
     
    static int[] flag;
     
    static int p1, p2;
     
    static int func(int p){
        while(!q.isEmpty()){
            Ic ic = q.poll();
            int tCnt = ic.cnt;
            int tP = ic.p;
            int t1 = (tP / 10) * 10;
            int t10 = ((tP / 100) * 100) + (tP % 10);
            int t100 = ((tP / 1000) * 1000) + (tP % 100);
            int t1000 = (tP % 1000);
             
            if(tP == p2){
                return tCnt;
            }
             
            for(int i = 0; i < 10; i++){
                if(prime.contains(t1 + i)){
                    if(flag[t1+i] == 0){
                        flag[t1+i] = 1;
                        q.add(new Ic(t1+i, tCnt+1));
                    }
                }
                if(prime.contains(t10 + (i*10))){
                    if(flag[t10+(i*10)] == 0){
                        flag[t10+(i*10)] = 1;
                        q.add(new Ic(t10+i*10, tCnt+1));
                    }
                }
                if(prime.contains(t100 + (i*100))){
                    if(flag[t100+(i*100)] == 0){
                        flag[t100+(i*100)] = 1;
                        q.add(new Ic(t100+i*100, tCnt+1));
                    }
                }
                if(i != 0)
                if(prime.contains(t1000 + (i*1000))){
                    if(flag[t1000+(i*1000)] == 0){
                        flag[t1000+(i*1000)] = 1;
                        q.add(new Ic(t1000+i*1000, tCnt+1));
                    }
                }
            }
             
        }
        return 0;
    }
     
    static void makeChe(){
        for(int i = 0; i < 10000; i+=2){
            che[i] = 1;
        }
         
        for(int i = 3; i < 100; i+=2){
            for(int j = 1; j < 10000; j++){
                if(i * j < 10000){
                    che[i*j] = 1;
                }else{
                    continue;
                }
            }
        }
    }
     
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         
        makeChe();
         
        for(int i = 1000; i < 10000; i++){
            if(che[i] == 0){
                prime.add(i);
            }
        }
         
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
         
         
        for(int tc = 0; tc < N; tc++){
            st = new StringTokenizer(br.readLine());
            p1 = Integer.parseInt(st.nextToken());
            p2 = Integer.parseInt(st.nextToken());
            flag = new int[10000];
            q = new ArrayDeque<Ic>();
            q.add(new Ic(p1, 0));
            flag[p1] = 1;
             
            System.out.println(func(p1));
        }
    }
}