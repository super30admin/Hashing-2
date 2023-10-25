// TC O(n)
// SC O(n)

class Solution {
    public int findMaxLength(int[] nums) {

        //map to store the prefix sum and when it has occured for the first time
        Map<Integer,Integer> map= new HashMap<>();

        // to handle the edge case
        map.put(0,-1);

        int preFixSum=0;
        int maxLen=0;

        for(int i=0; i<nums.length; i++){

            int num= nums[i];

            //consider 0 as -1
            preFixSum+= num==0? -1:num;

            //if we encounter the prefix sum then update the maxLen by comparing the old maxLen and the new length of the subarray with sum (Prefix-'0')
            // new length is (current index-index of first occurence)
            if(map.containsKey(preFixSum)){
                maxLen= Math.max(maxLen,i-map.get(preFixSum));
            }
            //if we encounter it for the first time then store the index of the first occurence
            else{
                map.put(preFixSum,i);
            }
        }
        return maxLen;
    }
}