package main

/*

Initial Though Process
^ Could not come up with a Brute Force Approach
- Loop over string
- Maintain if I have seen an element in a map with its value being 1
- if I see the char again, remove the char from map and increment a counter by 2
- in the end if I have a non empty map, add 1 to the counter and that will be the answer

*/

// Time : O(N) - n is the number of chars in the string
// Space : ~O(1) - max can be all alphabets in the map and hence constant after that.
func longestPalindrome(s string) int {
	// counter to track if I have seen a char 2 times
	count := 0
	// map to maintain if I have seen an element
	charMap := make(map[string]int)

	// iterate
	for i := 0; i < len(s); i++ {
		_, present := charMap[string(s[i])]
		if !present {
			charMap[string(s[i])] = 1
		} else {
			// means its present; so increment the counter
			count += 2
			// remove the char
			delete(charMap, string(s[i]))
		}
	}
	if len(charMap) > 0 {
		count = count + 1
	}
	return count
}
