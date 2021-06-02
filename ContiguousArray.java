class contiguousArray {

    public int findMaxLength(int[] nums) {

        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 0);
        map.put(1, 0);
        int count = 0;
        
        for (int i=0; i<nums.length; i++) {
            map.get(nums[i]) = map.get(nums[i])++;

            if (map.get(0) % 2 == 0 && map.get(1) % 2 == 0) {
                count++;
            }         
        }

        return count;

}