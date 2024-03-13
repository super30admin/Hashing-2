"""
Approach: Here, we have nums array and have to find the total number of subarrays that sum upto k. So, for that first, if we can have a running sum which cacluates the 
sum off elements at each index and by the formula of x + y = z, => y = x - z, we can summe x = running sum and z = or k. we can have a hash map that will have running 
sum and their frequencies as values. As we iterate through the array, we will get the running Sum and y, we can check through that if our y happend before we will increase 
our count the times the frequencies of that running sum happened before and if the running sum is not there in the map we will add it up and put our freq/value to 1
and if the running sum is there in the map we will add the frequency by 1.

T.C.: O(n)
S.C.: O(n)

"""

class Solution:
    def subarraySum(self, nums: List[int], k: int) -> int:
        count = 0
        rSum = 0
        hashDic = {}
        hashDic[0] = 1
        for i in range(len(nums)):
            rSum += nums[i]
            y = rSum - k
            if y in hashDic.keys():
                count += hashDic[y]
            if rSum not in hashDic.keys():
                hashDic[rSum] = 1
            else:
                hashDic[rSum] += 1
            
        return count

            
