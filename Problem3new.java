//TC : O(N) - looping through entire string once.
//SC : O(N) - worst case store all string chars whihc are unique.


import java.util.HashMap;
import java.util.Map;

 public class D9_HashMap2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		longPalindrome l = new longPalindrome();
		String s ="abcd";
		System.out.println(s.length());
		System.out.println(l.longestPalindrome(s));
		
	//	aaa r aaa cb aaaa b aaa b
	}

}

class longPalindrome {
    public int longestPalindrome(String s) {
         HashMap<Character, Integer> charCount = new HashMap<Character, Integer>();
        if(s == null || s.length() == 0) return 0;
        boolean isOneFound = false;

        for(char c: s.toCharArray()){
            charCount.put(c, charCount.getOrDefault(c,0) + 1);
        }

        int length = 0;
        for(Map.Entry<Character, Integer> e : charCount.entrySet()){
            int val = e.getValue();
            if(val % 2 == 1 && !isOneFound) {
                isOneFound = true;
                length = length + val;
            } else  {
                length = length +  ((val % 2 == 1) ? (val - 1) : val);
            }
        }
        return length;
    }
}
