package algorithms;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class REPRESENTATIVE {
    static int N, M;
    static int fIdx;
    static long maxArr[];
    static long minArr[];
    static long sumArr[];
     
    static long sum(int s, int e){
        s = s + fIdx - 1;
        e = e + fIdx - 1;
        long sum = 0;
         
        while(s<=e){
            if(s%2==1) sum+= sumArr[s++];
            if(e%2==0) sum+= sumArr[e--];
            e/=2;
            s/=2;
        }
         
        return sum;
    }
     
    static long max(int s, int e){
        s = s + fIdx - 1;
        e = e + fIdx - 1;
         
        long max = Long.MIN_VALUE;
         
        while(s <= e){
            if(s%2==1) if(max < maxArr[s++]) max = maxArr[s-1];
            if(e%2==0) if(max < maxArr[e--]) max = maxArr[e+1];
            s/=2;
            e/=2;
        }
         
        return max;
    }
     
    static long min(int s, int e){
        s = s + fIdx - 1;
        e = e + fIdx - 1;
         
        long min = Long.MAX_VALUE;
         
        while(s <= e){
            if(s%2 == 1) if(min > minArr[s++]) min = minArr[s-1];
            if(e%2 == 0) if(min > minArr[e--]) min = minArr[e+1];
            s/=2;
            e/=2;
        }
         
        return min;
    }
     
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         
        N = Integer.parseInt(br.readLine());
         
        StringTokenizer st = new StringTokenizer(br.readLine());
         
        int two[] = new int[20];
        fIdx = 0;
        two[0] = 1;
         
        for(int i = 1; i < 20; i++){
            two[i] = two[i-1] * 2; 
            if(two[i] > N){
                fIdx = two[i];
                break;
            }
        }
        maxArr = new long[fIdx*2];
        minArr = new long[fIdx*2];
        sumArr = new long[fIdx*2];
        for(int i = fIdx; i < fIdx + N; i++){
            long t = Long.parseLong(st.nextToken());
            maxArr[i] = minArr[i] = sumArr[i] = t;
        }
         
        M = Integer.parseInt(br.readLine());
        for(int i = fIdx; i < fIdx*2; i+=2){
            for(int j = i/2; j > 0; j/=2){
                minArr[j] = minArr[j*2] < minArr[j*2+1] ? minArr[j*2] : minArr[j*2+1]; 
                maxArr[j] = maxArr[j*2] > maxArr[j*2+1] ? maxArr[j*2] : maxArr[j*2+1];
                sumArr[j] = sumArr[j*2] + sumArr[j*2+1];
            }
        }
//      System.out.println();
//      for(int i = 0; i<minArr.length; i++){
//          System.out.print(minArr[i] + " ");
//      }
//      System.out.println();
//      for(int i = 0; i<maxArr.length; i++){
//          System.out.print(maxArr[i] + " ");
//      }
//      System.out.println();
//      for(int i = 0; i<sumArr.length; i++){
//          System.out.print(sumArr[i] + " ");
//      }
//      System.out.println();
         
        while(M-- != 0){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
             
            System.out.println(min(s,e) + " "+ max(s, e) + " " + sum(s, e));
        }
    }
}
