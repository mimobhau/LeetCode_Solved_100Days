/* LeetCode_1518>> WATER BOTTLES
There are numBottles water bottles that are initially full of water. You can exchange numExchange empty water bottles from the market with one full water bottle.

The operation of drinking a full water bottle turns it into an empty bottle.

Given the two integers numBottles and numExchange, return the maximum number of water bottles you can drink.

    Example 1:

    Input: numBottles = 9, numExchange = 3
    Output: 13
    Explanation: You can exchange 3 empty bottles to get 1 full water bottle.
    Number of water bottles you can drink: 9 + 3 + 1 = 13.

    Example 2:

    Input: numBottles = 15, numExchange = 4
    Output: 19
    Explanation: You can exchange 4 empty bottles to get 1 full water bottle. 
    Number of water bottles you can drink: 15 + 3 + 1 = 19.

Constraints:
    1 <= numBottles <= 100
    2 <= numExchange <= 100
 */

import java.util.Scanner;

public class LeetCode_1518 {
    private static int Solution(int numBottles, int numExchange)
    {
        int drank = numBottles;
        
        if(numBottles >= 1 && numBottles <= 100 && numExchange >= 2 && numExchange <= 100)
        {
            while(numBottles >= numExchange)
            {
                int n = numBottles/numExchange;
                int emptyBottles = numBottles%numExchange;
                drank += n;
                // remaining empty bottles add to the new empty bottles
                numBottles = n+emptyBottles;
            }           
        }
        return drank;
    }
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter numBottles: ");
        int numBottles = sc.nextInt();
        System.out.print("Enter numExchange: ");
        int numExchange = sc.nextInt();
        int result = Solution(numBottles, numExchange);
        
        System.out.println("Result: " + result);

        sc.close();
    }
}
