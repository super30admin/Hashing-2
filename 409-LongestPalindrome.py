class Solution:
    def longestPalindrome(self, s: str) -> int:
        if len(s) == None:return 0
        temp = []
        print(type(temp))
        count = 0
        for i in range(0,len(s)):
            if s[i] in temp:
                count += 2
                temp.remove(s[i])
                
            else:
                temp.append(s[i])
                
        if temp:
            count+=1
            
        return count
    
    
    # T.C=>O(n)
    # S.C=>O(1)
    # Approach => Here we are taking a list to hold a temporary character. If the list contains that character then just increase count by 2 since those two same character can be used to make a palindrome string. If the list is not empty then just add one more count in the total count. at the end just return the count 
                