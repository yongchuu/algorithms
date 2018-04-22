package algorithms;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
 
public class SDS_PRO_3_6 {
     
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         
        int N = Integer.parseInt(br.readLine());
         
        int[] arr = new int[N];
         
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(br.readLine().trim());
        }
         
        Queue<Integer> right = new PriorityQueue<Integer>();
        Queue<Integer> left = new PriorityQueue<Integer>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
        int middle = arr[0];
        System.out.println(middle);
         
        for(int i = 1; i < N-1; i++){
            //홀수
            if((i+1) % 2 == 1){
                System.out.println(middle);
            }else{
                if(arr[i] > middle){
                    right.add(arr[i]);
                    if(arr[i+1] > middle){
                        right.add(arr[i+1]);
                        left.add(middle);
                        middle = right.poll();
                    }else{
                        left.add(arr[i+1]);
                    }
                }else{
                    left.add(arr[i]);
                    if(arr[i+1]>middle){
                        right.add(arr[i+1]);
                    }else{
                        left.add(arr[i+1]);
                        right.add(middle);
                        middle = left.poll();
                    }
                }
            }
        }
        System.out.println(middle);
    }
}
