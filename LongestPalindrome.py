"""
Rasika Sasturkar
Time Complexity: O(n)
Space Complexity: O(1)
"""


def longestPalindrome(s: str) -> int:
    """
    If the character is not present in the set, we add it to set.
    If it is present, we remove the character and increase the count by 2.
    At the end, if the set is not empty, we can have odd number the longest
    palindrome so increase the count by 1.
    """
    count = 0
    temp_set = set()
    for char in s:
        if char in temp_set:
            count += 2
            temp_set.remove(char)
        else:
            temp_set.add(char)
    if len(temp_set) != 0:
        count += 1
    return count


def main():
    """
    Main function - an example from LeetCode problem to show the working.
    This code ran successfully on LeetCode and passed all test cases.
    """
    print(longestPalindrome(s="abccccdd"))  # returns 7
    print(longestPalindrome(s="a"))  # returns 1


if __name__ == "__main__":
    main()
