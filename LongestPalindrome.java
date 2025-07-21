// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach


/* Take a Hashmap and put character and its frequency
 * Iterate Hashmap 
 * If even add it to length
 * If odd add the even length by subtracting it by 1 and keep flag as true because we can use it in middle to make it odd length palindrome
 * After iterating check if we have any element that we
 */
class Solution {
    public int longestPalindrome(String s) {
        int len = 0;
        HashMap<Character,Integer> hm = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            hm.put(s.charAt(i),hm.getOrDefault(s.charAt(i), 0) + 1);
        }
        boolean flag = false;
        for(Map.Entry<Character,Integer> entry : hm.entrySet()){
            char c = entry.getKey();
            int cnt = entry.getValue();
            if(cnt % 2 == 0)
                len += cnt;
            else
            {
                len += cnt - 1;
                flag = true;
            }

        }
        if(flag==true)
            len++;
        return len;
    }
}

// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach


/*  Iterate through the string and add the character and frequency to the hashmap
    Each time check if element is present and get count
    if cnt  - 1 is 0 , remove the element from hashmap
    length is difference between size of string and hashmap size
    For odd length palindromes , check if array has one more element left so increase it by 1
 */
class Solution {
    public int longestPalindrome(String s) {
        int len = 0;
        HashMap<Character, Integer> hm = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (hm.containsKey(s.charAt(i))) {
                int cnt = hm.get(s.charAt(i)) - 1;
                if(cnt == 0)
                    hm.remove(s.charAt(i));
                else
                    hm.put(s.charAt(i), cnt);
            } else {
                hm.put(s.charAt(i), 1);
            }
        }
        len = s.length() - hm.size();
        if(hm.size() >= 1)
            len++;
        return len;

    }
}


// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach


/*  Initialize Hashset 
    If it already contains the element add 2 for the element in hashset and the character in the string
    If not present just add it
    For odd length plaindromes increment length by 1
 */
class Solution {
    public int longestPalindrome(String s) {
        int len = 0;
        HashSet<Character> hs = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            if (hs.contains(s.charAt(i))) {
                len += 2;
                hs.remove(s.charAt(i));
            } else {
                hs.add(s.charAt(i));
            }
        }
        if(hs.size() >= 1)
            len++;
        return len;

    }
}