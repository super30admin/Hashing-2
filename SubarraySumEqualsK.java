// Time Complexity : O(n2)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach


/*
    use two loops and try nested iterations and check sum for each sub array
    if sum == k increase count
    return count
 */
class Solution {
    public int subarraySum(int[] nums, int k) {
        int sum = 0;
        int cnt = 0;
        for(int start = 0; start < nums.length; start++){
            sum += nums[start];
             if(sum == k)
                    cnt++;
            for(int end = start + 1; end < nums.length; end++){
                sum += nums[end];
                if(sum == k)
                    cnt++;
            }
            sum = 0;
        }
        return cnt;
    }
}

// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach


/*
    Keep computing the running sum and store in hashmap 
    Each time check sum - k present in Hashmap , if present that is the subarray so increment count
 */
class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer,Integer> hm = new HashMap<>();
        int sum = 0;
        int cnt = 0;
        hm.put(0,1);
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
            if(hm.containsKey(sum - k)){
                cnt += hm.get(sum-k);
            }
            hm.put(sum,hm.getOrDefault(sum,0) + 1);
        }
        return cnt;
    }
}