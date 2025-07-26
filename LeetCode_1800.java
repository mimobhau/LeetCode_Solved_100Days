/* LeetCode_1800>> MAXIMUM ASCENDING SUBARRAY SUM
Given an array of positive integers nums, return the maximum possible sum of an strictly increasing subarray in nums.

A subarray is defined as a contiguous sequence of numbers in an array.

    Example 1:

    Input: nums = [10,20,30,5,10,50]
    Output: 65
    Explanation: [5,10,50] is the ascending subarray with the maximum sum of 65.

    Example 2:

    Input: nums = [10,20,30,40,50]
    Output: 150
    Explanation: [10,20,30,40,50] is the ascending subarray with the maximum sum of 150.

    Example 3:

    Input: nums = [12,17,15,13,10,11,12]
    Output: 33
    Explanation: [10,11,12] is the ascending subarray with the maximum sum of 33.

Constraints:
    1 <= nums.length <= 100
    1 <= nums[i] <= 100
 */

import java.util.Scanner;

public class LeetCode_1800 {
    private static int Solution(int[] nums)
    {
        // final max sum
        int max = nums[0];
        // current sum of ascending sub-array
        int currmax = nums[0];

        for(int i=1; i<nums.length; i++)
        {
            // if the previous value is smaller than current value, it is an ascending subarray, and value is added to the current sum (currmax)
            if(nums[i-1] < nums[i])
                currmax += nums[i];
            else
            {
                // replaces the max value with maximum value between 'currmax' & 'max'
                max = Math.max(currmax, max);
                // currmax is set to get the sum of the next sub-array
                currmax = nums[i];
            }
        }
        
        // if the last element is also a part of a sub-array
        max = Math.max(currmax, max);

        return max;
    }
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);

        // for inserting integer array
        System.out.print("Enter size of nums: ");
        int arraySize = sc.nextInt();
        int[] nums = new int[arraySize];
        System.out.print("Enter elements of nums: ");
        for(int i=0; i<arraySize; i++)
        {
            nums[i] = sc.nextInt();
        }
        
        int result = Solution(nums);
        System.out.print("Result: " + result);

        sc.close();
    }
}
