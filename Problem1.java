public class Problem1 {
    //Time complexity : O(n)
    //Space complexity : O(n)
    public int subarraySum(int[] nums, int k) {
    
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        int rsum=0;
        int count=0;
        for(int i=0; i<nums.length;i++){
            rsum+=nums[i];
            if(map.containsKey(rsum-k)){
                  count+=map.get(rsum-k);
            }
         map.put(rsum,map.getOrDefault(rsum,0)+1);
        }
          return count;
      }
  }
}
