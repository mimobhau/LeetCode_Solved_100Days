/* LeetCode_155>> MIN STACK
Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

Implement the MinStack class:

MinStack() initializes the stack object.
void push(int val) pushes the element val onto the stack.
void pop() removes the element on the top of the stack.
int top() gets the top element of the stack.
int getMin() retrieves the minimum element in the stack.
You must implement a solution with O(1) time complexity for each function.

    Example 1:

    Input
    ["MinStack","push","push","push","getMin","pop","top","getMin"]
    [[],[-2],[0],[-3],[],[],[],[]]

    Output
    [null,null,null,null,-3,null,0,-2]

    Explanation
    MinStack minStack = new MinStack();
    minStack.push(-2);
    minStack.push(0);
    minStack.push(-3);
    minStack.getMin(); // return -3
    minStack.pop();
    minStack.top();    // return 0
    minStack.getMin(); // return -2
 
Constraints:
    -231 <= val <= 231 - 1
    Methods pop, top and getMin operations will always be called on non-empty stacks.
    At most 3 * 104 calls will be made to push, pop, top, and getMin.
 */

import java.util.Scanner;
import java.util.Stack;

class MinStack {
    // stack
    private Stack<Integer> stack;
    // holds the minimum value
    private Stack<Integer> min;

    public MinStack()
    {
        // initialised in memory
        stack = new Stack<>();
        min = new Stack<>();
    }

    public void push(int val)
    {
        // if this is the first element, it is added to both 'stack' and 'min' Stack
        // if the element is the smallest yet, added to 'min' [done, so getMin() is O(1)]
        if(stack.size() == 0 || min.peek() >= val)
            min.push(val);
        
        stack.push(val);
    }

    public void pop()
    {
        // top element is removed
        int element1 = stack.pop();
        int element2 = min.peek();

        // if removed element == top of 'min' => (removed)
        if(element1 == element2)
            min.pop();
    }

    public int top()
    {
        return stack.peek();
    }

    public int getMin()
    {
        // top=most element of 'min' is the smallest element
        return min.peek();
    }
}

public class LeetCode_155 {
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
    
        MinStack minStack = new MinStack();
        sc.close();
    }
}
