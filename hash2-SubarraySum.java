class Solution {
    public int subarraySum(int[] nums, int k) {
        
        // int rSum[] = new int[nums.length];
        int n= nums.length;
        int sum=0;
        
        HashMap<Integer, Integer> map= new HashMap<>();
        map.put(0,1);
        int count=0;
        
        for(int i=0;i<n;i++){
            sum += nums[i];
            // rSum[i]= sum;
            
            if(map.containsKey(sum-k)){
                count+= map.get(sum-k);
            }
            if(!map.containsKey(sum)){
                map.put(sum,0);
            }
            map.put(sum, map.get((sum))+1);
        }
        return count;
    }
}
