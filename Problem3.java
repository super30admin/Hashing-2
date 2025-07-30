import java.util.HashSet;
//For a String to be a palindrome, it should have even no.of Character repetitions, except for the middle character. So to make sure a count the even occurrences, we use a set. We check if the char is in the set or not, if the char is in the set it means we encountered it already and so we remove it from the set and increate the count by 2, if it is not in the set which means we are visiting it for the first time and we don't have to increase the count and can store it in the set till another occurrence happens. Finally we check if the set is empty to make sure we account for any add chars that can be added in the middle.
// TC is 0(n) and SC is O(1) as we can only have at max of 52 chars
public class Problem3 {
    public int longestPalindrome(String s){
        int len = 0;
        HashSet<Character> charSet = new HashSet<>();
        for(char c : s.toCharArray()){
            if(charSet.contains(c)){
                charSet.remove(c);
                len += 2;
            }else charSet.add(c);
        }
        return (charSet.isEmpty()) ? len : len+1;
    }
}
