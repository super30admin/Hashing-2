class Solution(object):
    def longestPalindrome(self, s):
        """
        Time complexity: O(n)
        Space complexity:  O(n)
        """
        # create a set for each operation
        hash_set = set()
        res = 0
        
        # iterate through characters in s
        for c in s:
            # if it's not in the hash set, then add
            if c not in hash_set:
                hash_set.add(c)
            else:
                # otherwise, you will need to remove it
                hash_set.remove(c)
        
        # check the length comparison of hash_set and see if it is bigger than 0
        if len(hash_set) > 0:
            res = len(s) - len(hash_set) + 1
        else:
            res = len(s)
            
        
        return res