// TC: O(n)
// SC: O(n)
class Solution {
    public int longestPalindrome(String s) {
        if(s == null || s.length() == 0) {
            return 0;
        }
        HashMap<Character, Integer> map = new HashMap<>();
        for(char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int max = 0;
        boolean flag = false;
        for(Map.Entry<Character, Integer> e : map.entrySet()) {
            if(e.getValue() % 2 == 0) {
                max += e.getValue();
            } else if(flag == false) {
                max += e.getValue();
                flag = true;
            } else {
                max += e.getValue() - 1;
            }
        }
        return max;
    }
}