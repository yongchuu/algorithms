package algorithms;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SDS_PRO_6_8 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String A = br.readLine();
		String B = br.readLine();
		String C = br.readLine();
		
		int[][] arr = new int[A.length()+1][3];
		
		for(int i = 0; i < A.length(); i++){
			if(A.charAt(i) == B.charAt(i) && B.charAt(i) == C.charAt(i)){
				continue;
			}
			
			if(A.charAt(i) == B.charAt(i)){
				arr[i][2]++;
				arr[A.length()][2]++;
			}else if(A.charAt(i) == C.charAt(i)){
				arr[i][1]++;
				arr[A.length()][1]++;
			}else if(B.charAt(i) == C.charAt(i)){
				arr[i][0]++;
				arr[A.length()][0]++;
			}else{
				arr[i][2]++;
				arr[i][1]++;
				arr[i][0]++;
				arr[A.length()][2]++;
				arr[A.length()][1]++;
				arr[A.length()][0]++;
			}
		}
		int max = Math.max(arr[A.length()][0], arr[A.length()][1]);
		max = Math.max(max, arr[A.length()][2]);
		System.out.println(max);
	}
}
