#Time complexity: O(n)
#Space complexity: O(n)

#Accepted on leetcode

#Approach: Maintain a hashset to find the 'twin' of a given letter
#If letter does not exists in hashSet, no twin has been found so enter it into the hashSet
#If letter exists in hashSet, we have found it's twin, so remove twin from hashSet and increase count by 2
#At the end, check if any element exists in hashSet, if yes, these are the 'non-twin' elements
#If at least 1 non-twin element exists, we can increase count by 1 (this 'loner' element can act as the pivot of the palindrome)
#Return final count


class Solution:
    def longestPalindrome(self, s: str) -> int:
        hashSet = set()
        longestPalindromeCount = 0
        for letter in s:
            if letter in hashSet:
                longestPalindromeCount += 2
                hashSet.remove(letter)
            else:
                hashSet.add(letter)

        return longestPalindromeCount if len(hashSet) == 0 else longestPalindromeCount + 1
        
