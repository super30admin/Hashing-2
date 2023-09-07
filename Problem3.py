'''
1. Maintain a dictionary that keeps the frequency of occurances of each character in the string.
2. If we find any character that has occurred even number of times we can definitely form a palindrome from these characters so append to a length variable.  When it is an odd occurring character, we have two cases.
3. If it occurs once, we can have it as the middle element else we can have pairs on either side and one in middle. Handle the odd occurances with a flag to add the middle element in length and count-1 for the pairs. 

TC: O(n)
SC: O(n)
'''

class Solution:
    def longestPalindrome(self, s: str) -> int:
        
        freq = {}
        length = 0
        odd_flag = False
        for c in s:
            if c in freq:
                freq[c] +=1
            else:
                freq[c] = 1
        for _,count in freq.items():
            if count%2 == 0:
                length+=count
            else:
                if count > 1:
                    length+=count-1
                odd_flag = True
        if odd_flag:
            return length+1
        return length