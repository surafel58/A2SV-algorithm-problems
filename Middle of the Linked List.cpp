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
    ListNode* middleNode(ListNode* head) {
        //temporary pointer that traverse through the linked list
        ListNode* temp = head;
        
        //counter for counting the number of items in the list
        int counter = 0;
        
        //count the number of items in the list
        while(temp!=NULL)
        {
            counter++;
            temp=temp->next;
        }
        
        //if counter is even increment it by 1, to choose the second middle node 
        if(counter%2==0)
            counter++;
        
        //traverse through the list until you find the middle element
        temp=head;
        for(int x = 0; x != counter/2; x++)
            temp=temp->next;
        
        //return the pointer that points to the middle element
        return temp;
    }
};