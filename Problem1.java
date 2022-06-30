// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
class Solution {
    public int findMaxLength(int[] nums) {
        
        int max=0,rsum=0;
        int[] rsumArray=new int[nums.length];
        HashMap<Integer,Integer> map= new HashMap<>();
        map.put(0,-1);
        for(int i=0;i<nums.length;i++){
            if(nums[i]==1){
                rsum=rsum+1;
            }
            else{
                rsum=rsum-1;
            }
            if(map.containsKey(rsum)){
                    if((i-map.get(rsum))>max){
                        max=i-map.get(rsum);
                    }
                }
                else{
                    map.put(rsum,i);
                }
        }
        return max;
    }
}