# Time Complexity : O(n)
# Space Complexity : O(1)
def longestPalindrome(s: str) -> int:
    char_pair = set()
    count = 0

    for c in s:
        if c in char_pair:
            count += 2
            char_pair.remove(c)
        else:
            char_pair.add(c)
    if len(char_pair)>=1:
        return count + 1
    return count
s = "abccccdd"
print(longestPalindrome(s))
    