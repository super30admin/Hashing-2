'''
Time: O(N)
Space: O(N)
'''
class Solution:
    def longestPalindrome(self, s: str) -> int:
        '''
        we need count of each char 
        every char can be inserted into a map and its value is freq
        a = 1 b = 1 c = 4 , d = 2 
        if the frequency is even then they all will be part of the palindrome string 
        if frequency is odd, then only one of those odds can be used as the center char 
        '''
        if len(s) == 1:
            return 1
        frequency_map = dict()
        one_count = False
        odd_occurence = False
        max_palindrome_length = 0
        for i in s:
            if i not in frequency_map:
                frequency_map[i] = 1
            else:
                frequency_map[i] += 1
        if len(frequency_map) == 1:
            return list(frequency_map.values())[0]
        for key in frequency_map:
            if frequency_map[key] % 2 == 0:
                max_palindrome_length += frequency_map[key]
            else:
                if not odd_occurence:
                    max_palindrome_length += frequency_map[key]
                    odd_occurence = True
                else:
                    max_palindrome_length += frequency_map[key] - 1
        return max_palindrome_length
