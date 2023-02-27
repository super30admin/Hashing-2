public class ContiguousArray {
    public int findMaxLength(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,-1);
        int max = 0, rSum=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==1){
                rSum++;
            }else{
                rSum--;
            }
            if(map.containsKey(rSum)){
                max = Math.max(max,i-map.get(rSum));
            }else{
                map.put(rSum,i);
            }
        }
        return max;
    }
}

// TC - O(n)
// SC - O(n)