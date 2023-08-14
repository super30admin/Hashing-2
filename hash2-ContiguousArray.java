// TC:O(n)
class Solution {
    public int findMaxLength(int[] nums) {
        int n= nums.length;
        int max=0;
        int rSum=0;
        
        HashMap<Integer,Integer> map= new HashMap();
        map.put(0,-1);      //rSum, index
        
        for(int i=0;i<n;i++){
            if(nums[i]==0)
                rSum--;
            else rSum++;
            
            if(map.containsKey(rSum))
                max= Math.max(max, i- map.get(rSum));   //ultimately 
stores max length of cont. arr
            else
                map.put(rSum, i);
        }
        
        return max;
    }
}
