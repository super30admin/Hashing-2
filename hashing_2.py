##Longest Palindrome

'''
Concept to Remember:

    If a character appears twice, both occurrences can contribute to a palindrome.
    When encountering a duplicate character, remove it from the set and increase the palindrome length by 2.
    After processing all characters, if any remain in the set, one of them can be placed at the center, increasing the palindrome length by 1.

Example:
    For the string "aabcbaa":

    Pairs: 'a' (3 times, so we use 2), 'b' (2 times), 'c' (1 time).
    Longest palindrome length: 6 (from pairs) + 1 (center 'c') = 7.

'''
class Solution:
    def longestPalindrome(self, s: str) -> int:

        hash_set = set()

        count = 0

        for i in s:
            if i in hash_set:
                hash_set.remove(i)
                count+=2
            else:
                hash_set.add(i)

        if len(hash_set)>0:
            return count+1
        return count



## Contigous sub-array

'''
Concept to Remember:
    When encountering 0, decrement the counter by 1.
    When encountering 1, increment the counter by 1.
    If the running_sum has been seen before, it means there is a contiguous subarray with an equal number of 0s and 1s.
    To determine the length of this subarray, subtract the current index from the previously stored index of the same running_sum.

Edge Case:

    Store hash_map[0] = -1 initially.
    This handles cases where the running_sum becomes 0, meaning the subarray from the start (index 0) to the current index is balanced.
    Example:

    Index:      0  1  2  3
    Array:    [0, 1, 0, 1]
    Running Sum: -1 0 -1 0

    Without handling this edge case, the max subarray length would incorrectly be 2 instead of 4.

Alternative Approach:

    Instead of explicitly storing hash_map[0] = -1, check if running_sum == 0 and update max_length accordingly.

'''
class Solution:
    def findMaxLength(self, nums: List[int]) -> int:

        hash_map = {}
        hash_map[0]=-1
        max_value =0
        running_sum = 0

        for i in range(len(nums)):

            if nums[i]==0:
                running_sum -=1
            else:
                running_sum+=1

            if (running_sum in hash_map):
                max_value = max(max_value, i-hash_map[running_sum])
            else:
                hash_map[running_sum] =i
        return max_value


## Version 2, without prefilling the hash_map.
class Solution:
    def findMaxLength(self, nums: List[int]) -> int:

        hash_map = {}
        # hash_map[0]=-1
        max_value =0
        running_sum = 0

        for i in range(len(nums)):

            if nums[i]==0:
                running_sum -=1
            else:
                running_sum+=1

            if running_sum ==0:
                max_value = max(max_value, i+1)

            if (running_sum in hash_map):
                max_value = max(max_value, i-hash_map[running_sum])
            else:
                hash_map[running_sum] =i
        return max_value



'''
Concept to Remember:

    The problem relies on the idea that if you subtract the target sum (K) from the running sum, and that value has appeared before, then a valid subarray exists.
    To determine the length of such subarrays, store the first occurrence of each running_sum in a hashmap.
    If running_sum - K exists in the hashmap, it means a subarray summing to K is present.

Edge Case:

    Initialize hash_map[0] = 1 (instead of -1 like in previous problems).
    This ensures that if running_sum itself equals K, we count it as a valid subarray.
    Example:

    Array:      [4, 3, 7]
    Target K:   7
    Running Sum: 4 → 7 → 14

        Subarrays summing to 7: [4,3] and [7]
        Without hash_map[0] = 1, we'd miss the subarray [7].

Alternative Approach:

    If not explicitly setting hash_map[0] = 1, handle cases where running_sum == K by checking max_length or count separately.

'''

from collections import defaultdict
class Solution:
    def subarraySum(self, nums: List[int], k: int) -> int:
        hash_map = defaultdict(int)

        hash_map[0]=1

        running_sum =0

        max_sub_arrays = 0

        for i in nums:

            running_sum+=i

            if running_sum-k in hash_map:
                max_sub_arrays+= hash_map[running_sum-k]

            hash_map[running_sum]+=1


        return max_sub_arrays


