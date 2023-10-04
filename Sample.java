// ## Problem1 (https://leetcode.com/problems/subarray-sum-equals-k/)
// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : I didnt face any problem while coding this.
class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int count = 0;
        int sum = 0;
        map.put(0,1);
        for(int i=0; i<nums.length; i++){
            sum = sum + nums[i];
            int key = sum-k;
            if(map.containsKey(key)){
                count = count + map.get(key);
            }
            map.put(sum, map.getOrDefault(sum, 0)+1); 
        }
        return count;
    }
}

// ## Problem2 (https://leetcode.com/problems/contiguous-array/)
// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : I didnt face any problem while coding this.
class Solution {
    public int findMaxLength(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        map.put(0,-1);
        int start = 0, end = 0;
        int max = 0;
        for(int i=0; i< nums.length; i++){
            if(nums[i] == 0){
                sum = sum - 1;
            }else{
                sum = sum + 1;
            }
            if(map.containsKey(sum)){
               if(max < i-map.get(sum)){
                   //to find the start index of the longest sub array
                   max = Math.max(max, i-map.get(sum));
                   start = map.get(sum) + 1;
                   end = i;
               }
               
            }else{
                map.put(sum,i);
            }
        }
        return max;
    }
}

// ## Problem3 (https://leetcode.com/problems/longest-palindrome)
// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : I didnt face any problem while coding this.


// Your code here along with comments explaining your approach

class Solution {
    public int longestPalindrome(String s) {
        HashSet<Character> set = new HashSet<>();
        int count = 0;
        for(int i=0; i<s.length(); i++){
            
            char c = s.charAt(i);
            if(set.contains(c)){
                count = count + 2;
                set.remove(c);
            }else{
                set.add(c);
            }
        }
        if(!set.isEmpty()){
            count = count + 1;
        }
        return count;
    }
}

