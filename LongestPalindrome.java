// Time Complexity: O(n)
// Space Complexity: O(1)

class LongestPalindrome {
    public int longestPalindrome(String s) {
        Set<Character> set = new HashSet<Character>();
        int result = 0;

        for(char c: s.toCharArray()){
            if(set.contains(c)){
                set.remove(c);
                result+=2;
            } else{
                set.add(c);
            }

        }
        if(!set.isEmpty()) result++;

        return result;
    }
}