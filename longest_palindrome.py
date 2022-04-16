class Solution(object):
    def longestPalindrome(self, s):
        """
        :type s: str
        :rtype: int
        """
        dictMap = {}

        for i in s:
            dictMap[i] = dictMap.get(i, 0) + 1

        length = 0
        singlelement = False
        for i in dictMap:
            if dictMap[i] % 2 == 0:
                length = length + dictMap[i]

            if dictMap[i] % 2 == 1:
                if not singlelement:
                    length = length + dictMap[i]
                    singlelement = True
                else:
                    length = length + dictMap[i] - 1

        return length
