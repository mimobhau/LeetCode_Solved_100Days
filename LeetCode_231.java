/* LeetCode_231> POWER OF TWO
Given an integer n, return true if it is a power of two. Otherwise, return false. An integer n is a power of two, if there exists an integer x such that n == 2x.

    Example 1:

    Input: n = 1
    Output: true
    Explanation: 20 = 1

    Example 2:

    Input: n = 16
    Output: true
    Explanation: 24 = 16

    Example 3:

    Input: n = 3
    Output: false
 
Constraints:    -231 <= n <= 231 - 1

Follow up: Could you solve it without loops/recursion?
 */

import java.util.Scanner;

public class LeetCode_231 {
    private static boolean Solution(int x)
    {
        if(x < 1)
            return false;
        else if(x == 1)
            return true;
        else
        {
            while(x%2 == 0)
            {
                x = x/2;
            }

            // as, pow(2,0) = 1
            if(x == 1)
                return true;
            else
                return false;
        }
    }
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number: ");
        int x = sc.nextInt();
        boolean result = Solution(x);
        
        System.out.println("Result: " + result);

        sc.close();
    }
}
