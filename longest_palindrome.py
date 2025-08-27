'''
Maintain HashSet, keep adding element in the set, when we come across a repeated element,
we pair up, increase the count of longest pallindrome by 2 and remove that char from Set.
At the end, if any element is missing in the set, we increase the count of longest pallindrome
by 1 (with that can become the middle element)
Time Complexity: O(N) 
Space Complexity: O(1) : At max, 26 characters (a-z) 
'''
class Solution:
    def longestPalindrome(self, s: str) -> int:
        oddChar = set()
        ans = 0
        for ch in s:
            if ch in oddChar:
                # even pair up
                ans+=2
                oddChar.remove(ch) # O(1) time complexity 
            else:
                oddChar.add(ch) # O(1) time complexity
        if len(oddChar)!=0:
            ans+=1 # odd length, one middle element can be single 
        return ans
        