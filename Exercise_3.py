# Time Complexity: O(n)
# Space Complexity: O(1)
# Were you able to run the code on Leetcode: Yes
# Any problem you faced while coding this: The odd count logic was a bit tricky and neeeded some thought

class Solution:
    def longestPalindrome(self, s: str) -> int:

        if not s:
            return 0

        char_freq = {}
        odd_count=0

        for i in s:
            # count the freq of characters in the string and track the count of chars that have odd freq
            if char_freq.get(i, None) is not None:
                char_freq[i] += 1
            else:
                char_freq[i] = 1

            if char_freq[i]%2==1:
                odd_count +=1
            else:
                odd_count -=1
        # here we count only even freq to form the palindrome, odd freq chars only can be used if they are made even
        # except one odd freq char which can be used by placing it in the center

        if odd_count >1:
            return (len(s) - odd_count) + 1

        # else if no odd chars then simply return len of string as all chars have even freq
        return len(s)



        