def longestPalindrome(self, s: str) -> int: #TC: O(n) SC:O(1)

        chars=set()
        count=0

        for c in s:
            if c in chars:
                count+=2
                chars.remove(c)
            else:
                chars.add(c)

        if len(chars)>0:
            return count+1
        return count