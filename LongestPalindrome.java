import java.util.HashSet;

public class LongestPalindrome {
    public static int longestPalindrome(String s) {
        HashSet<Character> set = new HashSet<>();
        int count = 0;
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            //Check in hashset if elements exists, if pair matches then remove from set else add it
            if(set.contains(ch)){
                set.remove(ch);
                count +=2;
            }else{
                set.add(ch);
            }
        }
        //If hashset is not empty then add 1 of the element from set
        if(!set.isEmpty()){
            count++;
        }
        return count;
    }
    public static void main(String[] args){
        String s = "abccccdd";
        System.out.println(longestPalindrome(s));
    }

}
