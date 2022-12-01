class subArraySumK {
    /*
    Approach : using rSum Pattern to reduce the number of comparisons.
    Using hashMap for easy lookup. Map will contain (rsum, how many times it occured).

    Time complexity: o(n)
    Space complexity : o(n)

    where n is size of the input array.
     */
    public int subarraySum(int[] nums, int k) {

        int rSum =0;
        int result =0;
        //sum, how many times it has occured
        Map<Integer, Integer> map = new HashMap<>();
        //sum 0 has occured one time
        map.put(0,1);
        for(int i=0;i< nums.length;i++){
            rSum =rSum+nums[i];
            if(map.containsKey(rSum-k)){
             result =result+ map.get(rSum-k);
            }
            if(!map.containsKey(rSum)){
             map.put(rSum,1);
            }else{
                map.put(rSum, map.get(rSum)+1);
            }


        }
        return result;

    }
}