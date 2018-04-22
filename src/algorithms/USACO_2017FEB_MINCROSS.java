package algorithms;

import java.io.BufferedReader;
import java.io.InputStreamReader;
 
public class USACO_2017FEB_MINCROSS {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         
        int n = Integer.parseInt(br.readLine());
         
        int[] s1 = new int[n+1];
        int[] s2 = new int[n+1];
        int[] flag1 = new int[n+1];
        int[] flag2 = new int[n+1];
        int[] idx1 = new int[n+1];
        int[] idx2 = new int[n+1];
         
         
        for(int i = 1; i <= n; i++){
            int tmp = Integer.parseInt(br.readLine());
            s1[i] = tmp;
            idx1[tmp] = i;
        }
        for(int i = 1; i <= n; i++){
            int tmp = Integer.parseInt(br.readLine());
            s2[i] = tmp;
            idx2[tmp] = i;
        }
         
        for(int i = 1; i <= n; i++){
            flag1[i] = idx2[s1[i]];
            flag2[i] = idx1[s2[i]];
        }
         
        int[] tmp1 = flag1.clone();
        int[] tmp2 = flag2.clone();
         
        long ans1 = countingInversions(tmp1);
        long ans2 = countingInversions(tmp2);
//      for(int i = 1; i <= n; i++){
//          for(int j = i+1; j <= n; j++){
//              if(flag1[i] > flag1[j]){
//                  ans1++;
//              }
//              if(flag2[i] > flag2[j]){
//                  ans2++;
//              }
//          }
//      }
        long min1 = ans1;
        long min2 = ans2;
         
        for(int i = 1; i <= n; i++){
            ans1 = ans1 + n + 1 - 2*flag1[i];
            if(min1 > ans1)
                min1 = ans1;
            ans2 = ans2 + n + 1 - 2*flag2[i];
            if(min2 > ans2)
                min2 = ans2;
        }
         
        System.out.println(min1 < min2 ? min1 : min2);
    }
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
}
