// Time Complexity : O(n)
// Space Complexity : O(1) max length would be 26 + 26 = 52
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

class LongestPalindrome {
    // TC: O(n)
    // SC: O(1) max length would be 26 + 26 = 52
    public int longestPalindrome(String s) {
        // null check
        // if(s == null || s.length() == 0) return 0;
        if(s.length() == 1) return 1;

        int count = 0;
        Set<Character> freqSet = new HashSet<>();

        for(int i = 0; i< s.length(); i++){
            // check if char is found
            if(freqSet.contains(s.charAt(i))){
                count += 2;
                freqSet.remove(s.charAt(i));
            } else {
                // add to set
                freqSet.add(s.charAt(i));
            }
        }

        // check if set is empty of or not
        if(!freqSet.isEmpty()){
            count += 1;
        }
        return count;
    }
}