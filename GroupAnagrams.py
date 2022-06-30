from pip import List


class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        hashmap = dict()
        list1 = []
        a = []
        if len(strs) is None or strs == "":
            return [[""]]
        elif len(strs) ==1 :
            return [strs]
        for i in range(len(strs)):
            s1 = self.getascii(strs[i])
            if(hashmap.get(s1) is None):
                hashmap[s1] = []                
            hashmap[s1].append(strs[i])
        for val in hashmap.values():
            list1.append(val)
        return list1
    
    def getascii(self, string: str):
        dict1 = [2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101]
        count = 1
        for val in string:
            diff = ord(val)- ord('a')
            count = count * dict1[diff]
        return count
            
                
                