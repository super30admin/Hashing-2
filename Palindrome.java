public class Palindrome {
    // TC is O(n) where n is string length
    // SC is constant as O(26)
    public int longestPalindrome(String s) {
        Set<Character> chars = new HashSet<>();
        int n = s.length();
        int count = 0;
        for(int i=0;i<n;i++){
            Character curr = s.charAt(i);
            if(chars.contains(curr)){
                chars.remove(curr);
                count += 2;
            }else {
                chars.add(curr);
            }
        }
        if(!chars.isEmpty()){
            count++;
        }
        return count;
    }
}
