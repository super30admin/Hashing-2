# Time Complexity : O(n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode :

# using hashset
def longestPalindrome(s: str) -> int:
    hashSet = set() #after iteration through s, this set will contain all characters which have an add count
        
    for char in s:
        if char not in hashSet:
            hashSet.add(char)
        else:
            hashSet.remove(char)
    if len(hashSet) > 0:
        return len(s) - len(hashSet) + 1
    return len(s)


# #using hashmap
# def longestPalindrome(s: str) -> int:
#     hashmap = {}
#     for char in s:
#         if char not in hashmap:
#             hashmap[char]=1
        
#         else:
#             hashmap[char]+=1
#     count = 0
#     odd = 0
    
#     for val in hashmap.values():
#         if val%2==0:
#             count+=val
#         else:
#             odd+=1
#             count+=val
    
#     return count if odd<=1 else count-odd+1



s = "abccccdd"

print(longestPalindrome(s))