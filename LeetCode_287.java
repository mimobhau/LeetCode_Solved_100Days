/* LeetCode_287>> FIND the DUPLICATE NUMBER
Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.

There is only one repeated number in nums, return this repeated number.

You must solve the problem without modifying the array nums and using only constant extra space.

    Example 1:

    Input: nums = [1,3,4,2,2]
    Output: 2

    Example 2:

    Input: nums = [3,1,3,4,2]
    Output: 3

    Example 3:

    Input: nums = [3,3,3,3,3]
    Output: 3

Constraints:
    1 <= n <= 105
    nums.length == n + 1
    1 <= nums[i] <= n
    All the integers in nums appear only once except for precisely one integer which appears two or more times.

Follow up:
    How can we prove that at least one duplicate number must exist in nums?
    Can you solve the problem in linear runtime complexity?
 */

import java.util.Scanner;

public class LeetCode_287 {
    private static int Solution(int[] nums)
    {
        /*
         APPROACH-1: Using two nested loops
         * Time Complexity: O(n^2)
         
         APPROACH-2: Using HashMap (checks which number has frequency > 1)
         * Time Complexity: O(n)
         * Space Complexity: O(n)
         
         APPROACH-3:
         * Step 1: Intialise a loop
         * Step 2: if(nums[nums[i]] > 0), then nums[nums[i]] = -nums[nums[i]];
         * Step 3: if(nums[nums[i]] < 0), return nums[i];
         * Time Complexity: O(n)
         * Space Complexity: O(1)
         */

        //  APPROACH-3
        for(int i=0; i<nums.length; i++)
        {
            if(nums[Math.abs(nums[i])] > 0)
                nums[Math.abs(nums[i])] = -nums[Math.abs(nums[i])];
            // if the element at nums[nums[i]] is already negative, it means this the repeating number
            else
                return Math.abs(nums[i]);
        }

        return -99;
    }
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);

        // for inserting integer array
        System.out.print("Enter size of nums: ");
        int arraySize = sc.nextInt();
        int[] digits = new int[arraySize];
        System.out.print("Enter elements of nums: ");
        for(int i=0; i<arraySize; i++)
        {
            digits[i] = sc.nextInt();
        }
    
        int result = Solution(digits);
        System.out.print("Result: " + result);
        sc.close();
    }
}
