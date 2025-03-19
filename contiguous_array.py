'''
Approach:
1. Maintain a count variable that increments for 1s and decrements for 0s.
2. Use a hashmap to store the first occurrence of each count value and check for repeated counts to determine the maximum subarray length.
3. If the count reappears, update the maximum length; otherwise, store the index of its first occurrence.
'''

# Time Complexity: O(n) (Each element is processed once)
# Space Complexity: O(n) (Storing count values in a hashmap)

class Solution:
    def findMaxLength(self, nums: list[int]) -> int:
        count_map = {0: -1}
        max_length = 0
        count = 0
        
        for i, num in enumerate(nums):
            count += 1 if num == 1 else -1

            if count in count_map:
                max_length = max(max_length, i - count_map[count])
            else:
                count_map[count] = i
        
        return max_length
