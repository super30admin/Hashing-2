// Time: O(N)
// Space: O(26 + 26) total Characters 
class Solution {
    public int longestPalindrome(String s) {
        Set<Character> set = new HashSet<>();
        int count = 0;

        for(char c : s.toCharArray()){
            if(set.contains(c)){
                count+=2;
                set.remove(c);
            }
            else{
                set.add(c);
            }
        }

        if(set.size()>0) count++;
        return count;
    }
}