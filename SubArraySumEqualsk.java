//Time Complexity: O(n)
//Space Complexity : O(n)

// this approach has a runSum and checks the complement values everytime we had a runSum( which means we had a subarray of sum k present and then increase the count based on that)


class Solution {
    public int subarraySum(int[] nums, int k) {
        int totalCount = 0;
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        map.put(0,1);
        int runSum = 0;
        for(int i = 0; i < nums.length; i++){
    
            runSum = runSum+ nums[i];
            int cmp = runSum - k;


            if(map.containsKey(cmp)){
                totalCount = totalCount + map.get(cmp);
            }
         map.put(runSum, map.getOrDefault(runSum, 0) + 1);
            }
            return totalCount;

        }      
    
}