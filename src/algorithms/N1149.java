package algorithms;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N1149 {
	static class el{
		int red, green, blue;
		el(){}
		el(int red, int green, int blue){
			this.red = red;
			this.green = green;
			this.blue = blue;
		}
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		el arr[] = new el[N+1];
		el d[] = new el[N+1];
		
		for(int i = 1; i <= N; i++){
			st = new StringTokenizer(br.readLine());
			int red = Integer.parseInt(st.nextToken());
			int green = Integer.parseInt(st.nextToken());
			int blue = Integer.parseInt(st.nextToken());
			
			arr[i] = new el(red, green, blue);
			d[i] = new el();
		}
		
		d[1] = new el(arr[1].red, arr[1].green, arr[1].blue);
		
		for(int i = 2; i <= N; i++){
			d[i].red = Math.min(d[i-1].blue, d[i-1].green) + arr[i].red; 
			d[i].green = Math.min(d[i-1].blue, d[i-1].red) + arr[i].green; 
			d[i].blue = Math.min(d[i-1].red, d[i-1].green) + arr[i].blue; 
		}
		int min = Integer.MAX_VALUE;
		min = min < d[N].red ? min : d[N].red;
		min = min < d[N].green ? min : d[N].green;
		min = min < d[N].blue ? min : d[N].blue;
		System.out.println(min);
	}
}
