//TC: O(n)
//SC: O(n)

//Approach2 : to get the string stat and end

import java.util.HashMap;

class Solution {
    public int findMaxLength(int[] nums) {
        int n = nums.length;
        HashMap<Integer,Integer> map = new HashMap<>(); //rSum:Index
        int max = 0;
        int rSum = 0;
        // map.put(0,-1); //array is balanced for the 0th index

        int start = 0, end = 0;

        for(int i=0; i<n; i++){
            int num = nums[i];
            if(num == 0) rSum--;
            else rSum++;

            if(rSum == 0){ // to handle 0th index 0 case
                max = Math.max(max,i+1);
            }

            if(map.containsKey(rSum)){
                if(max < i - map.get(rSum)){
                    start = map.get(rSum) + 1;
                    end = i;
                }
                max = Math.max(max, i - map.get(rSum));
            }else{
                map.put(rSum,i);
            }
        }
        System.out.println(start+""+end);
        return max;
    }
}

//
// class Solution {
//     public int findMaxLength(int[] nums) {
//         int n = nums.length;
//         HashMap<Integer,Integer> map = new HashMap<>(); //rSum:Index
//         int max = 0;
//         int rSum = 0;
//         map.put(0,-1); //array is balanced for the 0th index

//         for(int i=0; i<n; i++){
//             int num = nums[i];
//             if(num == 0) rSum--;
//             else rSum++;

//             if(map.containsKey(rSum)){
//                 max = Math.max(max, i - map.get(rSum));
//             }else{
//                 map.put(rSum,i);
//             }
//         }

//         return max;
//     }
// }