class Solution {
    public int findMaxLength(int[] nums) {
        // maintain running sum & index of first occurence for max length
        // running sum of 0 means equal no. of 0s & 1s found ( as at 0 sum = -1 & at 1 sum = 1)
        // starting sum = 0 at index -1
        // Use hashmap for o(1) search
        // sc : o(n) time : o(n)

        HashMap<Integer,Integer> map = new HashMap<>();
        int rsum = 0;
        map.put(0,-1); // initially rsum is 0 at the very start at -1 index
        int max = 0;

        for( int i = 0; i<nums.length; i++ ){
            if( nums[i] == 0 ){
                rsum -= 1;

            }
            else{
                rsum += 1;
            }

            if( !map.containsKey(rsum) ){
                map.put(rsum,i);
            }
            else{
                int len = i - map.get(rsum);
                max = Math.max(max,len);
            }

        }
        return max;


    }
}