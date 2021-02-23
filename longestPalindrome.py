class Solution:
    def longestPalindrome(self, s: str) -> int:
        length = 0
        check = []
        for i in s:
            if i not in check:
                check.append(i)
                print("Appended: ",check)
            else:
                check.remove(i)
                print("Removed: ",check)
                length+=2
        if len(check)!=0:
            length+=1
        return length


sol = Solution()
s = "abcccdd"
'''
s = "a"
s = "bb"
'''
l = sol.longestPalindrome(s)
print("Longest Palindrome: ",l)

