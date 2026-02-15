class LongestPalindrome {
    public int longestPalindrome(String s) {

        Set<Character> dict = new HashSet<>();
        int count = 0;

        for(char c : s.toCharArray()) {
            if(dict.contains(c)) {
                count += 2;
                dict.remove(c);
            } else {
                dict.add(c);
            }
        }

        return dict.size() > 0 ? count + 1 : count;
    }
}