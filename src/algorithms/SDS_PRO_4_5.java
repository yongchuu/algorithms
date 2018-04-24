package algorithms;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SDS_PRO_4_5 {
	static int N, X;
	
	static class el {
		int b, t;
		el(int b, int t){
			this.b = b;
			this.t = t;
		}
	}
	
	static int dijkstra(int idx, ArrayList<ArrayList<el>> list){
		Queue<el> q = new ArrayDeque<el>();
		
		q.add(new el(idx, 0));
		int flag[] = new int[N+1];
		
		for(int i = 0; i <= N; i++){
			flag[i] = Integer.MAX_VALUE;
		}
		flag[idx] = 0;
		
		while(!q.isEmpty()){
			el tmp = q.poll();
			int b = tmp.b;
			int t = tmp.t;
			
			for(int i = 0; i < list.get(b).size(); i++){
				if(flag[list.get(b).get(i).b] > flag[b] + list.get(b).get(i).t){
					flag[list.get(b).get(i).b] = flag[b] + list.get(b).get(i).t;
					q.add(new el(list.get(b).get(i).b, flag[b] + list.get(b).get(i).t));
				}
			}
		}
		
		return flag[X];
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		
		ArrayList<ArrayList<el>> node = new ArrayList<ArrayList<el>>();
		ArrayList<ArrayList<el>> reverse = new ArrayList<ArrayList<el>>();
		
		for(int i = 0; i <= N; i++){
			node.add(new ArrayList<el>());
			reverse.add(new ArrayList<el>());
		}
		
		for(int i = 0; i < M; i++){
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken()); 
			int b = Integer.parseInt(st.nextToken()); 
			int t = Integer.parseInt(st.nextToken());
			
			node.get(a).add(new el(b, t));
			reverse.get(b).add(new el(a, t));
		}
		
		int max = 0;
		for(int i = 1; i <= N; i++){
			int tn = dijkstra(i, node);
			int tr = dijkstra(i, reverse);
			if(max < tn + tr)
				max = tn + tr;
		}
		
		System.out.println(max);
	}
}
