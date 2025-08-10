//Problem 560 : Subarray Sum Equals K
//Solved successfully on leetcode and faced no issues
//TC : o(n) Sc:O(n)


class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer,Integer>h1 = new HashMap<>();
        h1.put(0,1);

        int count = 0;
        int runningsum = 0;
        for(int i=0;i<nums.length;i++){
            runningsum = runningsum + nums[i];
            if(h1.containsKey(runningsum - k)){
                count+= h1.get(runningsum-k);


            }  
            if(!h1.containsKey(runningsum)){
                h1.put(runningsum,0);
            }
            h1.put(runningsum , h1.get(runningsum) + 1);
       
        } 
        return count;     

    }
}