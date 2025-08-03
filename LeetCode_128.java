/* LeetCode_128>> LONGEST CONSECUTIVE SEQUENCE
Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.

You must write an algorithm that runs in O(n) time.

    Example 1:

    Input: nums = [100,4,200,1,3,2]
    Output: 4
    Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.

    Example 2:

    Input: nums = [0,3,7,2,5,8,4,6,0,1]
    Output: 9

    Example 3:

    Input: nums = [1,0,1,2]
    Output: 3

Constraints:
    0 <= nums.length <= 105
    -109 <= nums[i] <= 109
*/

import java.util.Scanner;

public class LeetCode_128 {
    private static int Solution(int[] nums)
    {

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
