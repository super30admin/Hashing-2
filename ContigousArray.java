class Solution {
    public int findMaxLength(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,-1);
        int rsum = 0;
        int length = 0;

        for(int i=0; i<nums.length; i++){
          if(nums[i]==1){
              rsum += 1;
          }
          else{
              rsum -= 1;
          }
          if(map.containsKey(rsum)){
              length = Math.max(length, i - map.get(rsum));

          }
          else{
              map.put(rsum,i);
          }
        }
        return length;
    }
}





/**
TC : O(n) --> Length of the array

SC : O(n) --> HashMap

BruteForce : Using Nested Iterations, we can create possible subsets. It takes O(n^2) and to check each subset whether its balanced or not. It takes O(k). So overall O(n^2) + k. Higher Order term matters so O(n^2). We can optimise this by caliculating running sum and maining at every index.(z= y-x). 

Description : Assuming Rsum '0' in the -1 index. By this we can check the first subset of array.
              Then Just caliculating Rsum and checking whether Rsum exists inside Hashmap. If It exists then subtracting Current index with Hashmap value, to know the length.
              If Rsum is not present inside HashMap, then appending key as rsum and value as its index.




 */