/* LeetCode_881>> BOATS to SAVE PEOPLE
You are given an array people where people[i] is the weight of the ith person, and an infinite number of boats where each boat can carry a maximum weight of limit. Each boat carries at most two people at the same time, provided the sum of the weight of those people is at most limit.

Return the minimum number of boats to carry every given person.

    Example 1:

    Input: people = [1,2], limit = 3
    Output: 1
    Explanation: 1 boat (1, 2)

    Example 2:

    Input: people = [3,2,2,1], limit = 3
    Output: 3
    Explanation: 3 boats (1, 2), (2) and (3)

    Example 3:

    Input: people = [3,5,3,4], limit = 5
    Output: 4
    Explanation: 4 boats (3), (3), (4), (5)

Constraints:
    1 <= people.length <= 5 * 104
    1 <= people[i] <= limit <= 3 * 104
 */

import java.util.Arrays;
import java.util.Scanner;

public class LeetCode_881 {
    private static int Solution(int[] people, int limit)
    {
        /*
         APPROACH-1: Using Nested Loops
         * Time Complexity: O(n^2)
         
         APPROACH-2: Using two pointers after sorting
         * Time Complexity: O(nlogn)
         */

         Arrays.sort(people);

         int i=0, j = people.length-1;
         int boat = 0;
         while(i <= j)
         {
            if(people[i] + people[j] <= limit)
            {
                boat++;
                i++;
                j--;
            }
            else if(people[j] <= limit)
            {
                boat++;
                j--;
            }
         }

         return boat;
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

        System.out.print("Enter limit: ");
        int limit = sc.nextInt();
    
        int result = Solution(digits, limit);
        System.out.print("Result: " + result);
        sc.close();
    }
}
