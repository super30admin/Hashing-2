package main

import "fmt"

/*
409. Longest Palindrome
Given a string s which consists of lowercase or uppercase letters,
return the length of the longest palindrome that can be built with those letters.

Letters are case sensitive, for example, "Aa" is not considered a palindrome here.


Example 1:
Input: s = "abccccdd"
Output: 7
Explanation:
One longest palindrome that can be built is "dccaccd", whose length is 7.

Example 2:
Input: s = "a"
Output: 1

Example 3:
Input: s = "bb"
Output: 2

*/

func longestPalindrome(s string) int {
	if s == "" || len(s) == 0 {
		return 0
	}

	// to form a palindrome, we need a pair or characters
	// so lets count each char count we have
	freqMap := map[string]int{}
	for i := 0; i < len(s); i++ {
		char := string(s[i])
		freqMap[char]++
	}

	l := 0
	for char, count := range freqMap {
		if count%2 == 0 {
			l += count
			delete(freqMap, char)
		} else if count != 1 {
			evenCount := count - 1
			l += evenCount
			freqMap[char] = count - evenCount
		}
	}
	if len(freqMap) != 0 {
		l++
	}
	return l
}

func main() {
	fmt.Println(longestPalindrome("abccccdd"))
	fmt.Println(longestPalindrome("aa"))
	fmt.Println(longestPalindrome("ccc"))
}
