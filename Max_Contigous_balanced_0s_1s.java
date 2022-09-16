class Solution {
    public int findMaxLength(int[] nums) {
        
        if (nums == null || nums.length == 0) return 0;
        
        HashMap<Integer, Integer> hMap = new HashMap<>();
        
        hMap.put(0, -1);
        int sum = 0;
        int result = 0;
        
        for(int i = 0; i < nums.length; i++) {
            
            if(nums[i] == 1) {
                sum = sum + 1;
                if (hMap.containsKey(sum)) {
                    result = Math.max(result, i - hMap.get(sum));
                }
                else {
                    hMap.put(sum, i);
                }
            } else {
                sum = sum - 1;
                if (hMap.containsKey(sum)) {
                    result = Math.max(result, i - hMap.get(sum));

                }
                else {
                    hMap.put(sum, i);
                }
            } 
        }
        return result;
    }
}
