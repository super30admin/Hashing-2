public class MaxContiguousArray {
    // TC is O(n) where n is nums length
    // SC is O(n) which holds the running sum
        public int findMaxLength(int[] nums) {
            int n = nums.length;
            int[] sumArray = new int[n];
            if(nums.length == 1) return 0;
            sumArray[0] = nums[0] == 0? -1: 1;
            int max = 0;
            for(int i=1; i<n; i++){
                if(nums[i] == 0)
                {
                    sumArray[i] = sumArray[i-1]-1;
                }else {
                    sumArray[i] = sumArray[i-1]+1;
                }
            }
            Map<Integer, Integer> runningMap = new HashMap<>();
            runningMap.put(0,-1);
            for(int i=0;i<n;i++){
                if(runningMap.get(sumArray[i]) != null){
                    max = Math.max(max, i-runningMap.get(sumArray[i]));
                }else{
                    runningMap.put(sumArray[i],i);
                }
            }
            return max;
        }
}
