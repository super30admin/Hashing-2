// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
class Solution {
    public int findMaxLength(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int temp=0;
        int sum=0;
        int n = nums.length;
        map.put(0,-1);
        for(int i=0;i<n;i++){
            if(nums[i]==1){
                sum+=1;
            }else{
                sum-=1;
            }
            if(map.containsKey(sum)){
                int diff =i-map.get(sum);
                temp= Math.max(temp,diff);
            }else{
                map.put(sum,i);
            }
        }
        return temp;
    }
}
/* Uses Pattern Running Sum (v.common) - whenever see balanced subbarray where sum or product is asked or use, use this method*/
