/* LeetCode_53>> MAXIMUM SUBARRAY
Given an integer array nums, find the subarray with the largest sum, and return its sum.

    Example 1:

    Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
    Output: 6
    Explanation: The subarray [4,-1,2,1] has the largest sum 6.

    Example 2:

    Input: nums = [1]
    Output: 1
    Explanation: The subarray [1] has the largest sum 1.

    Example 3:

    Input: nums = [5,4,-1,7,8]
    Output: 23
    Explanation: The subarray [5,4,-1,7,8] has the largest sum 23.

Constraints:
    1 <= nums.length <= 105
    -104 <= nums[i] <= 104

Follow up: If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.
 */

import java.util.Scanner;

public class LeetCode_53 {
    private static int Solution(int[] nums)
    {
        /* BRUTE FORCE APPROACH - O(n^2)
            int max = Integer.MIN_VALUE;
            int n = nums.length;

            for(int i=0; i<n; i++)
            {
                int currentSum = 0;
                for(int j=i; j<n; j++)
                {
                    currentSum += nums[j];
                    
                    if(max < currentSum)
                        max = currentSum;
                }
            }

            return max;
        */

        int currentSum = nums[0];
        int max = nums[0];

        for(int i=1; i<nums.length; i++)
        {
            // if the sum is greater than current item value
            if(currentSum + nums[i] > nums[i])
                currentSum += nums[i];
            else
                currentSum = nums[i];

            max = Math.max(max, currentSum);
        }

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
        System.out.println("Result: " + result);
        sc.close();
    }
}
