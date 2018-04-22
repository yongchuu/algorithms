package algorithms;

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

    public static void main(String[] args) {
        for (short n = 1; n < 14; n++) {
            enumerate(n);
            
            System.out.println("n = " + (n < 10 ? "0" : "") + n + ", solution count is " + count + ".");
            count = 0;
        }
    }
}
