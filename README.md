# Hashing-2

Explain your approach in **three sentences only** at top of your code


## Problem1 (https://leetcode.com/problems/subarray-sum-equals-k/)
// Time Complexity : o(n)
// Space Complexity : o(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
1. Create a hashmap storing sum and frequency;
2. calculate sum - k, if this is present in hashmap then result+= frequency of that sum; 
3. put the current sum and its frequency into the hashmap

class Solution {
    public int subarraySum(int[] nums, int k) {
        if(nums == null || nums.length==0) return 0;

        Map<Integer, Integer> hm = new HashMap<>();
        hm.put(0,1);
        int sum = 0;
        int result = 0;

        for(int i=0; i<nums.length; i++){
            sum += nums[i];
            int currSum = sum - k;

            if(hm.containsKey(currSum)){
                result += hm.get(currSum);
            }

            hm.put(sum, hm.getOrDefault(sum, 0)+1);
        }
        return result;
    }
}


## Problem2 (https://leetcode.com/problems/contiguous-array/)
// Time Complexity : O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
1. We will create a hashmap to store the sum and the index we got that sum
2. if the sum is already present then that means we have equal number of 0's and 1's 
   from the next index where the sum was first found to the current index

class Solution {
    public int findMaxLength(int[] nums) {
        if(nums == null || nums.length == 0) return 0;

        Map<Integer, Integer> hm = new HashMap<>();
        hm.put(0, -1); 
        int sum = 0, result = 0;

        for(int i = 0; i < nums.length; i++){
            sum += (nums[i] == 0) ? -1 : 1;

            if(hm.containsKey(sum)){
                result = Math.max(result, i - hm.get(sum));
            } else {
                hm.put(sum, i);
            }
        }

        return result;
    }
}

## Problem3 (https://leetcode.com/problems/longest-palindrome)
// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
1. We will create a hashmap to store characters of the string as keys and their frequency as value
2. we will see if the freq is even then we will increment our result with 2
3. we will run another for loop to check if we had any odd values and if yes we will increment the final value of the result with 1
class Solution {
    public int longestPalindrome(String s) {
        if(s.length() == 1) return 1;

        Map<Character, Integer> hm = new HashMap<>();
        int result = 0;

        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if(hm.containsKey(c)) {
                int freq = hm.get(c) + 1;
                hm.put(c, freq);

                if(freq % 2 == 0) {
                    result += 2;
                }
            } else {
                hm.put(c, 1);
            }
        }

        
        for (int freq : hm.values()) {
            if (freq % 2 == 1) {
                result += 1;
                break; 
            }
        }

        return result;
    }
}
