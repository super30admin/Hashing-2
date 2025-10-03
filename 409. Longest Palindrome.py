# HASH-MAP SOLUTION
# Time: O(n + k) as n is bigger O(n)
# Space: O(k)

# Create a hashmap with the chars and how many times they occur
# Then loop through the map checking how many pairs can be formed and decrementing the count after using it
# After that if there is 1 element present in the hash-map just add that to the counter

class Solution:
    def longestPalindrome(self, s: str) -> int:
        my_map = {}
        count = 0

        for char in s:
            if char in my_map:
                my_map[char] += 1
            else:
                my_map[char] = 1

        for key in my_map:
            val = my_map[key]
            count += (val // 2) * 2
            my_map[key] -= (val // 2) * 2

        if any(my_map[key] > 0 for key in my_map):
            count += 1

        return count
    

# HASH-SET SOLUTION
# Time: O(n)
# Space: O(1)

# Create a hashset
# when looping through the characters of the string check if the char is already present in the set if yes form a pair and add to the counter
# if not add the element to the set
# In the end if set is not empty add 1 to the counter for 1 element

class Solution:
    def longestPalindrome(self, s: str) -> int:
        my_set = set()
        count = 0

        for char in s:
            if char in my_set:
                count += 2
                my_set.remove(char)
            else:
                my_set.add(char)
                
        if my_set:
            count += 1
        
        return count