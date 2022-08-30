# Hashing-2

## Problem1: Subarray Sum Equals k

```Java
// Time Complexity : O(n)
// Space Complexity : O(n) 
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int currentSum = 0;
        int count = 0;
        map.put(0,1);

        for(int i = 0; i < nums.length; i++){
            currentSum += nums[i];
            if(map.containsKey(currentSum - k)){
                count += map.get(currentSum-k);
            }
            if(map.containsKey(currentSum)){
                int newCount = map.get(currentSum);
                newCount++;
                map.put(currentSum,newCount);

            }
            else {
                map.put(currentSum,1);
            }
        }
        return count;
    }
}
```
## Problem2: Contiguous Array

```Java
// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class Solution {
    public int findMaxLength(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        int max = 0;
        int zero = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0)
                zero++;

            else
                zero--;

            if (zero == 0)
                max = i + 1;

            if (!map.containsKey(zero))
                map.put(zero, i);

            else
                max = Math.max(max, i - map.get(zero));
        }
        return max;
    }
}
```
## Problem3: Longest Palindrome

```Java
// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class Solution {
    public int longestPalindrome(String s) {
        int count=0;
        
        HashSet<Character> set = new HashSet<>();

        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);

            if(set.contains(c)){
                count += 2;
                set.remove(s);
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
```