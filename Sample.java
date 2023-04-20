// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach



## Problem from last class (https://leetcode.com/problems/group-anagrams/)

Given an array of strings, group anagrams together.

Example: Input: ["eat", "tea", "tan", "ate", "nat", "bat"], Output: [ ["ate","eat","tea"], ["nat","tan"], ["bat"] ]

Note: All inputs will be in lowercase. The order of your output does not matter.

// First Approach - using hashmap

// Time complexity - O(n * k log k) 
// Space Complexity - O(n * k) can be reduced by using an array of size 26 to count the frequency of each character

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
    for (String str : strs) {
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        String key = new String(chars);
        if (!map.containsKey(key)) {
            map.put(key, new ArrayList<>());
        }
        map.get(key).add(str);
    }
    return new ArrayList<>(map.values());
    }
}

// Second Approach - prime number multiplication

// It is passing the 3 test cases and when I submit this it shows error as WRONG ANSWER for the test case 4, the error is below the code


class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<Long, List<String>> map = new HashMap<>();
        int[] primes = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103};

        for (String str : strs) {
            long product = 1;
            for (char c : str.toCharArray()) {
                product *= primes[c - 'a'];
            }
            if (!map.containsKey(product)) {
                map.put(product, new ArrayList<>());
            }
            map.get(product).add(str);
        }
        return new ArrayList<>(map.values());
    }
}


## error

Input
strs =
["aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",
"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab"]

Output
[["aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",
"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab"]]

Expected
[["aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab"],
["aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"]]



## Problem3 (https://leetcode.com/problems/longest-palindrome)

// Time complexity - O(n) because the code iterates over each character of the string exactly once and performs constant time operations
// Space complexity - O(n) for the worst case, where all characters in the string are unique, the HashSet will need to store all n characters of the string.
// Best Case complexity - Where the string contains only one type of character, the HashSet will contain only one element, and the time and space complexity of the code will be O(1).

class Solution {
    public int longestPalindrome(String s) {
        if (s == null || s.length() == 0) {                     // base case as empty string would not give a palindrome
            return 0;
        }
        HashSet<Character> set = new HashSet<>();              // using Hashset with character type 
        int length = 0;

        for (int i = 0; i < s.length(); i++) {                 // iterating for loop over to the length of the string
            char c = s.charAt(i);                              // get the single character
            if (set.contains(c)) {                             // check that set contains the single character 'c'
                set.remove(c);                                 // remove the character
                length = length + 2;                           // add the length to plus 2 as 1 is the current and 2nd is the new found
            }
            else {
                set.add(c);                                    // add the character
            }
        }
        if (!set.isEmpty()) {                                 // check if the set is empty or not
            length++;                                         // if it is not empty add the length 
        }
        return length;                                        // return the length
    }
}


## Problem from last class (https://leetcode.com/problems/word-pattern/) 

//Time Complexity - O(n * k) because iterating over one string caused us n * K
// Space Complexity - O (n) HashMap and HashSet will need to store all n words of the string.

class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] strArray = s.split(" ");
        if (strArray.length != pattern.length()) {
            return false;
        }
        // Using 1 HashMap and 1 HashSet
        HashMap<Character, String> map = new HashMap<>();
        HashSet<String> set = new HashSet<>();

        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            String str = strArray[i];
            if (map.containsKey(c)) {
                if (!map.get(c).equals(str)) {
                    return false;
                }
            }
            else {
                if (set.contains(str)) {
                    return false;
                }
                set.add(str);
                map.put(c, str);
            }
        }
        return true;
    }
}