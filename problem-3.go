/*
// time complexity = O(2n)
space complexity = O(1)
*/
package main

func longestPalindrome(s string) int {
	m := make(map[rune]int)
	for _, char := range s {
		m[char]++
	}
	ans := 0
	hasOdd := false
	for _, count := range m {
		if count%2 == 0 {
			ans += count
		} else {
			ans += count - 1
			hasOdd = true
		}
	}
	if hasOdd {
		ans++
	}
	return ans
}
