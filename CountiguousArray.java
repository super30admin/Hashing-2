// Time Complexity : o(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes

class CountiguousArray{
    public int findMaxLength(int[] nums){
        HashMap<Integer, Integer> map = new HashMap<>();
        int rsum = 0;
        int max = 0;
        // Putting dummmy value in map sum is 0 and index is -1
        map.put(0, -1); 
        for(int i=0; i< nums.length; i++){
            id(nums[i]==0){
                rsum--;
            }else{
                rsum++;
            }
            if(map.containsKey(rsum)){
                max = Math.max(max, i-map.get(rsum))
            }else{
                map.put(rsum,i);
            }
        }
        return max;
    }
}