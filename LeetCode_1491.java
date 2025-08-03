/* LeetCode_1491>> AVERAGE SALARY EXCLUDING the MINIMUM and MAXIMUM SALARY
You are given an array of unique integers salary where salary[i] is the salary of the ith employee.

Return the average salary of employees excluding the minimum and maximum salary. Answers within 10-5 of the actual answer will be accepted.

    Example 1:

    Input: salary = [4000,3000,1000,2000]
    Output: 2500.00000
    Explanation: Minimum salary and maximum salary are 1000 and 4000 respectively.
    Average salary excluding minimum and maximum salary is (2000+3000) / 2 = 2500

    Example 2:

    Input: salary = [1000,2000,3000]
    Output: 2000.00000
    Explanation: Minimum salary and maximum salary are 1000 and 3000 respectively.
    Average salary excluding minimum and maximum salary is (2000) / 1 = 2000

Constraints:
    3 <= salary.length <= 100
    1000 <= salary[i] <= 106
    All the integers of salary are unique.
 */

import java.util.Scanner;

public class LeetCode_1491 {
    private static double Solution(int[] nums)
    {
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        double average = 0, sum = 0;

        for(int i=0; i<nums.length; i++)
        {
            // finding the largest value
            if(nums[i] > max)
                max = nums[i];
            // finding the smallest value
            else if(nums[i] < min)
                 min = nums[i];

            sum += nums[i];
        }

        sum = sum - min - max;          // as all values are unique

        average = sum/(nums.length - 2);
        return average;
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
    
        double result = Solution(digits);
        System.out.print("Result: " + result);
        sc.close();
    }
}
