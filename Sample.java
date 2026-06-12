//problem 1
// Calculate running prefix sum
// Check if a previous prefix sum equal to (currentSum - k) exists
// Its frequency gives the number of subarrays ending here with sum k
// Add that frequency to the answer
// Store/update the current prefix sum frequency
class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer,Integer> map=new HashMap<>();
        int n=nums.length;
        int rsum=0;
        int count=0;
        map.put(0,1);
        for(int i=0;i<n;i++){
            rsum+=nums[i];
            if(map.containsKey(rsum-k)){
                count+=map.get(rsum-k);
            }
            if(map.containsKey(rsum)){
                map.put(rsum,map.get(rsum)+1);
            }else{
                map.put(rsum,1);
            }
        }
        return count;
    }
}
//problem 2
// Convert 0 to -1 and 1 to +1 conceptually using prefix sum
// Store the first occurrence of each prefix sum in a HashMap
// If the same prefix sum appears again, the subarray between them has sum 0
// Calculate its length and update the maximum length
// Store only the first occurrence to maximize the subarray length
class Solution {
    public int findMaxLength(int[] nums) {
        HashMap<Integer,Integer> map=new HashMap<>();
        int n=nums.length;
        int maxi=0;
        int rsum=0;
        map.put(0,-1);
        for(int i=0;i<n;i++){
            if(nums[i]==1){
                rsum+=1;
            }else{
                rsum-=1;
            }
            if(map.containsKey(rsum)){
                maxi=Math.max(maxi,i-map.get(rsum));
            }else{
                map.put(rsum,i);
            }
        }
        return maxi;
    }
}
//problem 3
// Use a HashSet to track characters with odd frequency
// If a character appears again, a pair is formed
// Add 2 to the answer and remove it from the set
// After processing all characters, if the set is not empty,
// place one remaining character in the center and add 1
class Solution {
    public int longestPalindrome(String s) {
        int n=s.length();
        int count=0;
        HashSet<Character> map=new HashSet<>();
        for(int i=0;i<n;i++){
            char ch=s.charAt(i);
            if(map.contains(ch)){
                count+=2;
                map.remove(ch);
            }else{
                map.add(ch);
            }
        }
        if(!map.isEmpty()) count+=1;
        return count;
    }
}
