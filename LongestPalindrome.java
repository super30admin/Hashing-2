//Time Complexity : O(n)
//The algorithm counts the length of the longest palindrome by using a HashSet to track pairs of characters in the input string. 
//It iterates through the string, incrementing the count for each pair found, and considers a single character in the center if needed. The time complexity is O(n), and the space complexity is O(k), where n is the string length and k is the number of distinct characters.
class Solution {
    public int longestPalindrome(String s) {
        
        int count = 0;
        HashSet<Character> set = new HashSet<>();
        for(int i =0;i<s.length();i++){
            char c = s.charAt(i);
            if(set.contains(c)){
                count += 2;
                set.remove(c);
            }
            else set.add(c);
        }
        if(!set.isEmpty()) count++;

        return count;
    }
}