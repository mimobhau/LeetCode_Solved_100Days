/* LeetCode_724>> FIND PIVOT INDEX
Given an array of integers nums, calculate the pivot index of this array.

The pivot index is the index where the sum of all the numbers strictly to the left of the index is equal to the sum of all the numbers strictly to the index's right.

If the index is on the left edge of the array, then the left sum is 0 because there are no elements to the left. This also applies to the right edge of the array.

Return the leftmost pivot index. If no such index exists, return -1.

    Example 1:

    Input: nums = [1,7,3,6,5,6]
    Output: 3
    Explanation:
    The pivot index is 3.
    Left sum = nums[0] + nums[1] + nums[2] = 1 + 7 + 3 = 11
    Right sum = nums[4] + nums[5] = 5 + 6 = 11

    Example 2:

    Input: nums = [1,2,3]
    Output: -1
    Explanation:
    There is no index that satisfies the conditions in the problem statement.

    Example 3:

    Input: nums = [2,1,-1]
    Output: 0
    Explanation:
    The pivot index is 0.
    Left sum = 0 (no elements to the left of index 0)
    Right sum = nums[1] + nums[2] = 1 + -1 = 0

Constraints:
    1 <= nums.length <= 104
    -1000 <= nums[i] <= 1000

Note: This question is the same as 1991: https://leetcode.com/problems/find-the-middle-index-in-array/
 */

import java.util.Scanner;

public class LeetCode_724 {
    private static int Solution(int[] nums)
    {
        int rSum = 0;
        int lSum = 0;
        // finding the total sum of the array (rSum)
        for(int element: nums)
            rSum += element;
        
        for(int i=0; i<nums.length; i++)
        {
            rSum -= nums[i];
            // as the value at pivot index in not included in either sum

            // if the sum of both sides are equal, "i" is the pivot index
            if(rSum == lSum)
                return i;
            
            // if the 'i' is not pivot index, add the value at 'i' to lSum
            lSum += nums[i];
        }

        return -1;
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
