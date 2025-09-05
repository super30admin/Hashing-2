
// ## Problem3 (https://leetcode.com/problems/longest-palindrome)

// TimeComplexity: O(n)

// Space Complexity O(n)

class Solution {
    public int longestPalindrome(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int oddCount = 0;
        // convert all string elements with a character counter map
        for(char c: s.toCharArray()) {
            map.put(c,map.getOrDefault(c,0)+1);
        }
        // Have a integer reuslt to store the result
        int result = 0;

        for(char p: map.keySet() ) {
            // for all values if odd, add the values - 1 to have a add counter
            if(map.get(p) % 2 != 0) {
                // increment oddCounter by 1
                result = result + map.get(p) - 1;
                oddCount = oddCount + 1;
            }
            else {
                // if even add to result
                result = result + map.get(p);
            }
        }
        // if odd then suppose 3 then add result with + 1
        if(oddCount >= 1) {
            return result + 1;
        }
        // else return result
        return result;

    }
}