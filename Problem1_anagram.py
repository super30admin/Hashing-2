anagram

'''
Time Complexity : O(nlogn)
Space Complexity : O(n)

'''

class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        res = []
        ang = dict()
        for s in strs:
            sortedStr = ''.join(sorted(s))
            if sortedStr in ang:
                ang[sortedStr].append(s)
            else:
                ang[sortedStr] = [s]
        for val in ang.values():
            res.append(val)
        return res