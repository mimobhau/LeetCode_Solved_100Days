/* LeetCode_2529>> MAXIMUM COUNT of POSITIVE INTEGER and NEGATIVE INTEGER
Given an array nums sorted in non-decreasing order, return the maximum between the number of positive integers and the number of negative integers.

In other words, if the number of positive integers in nums is pos and the number of negative integers is neg, then return the maximum of pos and neg.
Note that 0 is neither positive nor negative.

    Example 1:

    Input: nums = [-2,-1,-1,1,2,3]
    Output: 3
    Explanation: There are 3 positive integers and 3 negative integers. The maximum count among them is 3.

    Example 2:

    Input: nums = [-3,-2,-1,0,0,1,2]
    Output: 3
    Explanation: There are 2 positive integers and 3 negative integers. The maximum count among them is 3.

    Example 3:

    Input: nums = [5,20,66,1314]
    Output: 4
    Explanation: There are 4 positive integers and 0 negative integers. The maximum count among them is 4.

Constraints:
    1 <= nums.length <= 2000
    -2000 <= nums[i] <= 2000
    nums is sorted in a non-decreasing order.

Follow up: Can you solve the problem in O(log(n)) time complexity?
 */

import java.util.Scanner;

public class LeetCode_2529 {
    // for finding the last negative integer
    private static int findNeg(int[] nums)
    {
        int start = 0, end = nums.length-1;
        int index = -1;

        // after finding the last negative integer, start > end, loop stops
        while(start <= end)
        {
            int mid = (start+end) / 2;

            // if element is negative, index = mid, also there could be larger negative numbers on the right hand side
            if(nums[mid] < 0)
            {
                index = mid;
                start = mid+1;
            }
            // if the elements is 'non-negative', then the negative integers should be on its left-hand side
            else
                end = mid-1;
        }

        return index;
    }

    // for finding the last negative integer
    private static int findPos(int[] nums)
    {
        int start = 0, end = nums.length-1;
        int index = -1;

        while(start <= end)
        {
            int mid = (start+end) / 2;

            // if element is positive, then first positive element may be on its left-hand side
            if(nums[mid] > 0)
            {
                index = mid;
                end = mid-1;
            }
            // if element <=0, then positive integers will be on its right-hand side
            else
                start = mid+1;
            
        }
        return index;
    }

    private static int Solution(int[] nums)
    {
        int n = nums.length;
        int a = findNeg(nums), b = findPos(nums);

        int max = Math.max(a+1, n-b);

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
