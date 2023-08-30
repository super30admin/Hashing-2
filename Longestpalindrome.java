class Solution {
    public int longestPalindrome(String s) {
        HashSet<Character> set = new HashSet<>();
        int count = 0;

        for(int i=0; i<s.length(); i++){
          char schar = s.charAt(i);

          if(set.contains(schar)){
            set.remove(schar);
            count += 2;
          }
          else {
            set.add(schar);
          }
        }
        if(!set.isEmpty()){
          return count +=1;
        }
        else {
          return count;
        }




    }
}





/**
TC : O(n) --> Length of the String

SC : O(1) --> As we have 26 aplhabets, Space is constant 

Description : Checking char inside HashSet, If char exists then forming a pair and removing that char from HashSet. At last Checking whether Hashset is empty or not, if it is not empty then adding 1 to count.


 */