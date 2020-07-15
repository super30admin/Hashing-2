class Solution {
    public int longestPalindrome(String s) {
        HashSet<Character> set = new HashSet<Character>();
        int count = 0;
        for(Character c : s.toCharArray()){
            if(set.contains(c)){
                set.remove(c);
                count += 2;
            }
            else{
                set.add(c);
            }
        }
        if(!set.isEmpty()){
            count++;
        }
        return count;
    }
}
