from collections import defaultdict
class Hashing2(object):
    def subarraySum(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: int
        1,2,3,4,5
        Brute force: Get all the subarrays and check their sum O(n*n) * O(n) = O(n^3)
        Better solution: In brute force, we are doing repeated work. For example, we compute sum of subarray from index 0 to index 4, then index 1 to index 4. 
        However, we do not need to compute index 1 to 4 sum. sum(1,4) = sum(0,4) - sum(0,0). Essentially, we can compute running sum and maintain a hash to store
        counts of running_sum. At every index, we check if the offset (running_sum - k) is present in the hash or not. If it is present then we know there is a 
        subarray with sum equal to k. Since we only iterate once, time complexity is O(n).
        """
        running_sum = 0
        ans = 0
        sum2freq = defaultdict(int, {0: 1}) # to catch the case where the subarray starts from index 0
        for n in nums:
        	running_sum += n
        	offset = running_sum - k
        	if offset in sum2freq:
        		ans += sum2freq[offset]    	
        	sum2freq[running_sum] += 1
        return ans

    def findMaxLength(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        Similar to the above problem, we maintain a hash to store running_sum and the earliest index for that running sum as we want the longest contiguous subarray.
        At every index, we check if the running_sum has occured previously or not. If yes, then we know the subarray between the previous index (of running_sum)
        and the current index is balanced.
        """
        running_sum = 0
        sum2idx = {0: -1}
        ans = 0
        for i, n in enumerate(nums):
            if n == 0:
                running_sum -= 1
            else:
                running_sum += 1
            if running_sum in sum2idx:
                ans = max(ans, i - sum2idx[running_sum])
            else:
                sum2idx[running_sum] = i
        return ans

    def longestPalindrome(self, s):
        """
        :type s: str
        :rtype: int
        Check for pair of chars by storing chars in a set. If we get a pair of char, remove the char from the set and increase the ans by 2 as it is a pair.
        If the char is not in the set, add it to the set but dont increment the ans as we only check for pair. In the end, if the set is not empty, it means we can take
        one char from the set and put it in the middle of the even length palindrom we have created from the char pairs.
        """
        char_set = set()
        ans = 0
        for c in s:
            if c in char_set:
                ans += 2
                char_set.remove(c)
            else:
                char_set.add(c)
        if char_set:
            ans += 1
        return ans
        