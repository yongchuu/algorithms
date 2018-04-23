package algorithms;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class NQUEEN {
    static int count = 0;
    public static boolean isPromising(int[] q, int n) {
        for (int i = 0; i < n; i++) {
            if (q[i] == q[n]) return false;
            if ((q[i] - q[n]) == (n - i)) return false;
            if ((q[n] - q[i]) == (n - i)) return false;
        }
        return true;
    }

    public static void enumerate(int N) {
        int[] a = new int[N];
        enumerate(a, 0);
    }

    public static void enumerate(int[] q, int n) {
        int N = q.length;
        if (n == N) {
            count++;
        } else {
            for (int i = 0; i < N; i++) {
                q[n] = i;
                if (isPromising(q, n)) enumerate(q, n + 1);
            }
        }
    }

    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int n = Integer.parseInt(br.readLine());
        enumerate(n);
            
        System.out.println(count);
    }
}
