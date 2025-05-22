# length of longest palindrome using the characters present in the input string
# Time Complexity will be O(n)
# Space Complexity will be O(n) as Set could contain max n chars
st1 = set()
def length_of_longest_palindrome(s) -> int:
    count = 0
    for ch1 in s:
        if ch1 not in st1:
            st1.add(ch1) 
        else:
            count += 2
            st1.remove(ch1)
    if len(s) > 0:
        return count+1
    return count

if __name__ == "__main__":
    s = "a"
    print(length_of_longest_palindrome(s))