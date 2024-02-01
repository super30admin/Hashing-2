//TimeComplexity:O(n)

class Solution {
    public int findMaxLength(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
          map.put(0,-1);
          int remainingSum = 0;
          int maximum =0;
          for(int i =0; i<nums.length;i++) {
              if(nums[i] == 1) {
                  remainingSum = remainingSum+1;
              } else {
                   remainingSum = remainingSum-1;
              }
              if(map.containsKey(remainingSum)) {
                  maximum = Math.max(maximum, i-map.get(remainingSum));
              } else {
                  map.put(remainingSum, i);
              }
          }
          return maximum;
    }
}
