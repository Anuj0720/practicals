public class DAA4knapDP {
    static int knapsack(int W, int wt[], int val[], int n) {
        int dp[][] = new int[n + 1][W + 1];
        for (int i = 1; i <= n; i++) {
            for (int w = 1; w <= W; w++) {
                if (wt[i - 1] <= w)
                    dp[i][w] = Math.max(val[i - 1] + dp[i - 1][w - wt[i - 1]], dp[i - 1][w]);
                else
                    dp[i][w] = dp[i - 1][w];
            }
        }
        return dp[n][W];
    }

    public static void main(String[] args) {
        int val[] = {60, 100, 120};
        int wt[] = {10, 20, 30};
        int W = 50;
        int n = val.length;

        long start = System.nanoTime(); 
        int result = knapsack(W, wt, val, n);
        long end = System.nanoTime();   

        System.out.println("Maximum value = " + result);
        System.out.println("Execution Time: " + (end - start) / 1e6 + " ms");
        System.out.println("Time Complexity: O(n*W)");
        System.out.println("Space Complexity: O(n*W)");
    }
}
