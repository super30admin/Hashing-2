import java.util.HashSet;

public class LongestPalindromeLength {


        public int longestPalindrome(String s) {

            int count = 0;

            int n = s.length();

            HashSet set = new HashSet<>();  // O(1)

            for(int i = 0; i < n; i++){ // O(n)

                char c = s.charAt(i);

                if(set.contains(c)){

                    count += 2;
                    set.remove(c);

                }else{

                    set.add(c);
                }
            }

            if(!set.isEmpty()){

                count++;
            }
            return count;
        }


        /*
        O(n) - time complexity - for loop
        O(1) - maximum size of set is constant i.e., number of alphabets possible
        */

        public static void main(String[] args){

            LongestPalindromeLength object = new LongestPalindromeLength();

            String check = "abccccdd";

            int result = object.longestPalindrome(check);

            System.out.println("Length of longest palindrome possible is "+ result);

        }

}
