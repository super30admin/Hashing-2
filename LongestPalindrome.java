import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution {

    public int longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        Set<Character> set = new HashSet();
        int count = 0;
        for (char c: s.toCharArray()) {
            if (!set.contains(c)) {
                set.add(c);
            } else {
                count += 2;
                set.remove(c);
            }
        }

        return set.isEmpty() ? count : count + 1;

    }


    public int longestPalindromeUsingMap(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        Map<Character, Integer> freqMap = new HashMap<>();
        for (char c: s.toCharArray()) {
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
        }

        boolean oneFreqPresent = false;
        int count = 0;
        for (Map.Entry<Character, Integer> entry : freqMap.entrySet()) {
            char c = entry.getKey();
            int freq = entry.getValue();

            if (freq % 2 == 1) {
                oneFreqPresent = true;
                count += freq - 1;
            } else {
                count += freq;
            }
            
            
            
        }

        return oneFreqPresent ? count + 1: count;
    }
}