//TC - O(n)
//SC - O(n)

// To find contiguous binary subarray we use running sum pattern.
class ContiguosArray {
    public int findMaxLength(int[] nums) {
        
        //base case
        if(nums==null && nums.length==0){
            return -1;
        }

        int rSum = 0;
        int max = 0;

        HashMap<Integer, Integer> map = new HashMap<>();

        // Setting initial values in map for edge case.
        map.put(0,-1);

        // looping through binary array and finding max contiguous subarray
        for(int i=0; i<nums.length; i++){
            if(nums[i]==0){
                rSum+=-1;
            }
            else{
                rSum+=1;
            }

            if(map.containsKey(rSum)){
                max = Math.max(max, i - map.get(rSum));
            }
            else{
                map.put(rSum, i);
            }
        }

        return max;
    }
}