// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


class ContiguousSubarray {
    public int findMaxLength(int[] nums) {

        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>(); //rSum : index

        int max=0;
        int rSum=0;
        // map.put(0, -1); //the array is balanced from 0th index
        int start=0, end=0;

        for(int i=0; i<n; i++) {
            int num = nums[i];
            if(num == 0) rSum--;
            else rSum++;

            // in this case, array is balanced from the beginning
            if(rSum == 0) {
                max= Math.max(max, i+1);
            }
            else if(map.containsKey(rSum)) {
                if(max < i - map.get(rSum) ) {
                    start = map.get(rSum) + 1;
                    end=i;
                }
                max= Math.max(max, i - map.get(rSum));
            }
            else {
                map.put(rSum, i);
            }
        }
        System.out.println(start + " "+ end);
        return max;
        
    }
}