/* LeetCode_1464>> MAXIMUM PRODUCT of TWO ELEMENTS in an ARRAY
Given the array of integers nums, you will choose two different indices i and j of that array. Return the maximum value of (nums[i]-1)*(nums[j]-1).

    Example 1:

    Input: nums = [3,4,5,2]
    Output: 12 
    Explanation: If you choose the indices i=1 and j=2 (indexed from 0), you will get the maximum value, that is, (nums[1]-1)*(nums[2]-1) = (4-1)*(5-1) = 3*4 = 12.

    Example 2:

    Input: nums = [1,5,4,5]
    Output: 16
    Explanation: Choosing the indices i=1 and j=3 (indexed from 0), you will get the maximum value of (5-1)*(5-1) = 16.

    Example 3:

    Input: nums = [3,7]
    Output: 12

Constraints:
    2 <= nums.length <= 500
    1 <= nums[i] <= 10^3
 */

import java.util.Scanner;

public class LeetCode_1464 {
    private static int Solution(int[] nums)
    {
        int max = -1, smax = -1;

        for(int i=0; i<nums.length; i++)
        {
            if(max < nums[i])
            {
                smax = max;
                max = nums[i];
            }
            else if(smax < nums[i])
            {
                smax = nums[i];
            }
        }

        return (max-1)*(smax-1);
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
