class Solution:
    def longestPalindrome(self, s: str) -> int:
        
        # freq_dict = {}
        # for char in s:
        #     freq_dict[char] = freq_dict.get(char, 0) + 1
        
        # max_length = 0
        # has_odd = False
        
        # for char in freq_dict:
        #     value = freq_dict[char]
        #     if value % 2 == 0:
        #         max_length += value
        #     else:
        #         max_length += value - 1 #for cases like 3, where 2 will be palindromic, but that additional 1 won't be so subtract it out
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
            