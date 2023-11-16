//Time Complexity: O(n)
//Space Complexity: O(n)
class ContiguousArray {
    public int findMaxLength(int[] nums) {

        int rSum = 0;
        int max = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0,-1);

        for(int i=0; i< nums.length; i++){
            if(nums[i] == 0) rSum--;
            else rSum++;

            if(map.containsKey(rSum)){
                max = Math.max(max, i - map.get(rSum));
            } else {
                map.put(rSum, i);
            }
        }
        return max;
    }
}