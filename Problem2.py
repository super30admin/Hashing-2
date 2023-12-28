
# Time Complexity :  O(n)
# Space Complexity :  O(n) for the hashmap and array storage.
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# Approach: Convert 0s to -1s and find the longest subarray with a sum of 0.
# This is done by maintaining a running sum and a hashmap to track the first occurrence of each sum.

def findMaxLength(self, nums: List[int]) -> int:
    r_sum = 0
    arr = []
    for x in nums:
        if x == 1:
            r_sum = x + r_sum
        else:
            r_sum = r_sum - 1
        arr.append(r_sum)
    print(arr)
    hm = {0: -1}

    maxs = 0

    for i in range(len(arr)):
        if arr[i] in hm:
            maxs = max(maxs, (i-hm[arr[i]]))

        else:
            hm[arr[i]] = i
    return maxs
