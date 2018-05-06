package algorithms;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N2606 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st ;
		
		int N = Integer.parseInt(br.readLine());
		int E = Integer.parseInt(br.readLine());
		
		int arr[][] = new int[N+1][N+1];
		for(int i = 1; i <= E; i++){
			st = new StringTokenizer(br.readLine());
			int t1 = Integer.parseInt(st.nextToken());
			int t2 = Integer.parseInt(st.nextToken());
			arr[t1][t2] = 1;
			arr[t2][t1] = 1;
		}
		
		for(int k = 1; k <= N; k++){
			for(int i = 1; i <= N; i++){
				for(int j = 1; j <= N; j++){
					if(arr[i][k] == 1 && arr[k][j] == 1){
						arr[i][j] = 1;
					}
				}
			}
		}
		int ans = 0;
		for(int i = 2; i <= N; i++){
			if(arr[1][i] == 1) ans++;
		}
		System.out.println(ans);
	}
}
