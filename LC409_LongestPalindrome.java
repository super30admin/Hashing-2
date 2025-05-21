// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : N/A


// Your code here along with comments explaining your approach

import java.util.*;

class Solution {

    /*
    Using map to store counts
     */
    public static int longestPalindromeMap(String s) {
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        char[] ch = s.toCharArray();

        for (int i = 0; i < ch.length; i++) {
            map.put(ch[i], map.getOrDefault(ch[i], 0) + 1);
        }

        int count = 0;
        boolean extra = false;

        for (char c : map.keySet()) {
            //System.out.println(" c " + c + " count " + map.get(c) % 2);
            count += map.get(c) / 2;
            if (map.get(c) % 2 != 0) {
                extra = true;
            }
            //System.out.println(" c " + c + " count " + map.get(c));
        }

        if (extra) {
            return (count * 2) + 1;
        } else {
            return count * 2;
        }

    }

    /*
Using set to store extra characters
 */
    public static int longestPalindromeSet(String s) {

        /* base case */
        if (s == null || s.length() == 0) {
            return -1;
        }

        Set<Character> set = new HashSet<>();

        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (set.contains(ch)) {
                count += 2;
                set.remove(ch);
            } else {
                set.add(ch);
            }
        }

        if (!set.isEmpty()) {
            count++;
        }

        return count;
    }

    /* trying to return all possible strings*/

    public static List<String> longestPalindrome(String s) {

        /* base case */
        if (s == null || s.length() == 0) {
            return null;
        }

        Set<Character> set = new HashSet<>();

        int count = 0;

        StringBuilder first  = new StringBuilder();
        StringBuilder second  = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (set.contains(ch)) {
                //count += 2;
                first.append(ch);
                second.insert(0, ch);
                set.remove(ch);
            } else {
                set.add(ch);
            }
        }

        List<String> list  = new ArrayList<>();

        if (!set.isEmpty()) {
            //count++;
            StringBuilder sb;

            for(char c : set){

                sb = new StringBuilder(second);

                sb.insert(0, c);



                list.add(sb.insert(0, first).toString());

                sb.setLength(0);



            }
        } else {
            list.add(first.append(second).toString());
        }

        return list;
    }

    public static void main(String[] args) {
        String s = "ababcccdbcdabc";

        List<String> list = longestPalindrome(s);

        for(String str  : list){
            System.out.println(str);
        }
    }

}

