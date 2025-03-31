//Approach: Map keeps the number of times a running sum appears.
//If rSum-k is present in the map, it means there is a subarray thst sums to k.
//The frequency of rSum-k tells how many such substrings  exist upto that point.
//The result is updated with the frequency of rSum-k.
//TC: O(n)
//SC: O(n) 



import java.util.HashMap;

class SubarraySumEqualsK {
    public int subarraySum(int[] nums, int k) {

        int n = nums.length;

        HashMap<Integer, Integer> map = new HashMap<>();

        int rSum=0;
        int result = 0;

        map.put(0,1);

        for(int num: nums){
            rSum+=num;

            int cmp = rSum - k;

            if(map.containsKey(cmp)){
                result+=map.get(cmp);
            }
            map.put(rSum,map.getOrDefault(rSum, 0)+1);
        }
        return result;
        
    }
}