/* Problem 1:
// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : yes
*/

class ContiguousArray {
    public int findMaxLength(int[] nums) {

        Map<Integer,Integer> map = new HashMap<>();
        int rSum = 0;
        map.put(0,-1);
        int max = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0){
                rSum-=1;
            }else{
                rSum+=1;
            }
            if(map.containsKey(rSum)){
                max = Math.max(max,i-map.get(rSum));
            }else{
                map.put(rSum,i);
            }

        }
        return max;
       
    }
}