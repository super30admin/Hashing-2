// Time complexity - O(n), n -> length of input string
// Space complexity - O(1), constant space due to fixed number alphabet characters
function longestPalindrome(s: string): number {
	const set = new Set<string>();
	let palLength = 0;
	for (let i = 0; i < s.length; i++) {
		if (set.has(s[i])) {
			palLength += 2;
			set.delete(s[i]);
		} else {
			set.add(s[i]);
		}
	}
	return set.size === 0 ? palLength : palLength + 1;
}
