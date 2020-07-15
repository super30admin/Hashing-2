class Solution {
    public int findMaxLength(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int currentSum = 0;
        int maxLength = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 0){
                currentSum -= 1;
            }
            else{
                currentSum += 1;
            }
            if(currentSum==0) maxLength = i + 1;
            if(map.containsKey(currentSum)){
                maxLength = Math.max(maxLength, i - map.get(currentSum));
            }
            else{
                map.put(currentSum, i);
            }
        }
        return maxLength;
    }
}
