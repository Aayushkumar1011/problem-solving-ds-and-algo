import java.util.Arrays;
import java.util.Collection;
import java.util.List;

class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> result = new ArrayList<Boolean>();
        // int maxCandy = Collection.max(Arrays.asList(candies));
        int maxCandy = getMax(candies);
        for (int candy : candies) {
            int newMaxCandy = candy + extraCandies;
            if (newMaxCandy >= maxCandy)
                result.add(true);
            else
                result.add(false);
        }
        return result;
    }

    public int getMax(int[] candies) {
        int max = candies[0];
        for (int i = 1; i < candies.length; i++) {
            if (max < candies[i]) {
                max = candies[i];
            }
        }
        return max;
    }
}