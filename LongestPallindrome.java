import java.util.HashMap;
import java.util.Map;

public class LongestPallindrome {
    //Time complexity: O(N)
    //Space Complexity: O( total number of alphabets): constant
    public int longestPalindrome(String s) {
        Map<Character, Integer> map = new HashMap<>();

        for(int i= 0; i< s.length(); i++){
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0)+ 1);
        }
        int longest = 0;
        boolean containsOdd = false;
        for(char ch: map.keySet()){
            longest+= (map.get(ch)%2 ==0? map.get(ch): map.get(ch) - 1);
            if(!containsOdd){
                containsOdd = map.get(ch) % 2 == 1;
            }
        }
        if(containsOdd){
            return longest + 1;
        }

        return longest;

    }
}
