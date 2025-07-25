/* LeetCode_238>> PRODUCT of ARRAY EXCEPT SELF
Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].

The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.

You must write an algorithm that runs in O(n) time and without using the division operation.

    Example 1:

    Input: nums = [1,2,3,4]
    Output: [24,12,8,6]

    Example 2:

    Input: nums = [-1,1,0,-3,3]
    Output: [0,0,9,0,0]

Constraints:
    2 <= nums.length <= 105
    -30 <= nums[i] <= 30
    The input is generated such that answer[i] is guaranteed to fit in a 32-bit integer.

Follow up: Can you solve the problem in O(1) extra space complexity? (The output array does not count as extra space for space complexity analysis.)
 */

import java.util.Scanner;

public class LeetCode_238 {
    private static void Solution(int[] nums)
    {
        int n = nums.length;
        // array for storing all the product of the numbers, starting from the right
        int[] right = new int[n];

        int pro = 1;

        for(int i=n-1; i>=0; i--)
        {
            pro = pro * nums[i];
            right[i] = pro;
        }

        // final ans array
        int[] ans = new int[n];
        int left = 1;

        // creates the final values/answers
        for(int i=0; i<n-1; i++)
        {
            int val = left * right[i+1];
            ans[i] = val;
            left = left * nums[i];
        }

        // getting the accurate value for the last element
        ans[n-1] = left;

        // printing the final array
        for(int i=0; i<n; i++)
        {
            System.out.println(ans[i] + " ");
        }
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
        
        Solution(nums);

        sc.close();
    }
}
