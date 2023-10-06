class Solution(object):
    def longestPalindrome(self, s):
        """
        :type s: str
        :rtype: int
        """

        # Using hash set

        # Intuition: Iterate through the string, and if the character not present in the set, store it. If present, increment count by 2 and remove from the set. At the end if hashset is not empty, means there are odd count characters so return total count + 1 else return just the count

        refSet = set()  # hash set
        count = 0
        for letter in s:  # TC: O(n)
            if letter not in refSet:
                # TC: O(1), SC: O(1) as max would be O(26) or O(52) if lower & upper case both considered
                refSet.add(letter)
            else:
                count += 2
                refSet.remove(letter)  # TC: O(1)
        if len(refSet) != 0:
            return count + 1
        else:
            return count

        # Using hash map

        # Intuition: Iterate through the string, and if the character is not present in the map, store the char as key & its count as the value. IF its present, just increment the count. Once done, iterate through the hashmap and search for chars with even count, keep summing them. At any point if you find an odd count char, set a flag so that eventually you can add 1 to the total sum.

#         refMap = {}  # hash map
#         count = 0
#         for letter in s: # TC: O(n)
#             if letter not in refMap:
#                 # print("Adding letter {} to map".format(letter))
#                 refMap[letter] = count + 1
#                 # print(refMap)
#             else:
#                 # print("Increasing count for letter {} in map".format(letter))
#                 refMap[letter] += 1
#                 # print(refMap)

#         length = 0
#         oddCountFlag = False

#         for key in refMap: # TC: O(n) , SC: O(1)
#             # print("Key: {}, Value: {}".format(key, refMap[key]))
#             length = length + 2*(refMap[key] //2)
#             if refMap[key]%2 != 0:
#                 oddCountFlag = True

#         if oddCountFlag is True:
#             return length + 1
#         else:
#             return length


# obj = Solution()
# print(obj.longestPalindrome ("abbcccdd"))
