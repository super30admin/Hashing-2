# Time: O(n), n is length of string
# space: O(1), for array of fixed size
# did this problem run successfully: yes
# any issues faced: initially stored the frequency of highest odd occurences, which is not needed
# Approach:
# iterate through the string and store the occurences of each letter, both upper and lower case in array of size 52.
# iterate through the counts array, add it to maximum length possible if count is even, if its odd add count-1 to lenght and at last add 1 for center element.

class Solution:
    def longestPalindrome(self, s: str) -> int:
        arr = [0 for _ in range(52)]
        for c in s: #O(n)
            if ord(c)-ord('a') < 0:
                idx = ord(c)-ord('A')
            else:
                idx = ord(c)-ord('a')+26
            arr[idx] += 1

        maxLen, oddFlag = 0, 0
        for count in arr: #O(1)
            if count:
                if count % 2 == 0:
                    maxLen += count
                else:
                    maxLen += (count-1)
                    oddFlag = 1
        return maxLen+1 if oddFlag else maxLen