class Solution:
    def wordPattern(self, pattern: str, s: str) -> bool:
        """
        Approach:
        1. Here we will use the two hashmaps
        2. One hasmap will store the key as pattern and values as word in string
        3. Second hashmap will store the key as word in string and value as pattern
        4. First check if pattern variable is present in first hashmap or not.
           If it is already present then check its corresponding value if the value and word            in string we are trying to add as a key are same then continue otherwise return              True Same checks for Second hashmap
        
        This can also be solved using hashmap and hashset, before adding value in the               hashmap 
        check if value is present in hashset. If value is already present then return false           otherwise add as value.
        
        Time Complexity: O(n)
        Space Complexity: O(n) As we are declaring extra string array for spliting the string
        """
        if not s or not pattern:
            print("Test")
            return False
        words = s.split()
        
        if len(pattern) != len(words):
            return False
        
        string_dict = {}
        pattern_dict = {}

        for i in range(len(pattern)):
            if pattern[i] not in pattern_dict.keys():
                pattern_dict[pattern[i]] = words[i]
            elif pattern_dict[pattern[i]] != words[i]:
                 return False
                
            if words[i] not in string_dict.keys():
                string_dict[words[i]] = pattern[i]
            elif string_dict[words[i]] != pattern[i]:
                 return False
        return True

pattern = "abba"
s = "dog cat cat dog"
temp = Solution()
result = temp.wordPattern(pattern, s)
print(result)