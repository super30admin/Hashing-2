//Problem 525 Contiguous Array
//Solved successfully on leetcode and faced no issues
//TC:O(n) Sc:O(n)


class Solution {
    public int findMaxLength(int[] nums) {
        HashMap<Integer,Integer>h1 = new HashMap<>();
        h1.put(0, -1);

        int runningsum = 0;
        int maximumlength = 0;
        for(int i = 0 ; i < nums.length ; i++){
            if(nums[i] == 0){
                runningsum = runningsum-1;
            }
            else{
                runningsum = runningsum+1;
            }
            if(h1.containsKey(runningsum)){
                maximumlength = Math.max(maximumlength , i - h1.get(runningsum));

            }
            else{
                h1.put(runningsum , i);
            }
        }
        return maximumlength;
        
    }
}