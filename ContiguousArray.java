// Time Complexity : O(n2)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach


/*
    use two loops and try nested iterations 
    If it is 0 increase sum else decrease 1 
    if sum == 0 update maxlength variable
    return count
 */
class Solution {
    public int findMaxLength(int[] nums) {
        int sum = 0;
        int maxLen = 0;
        for(int i = 0; i < nums.length; i++){
            sum = nums[i] == 0 ? sum + 1 : sum - 1;
            for(int j = i+1; j< nums.length; j++){
                if(nums[j] == 0)
                    sum++;
                else
                    sum--;
                if(sum == 0){
                     maxLen = Math.max(maxLen,j-i+1);
                }
                   
            }
            sum = 0;
        }
        return maxLen;
    }
}


// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach


/*
    Initialize HashMap
    If it is 0 increment prefix, else decrement prefix
    If HashMap already contains the prefix update maxlength to get the index where prefix was there till i
    else store the prefix and index
    return maxLen
 */
class Solution {
    public int findMaxLength(int[] nums) {
        HashMap<Integer,Integer> hm = new HashMap<>();
        int prefix = 0;
        int maxLen = 0;
        hm.put(0,-1);
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 0)
                prefix++;
            else
                prefix--;
             if(hm.containsKey(prefix))
                maxLen = Math.max(maxLen, i - hm.get(prefix));
                else
                    hm.put(prefix,i);
           

        }
        return maxLen;
    }
}

