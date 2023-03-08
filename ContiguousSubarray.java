public class ContiguousSubArray0and1 {
	     public int findMaxLength(int[] nums) {
		        HashMap <Integer, Integer> hashmap = new HashMap<Integer, Integer>();
		        int max = 0;
		        hashmap.put(0, -1);
		        int sum = 0;
	            for(int i = 0; i < nums.length; i++) {
	                if(nums[i]==1)
	                    nums[i] = 1;
	                else
	                    nums[i] = -1;
	            }

		        for(int i = 0; i < nums.length; i++) {
		        	sum += nums[i];
		        	if(hashmap.containsKey(sum)) {
		        		max = Math.max(max, i - hashmap.get(sum));
		        	}
		        	else
		        		hashmap.put(sum, i);
		        }
		        
		        return max;
		    }
}
