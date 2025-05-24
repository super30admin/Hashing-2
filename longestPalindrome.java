//T.C: O(n) n: length of String s.
//S.c: O(1) max Length of HashMap would be 26 which is constant.

/*Approach: here i will be using HashMap to store my character and its count.
if i already have the key and also the value associated with it is 2 then i will
increment my palindrome result length to 2 and remove the key.
*/

class Solution {
    public int longestPalindrome(String s) {
        
        HashMap<Character,Integer> map = new HashMap<>();
        int length = 0;

        for(int i = 0; i< s.length() ; i++){
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c,0)+1);

            if(map.containsKey(c)){
                if(map.get(c) == 2) {
                    length += 2;
                    map.remove(c);
                }
            }
        }

    if(!map.isEmpty()) length++;

    return length;
    }
}