package algorithms;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class NUMBEROFINVERSION {
    static int N;
     
    private static long countingInversions(int[] a) {
        int n = a.length;
        int[] buf = new int[n];           
        long cnt = count(a,0,n-1,buf);
        return cnt;
    }
 
    private static long count(int[] a, int s, int e, int[] buf){
        if((e-s)<1) {
                 return 0;
        }       
        
        int m = (s+e) / 2;
        long leftCount = count(a,s,m,buf);
        long rightCount = count(a,m+1,e,buf);
        long mergeCount = merge(a,s,m,e,buf);
        System.arraycopy(buf, s, a, s, (e-s)+1);
 
        return leftCount + rightCount + mergeCount;
    }
 
    private static long merge(int[]a,int s, int m, int e, int[] buf){
            int left=s;
            int right=m+1;
            long count=0;
            for(int k=s;k<=e;k++){
                     if(left<=m && ( (right>e) || (a[left] <= a[right]) ) ){
                             buf[k] = a[left++];                                 
                     }else{
                             buf[k] = a[right++];
                             count = count + (m-left+1);
                     }
            }
            return count;
    }
     
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         
        N = Integer.parseInt(br.readLine()); 
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
         
        System.out.println(countingInversions(arr));
    }
}