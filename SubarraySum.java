class Solution {
    public int subarraySum(int[] nums, int k) {
        // maintain running sum
        // if sum exist in HashMap update its frequency
        // check at each index if  = rsum - k exist , maintain count

        HashMap<Integer,Integer> map = new HashMap<>();
        int rsum = 0;
        map.put(0,1); // initialy sum is 0 & it's occurence is 1
        int count = 0;

        for( int i = 0; i<nums.length; i++ ){
            rsum += nums[i];
            int diff = rsum - k;
            if( map.containsKey(diff)){
                count += map.get(diff);


            }

            map.put( rsum , map.getOrDefault( rsum , 0 ) + 1);

        }
        return count;


    }
}