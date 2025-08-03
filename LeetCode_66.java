/* LeetCode_66>> PLUS ONE
You are given a large integer represented as an integer array digits, where each digits[i] is the ith digit of the integer. The digits are ordered from most significant to least significant in left-to-right order. The large integer does not contain any leading 0's.

Increment the large integer by one and return the resulting array of digits.

    Example 1:

    Input: digits = [1,2,3]
    Output: [1,2,4]
    Explanation: The array represents the integer 123.
    Incrementing by one gives 123 + 1 = 124.
    Thus, the result should be [1,2,4].

    Example 2:

    Input: digits = [4,3,2,1]
    Output: [4,3,2,2]
    Explanation: The array represents the integer 4321.
    Incrementing by one gives 4321 + 1 = 4322.
    Thus, the result should be [4,3,2,2].

    Example 3:

    Input: digits = [9]
    Output: [1,0]
    Explanation: The array represents the integer 9.
    Incrementing by one gives 9 + 1 = 10.
    Thus, the result should be [1,0].

Constraints:
    1 <= digits.length <= 100
    0 <= digits[i] <= 9
    digits does not contain any leading 0's.
 */

import java.util.Scanner;

public class LeetCode_66 {
    private static void print(int[] nums)
    {
        // printing the final array
        for(int i=0; i<nums.length; i++)
        {
            System.out.print(nums[i] + " ");
        }
    }

    private static void Solution(int[] digits)
    {
        int n = digits.length;

        // Traverse from the last digit to the first
        for(int i = n - 1; i >= 0; i--)
        {
            // if current digit is less than 9, just add 1 and print
            if(digits[i] < 9)
            {
                digits[i] += 1;
                print(digits);
                return;
            }

            // if current digit is 9, set it to 0 and continue to handle carry
            digits[i] = 0;
        }

        // when, all the elements are 9 (example, 999), then the loop ends with all elements = 0
        int[] ans = new int[n+1];
        // first number = 1 (999+1 = 1000)
        ans[0]=1;
        // rest numbers are 0 by default
        
        print(ans);
        
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
    
        Solution(digits);
        sc.close();
    }
}
