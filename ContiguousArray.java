// Time Complexity: O(n)
// Space Complexity: O(n)

// Using Running sum approach
class Solution {
    public int findMaxLength(int[] nums) {
        int len = 0;
        Map<Integer, Integer> map = new HashMap<>();
        int running_sum = 0;

        map.put(0, -1); //Initializing dummy index as [1,0,1,0] in this case the normal code will not work

        for(int i=0; i< nums.length; i++){
            if(nums[i] == 0) running_sum--;
            else running_sum++;

            if(map.containsKey(running_sum)){
                len = len < i - map.get(running_sum) ?  i - map.get(running_sum) : len;
            }else{
                map.put(running_sum, i);
            }
        }
        return len;
    }
}