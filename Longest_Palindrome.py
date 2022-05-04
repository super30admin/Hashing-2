def longestPalindrome(s):
    d={}
    length=0
    oddflag=False

    for i in s:
        d[i]=d.get(i,0)+1

    for i in d:
        #count all the even occurances to make palindrome
        if d[i]%2==0:
            length+=d[i]
        else:
            oddflag=True
            length+=d[i]-1
        
    if oddflag: length+=1

        
    return length
    


print(longestPalindrome("aaaabbcccddeeee"))