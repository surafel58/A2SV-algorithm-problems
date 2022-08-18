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
    public ListNode swapPairs(ListNode head) {
        //temp - pointer to current list, new_list - a new linekd list, temp2 - pointer to new list
        ListNode temp = head, new_list = null, temp2 = new_list;
        
        //pair counter
        int counter = 0;
        
        //stack to track value of pair nodes
        Stack<Integer> node_values = new Stack<>();
        
        //if list empty - return null
        if(head == null)
            return null;
        
        //iterate through the list and whenever every pair node is found push its value on the stack and add nodes into the new list popping its values from the stack 
        while(temp!=null)
        {
            //increment counter
            counter++;
            
            //push its value onto the stack
            node_values.push(temp.val);
            
            //if pair is found, add the pairs in reverse into the new list 
            if(counter == 2)
            {
                if(new_list == null)
                {
                    new_list = new ListNode();
                    new_list.val = node_values.pop();
                    new_list.next = new ListNode();
                    new_list.next.val = node_values.pop();
                    new_list.next.next = null;
                    temp2 = new_list.next;
                }
                else
                {
                    temp2.next = new ListNode();
                    temp2.next.val = node_values.pop();
                    temp2 = temp2.next;
                    temp2.next = new ListNode();
                    temp2.next.val = node_values.pop();
                    temp2.next.next = null;
                    temp2 = temp2.next;
                }
                counter = 0;
            }
            temp = temp.next;
        }

        //if there is remaining node left in the list, add it to the new list
        if(counter != 0)
        {
            if(new_list == null)
            {
                new_list = new ListNode();
                new_list.val = node_values.pop();
                new_list.next = null;
            }
            else
            {
                temp2.next = new ListNode();
                temp2.next.val = node_values.pop();
                temp2.next.next = null;                
            }
        }
        
        //return the new list
        return new_list;
    }
    
}