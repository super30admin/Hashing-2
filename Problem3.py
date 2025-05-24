class Solution(object):
    def longestPalindrome(self, s):
        """
        :type s: str
        :rtype: int
        """
        hash_map = {}

        for i in range(len(s)):

            if s[i] in hash_map:
                hash_map[s[i]] = hash_map[s[i]] + 1
            else:
                hash_map[s[i]] =  1

        varPalindromod = False
        counter = 0
        for k, v in hash_map.items():
            result = 0 if v//2 == 0 else v//2
            if not varPalindromod and v%2 > 0:
                varPalindromod = True
            counter+=result * 2
        
        if varPalindromod:
            return counter + 1
        return counter
            
        