
// //1) Subarray Sum Equals K 
// // Time Complexity : O(n)
// // Space Complexity : O(n)
// // Did this code successfully run on Leetcode :
// // Any problem you faced while coding this :


// Your code here along with comments explaining your approach
lass Solution {
    public int subarraySum(int[] nums, int k) {

        int count = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        int rsum = 0;
        map.put(0,1);

        for(int i =0; i<nums.length ;  i++){
            rsum = rsum + nums[i];
            if(map.containsKey(rsum-k)){
                count = count + map.get(rsum-k); 
            }
            map. put(rsum, map.getOrDefault(rsum,0)+1);
        }

        return count;
        
    }
}


//2) Contiguous Array
// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :
class Solution {
    public int findMaxLength(int[] nums) {

        if(nums == null || nums.length == 0){ return 0;}

    int rsum = 0;
    int max = 0;
    HashMap<Integer, Integer > map = new HashMap<>();
    map.put(0, -1);
    int n = nums.length;

    for (int i = 0; i< n; i++){

        if(nums[i] ==1){
            rsum = rsum +1;
        
        }else{
            rsum = rsum - 1;
        }

        if (map.containsKey(rsum)){

            max = Math.max(max, i- map.get(rsum));
    
        }
        else{
            map.put(rsum, i);
        }
    }
     return max;
    }
}


//3) Longest Palindrome
// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :

class Solution {
    public int longestPalindrome(String s) {

        HashSet<Character> set = new HashSet<>();
        int n = s.length();
        int count = 0;

        for(int i= 0; i<n ; i++){
            char c = s.charAt(i);
            if (set.contains(c)){
                count = count + 2;
                set.remove(c);
            }
            else{
                set.add(c);
            }
        }

        if(!set.isEmpty()){
            count++;
        }
        return count;  
    }
}