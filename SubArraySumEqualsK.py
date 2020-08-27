#Time Complexity : O(n))
#Space Complexity : O(n) for dictionary
#Did this code successfully run on Leetcode : yes
#Any problem you faced while coding this : This one was tricky, but the lecture video helped me. I still don't fully understand
#how to derive the 0:1 that we put inside the dictionary initially. I get why it's done,  but I don't know if i'd be able to come up with it
class Solution:
    def subarraySum(self, nums: List[int], k: int) -> int:
        result = 0
        cumulativeSum = 0
        helperDict = {0: 1}

        for number in nums:
            #the running sum
            cumulativeSum += number
            #the complement
            complement = cumulativeSum - k
            #if the complement exists, then we simply add the occurence of the complement to our result
            if complement in helperDict:
                result += helperDict[complement]

            #also making sure to add the running sum in the dictionary
            if cumulativeSum in helperDict:
                helperDict[cumulativeSum] += 1
            else:
                helperDict[cumulativeSum] = 1

        return result