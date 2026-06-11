// Time complexity O(n)
// Space complexity O(1)

class Problem1 {
    public int longestPalindrome(String s) {
        HashSet<Character> set = new HashSet<>();
        int count = 0;
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(set.contains(ch)){
                count = count+2;
                set.remove(ch);
            } else {
                set.add(ch);
            }
        }
        return set.isEmpty() ? count : count+1;
    }
}