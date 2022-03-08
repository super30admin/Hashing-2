// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class LongestPalindrome {
    public int longestPalindrome(String s) {
        HashMap<Character, Integer> hm = new HashMap<>();
        int result = 0;
        int freq = -1;
        boolean trip = false;
      
        //Build frequency map
        for(int i = 0; i < s.length(); i++){
            if(hm.containsKey(s.charAt(i))){
                freq = hm.get(s.charAt(i));
                hm.put(s.charAt(i),freq+1);
            }else{
                hm.put(s.charAt(i),1);
            }
        }
        
        // Count all evens and even sums of of odd and if at the end any odd left add 1 to result
        for(int i : hm.values()){
            if(i%2==0){
                result+=i;
            }else{
                if(trip==false){
                    trip=true;
                }
                result = result + i - 1;
            }
        }
        
        if(trip==true){
            return result + 1;
        }else{
            return result;
        }
        
    }
}
