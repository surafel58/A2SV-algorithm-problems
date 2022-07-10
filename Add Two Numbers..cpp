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
    ListNode* addTwoNumbers(ListNode* l1, ListNode* l2) {
        //pointers to traverse through the new linked list and the two linked list
        ListNode *result = new ListNode, *prev=NULL;
        ListNode *tempr = result, *temp1=l1, *temp2=l2;
        //to store temporary result in the calculation
        int carry=0, result_carry=0, x=0;
        
        //if both the list have only single element, then add only the two numbers and store it in the new linked list with a head pointer 'result'.
        if(l1->next == NULL && l2->next== NULL)
        {
            int x = l1->val + l2->val;
            result->val = x;
            //if the sum is greater than 9, then store the right digit in the new linked list and store the left digit in the carry variable 
            if(x>9)
            {
                result->val = x%10;
                carry = x/10;
                result->next = new ListNode;
                ListNode *temp = result->next;
                temp->val = carry;
            }
            return result;
        }
        
        //iterate through both lists until we reached end of both of the list and store the sum of the two digits from the lists into the new linked list and if there is a carry add it to the next sum.  
        while(temp1!=NULL || temp2!=NULL)
        {
            if(temp1==NULL)
                x = temp2->val;
            else if(temp2==NULL)
                 x = temp1->val;
            else
                x = temp1->val + temp2->val;
            
            tempr->val = x;
            
            //if there is a carry add the carry to the sum
            if(carry!=0)
            {
                x+=carry;
                tempr->val+=carry;
                carry=0;
            }
            
            //if the sum is greater than 9, then store the right digit in the new linked list and store the left digit in the carry variable 
            if(x>9)
            {
                tempr->val = x%10;
                carry = x/10;
            }
            
            //shift to the next node of the new list 
            tempr->next = new ListNode;
            prev = tempr;
            tempr=tempr->next;
            //if we didnt reach the end of the first list, then shift to the next number to be added
            if(temp1!=NULL)
                temp1=temp1->next;
            //if we didnt reach the end of the second list, then shift to the next number to be added
            if(temp2!=NULL)
                temp2=temp2->next; 
            
            //put the carry into result_carry to check later that if there is any carry left to be added 
            result_carry = carry;
        }
        
        //make the last node point to NULL
        prev -> next = NULL;
        
        //if there a carry left then add it to the new list
        if(result_carry!=0)
        {
            tempr=new ListNode;
            tempr->val = result_carry;
            tempr->next = NULL;
            prev->next = tempr;
        }
        
        //return the head of the new linked list
        return result;
    }
};  