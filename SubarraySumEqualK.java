class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        int rsum =0;
        int cal =0;
        int result = 0;

        for(int i =0; i<nums.length; i++){

            rsum += nums[i];
            
            if(map.containsKey(rsum - k)){
                result += map.get(rsum - k);

            }
            if(!map.containsKey(rsum)){
                map.put(rsum,1);
            }
            else{
                int oldCount = map.get(rsum);
                oldCount++;
                map.put(rsum,oldCount);
            }
           

        }
        return result;
    }
}




/**
TC : O(n) --> length of the array

Sc : O(n) --> Stroting the Rsum and its frequency.


Description : In BruteForce, it takes nested iterations to for sub arrays and it takes k time to check whether the sub array sum is equal to k. SO TC here --> O(n^2).
              Optimising by Caliculating running sum at every number, By this we can eleminate nested iterations 

              whenever we are using the Rsum approach, we are storing Rsum as an index inside the hashmap. HashMap values will change according to the problem.
               First, Checking whether the target contains (k-number) inside HashMap. Then storing Rsum and number of occurrences.





 */