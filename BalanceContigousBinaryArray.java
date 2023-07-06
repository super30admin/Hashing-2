import java.util.HashMap;

import java.util.Map;

class BalanceContigousBinaryArray {
    public int findMaxLength(int[] nums) {
        if(null == nums || nums.length == 0) return 0;
        Map<Integer, Integer> sumEarliestMap = new HashMap<>();
        sumEarliestMap.put(0, -1);
        int runningSum = 0;
        int maxLength = 0;
        for(int currentIndex=0; currentIndex< nums.length; currentIndex++){
            if(nums[currentIndex] == 0){
                runningSum = runningSum -1;
            }else{
                runningSum = runningSum + 1;
            }
            if(sumEarliestMap.containsKey(runningSum)){
                int earliestIndex = sumEarliestMap.get(runningSum);
                if(currentIndex - earliestIndex > maxLength){
                    maxLength = currentIndex - earliestIndex;
                }
               // maxLength = Math.max(maxLength, currentIndex - sumEarliestMap.get(runningSum));
            }else{
                sumEarliestMap.put(runningSum, currentIndex);
            }
        }

        return maxLength;

    }
}