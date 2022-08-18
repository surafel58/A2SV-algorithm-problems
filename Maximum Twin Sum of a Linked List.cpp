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
    int pairSum(ListNode* head) {
        
        //head2 = new list, head - pointer to the linkedlist. temp2 - pointer to the new list
        ListNode *head2 = NULL, *temp = head, *temp2;
        
        //length - length of the linked list 
        int length = 0, counter = 0;
        
        //if list has only two elements, then return their sum
        if(head->next->next == NULL)
            return head->val + head->next->val;
        
        //calculate the length of the list
        while(temp!=NULL)
        {
            temp=temp->next;
            length++;
        }
        
        temp = head;
        //copy only second half of linked list into the new list
        while(counter < length)
        {
            if(counter >= length/2)
            {
                if(head2==NULL)
                {
                    head2 = new ListNode;
                    head2->val = temp->val;
                    head2->next = NULL;
                    temp2 = head2;
                }

                else
                {
                    temp2->next = new ListNode;
                    temp2 = temp2->next;
                    temp2->val = temp->val;
                    temp2->next = NULL;
                }
            }
            temp=temp->next;
            counter++;
        }
        
        //reverse second list
        // pointers that traverse through the linked list  
        ListNode *current=head2, *next=NULL, *prev=NULL;
        
        //iterate through the list to reverse it
        while(current!=NULL)
        {
            next=current->next;
            current->next=prev;
            prev=current;
            current = next;
        }
        
        //assign head to the last element
        head2 = prev;
        
        //max twin sum
        int max = head->val + head2->val;
        
        temp = head;
        temp2 = head2;
        
        //find max twin sum 
        while(temp2!=NULL)
        {
            if(max < temp->val + temp2->val)
                max = temp->val + temp2->val;
            
            temp = temp->next;
            temp2 = temp2->next;
        }
        
        //return the max twin sum
        return max;
    }
};