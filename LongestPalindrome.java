// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
class LongestPalindrome {
    public int longestPalindrome(String s) {
        HashSet<Character> store = new HashSet<>();
        int resultLength = 0;
        for(int i = 0; i < s.length(); i++){
            char temp = s.charAt(i);
            if(store.contains(temp)){
                resultLength+=2;
                store.remove(temp);
            }
            else{
                store.add(temp);
            }

        }
        if(!(store.isEmpty())){
            return resultLength + 1;
        }
        else{
            return resultLength;
        }
    }
}