
// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
class Solution {
    public int longestPalindrome(String s) {
        HashSet<Character> map = new HashSet<>();
        int ans = 0;
        for(int i = 0; i < s.length();i++){
            char c = s.charAt(i);
            if(map.contains(c)){
                ans+=2;
                map.remove(c);
            }
            else
            map.add(c);

        }
        if(!map.isEmpty())
            ans++;
        return ans;

    }
}