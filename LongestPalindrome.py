class Solution(object):
    def longestPalindrome(self, s):
        """
        :type s: str
        :rtype: int
        """
        if not s:
            return 0
        
        """
          Plan : 
          If you look at the problem, all we want to know is basically
          the total number of pairs (palindrome length increases by 2 to each pair).
          To do that, we can simply have a set, and for each character
          1) if the character is not in the set, then we add it to the set
             assuming this is the first time we are seeing this character.
          2) if the character is there in the set, we now know that we have found a pair.
             increase the totalLength and remove the character from set as it has been used.
          In the end, if the set has one or more characters, we increase the count by 1 as
          one of the characters can be used for odd length palindromes.
        """
        vis = set()
        totalLength = 0
        for c in s:
            if c not in vis:
                vis.add(c)
            else:
                # great, we found a pair.
                totalLength += 2
                # need to remove so that c is not reused.
                vis.remove(c)
        # see if we can make an odd length palindrome
        if len(vis) != 0:
            totalLength += 1
        return totalLength

#TC : O(n)
#SC : O(n)