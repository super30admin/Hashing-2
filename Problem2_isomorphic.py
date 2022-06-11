isomorphic

'''
Time Complexity : O(1)
Space Complexity : O(1)
'''

class Solution:
    def isIsomorphic(self, s: str, t: str) -> bool:
        smap = dict()
        tmap = dict()
        for i in range(len(s)):
            schar = s[i]
            tchar = t[i]
            if (schar in smap):
                if smap[schar] != tchar:
                    return False
            else:
                smap[schar] = tchar
            if (tchar in tmap):
                if tmap[tchar] != schar:
                    return False
            else:
                tmap[tchar] = schar
        return True
