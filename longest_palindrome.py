"""
time - o(n)
space - o(n)
we add a character to the set and if we see it again we remove it from the set and increase
palindrome length by 2, finally, if there are any characters left in the set, we can add one
to the palindrome length as we can use it as the middle char of the palindrome

"""
class Solution:
    def longestPalindrome(self, s: str) -> int:
        char_set = set()
        count = 0
        for c in s:
            if not c in char_set:
                char_set.add(c)
            else:
                char_set.remove(c)
                count+=2
        if len(char_set)>0:
            count+=1
        return count

        