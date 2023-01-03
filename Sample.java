// Subarray Sum Equals K
class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0,1);
        int rSum = 0;
        int count = 0;
        for(int i = 0; i < nums.length; i++){
            rSum+= nums[i];
            if(map.containsKey(rSum-k)){
                count+= map.get(rSum-k);
            }if(map.containsKey(rSum)){
                map.put(rSum, map.get(rSum) + 1);
            }else{
                map.put(rSum, 1);
            }
        } return count;
    }
}

//Contiguous Array
class Solution {
    public int findMaxLength(int[] nums) {
      HashMap<Integer, Integer> map = new HashMap<>();
      map.put(0,-1);
      int rSum = 0 ;
      int result = 0;
      for (int i = 0; i< nums.length; i++){
          if(nums[i] == 0){
              rSum--;
          }else{
              rSum++;
          }if(map.containsKey(rSum)){
              result = Math.max(result, i - map.get(rSum));
          }else{
              map.put(rSum,i);
          }
      }return result;
    }
}

//Longest Palindrome
class Solution {
    public int longestPalindrome(String s) {
        int count = 0;
        HashSet<Character> set = new HashSet<>();
        for(int i = 0; i<s.length(); i++){
            char C = s.charAt(i);
            if(set.contains(C)){
                count+=2;
                set.remove(C);
            }else{
                set.add(C);
            }
        } if(!set.isEmpty()){
            count++;
        }
        return count;
    }
}