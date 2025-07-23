/* LeetCode_1137>> Nth TRIBONACCI NUMBER
The Tribonacci sequence Tn is defined as follows: 
    T0 = 0, T1 = 1, T2 = 1, and Tn+3 = Tn + Tn+1 + Tn+2 for n >= 0.
Given n, return the value of Tn.

    Example 1:

    Input: n = 4
    Output: 4
    Explanation:
    T_3 = 0 + 1 + 1 = 2
    T_4 = 1 + 1 + 2 = 4

    Example 2:

    Input: n = 25
    Output: 1389537
 

Constraints:    0 <= n <= 37
The answer is guaranteed to fit within a 32-bit integer, ie. answer <= 2^31 - 1.
 */

import java.util.Scanner;

public class LeetCode_1137 {
    // Tribonacci Number = n1 + n2 + n3
    //              where, n1 = 0, n2 = 1, n3 = 1
    private static int Solution(int n)
    {
        int firstNum = 0;
        int secondNum = 1;
        int thirdNum = 1;

        if(n < 1)
            return -99;
        else if(n == 1)
            return firstNum;
        else if(n == 2 || n == 3)
            return secondNum;
        else
        {
            for(int i=0; i<n; i++)
            {
                int fourthNum = firstNum + secondNum + thirdNum;

                firstNum = secondNum;
                secondNum = thirdNum;
                thirdNum = fourthNum;
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
