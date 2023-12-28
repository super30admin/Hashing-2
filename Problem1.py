
# Time Complexity :  O(n) where n is the number of elements in nums.
# Space Complexity :  O(n) for the hashmap storage.
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# Approach: Utilize a hashmap to store cumulative sums. For each element, check if
# (cumulative sum - k) exists in hashmap to find the count of subarrays summing to k.
def subarraySum(self, nums: List[int], k: int) -> int:
    r_sum = 0
    hm = {0: 1}
    count = 0

    for x in nums:
        r_sum = r_sum + x  # running sum until that index

        if r_sum - k in hm:
            count += hm[r_sum - k]
        if r_sum in hm:
            hm[r_sum] += 1
        else:
            hm[r_sum] = 1
    return count
