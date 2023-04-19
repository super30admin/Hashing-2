// Time Complexity : O(n) where n is the number of chars in the string
// Space Complexity : O(1) since the set will contain at max all the chars in
//    the English alphabet.
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

/*
 * Approach:
 * We use a HashSet to maintain the occurrence of chars in the string.
 * In case another same char exists in string, we add 2 to the sum (consider
 * those 2 chars as a pair) and remove the char from the HashSet. Eventually,
 * we end up with all the single chars in the string (that don't have a pair).
 * If the set contains ANY elements at all, then we add 1 to the total sum
 * (since this odd character will become the middle element in the palindrome).
 */

package main

func longestPalindrome(s string) int {
	if len(s) == 0 {
		return 0
	}
	if len(s) == 1 {
		return 1
	}

	m := make(map[rune]struct{})
	sum := 0

	for _, char := range s {
		if _, ok := m[char]; ok { // found in set, so add to sum and remove counter
			sum += 2
			delete(m, char)
		} else {
			m[char] = struct{}{} // otherwise add to set
		}
	}

	if len(m) > 0 {
		sum += 1
	}

	return sum
}
