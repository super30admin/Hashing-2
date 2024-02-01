class Solution {
    public int longestPalindrome(String s) {
        int count = 0;
        HashSet<Character> set = new HashSet<>();

        for(char c : s.toCharArray()) {
            if(!set.contains(c)) {
                set.add(c);
            }else {
                count = count + 2;
                set.remove(c);
            }
        }
        return set.isEmpty() ? count : count + 1;
    }
}