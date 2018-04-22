package algorithms;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class ASSEMBLY_LINE_SCHEDULING {
     
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         
        StringTokenizer st = new StringTokenizer(br.readLine());
         
        int n = Integer.parseInt(st.nextToken());
        int e1 = Integer.parseInt(st.nextToken());
        int e2 = Integer.parseInt(st.nextToken());
        int x1 = Integer.parseInt(st.nextToken());
        int x2 = Integer.parseInt(st.nextToken());
         
        int[] s1 = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            s1[i] = Integer.parseInt(st.nextToken());
        }
         
        int[] s2 = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            s2[i] = Integer.parseInt(st.nextToken());
        }
         
        int[] t1 = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n-1; i++){
            t1[i] = Integer.parseInt(st.nextToken());
        }
         
        int[] t2 = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n-1; i++){
            t2[i] = Integer.parseInt(st.nextToken());
        }
         
         
        int[][] a = new int[n][2];
         
        a[0][0] = e1 + s1[0];
        a[0][1] = e2 + s2[0];
         
        for(int i = 1; i < n; i++){
            a[i][0] = Math.min(t2[i-1]+a[i-1][1]+s1[i], a[i-1][0] + s1[i]);
            a[i][1] = Math.min(a[i-1][0]+t1[i-1]+s2[i], a[i-1][1] + s2[i]);
        }
         
        System.out.println(Math.min(a[n-1][0]+x1, a[n-1][1]+x2));
    }
 
}