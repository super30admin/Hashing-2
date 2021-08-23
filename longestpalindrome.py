# Time Complexity : O(N) 
# Space Complexity : O(K) for the primes array and the hashmap
# Did this code successfully run on Leetcode : Partially, 47/95 test cases
# Any problem you faced while coding this : I didn't get the logic exactly to solve this problem


class Solution:
    def longestPalindrome(self, s: str) -> int:
        # if len(s) == 1:
        #     return len(s[0])
        mydict = {}
        flag = 0
        count  = 0
        
        for i in range(len(s)):
            if s[i] not in mydict:
                mydict[s[i]] = 1
            else:
                mydict[s[i]] += 1
        vals = list(mydict.values())
        for i in range(len(vals)):
            if vals[i] % 2 == 1 and flag == 0:
                flag = 1
            elif vals[i] % 2 == 1 and flag == 1:
                vals[i] = 0
            
        return sum(vals)

s = "ccc"
obj = Solution()
print(obj.longestPalindrome(s))