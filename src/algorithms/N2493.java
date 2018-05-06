package algorithms;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N2493 {
	static int N;
	static int[] union;
	static int[] arr;
	
	static int find(int idx){
		while(arr[idx] > arr[union[idx]]){
			union[idx] = find(union[idx]);
		}
		return union[idx];
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		union = new int[N+2];
		arr = new int[N+2];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= N; i++){
			arr[i] = Integer.parseInt(st.nextToken());
			union[i] = i-1;
		}
		arr[0] = Integer.MAX_VALUE;
		
		
		for(int i = 1; i <= N; i++){
			System.out.println(find(i));
		}
	}
}
