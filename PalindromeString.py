#All test cases in leetcode passed

class Solution:
    def longestPalindrome(self, s: str) -> int:

        # Here we keep track of count of characters of string using set. 
        # If current char is already present in set then we remove it from set and we 
        # increment res by 2. If char is not present in set then we add it to the set. 
        # After the end of for loop, then we see if set contains any chars. 
        # If yes then we increament res by 1 else we return res. 
        # This is because a palindrome can have 1 uneven char at the middle of the palindromic string.
        # Time complexity - O(n) - traversing length of string
        # Space complexity - O(1) because at the max 52 is the size of set i.e. A-Z and a-z.
        charSet = set()
        res = 0

        for ch in s:
            if ch in charSet:
                charSet.remove(ch)
                res = res + 2
            else:
                charSet.add(ch)

        if charSet:
            res+=1
            
        return res 


        #---------------OR----------------------------------------


        # Here we keep track of count of characters of string using dictionary. 
        # If count becomes 2 then we add it to res. After the end of for loop, 
        # then we see if dictionary contains any keys. If yes then we increament 
        # res by 1 else we return res. This is because a palindrome can have 1 
        # uneven char at the middle of the palindromic string.
        # Time complexity - O(n) - traversing length of string
        # Space complexity - O(1) because at the max 52 is the size of dictionary i.e. A-Z and a-z.
        dict = collections.defaultdict(int)
        res = 0
        for ch in s:
            dict[ch]+=1
            if dict[ch]==2:
                res += 2
                dict.pop(ch)
            
        if dict:
            res += 1
        return res



       