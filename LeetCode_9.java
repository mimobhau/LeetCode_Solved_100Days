/*
LeetCode-9> PALINDROME NUMBER
Given an integer x, return true if x is a palindrome, and false otherwise.

    Example 1:

    Input: x = 121
    Output: true
    Explanation: 121 reads as 121 from left to right and from right to left.

    Example 2:

    Input: x = -121
    Output: false
    Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.

    Example 3:

    Input: x = 10
    Output: false
    Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
 

Constraints:    -231 <= x <= 231 - 1

Follow up: Could you solve it without converting the integer to a string?
 */
import java.util.Scanner;

public class LeetCode_9 {
    private static boolean isPalindrome(int x)
    {
        if(x<0)
            return false;
        
        int n = x;
        // transferring value of 'x' -> 'n', so that the original value isn't lost
        // '%' -> modulo operator (gives remainder)
        int revNum = 0;

        // retuns reverse of the given number
        while(n>0)
        {
            int i = n%10;
            revNum = (revNum*10) + i;

            n = n/10;
        }
        /*Example-
         * let, x = n = 122
         
          First loop,
         *      i = n%10 = 122 % 10 = 2
         *      revNum = (revNum*10) + i = (0*10)+ 2 = 2
         *      n = n/10 = 122/10 = 12 (returns quotient only)
         
          Second loop,
         *      i = n%10 = 12 % 10 = 2
         *      revNum = (revNum*10) + i = (2*10)+ 2 = 22
         *      n = n/10 = 12/10 = 1
         
          Third loop,
         *      i = n%10 = 1 % 10 = 1
         *      revNum = (revNum*10) + i = (22*10)+ 1 = 221
         *      n = n/10 = 1/10 = 0
         
         * [ loops ends (n=0)] we got the reverse of the given number
         */

        if(revNum == x)
            return true;
        else
            return false;
    }
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number: ");
        int x = sc.nextInt();
        boolean result = isPalindrome(x);
        
        System.out.println("Result: " + result);

        sc.close();
    }
}
