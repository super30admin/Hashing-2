// Time Complexity : O(n) - n is length of the array
// Space Complexity : O(n) - n is length of the array
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


/* Approach:
While traversing the array, calculate rSum (+1 for 1 and -1 for 0)
if we acheive same rSum again, the array between the same rSums is balanced. 
if the map contains rSum, update the max by checking it's difference with it's previous value and current max
*/
class ContiguousArray {
    public int findMaxLength(int[] nums) {
        HashMap<Integer, Integer> m = new HashMap<>();
        m.put(0,-1);
        int l = 0;
        int rSum =0;
        for(int i = 0; i < nums.length; i++ ){
            if(nums[i]==0){
                rSum--;
            }
            else if (nums[i]==1){
                rSum++;
            }
            if (m.containsKey(rSum)){
                l = Math.max(l,(i -m.get(rSum)));
            }
            else{
                m.put(rSum,i);
            }
        }
        return l;
    }
}