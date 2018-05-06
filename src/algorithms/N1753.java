package algorithms;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class N1753 {
	static final int INF = Integer.MAX_VALUE;
	static class el {
		int v, w;
		el(){}
		el(int v, int w){
			this.v = v;
			this.w = w;
		}
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		
		int K = Integer.parseInt(br.readLine());
		
		int d[] = new int[V+1];
		for(int i = 0; i <= V; i++){
			d[i] = INF;
		}
		d[K] = 0;
		
		ArrayList<ArrayList<el>> arr = new ArrayList<ArrayList<el>>();
		Queue<el> q  = new PriorityQueue<el>(new Comparator<el>() {
			@Override
			public int compare(el o1, el o2) {
				return o1.w - o2.w;
			}
		});
		
		for(int i = 0; i <= E; i++){
			arr.add(new ArrayList<el>());
		}
		for(int i = 1; i <= E; i++){
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			arr.get(u).add(new el(v, w));
		}
		
		for(int i = 0; i < arr.get(K).size(); i++){
			int v = arr.get(K).get(i).v;
			int w = arr.get(K).get(i).w;
			if(d[v] > w){
				d[v] = w;
				q.add(new el(v, w));
			}
		}
		
		while(!q.isEmpty()){
			el tmp = q.poll();
			int v = tmp.v;
			int w = tmp.w;
			
			for(int i = 0; i < arr.get(v).size(); i++){
				int tv = arr.get(v).get(i).v;
				int tw = arr.get(v).get(i).w;
				if(d[tv] > tw + w){
					d[tv] = tw + w;
					q.add(new el(tv, tw+w));
				}
			}
		}
		
		for(int i = 1; i <= V; i++){
			int t = d[i];
			System.out.println(t == INF ? "INF" : t);
		}
	}
}
