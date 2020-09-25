"""
Given a binary array, find the maximum length of a contiguous subarray with equal number of 0 and 1.

Example 1:
Input: [0,1]
Output: 2
Explanation: [0, 1] is the longest contiguous subarray with equal number of 0 and 1.
Example 2:
Input: [0,1,0]
Output: 2
Explanation: [0, 1] (or [1, 0]) is a longest contiguous subarray with equal number of 0 and 1.
"""
class Solution:
def findMaxLength(self, nums: List[int]) -> int:
"""
if number is 1 increment 1, if not decrement by 1.
if we found the number again update the length.
If not put it in hashmap of count to index.
for solving the cases starting with 0 we need to include a [0:-1] in hashmap to get correct value.
"""
    # Runtime Complexity : O(N)
    # Space Complexity : O(N)
    count = 0
    max_length = 0
    hashmap = dict()
    hashmap[0] = -1
    for i in range(len(nums)):
        if nums[i] == 1:
            count += 1
        else:
            count -= 1
        if count not in hashmap:
            hashmap[count] = i
        else:
            max_length = max(max_length, i - hashmap[count])
    return max_length
