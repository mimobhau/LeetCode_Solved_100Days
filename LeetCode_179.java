/* LeetCode_179>> LARGEST NUMBER
Given a list of non-negative integers nums, arrange them such that they form the largest number and return it.

Since the result may be very large, so you need to return a string instead of an integer.

    Example 1:

    Input: nums = [10,2]
    Output: "210"

    Example 2:

    Input: nums = [3,30,34,5,9]
    Output: "9534330"

Constraints:
    1 <= nums.length <= 100
    0 <= nums[i] <= 109
 */

import java.util.Arrays;
import java.util.Scanner;

public class LeetCode_179 {
    private static String Solution(int[] nums)
    {
        // Step I: Creating a String array
        String[] arr = new String[nums.length];

        // Step II: Converting the 'Integer' array to 'String' array (typecasting)
        for(int i=0; i<nums.length; i++)
            arr[i] = nums[i] + "";          // String typecasting
        
        // Step III: Sorting the String array
        Arrays.sort(arr, (s1, s2)->(s1+s2).compareTo(s2+s1));
        /* Comparison Condition-
                let, s1 = 3, s2 = 31
                [though, while sorting 3 comes before 31 (for ascending), but if we try to create the largest number, we get (s1+s2) = 313]
                even though, s2+s1 = 331 (greater than 313)

                therefore, s1+s2 < s2+s1        (commutivity doesn't exist for Strings)
         */

         StringBuilder sb = new StringBuilder("");
        //  StringBuilder is created to efficiently 'append strings'. Faster than using '+' in a loop

        //  Step IV: the elements of String array are added in descending (from the last) order to create the largest number
        for(int i=arr.length-1; i>=0; i--)
            sb.append(arr[i]);

        // Managing edge-case
        if(sb.charAt(0) == '0')         //if first character is 0, then the whole number is 0
            return "0";
        // Step V: Converting StringBuilder into String
        else
            return sb.toString();
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
    
        String result = Solution(nums);
        System.out.println("Result: " + result);
        sc.close();
    }
}
