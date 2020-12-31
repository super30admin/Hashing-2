// Time Complexity : O(N) because we are traversing through the characters in string
// Space Complexity : O(1) because we are checking the characters which are limited to a range.
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/*
Palindrome depends on length of the string. If the len is odd then there is one element in the middle
else there are 2 elements. Hence, this gives idea to check the count of the element.
In both cases we prefer even elements for sure. So we count them...if the element is single then we consider
it as palindrome thats why we returned count+1 in the end if an odd counted character is still left.
This problem can also be done using hashmap where value will be count and key will be character.
 */

class LongestPalindrome{

    public int longestPalindrome(String s) {
        HashSet<Character> set = new HashSet<>();
        int count = 0;

        for (int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if (!set.contains(c)){
                set.add(c);
            }
            else{
                count += 2;
                set.remove(c);
            }
        }

        return set.isEmpty() ? count: count+1;
    }
}

/*
Leetcode analysis:
Runtime: 4 ms, faster than 52.17% of Java online submissions for Longest Palindrome.
Memory Usage: 39.1 MB, less than 9.98% of Java online submissions for Longest Palindrome.
 */