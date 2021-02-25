'''
Time Complexity: O(n) becoz we are ooping through n elements
Space Complexity: O(n) becoz we are storing in hashmap
Leetcode: Success!
Problems: I little with the concept but got the hang of it. Made a silly mistake tho.

'''

class Solution:
    def findMaxLength(self, nums) -> int:
        hashMap = {}
        hashMap[0] = -1
        currSum = 0
        Max = 0
        lnum = len(nums)
        for i in range(lnum):
            if nums[i]==0:
                currSum +=1
            else:
                currSum -=1
            print("currSum: ",currSum)
            if currSum in hashMap:
                print("yes")
                Max = max(Max,(i - hashMap[currSum]))
            else:
                hashMap[currSum]= i
        print(hashMap)
        return Max


nums = [1,0,1,0,1,1,1,1,0,0,1,0,1]
#nums = [0,1]
#nums = [0,1,0]
nums = [0,0,1,0,0,0,1,1]
nums = [0,1,0]
s = Solution()
ls = s.findMaxLength(nums)
print("Length of the longest sub array: ",ls)
