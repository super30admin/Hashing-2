// Time Complexity : O(n)
// Space Complexity : O(n)
// Method : Hashing

class Solution {
    public int longestPalindrome(String s) {
        
        int count = 0;
        HashSet<Character> h = new HashSet();
        for(int i = 0;i < s.length();i++)
        {
            //counts for even length of characters
            if(h.contains(s.charAt(i)))
            {
                count += 2;
                h.remove(s.charAt(i));
            }
            else
                h.add(s.charAt(i));
        }
    
        return (!h.isEmpty()) ? count + 1 : count;
    }
}