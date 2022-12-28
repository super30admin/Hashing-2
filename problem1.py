# 560. Subarray Sum Equals K

# // Time Complexity : O(n)
# // Space Complexity : O(n)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No


# // code here along with comments explaining approach


def subarraySum(self, nums: List[int], k: int) -> int:
    hashmap = {0:1} # storing (rsum - target):freq, starting with 0:1 (to count the k-k sub array)
    result = 0
    rsum =0
    for i in range(len(nums)):
        rsum = rsum + nums[i]
        z = rsum - k # running sum - target
        if z in hashmap: # (check if happen before)
            result = result + hashmap[z] # update result by the freq (to count all sub arrays)
        
        if rsum in hashmap:
            hashmap[rsum] = hashmap[rsum] + 1  # increase the freq if happend before
        else:
            hashmap[rsum] = 1 # put the rsum in hashmap
    return result
