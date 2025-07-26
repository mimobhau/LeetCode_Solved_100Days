/* LeetCode_153>> FIND PEAK ELEMENT
A peak element is an element that is strictly greater than its neighbors.

Given a 0-indexed integer array nums, find a peak element, and return its index. If the array contains multiple peaks, return the index to any of the peaks.

You may imagine that nums[-1] = nums[n] = -∞. In other words, an element is always considered to be strictly greater than a neighbor that is outside the array.

You must write an algorithm that runs in O(log n) time.

    Example 1:

    Input: nums = [1,2,3,1]
    Output: 2
    Explanation: 3 is a peak element and your function should return the index number 2.

    Example 2:

    Input: nums = [1,2,1,3,5,6,4]
    Output: 5
    Explanation: Your function can return either index number 1 where the peak element is 2, or index number 5 where the peak element is 6.

Constraints:
    1 <= nums.length <= 1000
    -231 <= nums[i] <= 231 - 1
    nums[i] != nums[i + 1] for all valid i.
 */

import java.util.Scanner;

public class LeetCode_162 {
    private static int Solution(int[] nums)
    {
        int start = 0;
        int end = nums.length-1;

        if(nums.length == 1)
            return 0;
        else if(nums[start] > nums[1])
            return 0;
        else if(nums[end] > nums[end-1])
            return nums.length-1;
        else
        {
            while (start <= end) {
                int mid = (start + end)/2;

                if(nums[mid-1] < nums[mid] && nums[mid] > nums[mid+1])
                    return mid;
                else if(nums[mid-1] > nums[mid])          // if the left side has bigger element
                    end = mid-1;
                else          // if the right side has bigger element
                    start = mid+1;
            }
        }

        return -1;
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
