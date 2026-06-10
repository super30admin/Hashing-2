import java.util.HashSet;

class Solution {
    /*
        TC - O(n)
        SC - O(1)
        Solution - using hashset to keep track of characters. When adding a char to set, we
        check if it already exists. If it does it is a pair and we add +2 to the total and 
        remove character from the set. If it does not, we add it to set. At the end if set is empty, return total, else return 
        total + 1.
    */
    public int longestPalindrome(String s) {
        HashSet<Character> set = new HashSet<>();
        int total = 0;

        for (Character c : s.toCharArray()) {
            if (set.contains(c)) {
                total += 2;
                set.remove(c);
            } else {
                set.add(c);
            }
        }

        if (set.isEmpty()) {
            return total;
        }

        return total + 1;
    }
}