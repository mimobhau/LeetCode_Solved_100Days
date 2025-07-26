/* LeetCode_540>> SINGLE ELEMENT in a SORTED ARRAY
You are given a sorted array consisting of only integers where every element appears exactly twice, except for one element which appears exactly once.

Return the single element that appears only once.

Your solution must run in O(log n) time and O(1) space.

    Example 1:

    Input: nums = [1,1,2,3,3,4,4,8,8]
    Output: 2

    Example 2:

    Input: nums = [3,3,7,7,10,11,11]
    Output: 10

Constraints:
    1 <= nums.length <= 105
    0 <= nums[i] <= 105
 */

import java.util.Scanner;

public class LeetCode_540 {
    private static int Solution(int[] nums)
    {
        int start = 0;
        int end = nums.length-1;

        while(start < end)
        {
            int mid = (start + end)/2;

            while(start <= end)
            {
                if(nums[mid] != nums[mid+1] || nums[mid] != nums[mid-1])
                    return nums[mid];
                else if(mid % 2 == 1)           // if mid index is odd
                {
                    if(nums[mid-1] == nums[mid])
                        start = mid + 1;
                    else
                        end = mid-1;
                }
                else                // if mid index is even
                {
                    if(nums[mid] == nums[mid+1])
                        start = mid+1;
                    else
                        end = mid-1;
                }
            }
        }
        return nums[start];
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
