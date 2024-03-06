#Longest palindrome
# Time and space complexity is O(N)
class LongestPalindrome:
    def FindLongestPalidrome(self, strs):
        
        dic = {}   
        for c in s:
            if c not in dic:
                dic[c] = 1
            else:
                dic[c]+=1       
        odd = 0
        ans = 0
        for i in dic.values():
            if i > 1:
                if i % 2 == 0:
                    ans+= i
                else:
                    ans+= i-1
                    odd+= 1
            elif i==1:
                odd+=1
        if odd > 0:
            ans+=1
        return ans