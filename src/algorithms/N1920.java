package algorithms;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N1920 {
	static int[] arr;
	
	static int find(int idx, int N){
		int s = 0;
		int e = N-1;
		int m = (e + s) / 2;
		while(e >= s){
			if(arr[m] < idx){
				s = m + 1;
				m = ( e + s ) / 2;
			}else if(arr[m] > idx){
				e = m - 1;
				m = ( e + s ) / 2;
			}else{
				return 1;
			}
		}
		
		return 0;
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < N; i++){
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < M; i++){
			int t = Integer.parseInt(st.nextToken());
			System.out.println(find(t, N));
		}
	}
}
