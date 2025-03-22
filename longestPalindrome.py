# sol - 1 using character array and getting the size of the palindrome
# TC: O(N) just using linear methond on a string
# Sc: O(1) avg case


class Solution:
    def longestPalindrome(self, s: str) -> int:
        char_set = [0] * 100  # character array
        count = 0

        for c in s:
            index = ord(c) - ord("A")  # Convert character to index
            if char_set[index]:
                count += 2
                char_set[index] = 0  # Reset after forming a pair
            else:
                char_set[index] = 1

        return count if len(s) == count else count + 1


Sol = Solution()
string = "abccccdd"
print(Sol.longestPalindrome(string))


# sol - 2: using hashset to store the unique values
# TC: O(N) linear iteration on a string
# SC: O(1) hashSet stores at most unique characters from string avg case
# hashSet = set()
# count = 0

# for c in s:
#     if c in hashSet:
#         hashSet.remove(c)  # Found a pair
#         count += 2
#     else:
#         hashSet.add(c)

# # If there are remaining characters, we can place one in the middle
# if hashSet:
#     count += 1

# return count


# sol-3 using hashmap to store and count the freq. of characters
# TC: O(2n) first loop to iterate through string and count character freq and secon to process hashMap.values()
# SC: O(1) avg case
# hashMap = {}
# for c in s:
#     hashMap[c] = hashMap.get(c, 0) + 1

# res = 0
# flag = False
# for c in hashMap.values():
#     if (c % 2) == 0:
#         res += c
#     else:
#         res += c - 1
#         flag =True

# if flag:
#     return res + 1

# return res
