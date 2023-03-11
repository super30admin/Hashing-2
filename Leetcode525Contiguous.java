//Time Complexity:O(n)
//Space Complexity:O(1)
class Solution {
    public int findMaxLength(int[] nums) {

        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int rsum =0 ;
        int maxlen=0;

        for(int i=0; i<nums.length; i++)
        {
            if(nums[i]==0){
                rsum--;
            }
            else{
                rsum++;
            }
            if(map.containsKey(rsum)){
              maxlen = Math.max(maxlen, i-map.get(rsum));
            }
            else{map.put(rsum, i);
}
            
        }
        return maxlen;
        
    }
}
