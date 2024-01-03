//approach - hahsset
/*
if set doesnt have character, add it to the set. 
if set has it, i.e. we found 2 occurrence of that character, so add 2 to the count, and remove it from set as well. 
at last if the set size is not 0, add 1 to the count else just return the count.
*/

//tc: O(n) : len of string
//sc : constant

class Solution {
    public int longestPalindrome(String s) {

        if (s == null)
            return -1;

        Set<Character> set = new HashSet<>();

        int count = 0;
        for (char c : s.toCharArray()) {
            if (set.contains(c)) {
                count += 2;
                set.remove(c);
            } else
                set.add(c);
        }

        return set.size() > 0 ? count + 1 : count;
    }
}

/*
 * 
 * with Hahsmap
 * char - freq map
 * go through keys, and when find even values, add it to the count, we cant
 * change values, or remove keys wihile iterating over key set.
 * at last, if the map size is not 0 add count in +1
 * 
 * 
 * tc: O(n) - 2 pass
 * sc: constant
 */

class Solution {
    public int longestPalindrome(String s) {
        if (s == null)
            return -1;

        Map<Character, Integer> map = new HashMap<>();

        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        // now go voer all the keys
        boolean odd = true;

        int count = 0;
        for (char c : map.keySet()) {
            int val = map.get(c);
            if (val % 2 == 0) {
                count += val;
            } else if (val >= 1) {
                if (odd) {
                    count += val;
                    odd = false;
                } else
                    count += val - 1;
            }

            /*
             * else
             * {
             * count += (val/2) *2; division*2 gets us even vallues! 11/2 =5 ; 5*2 =10
             * }
             * at last if (odd) return count++;
             */

        }

        return count;
    }
}

/*
 * set solution, but instead set, we use Array of booleans
 * TC: O(n); 2 pass, sc :O(1)
 * 
 * 
 */
class Solution {
    public int longestPalindrome(String s) {

        if (s == null)
            return -1;

        boolean[] set = new boolean[60]; // because of capital and small letters we are taking 60
        int count = 0;

        for (char c : s.toCharArray()) {
            if (set[c - 'A']) // true
            {
                count += 2;
                set[c - 'A'] = false;
            } else {
                set[c - 'A'] = true;
            }
        }

        for (int i = 0; i < 60; i++) {
            if (set[i])
                return count + 1;
        }
        return count;
    }
}