// Using set

class Solution {
     public int longestPalindrome(String s) {
         // constant to store the longest palindrome
         int longestLtPal = 0;
         // Using hashset
         Set<Character> set = new HashSet<>();
         // iterate through each character in the string
         for(int i=0; i<s.length(); i++){
             // storing character ith index of string in ch
             char ch = s.charAt(i);
             // If set does not contain ch, we add it to the set else we add 2 to longestLtPal and remove the character from 
             // set. We are doing this as we know to form a palindrome, characters should be in pairs and a single count 
             // character.
             if(!set.contains(ch)){
                 set.add(ch);
             }else{
                 longestLtPal += 2;
                 set.remove(ch);
             }
         }
         // We check if set is empty, else we add 1 to longestLtPal.
         if(!set.isEmpty()){
             return longestLtPal + 1;
         }
         return longestLtPal;
     }
}


// Using HashMap

// class Solution {
//     public int longestPalindrome(String s) {
//         int longestltPal = 0;
//         Map<Character, Integer> map = new HashMap<>();
        
//         for(int i=0; i<s.length(); i++){
//             char ch = s.charAt(i);
//             if(!map.containsKey(ch)){
//                 map.put(ch, 1);
//             }else{
//                 longestltPal += 2;
//                 map.remove(ch);
//             }
//         }
//         if(!map.isEmpty()){
//             return longestltPal + 1;
//         }
//         return longestltPal;
//     }
// }