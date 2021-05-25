public class SmallerCurrent {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        var size = nums.length;
        int[] result = new int[size];
        var elementCount = 0;
        for (var i = 0; i < size; i++) {
            elementCount = 0;
            for (var j = 0; j < size; j++) {
                if (j != i && nums[j] < nums[i]) {
                    elementCount++;
                }
            }
            result[i] = elementCount;
        }
        return result;
    }
}


// class Solution {
//     public int[] smallerNumbersThanCurrent(int[] nums) {
//         int[] count = new int[101];
//         int[] res = new int[nums.length];
        
//         for (int i =0; i < nums.length; i++) {
//             count[nums[i]]++;
//         }
        
//         for (int i = 1 ; i <= 100; i++) {
//             count[i] += count[i-1];    
//         }
        
//         for (int i = 0; i < nums.length; i++) {
//             if (nums[i] == 0)
//                 res[i] = 0;
//             else 
//                 res[i] = count[nums[i] - 1];
//         }
        
//         return res;        
//     }
// }

/**
 * find count of element such that for All j!=i and num[j] < num[i] arr.lentgth
 * in [2, 500], num[i] in [0, 100]
 * 
 * 1. Consrtuct a new array to store the result
 * 
 * 2. Take first element and check for all element smaller than this and
 * increase the the smallerElement++ and push the smallerElement in the result
 * array.
 * 
 * 3. Repeat step 2 until all the element in the array are exhausted
 * 
 * nums = [2, 4, ,4, 3,6, 8, ,8, 2, 4, 10000]
count[0] =0
count[1] =0
count[2] = 2, 
count[3] = 1
count[4] = 3
count[6] = 1
count[8] = 2
count[9] = 0
-----
count[1] = count[1] + count[0] = 0+0 = 0
count[2] = count[2] + count[1] = 2 + 0 = 2
count[3] = count[3] + count[2] = 1 + 2 = 3
count[4] = count[3] + count[2] = 1 + 3 = 4


 */