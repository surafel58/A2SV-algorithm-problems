/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */
class Solution {
public:
    ListNode* insertionSortList(ListNode* head) {
        
        //if only one node, return that node 
        if(head->next == NULL)
            return head;
        
        //num_temp: store current element value, i: iterator
        int num_temp, i=1;
        
        //temp: to traverse list, pre: to keep track of the previous node
        ListNode *temp = head->next, *pre = head;
        
        //to store the pointers that point to the previous nodes at each iteration
        vector<ListNode*> pre_pointers; 
        
        //push the previous pointer
        pre_pointers.push_back(pre);
        
        //iterate through the list until Null is found
        while(temp!=NULL)
        {
            //store the current value
            num_temp = temp->val;
            
            //keep building a relatively sorted subarray 
            for(int j=i; j>0; j--)
            {  
                //if the current element is not in its proper place swap it
                if(num_temp < pre_pointers[j-1]->val)
                {
                    pre_pointers[j-1]->next->val = pre_pointers[j-1]->val;
                    pre_pointers[j-1]->val = num_temp;
                }
                
                //else it is in its proper place
                else
                    break;                    
            }
            
            //move to next node
            temp = temp->next;
            
            //move the next previous node
            pre = pre->next;
            
            //keep storing the pre pointer
            pre_pointers.push_back(pre);
            
            //increment i
            i++;
        }
        
        //return the sorted list
        return head;
    }
};