//Time Compexity : O(n)
//Space Complexity : O(n)
// submission successful on leetcode
class Solution {
    public int findMaxLength(int[] nums) {
        
        if(nums==null || nums.length==0) return 0;
        
        HashMap<Integer, Integer> map = new HashMap<>();
        int rsum=0;
        int len=0;
        //rsum and index where rsum occurs
        map.put(0,-1);
        for(int i=0;i<nums.length;i++){
            if(nums[i]==1){
                rsum=rsum+1;
            }
            else{
                rsum--;
            }
            if(map.containsKey(rsum)){
                len=Math.max(len,i-map.get(rsum));
            }
            else{
                map.put(rsum,i);
            }
        }
            return len;
    }
}