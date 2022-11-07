#time complexity: O(n)
#space complexity: O(n)
#ran on leetcode: Yes
#All character that occur even number of times will be part of palindrome. Among all 
#elements that occur odd elements, one of those will count towards the palindrome.
#set is used to find out the if an elemnt occurs even number of times
#after scanning through input string if the set is not empty, then this proves that 
#atleast one element occurs odd number of times
class Solution:
    def longestPalindrome(self, s: str) -> int:
        char_count=set()
        count=0
        for i in s:
            if(i in char_count):
                count+=2
                char_count.remove(i)
            else:
                char_count.add(i)
        if(len(char_count)!=0):
            count+=1
        return count
s=Solution()
st="abccccdd"
print(s.longestPalindrome(st))
