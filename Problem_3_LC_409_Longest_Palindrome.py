
"""

Time Complexity: O(N), where N is the length of the string.
Space Complexity: O(1), since at most 52 distinct letters (upper + lower
case) can appear in the character map.
Did this code successfully run on Leetcode (Problem 409. Longest Palindrome) : Yes
Any problem you faced while coding this : None


Approach: Count each character's frequency with a hash map. Every character
with an even count can be fully used; for an odd count, use (count - 1)
characters and remember that at least one leftover exists. If any leftover
exists, one of them can sit in the middle, so add 1 to the total.
"""


class SolutionHashMap:

    def longestPalindrome(self, s: str) -> int:
        if not s:
            return 0
 
        char_mapping = {}
        longest_palindrome_count = 0
        has_odd_leftover = False
        for i in s:
            if i not in char_mapping:
                char_mapping[i] = 1
            else:
                char_mapping[i] += 1
 

 
        for key in char_mapping:
            count = char_mapping[key]
            if count % 2 == 0:
                longest_palindrome_count += count
            else:
                longest_palindrome_count += count - 1
                has_odd_leftover = True
 
        if has_odd_leftover:
            longest_palindrome_count += 1
 
        return longest_palindrome_count


"""
Time Complexity: O(N), where N is the length of the string.
Space Complexity: O(1), since at most 52 distinct letters (upper + lower
case) can appear in the set.
Did this code successfully run on Leetcode (Problem 409. Longest Palindrome) : Yes
Any problem you faced while coding this : None

Approach: Track characters in a set. Adding a new character means we've
seen it once; seeing it again means we have a matching pair, so remove it
from the set and add 2 to the count. Any character still left in the set
at the end can serve as the single middle character, so add 1 if the set
is non-empty.
"""

class SolutionHashSet:
    def longestPalindrome(self, s: str) -> int:
        if not s:
            return 0

        seen = set()
        longest_palindrome_count = 0

        for char in s:
            if char in seen:
                seen.remove(char)
                longest_palindrome_count += 2
            else:
                seen.add(char)

        if seen:
            longest_palindrome_count += 1

        return longest_palindrome_count


# ---------------------------------------------------------------------------
# Test cases
# ---------------------------------------------------------------------------
if __name__ == "__main__":
    test_cases = [
        ("abccccdd", 7),   # LeetCode example: dccaccd or similar, length 7
        ("a", 1),          # single character
        ("", 0),           # empty string
        ("aa", 2),         # simple even pair
        ("aaa", 3),        # odd count > 1, still fully usable with middle char
        ("bb", 2),         # simple even pair
        ("ccc", 3),        # odd count > 1
        ("abc", 1),        # all distinct, only one can be the middle char
        ("Aa", 1),         # case-sensitive: 'A' and 'a' are different single chars
        ("aabbccddeeffg", 13),  # multiple even pairs + one leftover single char
        ("tattarrattat", 12),  # all character counts happen to be even
    ]

    for solution_cls in (SolutionHashMap, SolutionHashSet):
        solution = solution_cls()
        print(f"--- {solution_cls.__name__} ---")
        for s, expected in test_cases:
            result = solution.longestPalindrome(s)
            status = "PASS" if result == expected else "FAIL"
            print(f"{status}: longestPalindrome({s!r}) = {result} (expected {expected})")