//We us ethe running sum pattern here
// We will be having a balanced subarray if running sum of the subarray is zero
//And we keep storing the running sum in pur hashmap and if repated the running sum 
// then we compare the currentIndex - the value of the key repeated and compare it with max
// this gives us the longest balanced sub array and the max value is returend
//for every value of zzero rsum-1;for 1 rsum+1;
//we use the z = y-x approach
//Id rSum repeats then compare the earliest Index with current Index where the rs
//rsum is repeated
class Solution {
    public int findMaxLength(int[] nums) {
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        int max = 0;
        int rSum = 0;
        //put(ruuninsum, index)
        hashMap.put(rSum,-1);
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i] == 0)
            {
               rSum -= 1;
            }
            else {
                rSum += 1;
            }
            
            if(hashMap.containsKey(rSum))
            {
                max = Math.max(max,i - hashMap.get(rSum));
                
            }
            else {
                hashMap.put(rSum,i);
            }
            

        }
        return max;
    }
}