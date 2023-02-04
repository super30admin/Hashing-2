class Solution {
    public int subarraySum(int[] nums, int k) {
     HashMap<Integer, Integer> hmap = new HashMap<>();
     hmap.put(0,1);
     int rsum=0;
     int count=0;
     for (int i : nums){
         rsum=rsum+i;
         if(hmap.containsKey(rsum-k)){
             count+=hmap.get(rsum-k);
            
         } if(hmap.containsKey(rsum)){
                 hmap.put(rsum, hmap.get(rsum)+1);
             }else hmap.put(rsum, 1);
     }
return count;
    }
}