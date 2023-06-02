#Time Complexity: 0(n)
#Space Complexity:O(n)
#Did it run on leetcode: Yes

class Solution:
    def longestPalindrome(self, s: str) -> int:
        #Creating a hashmap to insert and keep track the values
        hash_map = dict()
        count = 0
        length = len(s)
        #Iterating through the strings t
        for i in range(length):
            c = s[i]
            #If function to find if the element exist or else insert into the array, if the element already exist then pop the element by increasing the count by 2
            if (hash_map.get(c) == c):
                hash_map.pop(c)
                count += 2
            else:
                hash_map[c] = c
        if(len(hash_map)!=0):
            #If the hashmap is not empty even after the element has been iterated through then return the count+1
            return count+1
        return count
