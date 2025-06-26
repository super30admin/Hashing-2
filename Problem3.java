// Time Complexity: O(n)
// Space Complexity: O(1)

// Using a freqMap to store freq of all characters
// one odd frequency is allowed, remaining we perform 2 * (freq/2), this omits the odd characters if any exists

class Solution {
    public int longestPalindrome(String s) {
        int maxLen = 0;

        boolean hasOdd = false;

        HashMap<Character, Integer> freqMap = new HashMap<>();

        for (int i=0; i<s.length(); i++) {
            freqMap.put(s.charAt(i), freqMap.getOrDefault(s.charAt(i), 0) + 1);
        }

        for (int freq : freqMap.values()) {
            if (!hasOdd && freq%2 == 1) {
                hasOdd = true; 
                maxLen = maxLen + 1; // one odd character is allowed
            }
            maxLen = maxLen + 2 * (freq/2); // even number of characters
        }

        return maxLen;
    }
}
