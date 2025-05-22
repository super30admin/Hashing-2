// Time Complexity =O(n)
// Space Complexity - O(1)
// solved in leetcode - Yes
// faced any issues - No
// Mantaining a set to store the individual character, If we find the pair for it, we remove the character from the set and add the count by 2. Finally if set contains atleast one element add 1 to count
class Solution {
    public int longestPalindrome(String s) {
        HashSet<Character> result = new HashSet<>();
        int count =0;
        for(char i:s.toCharArray()) {
            if(result.contains(i)) {
                count = count +2;
                result.remove(i);
            } else {
                result.add(i);
            }
        }
        if(!result.isEmpty()) {
            count = count +1;
        }
        return count;
    }
}
