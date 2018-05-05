package algorithms;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class N9095 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int TC = Integer.parseInt(br.readLine());
		
		int arr[] = new int[TC];
		int max = 0;
		
		for(int i = 0; i < TC; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			max = max < arr[i] ? arr[i] : max;
		}
		
		int D[] = new int[max+1];
		
		D[1] = 1;
		D[2] = 2;
		D[3] = 4;
		
		for(int i = 4; i <= max; i++) {
			D[i] = D[i-1] + D[i-2] + D[i-3];
		}
		
		for(int i = 0; i < TC; i++) {
			System.out.println(D[arr[i]]);
		}
	}
}
