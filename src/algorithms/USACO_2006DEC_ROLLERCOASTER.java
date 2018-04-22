package algorithms;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
 
public class USACO_2006DEC_ROLLERCOASTER {
    static class innerClass{
        int X, W, F, C;
        innerClass(String x, String w, String f, String c){
            X = Integer.parseInt(x);
            W = Integer.parseInt(w);
            F = Integer.parseInt(f);
            C = Integer.parseInt(c);
        }
         
        @Override
        public String toString(){
             
            return X+""+W+""+F+""+C+" ";
        }
    }
     
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         
        StringTokenizer st = new StringTokenizer(br.readLine());
        int L = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
         
        innerClass[] ic = new innerClass[N+1];
        ArrayList<ArrayList<innerClass>> list = new ArrayList<ArrayList<innerClass>>();
         
        for(int i = 0; i <= N; i++){
            ArrayList<innerClass> tmpList = new ArrayList<innerClass>();
            list.add(tmpList);
        }
         
        for(int i = 1; i <= N; i++){
            st = new StringTokenizer(br.readLine());
            innerClass tmpIc = new innerClass(st.nextToken(), st.nextToken(), st.nextToken(), st.nextToken());
            ic[i] = tmpIc;
            list.get(tmpIc.X + tmpIc.W).add(tmpIc);
        }
         
        int[][] d = new int[L+1][B+1];
        for(int i = 1; i <= L; i++){
            for(int j = 0; j <= B; j++){
                d[i][j] = -1;
                for(int k = 0; k < list.get(i).size(); k++){
                    innerClass tmp = list.get(i).get(k);
                    if(j-tmp.C < 0) continue;
                    if(d[tmp.X][j-tmp.C] == -1) continue; 
                    if(d[i][j] == -1 || d[i][j] < d[tmp.X][j-tmp.C] + tmp.F)
                        d[i][j] = d[tmp.X][j-tmp.C] + tmp.F;
                }
            }
        }
         
        int max = Integer.MIN_VALUE;
         
//      for(int i = 1; i <=L; i++){
//          for(int j = 0; j <= B; j++){
//              System.out.print(d[i][j]+"\t");
//          }
//          System.out.println();
//      }
        for(int i = 1; i <= B; i++){
            if(max < d[L][i]){
                max = d[L][i];
            }
        }
         
        System.out.println(max);
    }
}
