"""
Given a sorted array nums, remove the duplicates in-place such that each element appears only once 
and returns the new length. Do not allocate extra space for another array, you must do this by 
modifying the input array in-place with O(1) extra memory.

Clarification:
Confused why the returned value is an integer but your answer is an array?
Note that the input array is passed in by reference, 
which means a modification to the input array will be known to the caller as well.

Internally you can think of this:
// nums is passed in by reference. (i.e., without making a copy)
int len = removeDuplicates(nums);

// any modification to nums in your function would be known by the caller.
// using the length returned by your function, it prints the first len elements.
for (int i = 0; i < len; i++) {
    print(nums[i]);
}

Example 1:

Input: nums = [1,1,2]
Output: 2, nums = [1,2]
Explanation: Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively. 
It doesn't matter what you leave beyond the returned length.
"""
class Solution:
    def removeDuplicates(self, nums):
        """
        [0,0,1,1,1,2,2,3,3,4]
        # [0,0,1,1,1,2,2,3,3,4]
        # [0,1,2,3,4,2,2,3,3,4]
        # List is sorted. 
        # Two pointer approach : 1: current element, 2: unique element
        # once an element is encountered, bypass its duplicates till unique element
        """

class Solution:
    def removeDuplicates(self, nums):
        # [0,0,1,1,1,2,2,3,3,4]
        #  u                
        # [0,1,2,3,4,2,2,3,3,4]
        #  c
        # Hint :
        # List is sorted. 
        # Two pointer approach : 1: current element, 2: unique element
        # once an element is encountered, bypass its duplicates till unique element
        
        cur_ind=0
        for unique_elem in range(cur_ind,len(nums)):
            if nums[cur_ind] == nums[unique_elem]:
                pass
            else:
                nums[cur_ind+1] = nums[unique_elem]
                cur_ind += 1
        return len(nums[:cur_ind+1])
