/* LeetCode_316>> REMOVE DUPLICATE LETTERS
Given a string s, remove duplicate letters so that every letter appears once and only once. You must make sure your result is the smallest in lexicographical order among all possible results

    Example 1:

    Input: s = "bcabc"
    Output: "abc"

    Example 2:

    Input: s = "cbacdcbc"
    Output: "acdb"

Constraints:
    1 <= s.length <= 104
    s consists of lowercase English letters.
 

Note: This question is the same as 1081: https://leetcode.com/problems/smallest-subsequence-of-distinct-characters/
 */

import java.util.Scanner;
import java.util.Stack;

public class LeetCode_316 {
    private static String Solution(String s)
    {
        // 'lexicographical order' means dictionary order

        int[] lastIndex = new int[26]; // stores the last occurrence index of each character
        boolean[] seen = new boolean[26]; // keeps track of characters already in result
        Stack<Character> stack = new Stack<>();

        // Step 1: Store last occurrence index for each character
        for (int i = 0; i < s.length(); i++) {
            lastIndex[s.charAt(i) - 'a'] = i;
        }

        // Step 2: Iterate through characters
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            // Skip if already added
            if (seen[c - 'a']) continue;

            // Step 3: Maintain lexicographical order
            while (!stack.isEmpty() &&
                c < stack.peek() &&  // current char is smaller than last in stack
                lastIndex[stack.peek() - 'a'] > i) { // last occurrence of stack top is later
                seen[stack.pop() - 'a'] = false; // remove from seen
            }

            // Step 4: Add current character to stack and mark as seen
            stack.push(c);
            seen[c - 'a'] = true;
        }

        // Step 5: Build result from stack
        StringBuilder sb = new StringBuilder();
        for (char c : stack) sb.append(c);

        return sb.toString();
    }


    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);

        // for inserting integer array
        System.out.print("Enter size of nums: ");
        String s = sc.nextLine();
    
        String result = Solution(s);
        System.out.print("Result: " + result);
        sc.close();
    }
}
