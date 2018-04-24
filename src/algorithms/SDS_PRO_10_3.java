package algorithms;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
 
public class SDS_PRO_10_3 {
     
     
    public static void main(String[] args) throws Exception{
        ArrayList<ArrayList<Integer[]>> list = new ArrayList<ArrayList<Integer[]>>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        long[] D = new long[N+1];
         
        for(int i = 0; i <= N; i++){
            list.add(new ArrayList<Integer[]>());
        }
         
        for(int tc = 0; tc < M; tc++){
            st = new StringTokenizer(br.readLine());
            Integer[] tmp = new Integer[2];
            int a = Integer.parseInt(st.nextToken()); 
            int b = Integer.parseInt(st.nextToken()); 
            int c = Integer.parseInt(st.nextToken());
            tmp[0] = a;
            tmp[1] = c;
             
            list.get(b).add(tmp);
        }
         
        D[1] = 1;
        for(int i = 2; i <= N; i++){
            int size = list.get(i).size();
            for(int j = 0; j < size; j++){
                int a = list.get(i).get(j)[0];
                int c = list.get(i).get(j)[1];
                 
                if(D[a] != 0)
                    if(D[i] == 0 || D[a] + c < D[i])
                        D[i] = D[a] + c;
            }
        }
         
        if(D[N] == 0)
            System.out.println("-1");
        else
            System.out.println(D[N] - 1);
    }
}
