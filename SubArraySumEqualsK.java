/*
Time Complexity - O(n) where n is the size of array nums.
Space Complexity - O(n)
*/
class SubArraySumEqualsK {
    public int subarraySum(int[] nums, int k) {

       if(nums == null || nums.length == 0)
            return 0;

       int rsum = 0, count = 0;
       Map<Integer,Integer> map = new HashMap<>();
       map.put(0,1);

       for(int n:nums) {
            rsum = rsum + n;            
            if(map.containsKey(rsum - k))
                count = count + map.get(rsum - k);        
            map.put(rsum, map.getOrDefault(rsum, 0) + 1);
       } 
       return count;
    }
}
