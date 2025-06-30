// We use a HashSet to track characters with odd frequencies while iterating through the string.
// Each time we find a matching character (even count), we add 2 to the length and remove it from the set.
// After the loop, if the set is not empty, we can place one odd-frequency character in the center (add 1 to length).

//Time Complexity:** O(n), where *n* is the length of the string — we traverse the string once.
//Space Complexity:** O(1), because the HashSet stores at most 52 characters (uppercase + lowercase English letters).


class Solution {
    public int longestPalindrome(String s) {
        
        HashSet<Character> set = new HashSet<>();
        int length = 0;
        for(char ch : s.toCharArray())
        {
            if(set.contains(ch))
            {
                length+=2;
                set.remove(ch);
            }
            else
            {
                set.add(ch);
            }
        }
        if(!set.isEmpty())
        {
            length+=1;
        }
        return length;

    }
}