package algorithms;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class SDS_PRO_3_5 {
    static long two[];
    static long tree[];
    static int fIdx;
     
    static void insert(int w, int g){
        long imsi = tree[fIdx+w-1];
        tree[fIdx+w-1] = g;
         
        for(int i = (fIdx + w-1)/2; i > 0; i/=2){
            tree[i] = tree[i] + g - imsi; 
        }
    }
     
    static long getTot(int l, int r){
        long tot = 0;
         
        l += fIdx-1;
        r += fIdx-1;
         
        while(l <= r){
            if(l % 2 == 1) tot+=tree[l++];
            if(r % 2 == 0) tot+=tree[r--];
            l/=2;
            r/=2;
        }
         
        return tot;
    }
     
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         
        int N = Integer.parseInt(br.readLine());
        int Q = Integer.parseInt(br.readLine());
         
        StringTokenizer st;
         
        //2의배수 만들기
        two = new long[19];
        two[0] = 1;
        int flag = 0;
        for(int i = 1; i < 19; i++){
            two[i] = two[i-1] * 2;
            if(N <= two[i]){
                flag = i;
                break;
            }
        }
         
        fIdx = (int)two[flag];
        //int lIdx = two[flag] * 2-1;
         
        tree = new long[(int)(two[flag]*2)];
         
        //초기화
        for(int i = 1; i <= N; i++){
            insert(i, i);
        }
         
        for(int i = 0; i < Q; i++){
            st = new StringTokenizer(br.readLine());
            int q = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
             
            if(q==0){
                insert(x, y);
            }else{
                System.out.println(getTot(x,y));
            }
        }
    }
}
