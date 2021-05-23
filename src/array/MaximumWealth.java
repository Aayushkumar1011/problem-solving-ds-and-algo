public class MaximumWealth {
    public int maximumWealth(int[][] accounts) {
        int[] result = new int[accounts.length];
        for (int i = 0; i < accounts.length; i++) {
            int sum = 0;
            for (int j = 0; j < accounts[i].length; j++) {
                sum += accounts[i][j];
            }
            result[i] = sum;
        }
        return getMax(result);
    }

    public int getMax(int[] result) {
        int max = result[0];
        for (int i = 1; i < result.length; i++) {
            if (max < result[i]) {
                max = result[i];
            }
        }
        return max;
    }
}
