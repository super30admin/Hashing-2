class Solution {
    public int findMaxLength(int[] nums) {
       HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int maxlen=0;
        int count=0;
       for(int i=0;i<nums.length;i++){
           count += (nums[i] == 1)?1:-1;
                // Array from index 0 to i contains equal number of 0's and 1's
    		if(count == 0)
    			maxlen = Math.max(maxlen, i+1);    		
    		if(map.containsKey(count)) {
    			maxlen = Math.max(maxlen, i - map.get(count));
    		} else 
    			map.put(count, i);
           
        }
        return maxlen;
    }
}
