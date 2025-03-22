// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

// Find frequency of each character in the string.
// Iterate through values in the frequency map. If freq is even, then add freq to result (as even count of characters satisfy palindrome property). Else, add freq - 1 to result (since the value is odd, set flag to True, indicating that we have encountered an odd occurence of a character)
// If flag is set to true, then we can use 1 more character in the final result. Hence, add 1 to the result. Return result (count)

from collections import Counter
class Solution:
    def longestPalindrome(self, s: str) -> int:
        counter = Counter(s)
        print(counter)

        # Counter({'c': 4, 'd': 2, 'a': 1, 'b': 1})

        flag = False
        count = 0
        for freq in counter.values():
            if freq % 2 == 0:
                count += freq
            else:
                count += freq - 1
                flag = True # we had odd occurence
        
        if flag:
            count += 1
        return count
