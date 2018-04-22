package algorithms;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Hashtable;
import java.util.Map;
 
public class SDS_PRO_2_4 {
     
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         
        Map<String, Integer> map = new Hashtable<String, Integer>();
         
        int N = Integer.parseInt(br.readLine());
         
        String maxK = "";
         
        for(int i = 0; i < N; i++){
            String tmp = br.readLine();
            if(i == 0){
                maxK = tmp;
            }
            if(map.containsKey(tmp)){
                int a = map.get(tmp);
                map.put(tmp, a+1);
                 
                int k = map.get(maxK);
                int t = map.get(tmp);
                 
                if(k < t){
                    maxK = tmp;
                }else if(k == t){
                    if(Long.parseLong(maxK) > Long.parseLong(tmp))
                        maxK = tmp;
                }
            }else{
                map.put(tmp, 1);
            }
        }
         
        System.out.println(maxK);
    }
}
