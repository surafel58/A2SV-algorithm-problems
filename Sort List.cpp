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
    ListNode* sortList(ListNode* head) {
        //linked list sie counter
        int N=0;
        //pointer to traverse through the list
        ListNode* temp = head;
        
        //determine the size of the list
        while(temp!=NULL)
        {
            temp = temp->next;
            N++;
        }
        
        //if size is 0, then return NULL
        if(N==0)
            return NULL;
        //if size is 1, then return head
        if(N==1)
            return head;
        
        //declare array to store the values to be sorted from the list
        int values[N];
        
        //traverse through the list to copy the values into the array
        temp=head;
        for(int i=0; i<N; i++)
        {
            values[i] = temp->val;
            temp=temp->next;
        }
     
        int len = sizeof(values) / sizeof(values[0]); //get array length
     
        //sort the array
        sort(values, values + len);
        
        //copy back the sorted values from the array to the linked list
        temp=head;
        for(int i=0; i<N; i++)
        {
            temp->val = values[i];
            temp=temp->next;
        }
        
        //return the updated list
        return head;
        
    }
};