// Time complexity: O(n)
// space complexity: O(1)
class Solution {
    public int longestPalindrome(String s) {

        if (s == null || s.length() == 0) return 0;

        Set<Character> set = new HashSet<>();
        int result = 0;

        for(int i = 0 ; i < s.length(); i++) {

            if (set.contains(s.charAt(i))) {
                set.remove(s.charAt(i));
                result+=2;    
            } else {
                set.add(s.charAt(i));    
            }
        }

        if(!set.isEmpty()) {
            result+=1;
        }
        return result;
    }
}