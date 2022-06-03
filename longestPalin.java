class Solution {
    public int longestPalindrome(String s) {
        HashSet<Character> hSet = new HashSet<>();
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (hSet.contains(c)) {
                hSet.remove(c);
                count = count + 2;
            } else {
                hSet.add(c);
            }

        }
        if (!hSet.isEmpty()) {
            return count + 1;
        }
        return count;

    }
}