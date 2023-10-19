// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

//Longest Palindrome String
#Time Complexity -> O(n) as we are interating over the String
#Space Complexity - >O(26) or O(1) or constant as there will be no more than 26 english characters in the set therefore constant space
class Solution { 
    public int longestPalindrome(String s) {

        Set<Character> hs = new HashSet();
        int length = s.length();
        int palindromeLength = 0;
        for(int i=0;i<length;i++){
            Character ch = s.charAt(i);
            if(hs.contains(ch)){
              palindromeLength += 2;
              hs.remove(ch);
            }
            else{
                hs.add(ch);
            }
        }
        if(!hs.isEmpty()){
            palindromeLength +=1;
        }

        return palindromeLength;        
    }
    
}

//Continous Array 
//Time Complexity -> O(n) -> we will traverse the array only once
//Space Complexity -> O(n) -> we can have n running sum 
class Solution {
    //Using hashMap
    public int findMaxLength(int[] nums) {
        Map<Integer,Integer> map = new HashMap();
        int rsum = 0;
        int max = 0;
        map.put(0,-1); //making a dummy entry to count for initial sub array
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0){
                rsum --;
            }
            else{
                rsum ++;
            }
            if(map.containsKey(rsum)){
               max = Math.max(max,i-map.get(rsum));
            }
            else{
                map.put(rsum,i);
            }
        }

        return max; 
        
    }
}

//Subarray equal to k
//Time Complexity - >O(n) -> we will traverse the array only once
//Space Complexity -> O(n) -> in the worst case we can add n rsum
class Solution {
    //O(n solution)
    public int subarraySum(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap();
        int n = nums.length;
        int rsum = 0;
        int count = 0;
        map.put(0,1); //Dummy entry to add 0 as rsum as we can't miss the initial sub array and it indicates rsum 0 is encountered before'
        for(int i=0;i<n;i++){
            rsum += nums[i];
            int complement = rsum - k;
            if(map.containsKey(complement)){
                 count += map.get(complement);                
            }
            if(map.containsKey(rsum)){
                map.put(rsum,map.get(rsum)+1);
            }else{
                map.put(rsum,1);
            }
        }
        

        return count;
    }
}

