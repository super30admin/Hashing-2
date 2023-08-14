class Solution {
    public int longestPalindrome(String s) {
        HashSet<Character> set = new HashSet<>();
        Integer count = 0;
        for(Character iter:s.toCharArray()){
            if(!set.contains(iter)){
                set.add(iter);
            }else{
                count+=2;
                set.remove(iter);
            }
        }
        return count + (set.size()>0 ? 1:0);
    }
}
