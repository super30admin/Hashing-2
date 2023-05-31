//First we check if target -currentRunningSum is present in our hashmap
//If present then then we increase the count by the frequency of the respective key.
//
class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        hashMap.put(0,1);
        int rSum = 0; int count = 0;
        for (int i=0;i<nums.length;i++)
        {
            rSum += nums[i];
            int x = rSum - k;
            if(hashMap.containsKey(x))
            {
                count += hashMap.get(x);
            }
            if(!hashMap.containsKey(rSum))
            {
                hashMap.put(rSum,1);
            }
            else {
                hashMap.put(rSum,hashMap.get(rSum)+1);
            }
        }
        return count;

    }
}