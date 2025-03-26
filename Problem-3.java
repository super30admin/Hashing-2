/* Using char arr or boolean arr: Time complexity - O(n) & Space complexity - O(1) */

class Solution {
    public int longestPalindrome(String s) {
        char[] arr = new char[100];
        int count = 0;

        for(char c : s.toCharArray()){
            if(arr[c - 'A'] == 0){
                arr[c - 'A'] = c;
            }else{
                count = count + 2;
                arr[c - 'A'] = 0;
            }
        }

        if(count == s.length()) return count ;
        return count + 1;
    }
}

/* Using HashMap: Time complexity - O(2n) & Space complexity - O(1)
 * Using HashSet: Time complexity - O(n) & Space complexity - O(1)
 */
/*
class Solution {
    public int longestPalindrome(String s) {
        HashSet<Character> set = new HashSet<>();
        int count = 0;

        for(char c : s.toCharArray()){
            if(!set.contains(c)){
                set.add(c);
            }else{
                count = count + 2;
                set.remove(c);
            }
        }

        if(set.isEmpty()) return count;
        return count + 1;
    }
}
*/