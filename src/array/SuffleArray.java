public class SuffleArray {
    public int[] shuffle(int[] nums, int n) {
        int[] result = new int[2 * n];
        int i = 0;
        int counter = 0;
        while (i < n) {
            result[counter] = nums[i];
            result[counter + 1] = nums[n + i];
            i++;
            counter += 2;
        }
        return result;
    }
}
