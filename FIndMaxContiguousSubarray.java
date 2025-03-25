//Time Complexity: O(n)
//Space Complexity: O(n)
//Did this code successfully run on Leetcode : Yes

/*Approach:
1. Find the running sum of the array with +1 and -1 for every 1's and 0's respectively.
2. Store the running sum and the first occurring index of that sum in a hashmap
3. If a running sum occurs again, it implies equal no of 0's and 1's at current index.Find the difference of current index and rSum first occurring index
4. Update maxLength counter with the higher value.
 */
class Solution {
    public int findMaxLength(int[] nums) {

        int rSum=0;
        int max=0;
        HashMap<Integer, Integer> map= new HashMap<>(); //key: rSum, value: starting index with that rSum value

        for(int i=0;i<nums.length;i++){

            if(nums[i]==0)
                rSum--;
            else
                rSum++;

            //to cover the case when the sum is 0, that means the entire subarray is contiguous till index i
            if(rSum==0){
                max=Math.max(max, i+1);
            }

            if(map.containsKey(rSum)){
                max=Math.max(max,i-map.get(rSum));  //if rSum present then find the difference from current index to initial occurrence of rSum and update max length value
            }
            else
                map.put(rSum,i);

        }

        return max;

    }
}