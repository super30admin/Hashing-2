# Method 1 - Hashmap
# Time Complexity - O(n), where n is the length of s
# Space Complexity - O(n) 
# First, build a letter frequency hashmap.
# If value is even, add it to the max_len variable, else add value-1 since, 1 occurence won't be included in the palindrome and set a odd flag to True
# If odd flag is true, add 1, since this character can occur in the middle of the palindrome.


# Method 1 - Hashset
# Time Complexity - O(n), where n is the length of s
# Space Complexity - O(n) 
# We use a hashset to keep track off all characters.
# If not in hashset, add it.
# If present, remove it and add 2 to the count.
# In the end, if hashset isn't empty add 1 to count.
class Solution:
    def longestPalindrome(self, s: str) -> int:
        # freq_dict = {}
        # for char in s:
        #     freq_dict[char] = freq_dict.get(char, 0) + 1
        #     max_length = 0
        #     has_odd = False
        
        # for value in freq_dict.values():
        #     if value % 2 == 0:
        #         max_length += value
        #     else:
        #         max_length += value - 1         #for cases like 3, where 2 will be palindromic, but that additional 1 won't be so subtract it out
        #         has_odd = True
        
        # if has_odd:
        #     max_length += 1
        
        # return max_length


        oddcount_chars=set()
        count=0
        for ch in s:
            if ch in oddcount_chars:
                count+=2
                oddcount_chars.remove(ch)
            else:
                oddcount_chars.add(ch)
        if len(oddcount_chars)>0:
            count+=1
        return count
            