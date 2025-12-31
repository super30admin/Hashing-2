public class TestHashing2 {
    public static void main(String[] args) {
        SubArraySumK obj = new SubArraySumK();
        int [] nums1 = {1,1,1};
        int [] nums2 = {1,2,3};
        System.out.println("Total Number of subarrays whose sum equals to " + 2 + " is " + obj.subarraySum(nums1,2));
        System.out.println("Total Number of subarrays whose sum equals to " + 3 + " is " + obj.subarraySum(nums2,3));
        // Test longest palindrome
        LongestPalindrome obj2 = new LongestPalindrome();
        String s = "abccccdd";
        String s2 = "a";
        System.out.println("length of the longest palindrome that can be built with those letters of the String " + s + " is "+ obj2.longestPalindrome(s));
        System.out.println("length of the longest palindrome that can be built with those letters of the String " + s2 + " is "+ obj2.longestPalindrome(s2));

        // Test Contiguous Array
        BinarySubArray obj3 = new BinarySubArray();
        int [] bs1 = {0,1};
        int [] bs2 = {0,1,0};
        int [] bs3 = {0,1,1,1,1,1,0,0,0};
        System.out.println("maximum length of a contiguous subarray with an equal number of 0 and 1 is " + obj3.findMaxLength(bs1));
        System.out.println("maximum length of a contiguous subarray with an equal number of 0 and 1 is " + obj3.findMaxLength(bs2));
        System.out.println("maximum length of a contiguous subarray with an equal number of 0 and 1 is " + obj3.findMaxLength(bs3));
    }
}
