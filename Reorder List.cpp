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
    void reorderList(ListNode* head) {
        
        //head2 = new list, head - pointer to the linkedlist. temp2 - pointer to the new list
        ListNode *head2 = NULL, *temp = head, *temp2;
        
        //if only one node, return it self
        if(head->next == NULL)
            return;
        
        //length - length of the linked list 
        int length = 0, counter = 0;
        
        //calculate the length of the list
        while(temp!=NULL)
        {
            temp=temp->next;
            length++;
        }
        
        temp = head;
        int half_length = (length % 2 == 0 ? length/2: length/2 + 1);
        //copy only second half of linked list into the new list
        while(counter < length)
        {
            if(counter >= half_length)
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
        
        temp = head;
        temp2 = head2;
        
        //iterate throguh both lists and insert each nodes from those lists into the new list alternatively until the second list(reversed half of list 1) is traversed completely.
        ListNode *result = NULL, *temp3;
        while(temp2 != NULL)
        {
            if(result == NULL)
            {
                result = new ListNode;
                result->val = temp->val;
                result->next = new ListNode;
                result->next->val = temp2->val;
                result->next->next = NULL;
                temp3 = result->next;
            }
            
            else
            {
                temp3->next = new ListNode;
                temp3 = temp3->next;
                temp3->val = temp->val;
                temp3->next = new ListNode;
                temp3 = temp3->next;
                temp3->val = temp2->val;
                temp3->next = NULL;
            }
            
            temp = temp->next;
            temp2 = temp2->next;
        }
        
        //if length is odd , then add the remaining node into the new list
        if(length % 2 != 0)
        {
            temp3->next = new ListNode;
            temp3 = temp3->next;
            temp3->val = temp->val;
            temp3->next = NULL;
        }
        
        //copy each values of the new list into the first list
        temp3 = result;
        temp = head;
        while(temp3!=NULL)
        {
            temp->val = temp3->val;
            temp = temp->next;
            temp3 = temp3->next;
        }
    }
};