package algorithms;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N2042 {
	static int N, M, K;
	static long tree[];
	static int fIdx;
	static void insert(int b, int c){
		long now = tree[fIdx+b-1];
		tree[fIdx+b-1] = c;
		for(int i = (fIdx + b - 1)/2; i > 0; i /= 2){
			tree[i] = tree[i] - now + c;
		}
	}
	static long sum(int b, int c){
		long ans = 0;
		b += fIdx - 1;
		c += fIdx - 1;
		
		while(b <= c){
			if(b % 2 == 1) ans += tree[b++];
			if(c % 2 == 0) ans += tree[c--];
			b /= 2;
			c /= 2;
		}
		
		return ans;
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		fIdx = 1;
		while(N > fIdx){ fIdx *= 2; }
		tree = new long[fIdx*2];
		
		for(int i = 0; i < N; i++){
			tree[fIdx+i] = Long.parseLong(br.readLine());
		}
		
		for(int j = 0; j < N; j++)
		for(int i = fIdx + j; i > 1; i /= 2){
			tree[i/2] += tree[fIdx+j];
		}
		
		for(int i = 0; i < M + K; i++){
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			if(a == 1){
				insert(b, c);
			}else{
				System.out.println(sum(b, c));
			}
		}
	}
}
