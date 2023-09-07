
// TC O(n)
// SC O(1)

public class longestPalindrome {
    
    public static void main(String args[]){
        longestPalindrome l = new longestPalindrome();

        String s = "abccccdd";
        int result = l.longestPalindromeSequence(s);

        System.out.println(result);
    }

    public int longestPalindromeSequence(String s) {
        int[] count = new int[128];
        int length = 0;
        boolean hasOddFrequency = false;

        for(char ch: s.toCharArray()){
            count[ch]++;
        }

        
        for(int i=0; i<count.length; i++){
            System.out.println(count[i]);
            if(count[i]%2 == 0){
                length += count[i];
            }else{
                length += count[i] - 1;
                hasOddFrequency = true;
            }
        }

        if(hasOddFrequency){
            length++;
        }

        return length;
    }
}