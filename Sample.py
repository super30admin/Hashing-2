
# Hashing-2

Explain your approach in **three sentences only** at top of your code


## Problem1 (https://leetcode.com/problems/subarray-sum-equals-k/)
// Time Complexity :o(n)
// Space Complexity : o(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :no
// Your code here along with comments explaining your approach
# Approaching using Hashmap
#For each element nums in the input array:
# hashmap map which is used to store the cumulative sum up to all the indices possible along with the number of times the same sum occurs
# Update the cumulative sum_value by adding the current element.
# if same number occurs again we can increment the count corresponding to the sum in the hashmap
# Check if (sum_val - k) exists in the dictionary.
# If yes, add the count of (sum_val - k) to the result count.
# the count will provide the result

class Solution:
    def subarraySum(self, nums: List[int], k: int) -> int:
        count = 0
        sum_val = 0
        map = defaultdict(int)
        map[0] = 1

        for num in nums:
            sum_val += num
            count += map[sum_val - k]
            map[sum_val] += 1

        return count


## Problem2 (https://leetcode.com/problems/contiguous-array/)
// Time Complexity : o(n)
// Space Complexity : o(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
// Your code here along with comments explaining your approach
# Initialize a hash map to store prefix sums along with their indices.
# Initialize variables for sum, maximum subarray length, and iterate through the input array.
# For each element in the array, update the sum according to the element (decrement by 1 for 0, increment by 1 for 1).
# If the sum becomes zero at any index, update the maximum length to the current index plus one.
# If the sum is encountered again (which means there is a subarray with equal 0s and 1s between the previous occurrence and the current index), update the maximum length if the current subarray length is greater than the previously stored maximum length.
# Return the maximum subarray length.

class Solution:
    def findMaxLength(self, nums: List[int]) -> int:
        mp = {}
        sum_val = 0
        max_len = 0
        for i, num in enumerate(nums):
            sum_val += 1 if num == 1 else -1
            if sum_val == 0:
                max_len = i + 1
            elif sum_val in mp:
                max_len = max(max_len, i - mp[sum_val])
            else:
                mp[sum_val] = i
        return max_len


## Problem3 (https://leetcode.com/problems/longest-palindrome)
// Time Complexity : o(n)
// Space Complexity : o(m)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
// Your code here along with comments explaining your approach
# Initialize two variables, 
# oddCount to store the number of characters with an odd count of occurrences and an unordered map ump to store the count of each character in the string.
# Iterate through the string and for each character ch, increment the count of that character in the unordered map.
# If the count of the current character ch is odd, increment oddCount. If the count is even, decrement oddCount.
# If oddCount is greater than 1, return s.length() - oddCount + 1, which is the maximum length of a palindrome that can be formed by using all but one character with an odd count of occurrences.
# If oddCount is not greater than 1, return s.length(), which is the length of the original string, as all characters can be used to form a palindrome.

class Solution:
    def longestPalindrome(self, s: str) -> int:
        odd_count = 0
        d = {}
        for ch in s:
            if ch in d:
                d[ch] += 1
            else:
                d[ch] = 1
            if d[ch] % 2 == 1:
                odd_count += 1
            else:
                odd_count -= 1
        if odd_count > 1:
            return len(s) - odd_count + 1
        return len(s)