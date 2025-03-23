class Solution {
    public int findMaxLength(int[] nums) {
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>(); //rSum : index

        int max = 0;
        int rSum = 0;
        map.put(0,-1); //that arrays is balanced from the 0th index

        for (int i=0; i<n; i++){
            int num = nums[i];
            if(num == 0) rSum--;
            else rSum++;

            if(map.containsKey(rSum)){
                max = Math.max(max, i - map.get(rSum));
            } else{
                map.put(rSum,i);
            }
        }
        return max;
    }
}
