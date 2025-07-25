/* LeetCode_319>> BULB SWITCHER
There are n bulbs that are initially off. You first turn on all the bulbs, then you turn off every second bulb.

On the third round, you toggle every third bulb (turning on if it's off or turning off if it's on). For the ith round, you toggle every i bulb. For the nth round, you only toggle the last bulb.

Return the number of bulbs that are on after n rounds.

    Example 1:

    Input: n = 3
    Output: 1
    Explanation: At first, the three bulbs are [off, off, off].
    After the first round, the three bulbs are [on, on, on].
    After the second round, the three bulbs are [on, off, on].
    After the third round, the three bulbs are [on, off, off]. 
    So you should return 1 because there is only one bulb is on.

    Example 2:

    Input: n = 0
    Output: 0

    Example 3:

    Input: n = 1
    Output: 1

Constraints:
    0 <= n <= 109
 */

import java.util.Scanner;

public class LeetCode_319 {
    private static int Solution(int n)
    {
        /*
         * for this question, on taking a bigger example (say, n=15) we observe that after nth round only the 'perfect square numbers' are still on.
         * this is beacuse, when we find out the factors of the perefect squares, their count is 'odd', unlike non-Square numbers
         * therefore, we count the perfect square numbers under tha range 'n'
         */
        int count = 0;
        int i = 1;

        if(i*i <= n)
        {
            count++;
            i++;
        }

        return count;
    }
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);

        // for inserting integer array
        System.out.print("Enter n: ");
        // as it says, "For the nth round, you only toggle the last bulb."; it suggests that there are 'n' number of bulbs
        int n = sc.nextInt();
        
        int result = Solution(n);
        System.out.println("Result: " + result);

        sc.close();
    }
}
