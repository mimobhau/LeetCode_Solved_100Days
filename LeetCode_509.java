/* LeetCode_509>> FIBONACCI NUMBER
The Fibonacci numbers, commonly denoted F(n) form a sequence, called the Fibonacci sequence, such that each number is the sum of the two preceding ones, starting from 0 and 1. That is,
        F(0) = 0, F(1) = 1
        F(n) = F(n - 1) + F(n - 2), for n > 1.
Given n, calculate F(n).

    Example 1:

    Input: n = 2
    Output: 1
    Explanation: F(2) = F(1) + F(0) = 1 + 0 = 1.

    Example 2:

    Input: n = 3
    Output: 2
    Explanation: F(3) = F(2) + F(1) = 1 + 1 = 2.

    Example 3:

    Input: n = 4
    Output: 3
    Explanation: F(4) = F(3) + F(2) = 2 + 1 = 3.
 

Constraints:    0 <= n <= 30
 */
import java.util.Scanner;

public class LeetCode_509 {
    private static int Solution(int x)
    {
        int firstNum = 0;
        int secondNum = 1;

        if(x < 1)
            return -999;
        else if(x == 1)
            return firstNum;
        else if(x == 1)
            return secondNum;
        else
        {
            for(int i=0; i<x; i++)
            {
                int thirdNum = firstNum + secondNum;

                firstNum = secondNum;
                secondNum = thirdNum;

            }

            return firstNum;
        }
    }
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number: ");
        int x = sc.nextInt();
        int result = Solution(x);
        
        System.out.println("Result: " + result);

        sc.close();
    }
}
