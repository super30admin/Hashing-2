import java.util.HashMap;

//TC O(n)
//SC O(n)

class MaxLengthContiguousArray {

    public static void main(String args[]){
        MaxLengthContiguousArray max = new MaxLengthContiguousArray();

        int[] nums = {0,1}
        int result = max.findMaxLength(null);

        System.out.println(result);
    }

        public int findMaxLength(int[] nums) {
        int runningSum = 0;
        int max = 0;
        //map storing runningsum, index
        HashMap<Integer, Integer> map = new HashMap<>();

        //defaultvalue at running sum0 index -1
        map.put(0,-1);

        for(int i=0; i<nums.length; i++){
            if(nums[i] == 1){
                runningSum = runningSum + 1;
            }else{
                runningSum = runningSum - 1;
            }
            int currentMax = 0;
            if(map.containsKey(runningSum)){
                currentMax = i - map.get(runningSum);
                max = Math.max(max, currentMax);
            }else{
                map.put(runningSum, i);
            }
        }

        return max;
        
    }



}
