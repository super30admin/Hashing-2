'''
Time Complexity : O(1)
Space Complexity : O(n)
'''
class Solution:
    def wordPattern(self, pattern: str, s: str) -> bool:
        pmap = dict()
        slist = list(s.split(' '))
        smap = dict()
        if len(pattern) != len(slist):
            return False
        for i in range(len(pattern)):
            pchar = pattern[i]
            skey = slist[i]
            if (pchar in pmap):
                if pmap[pchar] != skey:
                    return False
            else:
                pmap[pchar] = skey
            if (skey in smap):
                if smap[skey] != pchar:
                    return False
            else:
                smap[skey] = pchar
        return True
