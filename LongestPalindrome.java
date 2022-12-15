import java.util.HashSet;
//Time Complexity - O(n)
//Space Complexity - O(1)
//Leetcode passed
/*Maintain a HashSet and a counter for the characters. If character is present in the map increment the counter by 2
* if not present then add the character in the set. After loop if the set is not empty then increment the counter by 1 as we can
* select a single non repeating element which can work as middle character.
* */
public class LongestPalindrome {
    //https://leetcode.com/problems/longest-palindrome/
    public static void main(String[] args) {
        String s = "abccccdd";
        System.out.println(longestPalindrome(s));
    }
//Using HashMap
//Time Complexity - O(n)
//Space Complexity - O(1)
   /* private static int longestPalindrome(String s) {
        int count = 0;

        HashMap<Character,Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char sChar =s.charAt(i);
            if(!map.containsKey(sChar)) {
                map.put(sChar,1);
            }
            if(map.containsKey(sChar)) {
                int counter = map.containsKey(sChar)?map.get(sChar):0;
                System.out.println(counter);
                counter=counter+1;
                System.out.println("Second Time "+counter);
                map.put(sChar,counter);
                count= count+counter;
            }


        }


return count;}*/

    public static int longestPalindrome(String s) {
        int count =0;
        if(s==null||s.length()==0) return 0;
        HashSet<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(set.contains(c)){
                count=count+2;
                set.remove(c);
            }
            else{
                set.add(c);
            }

        }
        if(!set.isEmpty())count++;
        return count;
    }
}
