//Time Complexity: O(n)
//Space Complexity: O(1) as hashset stores only characters (max:52 characters)
//Solved in leetcode: Yes
/*
Approach: Maintain a hashset to store every character we encounter initially,
if encounter it again then increment the length to 2,
and remove that character from hashset
 */
import java.util.HashMap;
import java.util.HashSet;

public class LongestPalindrome {
    public int longestPalindrome_optimized(String s) {
        HashSet<Character> charSet = new HashSet<>();
        int length = 0;
        for (int i=0;i<s.length();i++){ //Time complexity: O(n)
            char c = s.charAt(i);
            if (!charSet.contains(c)){
                charSet.add(c);
            } else {
                length+=2;
                charSet.remove(c);
            }
        }
        if (charSet.isEmpty()) return length;
        return length+1;
    }

    public int longestPalindrome_bruteForce(String s){
        HashMap<Character, Integer> countMap = new HashMap<>();
        for (int i=0;i<s.length();i++){  //Time complexity:O(n)
            char c = s.charAt(i);
            if (!countMap.containsKey(c)){
                countMap.put(c,1);
            } else {
                int count = countMap.get(c);
                countMap.put(c, count+1);
            }
        }

        int length=0;
        int remaining=0;
        for(Integer value:countMap.values()){ //Time Complexity: O(n)
            if (value%2 == 0){
                length+=value;
            } else{
                length+=value-1;
                if(remaining==0){
                    remaining+=1;
                }
            }
        }
        return length+remaining;
    }
    public static void main(String args[]){
        LongestPalindrome lp = new LongestPalindrome();
        System.out.println(lp.longestPalindrome_bruteForce("abccccdd"));
        System.out.println(lp.longestPalindrome_optimized("bb"));
    }
}
