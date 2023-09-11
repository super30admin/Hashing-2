                     // Subarray Sum Equals K

// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class Solution {
    public int subarraySum(int[] nums, int k) {
        // running sum, number of occurrences
        Map<Integer, Integer> map = new HashMap();
        map.put(0,1);
        int curSum = 0;
        int numOfArrays = 0;

        for(int i=0;i<nums.length;i++){
            curSum += nums[i];
            if(map.containsKey(curSum - k))
                numOfArrays += map.get(curSum - k);
            map.put(curSum, map.getOrDefault(curSum, 0) + 1);
        }

        return numOfArrays;
    }
}


                     // Contigous Array 

// Time Complexity : O(n).
// Space Complexity : O(n), if all values are either 0 or 1.
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this : 

class Solution {
    public int findMaxLength(int[] nums) {
        int maxLen = 0, netValue = 0;
        Map<Integer, Integer> map = new HashMap();
        map.put(0, -1);

        for(int i=0;i<nums.length;i++){
            if(nums[i] == 0)
                netValue--;
            else netValue++;

            if(map.containsKey(netValue))
                maxLen = Math.max(maxLen, i - map.get(netValue));
            else map.put(netValue, i);
        }
        return maxLen;
    }
}

                     // Longest Palindrome 

// Time Complexity : O(n) .. n = length of string
// Space Complexity : O(1) .. there can be max 52 unique characters (26 smallCase + 26 upperCase)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : repeatedly missed the condition of adding odd characters. Was only adding one character with odd occurrences. Then, saw solution and took even count , i.e. their occurrences - 1 and added it to the final length

class Solution {
    public int longestPalindrome(String s) {

        Map<Character, Integer> map = new HashMap();
        int maxLen = 0;
        boolean odd = true;
        for(char ch : s.toCharArray())
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        
        for(Map.Entry<Character, Integer> mapElement : map.entrySet()){
            int val = mapElement.getValue();
            if(val % 2 != 0){
                if(odd){
                    odd = false;
                    maxLen += val;
                } else maxLen += (val - 1); // very very important condition (check notes)
            } else maxLen += val;
        }

        return maxLen;
    }
}
