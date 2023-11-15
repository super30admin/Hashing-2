class Solution:
    def longestPalindrome(self, s: str) -> int:
        dic1={}
        flag=0
        count=0
        lis=list(s)

        for i in range(0,len(lis)):
            if lis[i] not in dic1:
                dic1[lis[i]]=1
            else:
                dic1[lis[i]]+=1
        print(dic1)

        for key,value in dic1.items():
            if value%2==0:
                count+=value
            else:
                flag=1
                count+=(value-1)
        
        if flag==0:
            return count
        else:
            return count+1
        