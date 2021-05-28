public class RemoveDuplicate {
    public int removeDuplicates(int[] nums) {
        var result = 0;
        var startIndex = 0;
        for (int currentIndex = startIndex + 1; currentIndex < nums.length; currentIndex++) {
            if (nums[startIndex] == nums[currentIndex]) {
                ;
            } else {
                nums[++startIndex] = nums[currentIndex];

            }
        }
        return startIndex + 1;
    }
}
// Dry run example
// s c
// [0,1,2,3,2,2,3,3,4]