package algorithms;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
  
public class ROOTED_TREE {
    static int N;
    static int[][] arr;
    static int[][] flag;
    static long ans = 0;
  
    static void func(int y, int x) {
        int min = Math.min(flag[y-1][x], flag[y][x-1]);
        min = Math.min(min, flag[y-1][x-1]);
        flag[y][x] = min + 1;
        ans += flag[y][x]-1;
    }
  
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  
        N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        arr = new int[N + 1][N + 1];
        flag = new int[N + 1][N + 1];
  
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                flag[i][j] = arr[i][j];
            }
        }
  
        for (int i = 2; i <= N; i++) {
            for (int j = 2; j <= N; j++) {
                if (arr[i][j] == 1)
                    func(i, j);
            }
        }
  
        System.out.println(ans);
    }
}
