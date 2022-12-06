#Time Complexity :  O(n)
#Space Complexity : O(1)
#Did this code successfully run on Leetcode : Yes
#Any problem you faced while coding this : No


#using Hashmap
class Solution:
    def longestPalindrome(self, s: str) -> int:
        hashmap = {}                                
        count = 0
        for i in range(len(s)):                     #creating the frequency of characters
            if s[i] not in hashmap:
                hashmap[s[i]] = 1
            else:
                hashmap[s[i]] += 1
        
        for key in hashmap.copy():                  #we iterate over a copy of hashmap
            if hashmap[key] % 2 == 0:               #if value is even we increment count according to value
                count += hashmap[key]
                del hashmap[key]                    #we delete key containing even value
            else:
                count += (hashmap[key]//2)*2        #if value odd we div by 2 and multiply by 2

        if hashmap:                                 #finally if hashmap still contains values they will be odd values
            count += 1                              #we add 1 to count
            
        return count

#using hashset
class Solution:
    def longestPalindrome(self, s: str) -> int:
        mySet = set()               #using hashset
        count = 0
    
        for i in range(len(s)):
            if s[i] not in mySet:   #if char in s is not in mySet we add it
                mySet.add(s[i])
            else:                   #if char is already in set we remove it and increment count by 2
                mySet.remove(s[i])
                count += 2
        
        if not mySet:               #if set is empty we just return the count
            return count
        else:                       #if set is non-empty we return count + 1  because one more char 
            return count + 1        #can be added to the longest palidrome string from the set