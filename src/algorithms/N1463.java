package algorithms;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class N1463 {
	static class el{
		int val, cnt;
		el(){}
		el(int val, int cnt){
			this.val = val;
			this.cnt = cnt;
		}
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Queue<el> q = new ArrayDeque<el>(); 
		
		int N = Integer.parseInt(br.readLine());
		
		q.add(new el(1, 0));
		
		int flag[] = new int[N+1];
		
		while(!q.isEmpty()) {
			int val = q.peek().val;
			int cnt = q.poll().cnt;
			
			if(val == N) {
				System.out.println(cnt);
				return;
			}
			
			if(val + 1 == N || val * 2 == N || val * 3 == N) {
				System.out.println(cnt+1);
				return;
			}
			
			if(val + 1 < N && flag[val+1] == 0) {
				flag[val+1] = 1;
				q.add(new el(val + 1, cnt+1));
			}
			if(val * 2 < N && flag[val*2] == 0) {
				flag[val*2] = 1;
				q.add(new el(val * 2, cnt+1));
			}
			if(val * 3 < N && flag[val*3] == 0) {
				flag[val*3] = 1;
				q.add(new el(val * 3, cnt+1));
			}
		}
	}
}
