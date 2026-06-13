# Problem3 (https://leetcode.com/problems/longest-palindrome)

#Did this code successfully run on Leetcode :Yes
#Any problem you faced while coding this :No
#Your code here along with comments explaining your approach
#TC: O(n)
#Space Complexity : O(1):Set holds max 52 chars,so it is fixed
class Solution:
    def longestPalindrome(self, s: str) -> int:
        charset = set()     #we initilize an empty set where we will be add/removing chars
        count = 0       # we set the count to 0 

        for i in s:     #for each char in the string
            if i in charset:   #if the char i is present in the charset then remove it from set and increase the count by 2
                count +=2
                charset.remove(i)
            else:
                charset.add(i)  #if the element isnt there in the set then just add it
        
        if len(charset) > 0:  #we can form an odd palindrome
            return count +1     #so if there are more then 1 element in the set we can add one to the palindrome
        else:
            return count