public class RotoateElement {
    public void rotate(int[] nums, int k) {
        k %= nums.length;
        int previous, temp;
        for (int i = 0; i < k; i++) {
            previous = nums[nums.length - 1];
            for (int j = 0; j < nums.length; j++) {
                temp = nums[j];
                nums[j] = previous;
                previous = temp;
            }
        }
    }
}
