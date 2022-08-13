/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int[] nextLargerNodes(ListNode head) {

        //monotonic stack
        Stack<Integer> mono_stack = new Stack<>();
        //pointer to traverse list
        ListNode temp = head;
        //length of list 
        int n=0;
        
        //count length of list
        while(temp!=null)
        {
            n++;
            temp = temp.next;
        }
        
        //input array - array that stores the values of the list, ans - array that stores the result
        int[] input = new int[n];
        int[] ans = new int[n];
        temp=head;
        
        //copy list value to array
        for(int i=0; i<n; i++)
        {
            input[i] = temp.val;
            temp = temp.next;
        }
        
        //maintain decreasing stack, store index in the stack, if greater element compared to stack is found put that value in the ans array for the corresponding element
        for(int i=0; i<n; i++)
        {
            while(!mono_stack.empty() && input[mono_stack.peek()] < input[i])
            {
                ans[mono_stack.peek()] = input[i];
                mono_stack.pop();
            }
            mono_stack.push(i);
        }
        
        //return result
        return ans;
    }
}