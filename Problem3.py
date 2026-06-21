'''
If there are 2 occurances of a char, we can make a palindrome using them.
So after every 2 occurances of any character we add 2 to the maxLength of palindrome.

Now a palindrome can have odd length if there is only one element in the middle which occurs only once in
the palindrome string.

So if there are any other characters which only occur once or for odd times we add 1 to the final result
as we can only use one of those remaining characters.

Time Complexity: O(n)
Space Complexity: O(n)
'''
class Solution:
    def longestPalindrome(self, s: str) -> int:
        charSet = set()
        result = 0

        for i in s:
            if i in charSet:
                result += 2
                charSet.remove(i)

            else:
                charSet.add(i)

        if len(charSet) != 0:
            result += 1

        return result