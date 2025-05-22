//time complexity:O(n)
//space complexity:O(n)
//calculate the running sum, if the rsum is not their in hashmap add it and count=1(value) now we will see if the rsum-target=y has occured before if it is it means that is the subarray with sum target so increment the count by the count of the times it has occured before
class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        int count =0;
        int rsum=0;
        for(int i=0;i<nums.length;i++){
            rsum+=nums[i];
            if(map.containsKey(rsum-k)){
                count+=map.get(rsum-k);
            }
            if(!map.containsKey(rsum)){
                map.put(rsum,0);
            }
            map.put(rsum,map.get(rsum)+1);

        }
        return count;
    }
}
