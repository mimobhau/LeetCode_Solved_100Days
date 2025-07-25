/* LeetCode_167>> TWO SUM 2 -> Input Array Sorted
Given a 1-indexed array of integers numbers that is already sorted in non-decreasing order, find two numbers such that they add up to a specific target number. Let these two numbers be numbers[index1] and numbers[index2] where 1 <= index1 < index2 <= numbers.length.

Return the indices of the two numbers, index1 and index2, added by one as an integer array [index1, index2] of length 2.

The tests are generated such that there is exactly one solution. You may not use the same element twice.

Your solution must use only constant extra space.

    Example 1:

    Input: numbers = [2,7,11,15], target = 9
    Output: [1,2]
    Explanation: The sum of 2 and 7 is 9. Therefore, index1 = 1, index2 = 2. We return [1, 2].

    Example 2:

    Input: numbers = [2,3,4], target = 6
    Output: [1,3]
    Explanation: The sum of 2 and 4 is 6. Therefore index1 = 1, index2 = 3. We return [1, 3].

    Example 3:

    Input: numbers = [-1,0], target = -1
    Output: [1,2]
    Explanation: The sum of -1 and 0 is -1. Therefore index1 = 1, index2 = 2. We return [1, 2].
 

Constraints:
    2 <= numbers.length <= 3 * 104
    -1000 <= numbers[i] <= 1000
    numbers is sorted in non-decreasing order.
    -1000 <= target <= 1000
    The tests are generated such that there is exactly one solution.
 */

import java.util.Scanner;

public class LeetCode_167 {
    private static void Solution(int[] nums, int target)
    {
        int i = 0;
        // start pointer
        int start = 0;
        // end pointer
        int end = nums.length-1;

        while(start < end)
        {
            int sum = nums[start] + nums[end];
            // if the sum == target, return (indices+1)
            if(sum == target)
            {
                System.out.println("Result: [" + (start+1) + ", " + (end+1) + "]");
                break;
            }
            // if sum < target, since array is sorted -> increase the start pointer (increases the sum value)
            else if(sum < target)
            {
                start++;
            }
            // if sum > target, since array is sorted -> decrease the end pointer (decreases the sum value)
            else
            {
                end--;
            }

            i++;
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

        System.out.print("Enter target: ");
        int target = sc.nextInt();

        Solution(nums, target);

        sc.close();
    }
}
