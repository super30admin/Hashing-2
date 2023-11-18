// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/**
 * Store each character in a hashset if it occurs once. If it comes up again, remove it
 * from the hashset and increment the count by 2. After iterating over the entire string. check if there are any elements in
 * hashset with odd occcurances, If yes, then that character can be the mid of the palindrome. Hence, increment count by 1.
 */
class Solution {
    public int longestPalindrome(String s) {

        HashSet<Character> set = new HashSet<>();
        int count = 0;

        for(char c: s.toCharArray()) {
            if(set.contains(c)) {
                count += 2;
                set.remove(c);
            }
            else {
                set.add(c);
            }
        }

        if(set.size() != 0)
            count++;

        return count;
    }
}

/*
class Solution {
    public int longestPalindrome(String s) {
         boolean[] set = new boolean[60];
         int count = 0;

         for(char c: s.toCharArray()) {
             if(!set[c-'A']) {
                 set[c-'A'] = true;
             }
             else {
                 set[c-'A'] = false;
                 count += 2;
             }
         }

         for(int i=0; i<set.length; i++) {
             if(set[i]) {
                 count++;
                 break;
             }
         }

         return count;
    }
}*/
